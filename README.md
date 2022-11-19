# mongodb

Docker config:

docker run -d --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=<USER> -e MONGO_INITDB_ROOT_PASSWORD=<PASSWORD> mongo
