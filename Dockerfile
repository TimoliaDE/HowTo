FROM alpine:latest

RUN apk add --update \
    ca-certificates \
    bash \
    gcc \
    git \
    musl-dev \
    python3 \
    python3-dev \
    curl \
    openrc \
    nginx

RUN curl -s https://bootstrap.pypa.io/get-pip.py | python3 - && \
    echo -en '\nPython version: ' && python3 -V && echo -n 'pip version:    ' &&  pip -V && echo -en '\n'
RUN pip install mkdocs
RUN pip install mkdocs-material

COPY ./ /code/
RUN cd /code && mkdocs build

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
