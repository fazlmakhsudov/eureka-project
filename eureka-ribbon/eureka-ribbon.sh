#!/bin/sh
date 
echo "==== EUREKA-RIBBON ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

command="java -jar target/eureka-ribbon-0.0.1-SNAPSHOT.jar"
echo "2 ".$command
eval $command

echo "============================="
