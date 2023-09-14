# Spring Boot REST-API

A REST-API written in Java using the Spring Boot framework. Containerized and deployed to AWS ECS, and connected to an RDS MySQL database.

# Running Locally

- Use `docker compose -f docker-compose.dev.yml up` to run the rest-api and mysql server locally. 
- Teardown with `docker compose -f docker-compose.dev.yml down`

# Deploying Changes

1. Build docker image and push to AWS ECR by running the following commands:
   -   `aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 288610995890.dkr.ecr.us-east-2.amazonaws.com`
   -  `docker build -t spring-boot-rest-api .`
   -  `docker tag spring-boot-rest-api:latest 288610995890.dkr.ecr.us-east-2.amazonaws.com/spring-boot-rest-api:latest`
   -  `docker push 288610995890.dkr.ecr.us-east-2.amazonaws.com/spring-boot-rest-api:latest`

2. Create a MySQL instance in RDS

3. Update the ECS Task Definition with the new database credentials

4. Deploy a new ECS Service using the revised task definition

### * Delete the MySQL instance and ECS service afterwards to avoid charges