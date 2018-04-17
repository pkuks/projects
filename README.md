FriendsBook is a social network application with  with features like "Friend", "Unfriend", "Block", "Receive Updates" etc.

This application using Spring Boot, JPA, H2 in memory database.

Project structure
- model - this contains the entities used in the project (user and user_relationship)
- repository - repository layer for database
- service - contains service interface and classes for User, UserRelationship and ManageFriend.
- request - request objects for restful api's
- response - response objects of restful api's
- controller - controller to expose the restful api's for friends management
- exception - customized exception classes to handle the exceptions
- utils - utilities classes


Docker command to run

docker-compose up --build

Test APIs

import fb_postman_collection.json in postman plugin and test

Documentation

http://192.168.99.100:8090/swagger-ui.html
