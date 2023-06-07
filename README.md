# In this sample app I tried using redis with springboot. I am running Redis with docker.
Use the following docker command to run redis thorugh docker.
# docker run --name recorder-redis -p 6379:6379 -d redis:alpine

#Few useful redis commands I found useful:
 * select db index, example: select 0
 * keys pattern, example: keys *
 * set db db-name, example set db redis-test
 * get db 
 * get key, example: get hello 

## Added docker file for containerization of the app, here are the steps:
* add a file named as Dockerfile
* run - docker build -t spring-boot-redis-example:ver01 . 
* run - docker run -p 8787:8787 efda6529e1ed7928496b8b374b26434fd5ed65f9cb126bd8a8cab868179912e0
* The long string used after port 8787 is the image id which we get after successful build command
* -p 8787:8787 is used to expose the port 8787 outside the docker container
 