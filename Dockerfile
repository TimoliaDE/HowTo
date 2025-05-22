FROM core.harbor.timolia.de/proxy_cache_docker_hub/library/alpine:3.21.3

RUN set -x \
    && apk --no-cache upgrade \
    && apk --no-cache add \
         bash \
         ca-certificates \
         curl \
         gcc \
         git \
         musl-dev \
         nginx \
         openrc \
         python3 \
         python3-dev

RUN curl -s https://bootstrap.pypa.io/get-pip.py | python3 - && \
    echo -en '\nPython version: ' && python3 -V && echo -n 'pip version:    ' &&  pip -V && echo -en '\n'
RUN pip install mkdocs
RUN pip install mkdocs-material

COPY ./ /code/
RUN cd /code \
    && rm docs/team/teamler.json \
    && rm -rf howto-dapp \
    && find . -name '*.md.old' -delete \
    && mkdocs build

RUN adduser -D -g 'www' www
RUN mkdir /www
RUN chown -R www:www /var/lib/nginx
RUN cp -r /code/site/* /www/
RUN chown -R www:www /www
RUN mv /etc/nginx/nginx.conf /etc/nginx/nginx.conf.orig
COPY ./nginx.conf /etc/nginx/nginx.conf

WORKDIR /code
EXPOSE 80
CMD nginx
