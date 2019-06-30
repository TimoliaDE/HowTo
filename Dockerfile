FROM alpine:latest

RUN apk add --update \
    ca-certificates \
    bash \
    git \
    python2 \
    python2-dev \
    py-setuptools \
    openrc \
    nginx

RUN easy_install-2.7 pip 
RUN pip install mkdocs

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
EXPOSE 8000
CMD nginx
