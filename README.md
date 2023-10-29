# post-backend
is a versatile and efficient tool designed to simplify the process of creating, organizing and managing posts of any topic.

### Basic infrastructure

Before we try to start the application, we should set up its basic infrastructure.
For this purpose, it is provided a [docker-compose.yml](/docker-compose.yml) file, which describes this basic infrastructure.
Currently, the infrastructure needed is a [PostgresSQL](https://www.postgresql.org/) database. Having [docker](https://www.docker.com/) and
[docker compose](https://docs.docker.com/compose/) installed in your environment, you should be able to provision the resources using the following command:
```sh
docker-compose up -d
```
on the other side, in order to stop these resources in your environment you should type
```sh
docker-compose stop
```

We also have an script that you can run to setup initial mocks for testing. Just run the test_script.sql