# Description
Service for playing snake ladder game

# Setup
Please refer to the Makefile. use run-local to run the service as binary.

#Tests
Please run make test for running unit tests.

#Containerisation
Please use make build-artifact to build the docker image and run-docker to run the service as container

#Kubernetes Packaging
Helm is used as package manager for kubernetes objects. make run-helm

# Verifying service
Once pre-requisites are met the service could be found at  http://snake-ladder-service.local/
