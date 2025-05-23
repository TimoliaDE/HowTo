FROM core.harbor.timolia.de/proxy_cache_docker_hub/library/alpine:3.21.3 AS builder

RUN set -x \
    && apk --no-cache upgrade \
    && apk --no-cache add \
         bash \
         ca-certificates \
         curl \
         gcc \
         git \
         musl-dev \
         python3 \
         python3-dev \
         py3-pip \
         py3-virtualenv

RUN virtualenv /opt/venv
ENV PATH="/opt/venv/bin:$PATH"

RUN pip install mkdocs mkdocs-material

COPY ./ /code/
WORKDIR /code
RUN rm docs/team/teamler.json \
    && rm -rf howto-dapp \
    && find . -name '*.md.old' -delete \
    && mkdocs build

FROM core.harbor.timolia.de/proxy_cache_docker_hub/library/alpine:3.21.3

RUN apk --no-cache add nginx \
    && adduser -D -g 'www' www \
    && mkdir /www \
    && chown -R www:www /var/lib/nginx

COPY --from=builder /code/site/ /www/

COPY ./nginx.conf /etc/nginx/nginx.conf

RUN chown -R www:www /www

EXPOSE 80
CMD ["nginx"]
