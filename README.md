# Assurance Applcaition

## Run docker compose for run local application
```sh
$ docker-compose up -d
```
## Build docker image
```sh
$ docker build -t tangbearrrr/assurance-service:lastest
```
## Deploy using helm

You should have a running Kubernetes cluster and helm installed before proceed.

Deploy application using helm.
```sh
$ helm install mychart kubechart
```
## Swagger
http://localhost:8080/swagger-ui/index.html#/

## Status Codes

api returns the following status codes in its API:

| Status Code | Description |
| :--- | :--- |
| 1001 | `Record not found` |
| 1002 | `Status must be approve or reject` |
| 1003 | `Invalid Data` |

## Architecture Diagram
![alt text](https://ibb.co/ZNFsjG3)
