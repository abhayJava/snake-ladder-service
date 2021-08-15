#!/bin/bash

for i in $(seq 1 $1);
do

curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/health

  echo "Exit code: $?"
  printf "\n"
done