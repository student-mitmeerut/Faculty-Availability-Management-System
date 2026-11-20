# Faculty Availability Management System

A Java Spring Boot + Thymeleaf + MySQL web application for faculty availability publishing and student appointment requests.

## Features present in this source

- Student and faculty registration
- Login with BCrypt password hashing and session-based role routing
- Faculty can publish availability with date, start/end time, location and note
- Students can view active published slots and submit appointment requests
- Faculty can approve or reject appointment requests
- Student dashboard shows the student's appointment requests and status
- Admin dashboard lists users and appointments; an admin account can be seeded with environment variables

## Technology

- Java 21
- Spring Boot (version declared in `pom.xml`)
- Spring MVC, Thymeleaf
- Spring Data JPA / Hibernate
- Spring Security password encoder
- MySQL 8+
- Maven Wrapper

## Requirements

- JDK 21
- MySQL Server 8 or compatible
- Windows PowerShell / Command Prompt, macOS Terminal, or Linux shell

## Database setup

Create the database and a dedicated MySQL user. Choose a new password locally; do not commit it or share it.

```sql
CREATE DATABASE faculty_availability_db;
CREATE USER 'faculty_app'@'localhost' IDENTIFIED BY 'SET_A_NEW_LOCAL_PASSWORD';
GRANT ALL PRIVILEGES ON faculty_availability_db.* TO 'faculty_app'@'localhost';
FLUSH PRIVILEGES;
```

If the database user already exists, update its password securely instead of creating it again.

## Configure and run

1. Copy `src/main/resources/application.properties.example` to `src/main/resources/application.properties`.
2. Set the `spring.datasource.password` value to your local MySQL password, or keep `${DB_PASSWORD}` and define the `DB_PASSWORD` environment variable before starting the app.
3. From the project root run:

   **Windows:**
   ```powershell
   $env:DB_PASSWORD="YOUR_LOCAL_DB_PASSWORD"
   .\mvnw.cmd spring-boot:run
   ```

   **macOS / Linux:**
   ```bash
   export DB_PASSWORD='YOUR_LOCAL_DB_PASSWORD'
   ./mvnw spring-boot:run
   ```

4. Open <http://localhost:8081/>.
5. Register a Student account and a Faculty account from the registration page.
6. Sign in as Faculty, publish a future availability slot, then sign in as Student and request an appointment.
7. Sign in as Faculty again and approve/reject the request. Check the status on the Student dashboard.

### Optional admin account

Before starting the app, define `FACULTY_ADMIN_EMAIL` and `FACULTY_ADMIN_PASSWORD` environment variables. The password must be at least 8 characters. On startup, the app creates the admin account if that email is not already registered.

## Demo walkthrough

1. Open the home page and show the Student / Faculty entry points.
2. Register or sign in as Faculty.
3. Publish a future date/time slot and show it in the Faculty availability table.
4. Sign in as Student and show the available faculty slot.
5. Submit an appointment request with a purpose.
6. Return to Faculty and approve or reject the request.
7. Return to Student and show the updated appointment status.
8. Show the Admin dashboard if an admin account has been configured.

## Important implementation notes / limitations

This repository is a learning/demo application, not a production-ready appointment platform. The current `SecurityConfig` permits all HTTP routes at the Spring Security filter level and disables CSRF; the controllers perform their own session/role checks for the dashboard and actions. Before public deployment, implement enforced Spring Security role authorization, enable CSRF protection, add request validation and booking conflict/capacity rules, and add automated tests for registration, booking, authorization and approval/rejection.

The current automated test suite contains only a Spring application context-load test. A successful manual demo does not replace broader automated testing.

## Repository hygiene

- `application.properties` is intentionally ignored because it contains local database configuration.
- `target/`, IDE metadata and `.git/` are not part of the source distribution.
- Never commit database passwords, admin passwords, `.env` files, or other credentials.
