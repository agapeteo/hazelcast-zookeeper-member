#!/bin/sh

CONFIG_LOCATION_DEFAULT=file:/opt/config/application.yml
CONFIG_LOCATION_VALUE=${CONFIG_LOCATION:-${CONFIG_LOCATION_DEFAULT}}

JAVA_OPTS_DEFAULT=""
JAVA_OPTS=${JAVA_OPTS:-${JAVA_OPTS_DEFAULT}}

echo
echo "java ${JAVA_OPTS} -jar /app.jar --spring.config.location=${CONFIG_LOCATION_VALUE}"
echo
java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=${CONFIG_LOCATION_VALUE}