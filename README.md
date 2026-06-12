# JwtAuthAPI

A production-ready Spring Boot REST API implementing JWT Authentication, Role-Based Access Control (RBAC), and User Management features.

## Live API

https://jwtauthapi-4rsw.onrender.com

---

## Features

### Authentication

- User Registration
- User Login
- JWT Token Generation
- BCrypt Password Encryption

### Authorization

- USER Role
- ADMIN Role
- Role-Based Access Control (RBAC)
- Protected Endpoints

### User Features

- View Current User Profile
- Secure Authentication

### Admin Features

- Get All Users
- Update User Name
- Change User Role
- Reset User Password
- Delete User
- User Statistics Support

### Security

- Spring Security
- JWT Authentication Filter
- Password Encryption
- Protected REST APIs

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- MySQL
- Maven
- Render

---

## API Endpoints

### Authentication

POST /api/auth/register

POST /api/auth/login

### User

GET /api/user/me

### Admin

GET /api/admin

GET /api/admin/users

PUT /api/admin/users/{id}

PUT /api/admin/users/{id}/role

PUT /api/admin/users/{id}/password

DELETE /api/admin/users/{id}

---

## Project Structure

src/main/java/com/akhil/jwtauthapi

- controller
- service
- repository
- entity
- dto
- security
- config
- util

---

## Key Learnings

- Spring Security
- JWT Authentication
- Role-Based Authorization
- REST API Development
- DTO Design
- MySQL Integration
- API Deployment
- Git Rebase Conflict Resolution
- Production Debugging

---

## Run Locally

### Clone Repository

git clone https://github.com/akhil4160/JwtAuthAPI.git

### Configure Environment Variables

SPRING_DATASOURCE_URL

SPRING_DATASOURCE_USERNAME

SPRING_DATASOURCE_PASSWORD

JWT_SECRET

### Run

./mvnw spring-boot:run

---

## Author

Akhil Agrawal

GitHub:
https://github.com/akhil4160
