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
https://lucid.app/lucidchart/ec4afb84-6242-44e6-b00a-61f8d35db6c9/edit?viewport_loc=-1323%2C-910%2C3903%2C1959%2C0_0&invitationId=inv_e79b1bbd-819f-4306-a2f3-5a6ab4723af9
