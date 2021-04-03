#!/bin/sh
date 
echo "==== RUN EUREKA SERVER  ==== "
command="mvn clean install"
echo "1 ".$command
eval $command

echo "2 It's going to be run two instances of Eureka-Server"
command="java -jar -Dspring.profiles.active=peer-1 target/eureka-server-0.0.1-SNAPSHOT.jar"
echo "2.1 ".$command
gnome-terminal -- bash -c "$command; bash"

command="java -jar -Dspring.profiles.active=peer-2 target/eureka-server-0.0.1-SNAPSHOT.jar"
echo "2.2 ".$command
eval $command

echo "============================="
