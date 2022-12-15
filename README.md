# DISCLAIMER
Currently, some URLs may be discontinued because the application were initially deployed using a free AWS account.

# DevOps Application

This application has been created by 5 steps through CI and CD by Gitlab CI
and Ansible technologies that creates, deploy and test the java spring boot app
with the definition of swagger: https://s3-eu-west-1.amazonaws.com/mmi-codechallenge/swagger-users-v1.json

The main CI pipeline have these steps that is divide in 5 children pipelines that
run everything that you need to deploy this application in AWS EKS:

## The pipeline

- The first step deploy all the infrastructure (VPC, security groups, EKS) that you need using terraform.
- The second step builds the image of the app and push them in AWS ECR.
- The third step deploy the app and his services in the AWS EKS, also with HPA to upscaling if necessary.
- The 4th step testing the example postman collection.
- The last step run J-meter load testing to check if the app upscaling in the cloud.

The app has these methods:

## API Reference

- Hostname - Load Balancer: http://a6c62c0f1490f4f34bc6c1b16cc72978-1383435178.us-east-2.elb.amazonaws.com
- The app has been deployed in the cloud, to check the swagger, go to this URL: http://a6c62c0f1490f4f34bc6c1b16cc72978-1383435178.us-east-2.elb.amazonaws.com/swagger-ui.html

#### Get all users

```http
  GET /users/getusers
```

#### Get user By Id

```http
  GET /users/getusersById/${userId}
```

| Parameter | Type     | Description                       |
|:----------| :------- |:----------------------------------|
| `userId`  | `string` | **Required**. Id of user to fetch |

#### Create User

```http
  POST /users/createUsers/
```

#### Update User By Id

```http
  PUT /users/updateUsersById/${userId}
```

| Parameter | Type     | Description                        |
|:----------| :------- |:-----------------------------------|
| `userId`  | `string` | **Required**. Id of user to update |


#### Delete User By Id

```http
  DELETE /users/deleteUsersById/${userId}
```

| Parameter | Type     | Description                        |
|:----------| :------- |:-----------------------------------|
| `userId`  | `string` | **Required**. Id of user to delete |

## Technologies that are using

- Java Spring Boot as the APP
- Ansible as CD
- Gitlab CI as CI
- NodeJS to run integration tests with postman collection
- Terraform to deploy infrastructure
- Jmeter to Load Testing
- JUnit to Unit Testing
- Maven to Build artifacts
- Docker to create and build image containers
- AWS services like EKS, ECR, IAM, EC2, VPC
- Kubernetes to orchestrate the microservices and the autoscaling
 

