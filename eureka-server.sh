#!/bin/sh
date 
echo "==== RUN EUREKA PROJECT  ==== "
echo "1.1 Go to directory eureka-server/"
cd eureka-server/

command="mvn clean install"
echo "1.2 ".$command
eval $command

cd target/ 
echo "1.3 Go to directory target/"

command="java -jar eureka-server-0.0.1-SNAPSHOT.jar"
echo "1.3 ".$command
gnome-terminal -- bash -c "$command; bash"

echo "Server Eureka has started at port 8761. Huura!!!"
echo "------------------------------------------------"
cd ../../eureka-ribbon/
echo "2 Starting Ribbon client"

command="mvn clean install"
echo "2.1 $command"
eval $command

command="java -jar target/eureka-ribbon-0.0.1-SNAPSHOT.jar"
echo "2.2 $command"
gnome-terminal -- bash -c "$command; bash"

echo "Ribbon client has started"
echo "============================="
