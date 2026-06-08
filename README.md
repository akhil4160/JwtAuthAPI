# JWT Authentication API

A secure REST API built using Spring Boot and Spring Security that implements JWT-based authentication and role-based authorization.

## Features

- User Registration
- User Login
- BCrypt Password Encryption
- JWT Token Generation
- JWT Token Validation
- Spring Security Integration
- Role-Based Authorization
- Global Exception Handling
- MySQL Database Integration

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

### Register

POST /api/auth/register

### Login

POST /api/auth/login

### Current User

GET /api/user/me

### Admin Endpoint

GET /api/admin

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
