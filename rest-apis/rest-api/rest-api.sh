#!/bin/sh
date 
echo "==== RUN REST API  ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

echo "2 It's going to be run two instances of Rest-api"
port=4001
command="java -jar target/rest-api-0.0.1-SNAPSHOT.jar --server.port="
echo "2.1 ".$command$port
gnome-terminal -- bash -c "$command$port; bash"
port=4002
echo "2.2 ".$command$port
eval $command$port

echo "============================="
