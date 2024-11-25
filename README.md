
# LeaveXpress

LeaveXpress is a backend application designed to manage leave requests within an organization. The application supports two roles: **Employee** and **Manager**. Employees can raise, update, and view their leave requests, while Managers have the authority to accept or reject these requests.

This project was developed to deepen the understanding of **Spring Security** concepts, including `@PreAuthorize` and `antMatchers`.

## Features

### Role-Based Access
- **Employee**:
  - Raise a leave request.
  - Update an existing leave request.
  - View leave requests.
- **Manager**:
  - View all leave requests.
  - Accept or reject leave requests.

### Spring Security Highlights
- **`@PreAuthorize`**:
  - Used for method-level security to enforce role-based restrictions.
- **`antMatchers`**:
  - Configured URL-based access control.

## Technologies Used
- **Spring Boot**: For application development.
- **Spring Security**: For authentication and authorization.
- **Java**: Core programming language.
- **Maven**: For build and dependency management.
- **MySQL**: For persistent data storage.

## Endpoints

### Employee Endpoints
| HTTP Method | Endpoint               | Description                  |
|-------------|------------------------|------------------------------|
| `POST`      | `/api/leave`           | Raise a leave request.       |
| `PUT`       | `/api/leave/{id}`      | Update a leave request.      |
| `GET`       | `/api/leave`           | View all leave requests.     |

### Manager Endpoints
| HTTP Method | Endpoint               | Description                  |
|-------------|------------------------|------------------------------|
| `PUT`       | `/api/leave/approve/{id}` | Approve a leave request.  |
| `PUT`       | `/api/leave/reject/{id}`  | Reject a leave request.   |
| `GET`       | `/api/leave/all`       | View all leave requests.     |

## Authentication and Roles
- Default username and roles:
  - **Employee**: `employee`, Password: `password`, Role: `EMPLOYEE`
  - **Manager**: `manager`, Password: `password`, Role: `MANAGER`
- These credentials can be configured in the application or replaced with database-based user management.

## Learning Outcomes
This project helped in understanding:
- Configuring **role-based access control** using Spring Security.
- Securing endpoints with `@PreAuthorize` annotations.
- Understanding the order of security rules with `antMatchers`.
- Integrating authentication with user roles.
