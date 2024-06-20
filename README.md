# Assurance Applcaition

## Run docker compose for run local application
```sh
$ docker-compose up -d
```
# Build docker image
```sh
$ docker build -t tangbearrrr/assurance-service:lastest
```
# Deploy using helm

You should have a running Kubernetes cluster and helm installed before proceed.

Deploy application using helm.
```sh
$ helm install mychart kubechart
```
