#!/bin/sh
date 
echo "==== RUN EUREKA CLIENTS  ==== "
echo "1.1 Run Rest-api-1"

command="cd rest-api/ && ./rest-api.sh"
echo "1.2 ".$command
gnome-terminal -- bash -c "$command; bash"

command="cd rest-api-3/ && ./rest-api-3.sh"
echo "1.3 ".$command
gnome-terminal -- bash -c "$command; bash"

command="cd rest-api-4/ && ./rest-api-4.sh"
echo "1.4 ".$command
gnome-terminal -- bash -c "$command; bash"

command="cd rest-api-5/ && ./rest-api-5.sh"
echo "1.5 ".$command

echo "Clients have been run!!!"
echo "============================="
eval $command
