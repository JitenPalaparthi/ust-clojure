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

- To run adminer instance 

```
docker run -d --name pgadmin -p 38080:8080 adminer
```

- To access adminer in your local machine

- open browser and hit http://localhost:38080 

- select postgres, provide postgres username,password and database

- To get server details, run docker inspect clojure-pg-db

- pick the ip address from the above command and provide to server details in adminer portal with ip address, example 172.17.0.2:5432 (This may be or meay not the ip address)