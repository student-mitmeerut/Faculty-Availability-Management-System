# Project Guide and Presentation Notes

## Project title
Faculty Availability Management System

## Problem addressed
Students may need to meet faculty members but may not know when a faculty member is available. This application lets faculty publish availability slots and lets students request appointments against those slots.

## User roles
- **Student:** register/login, browse published slots, submit appointment requests, view request status.
- **Faculty:** register/login, publish availability, review appointment requests, approve or reject requests.
- **Admin:** view registered users and appointments. Admin creation is configured through environment variables.

## Main workflow
Faculty publishes a future slot → Student views the slot → Student submits a request with a purpose → Faculty approves/rejects → Student sees the updated status.

## Main source-code areas
- `entity/`: `AppUser`, `FacultyAvailability`, `Appointment` database entities.
- `repository/`: Spring Data repositories.
- `service/`: registration/login logic and optional admin initialization.
- `controller/`: authentication and role-specific portal routes.
- `config/`: Spring Security configuration.
- `resources/templates/`: Thymeleaf pages for home, login, registration and dashboards.

## Suggested interview explanation
"I developed a Faculty Availability Management System using Java, Spring Boot, Thymeleaf and MySQL. Faculty members can publish date and time slots. Students can browse those slots and request appointments by providing a purpose. Faculty members can approve or reject requests, and students can track the resulting status. I used Spring Data JPA for persistence and BCrypt password hashing for stored user passwords."

## Be accurate when presenting
Describe this as a working academic/demo project. Do not claim production-grade security, collision prevention, email notifications, deployment, or comprehensive automated testing; those are not implemented in the supplied source.
