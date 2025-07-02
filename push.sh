#!/bin/bash

#usage: ./push.sh -> commint to main branch 

if [ -z "$1" ] ;then
echo "commit msg is required pass it boi" 
exit 1
fi 
git add .
git commit -m "$1"
git push origin main

