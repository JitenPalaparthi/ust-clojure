- basic introduction to containers technology

https://docs.google.com/presentation/d/1TClOq3s__IAEwI7xQbVTJ1nMv9UNQ1OcoQ6-OKSy3Ko/edit?usp=sharing

- To pull image

```
docker pull postgres:latest
```

- To run postgres instance

```
docker run -d --name clojure-pg-db -p 5432:5432 -e POSTGRES_USER=app -e POSTGRES_PASSWORD=app123 -e POSTGRES_DB=appdb postgres
```