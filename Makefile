#!make

.PHONY: build-artifact push-artifact run-local run-tests run-docker run-helm

build-artifact:
	docker build -t abhayjava/snake-ladder-service:0.1.0 .

push-artifact:
	docker push abhayjava/snake-ladder-service:0.1.0

run-local:
	mvn clean spring-boot:run

run-tests:
	mvn clean test

run-docker:
	docker run -p 8080:8080 abhayjava/snake-ladder-service:0.1.0

run-helm:
	helm upgrade --install dev-release helm/ -n intuit
