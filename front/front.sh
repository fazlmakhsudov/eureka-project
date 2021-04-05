#!/bin/sh
date 
echo "==== FRONT SERVICE ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

command="java -jar target/front-0.0.1-SNAPSHOT.jar"
echo "2 ".$command

echo "3 Open browser (google chrome)"
eval $command & google-chrome http://localhost:8080
echo "============================="
