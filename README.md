# Flight Booking Project

## Overview
This project is a **Flight Booking System**, but currently, **only the DAO (Data Access Object)** layer has been implemented. The DAO interacts directly with a **PostgreSQL** database using traditional SQL queries. This is not a Spring-based project, and modern ORM tools like JPA have not been used. All database operations are performed using manual implementations.

## Key Features
- **DAO-Only Implementation**: The project focuses solely on the DAO layer, demonstrating how to handle database interactions using pure Java.
- **Traditional Database Operations**: CRUD operations are implemented with direct SQL queries written in Java.
- **PostgreSQL Integration**: All data is stored in and retrieved from a PostgreSQL database.
- **Core Java Implementation**: The project does not use Spring Boot or any web-based framework. It is designed to run in a console environment.

## Technical Details
1. **Database Connectivity**: 
   - A custom `DbConnector` class handles connections to the PostgreSQL database.
2. **DAO Implementation**:
   - DAO classes (e.g., `BookingDao`, `FlightDao`) manage database operations such as insert, update, delete, and select queries.
3. **Object-Oriented Design**:
   - The system is designed using OOP principles, with separate classes for database interactions and business logic.

## How to Run
1. Set up a PostgreSQL database and configure it with the required tables.
2. Update the database connection details in the `DbConnector` class.
3. Compile and run the project using a Java compiler.
4. Use the DAO methods to interact with the database directly through code.

---

### Database Setup
Ensure the following tables exist in your PostgreSQL database:
- **Flights Table**: Contains flight details.
- **Bookings Table**: Stores booking information.
- **Passengers Table**: Maintains passenger details.

Sample SQL scripts for creating tables can be provided in the `/sql-scripts` folder.

---

This project is designed to showcase foundational Java database management skills through DAO-based implementations with PostgreSQL.
