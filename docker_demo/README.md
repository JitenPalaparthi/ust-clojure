## 1.Docker build

```
docker build . -t jpalaparthi/clojuredemo:v0.1  
```

## 2.Docker run 

- Note: japalaprthi is my docker hub id, user yours

```
docker run -d -p 8081:8081 --name app1 jpalaparthi/clojuredemo:v0.1
```

## 3.Docker push

- have an account in hub.docker.com (if you don't have signup)

- login to docker using username and password (used while signup with hub.docker.com)

```
docker login
```

- To push image 

```
docker push jpalaparthi/clojuredemo:v0.1
```


- since it is pushed any body can call and use that image.

- simply call step 2(docker run) to run the application

