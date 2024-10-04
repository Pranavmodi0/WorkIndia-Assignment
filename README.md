# Railway Management System API

## Overview

This project is a RESTful API for a railway management system, similar to the functionalities provided by IRCTC. The API allows users to manage train bookings, check seat availability, and handle user accounts with role-based access control.

## Technologies Used

- **Java**: The primary programming language.
- **Spring Boot**: For building the RESTful API.
- **MySQL**: For the database management system.
- **Maven**: For dependency management.
- **Spring Security**: For authentication and authorization.
- **Swagger**: For API documentation.

## Features

- **User Registration**: Users can register for an account.
- **User Login**: Users can log into their accounts using a secure token.
- **Admin Features**: Admins can add new trains and manage seat availability.
- **Seat Availability Check**: Users can check for trains between two stations.
- **Booking Seats**: Users can book seats if available.
- **View Booking Details**: Users can retrieve their booking details.
- **Role-Based Access Control**: Different roles for users and admins, ensuring secure access.

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd railway-management-system
