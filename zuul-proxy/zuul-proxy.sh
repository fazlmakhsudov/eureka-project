#!/bin/sh
date 
echo "==== ZUUL PROXY ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

command="java -jar target/zuul-proxy-0.0.1-SNAPSHOT.jar"
echo "2 ".$command
eval $command

echo "============================="
