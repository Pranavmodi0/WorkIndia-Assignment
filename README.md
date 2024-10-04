# Railway Management System API

## Overview

This project is a RESTful API for a railway management system. The API allows users to manage train bookings, check seat availability, and handle user accounts with role-based access control.

## Technologies Used

- **Java**: The primary programming language.
- **Spring Boot**: For building the RESTful API.
- **MySQL**: For the database management system.
- **Maven**: For dependency management.

## IDE Used
- Intellj IDE

## Features

- **User Registration**: Users can register for an account.
- **User Login**: Users can log into their accounts using a secure token.
- **Admin Features**: Admins can add new trains and manage seat availability.
- **Seat Availability Check**: Users can check for trains between two stations.
- **Booking Seats**: Users can book seats if available.
- **View Booking Details**: Users can retrieve their booking details.
- **Role-Based Access Control**: Different roles for users and admins, ensuring secure access.

## Setup Instructions

2. **Install SDE**
   - Intellij / Eclipse or as per your choice

1. **Clone the Repository**
   - clone the repository in your sdk
   
3. **Configure Database**
   - You can create you own Mysql DB and change the name of database and username, password
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/railway_management
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>

3. **Run the Application**
   - run the application from the main file of the project in IDE

## Endpoints

- **POST /api/trains/add**: Add a new train (Admin).
- **GET /api/trains/availability**: Check seat availability between two stations.
- **POST /api/trains/book**: Book a seat on a train (User).
- **GET /api/trains/bookings**: Get booking details for a user (User).


## Testing

- You can use tools like Postman to test the API endpoints.
- Ensure you set the Authorization header for secured endpoints.
