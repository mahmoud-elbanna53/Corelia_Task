1. Installation Instructions:

Cloning the Repository:
Bash

git clone <repository_url>
Database Configuration:
YAML

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/corelia_task
    username: <your_username>
    password: <your_password>
2. Running Instructions:

Building the Project:
Bash

./gradlew build
Running the Application:
Bash

./gradlew bootRun
3. Usage Instructions:

API Endpoints:
Detailed descriptions of each endpoint (registration, contact management, authentication).
Information on request methods (POST, GET, PUT, DELETE).
Payload requirements (JSON structure).
Validation:
Explanation of validation rules and error handling.
Sorting and Pagination:
How to use query parameters for sorting and pagination.
Examples of request URLs.
Authentication (if implemented):
How to use JWT authentication.
Instructions on including the JWT in the Authorization header.
