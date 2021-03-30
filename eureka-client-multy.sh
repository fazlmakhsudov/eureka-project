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

for number in 1 2 3 4
do
#command="java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=909$number --spring.application.name=eureka-client-$number"
command="java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=909$number"
echo "1.3.$number ".$command
gnome-terminal -- bash -c "$command; bash"
done

echo "Eureka clients have started at ports: 9091,9092,9093,9094. Huura!!!"
echo "============================="
