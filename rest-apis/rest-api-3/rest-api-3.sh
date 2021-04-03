#!/bin/sh
date 
echo "==== RUN REST API 3 ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

command="java -jar target/rest-api-0.0.1-SNAPSHOT.jar"
echo "2 ".$command
eval $command

echo "============================="
