#!/bin/sh
date 
echo "==== RUN EUREKA PROJECT  ==== "

echo "1 Run eureka server"
command="cd eureka-server/ && ./eureka-server.sh"
echo $command
gnome-terminal -- bash -c "$command; bash"

echo "2 Run Rest-apis"
command="cd rest-apis/ && ./rest-apis.sh"
echo $command
gnome-terminal -- bash -c "$command; bash"

echo "3 Run Eureka-Ribbon"
command="cd eureka-ribbon/ && ./eureka-ribbon.sh"
echo $command
gnome-terminal -- bash -c "$command; bash"

echo "4 Run Zuul-Proxy"
command="cd zuul-proxy/ && ./zuul-proxy.sh"
echo $command
gnome-terminal -- bash -c "$command; bash"

echo "5 Run front page"
google-chrome http://localhost:8080/

echo "============================="
