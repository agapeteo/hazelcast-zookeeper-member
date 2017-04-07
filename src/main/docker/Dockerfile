FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD *.jar app.jar
RUN sh -c 'touch /app.jar'

ENV RUN_FILE /run.sh
ADD run.sh ${RUN_FILE}
RUN chmod +x ${RUN_FILE}

ENTRYPOINT [ "sh", "-c", "${RUN_FILE}" ]