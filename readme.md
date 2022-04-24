# Demo project for Cloud computing systems course

## Author: Daniel Pinczes

## Requirements

* Linux
* Docker
* Kubernetes cluster 

## Installation

* Dockerfile should be built in project directory


`docker build . --tag=demo-application:latest`
    
* Database pod should be created with kubectl

`kubectl apply -f db-pod.yaml`

* Database service should be created with kubectl

`kubectl apply -f db-service.yaml`

* Application pod should be created with kubectl

`kubectl apply -f demo-application-pod.yaml`

* Application service should be created with kubectl

`kubectl apply -f demo-application-service.yaml`


