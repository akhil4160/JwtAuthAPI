# JWT Authentication & User Management API

A secure REST API built using Spring Boot, Spring Security, JWT Authentication, and MySQL. The application supports user registration, login, role-based authorization, and complete user management functionality for administrators.

## Features

### Authentication
- User Registration
- User Login
- JWT Token Generation
- JWT Token Validation
- BCrypt Password Encryption

### User Features
- View Current User Profile

### Admin Features
- View All Users
- Change User Name
- Change User Role
- Reset User Password
- Delete User

### Security
- Spring Security Integration
- Role-Based Access Control (ADMIN / USER)
- JWT Authentication Filter
- Protected Endpoints

### Database
- MySQL Integration
- Spring Data JPA
- Hibernate ORM

### Error Handling
- Global Exception Handling

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JJWT)
- MySQL
- Maven

## API Endpoints

### Authentication

**POST** `/api/auth/register`  
Register a new user.

**POST** `/api/auth/login`  
Authenticate user and generate JWT token.

### User

**GET** `/api/user/me`  
Get currently authenticated user details.

### Admin

**GET** `/api/admin/users`  
Get all users.

**PUT** `/api/admin/users/{id}/name`  
Update user name.

**PUT** `/api/admin/users/{id}/role`  
Change user role.

**PUT** `/api/admin/users/{id}/password`  
Reset user password.

**DELETE** `/api/admin/users/{id}`  
Delete user.

## Project Structure

controller/  
service/  
repository/  
entity/  
dto/  
security/  
config/  
util/  
exception/

## Authentication Flow

User Login  
↓  
JWT Generated  
↓  
Token Sent In Authorization Header  
↓  
JWT Filter Validates Token  
↓  
SecurityContext Updated  
↓  
Protected Endpoint Access Granted

## Author

Akhil Agrawal
