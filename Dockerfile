FROM alpine:latest

RUN apk add --update \
    ca-certificates \
    bash \
    git \
    python2 \
    python2-dev \
    py-setuptools

RUN easy_install-2.7 pip 
RUN pip install mkdocs
RUN rm -rf /tmp/* /var/tmp/* /var/cache/apk/* /var/cache/distfiles/*

COPY ./ /code/
RUN cd /code && mkdocs build
WORKDIR /code/site

CMD mkdocs serve
