#!/bin/bash
# -------------------------------------------------------------------------
# This is the Unix startup script to build and run springboot application in local environment
# Author : Mak Sophea
# Version : 1.0
#
# -------------------------------------------------------------------------
clear
basedir=$(dirname $0)
echo "basedir ${basedir}"
cd ${basedir}
env="$1"
##build the project
echo "=============build phase=============="
mvn clean package -DskipTests

if [[ $? != 0 ]]; then
 echo ">>>>>>>build is not successful"
 exit 1
fi
JAVA_FILE="`ls -t target/*.jar | head -1`"
echo "============Startup java application $JAVA_FILE==================="


javaArgs="${javaArgs} -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

activeProfile="local"
####
serviceArgs=" --SPRING_CLOUD_CONFIG_ENABLE=false --RSF_CONFIG_CLIENT_ENABLED=false"
serviceArgs=" ${serviceArgs}  --BASIC_PWD=test123 --PORT=8081 "
serviceArgs=" ${serviceArgs} "
javaCommand="java -server\
 ${javaArgs} -jar\
 $JAVA_FILE\
 --spring.profiles.active=${activeProfile} ${serviceArgs}"

echo "Running ${javaCommand}"

exec ${javaCommand}
