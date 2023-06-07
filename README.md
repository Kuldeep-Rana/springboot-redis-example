# In this sample app I tried using redis with springboot. I am running Redis with docker.
Use the following docker command to run redis thorugh docker.
# docker run --name recorder-redis -p 6379:6379 -d redis:alpine

#Few useful redis commands I found useful:
 * select db index, example: select 0
 * keys pattern, example: keys *
 * set db db-name, example set db redis-test
 * get db 
 * get key, example: get hello 
