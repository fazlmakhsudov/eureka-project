#!/bin/sh
date 
echo "==== RUN EUREKA PROJECT  ==== "
echo "1.1 Go to directory eureka-client/"
cd eureka-client/

command="mvn clean install"
echo "1.2 ".$command
eval $command

cd target/
echo "1.3 Go to directory target/"

command="java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=8001 --spring.application.name=eureka-client-1"
echo "1.3 ".$command
eval $command

echo "Client Eureka has started at port 8001. Huura!!!"
echo "============================="
