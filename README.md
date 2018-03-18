Resful Java API

This project is a project based on Spring Boot with Spring Data JPA, Restful APIs and MySQL.

1- Allow Authentication;
JWT and Spring Boot OAuth doesn't work fine. Removed for while

2- Query Products;
GET http://localhost:8080/api/v1/products/search/{searchQuery}
searchQuery example: pizza, simple+burguer

3- Receive Orders;
POST http://localhost:8080/api/v1/orders

4- Cancel an Order;
PATCH http://localhost:8080/api/v1/orders

5- Get Order Status;
GET http://localhost:8080/api/v1/orders/{orderId}

6- Store data in a database of his/her choice;
User Mysql to save Entities.


Postman collection to test:

https://github.com/pett4j/api-std/blob/master/restful-java-api.postman_collection.json

I used only one project to solve the problem, but it can be splitted in other 3 microservices.

A API Gateway in front of API is a good option to easy scale and upgrade the project.

