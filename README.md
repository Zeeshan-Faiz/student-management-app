# Student Management System 

## Overview

This Student Management System is a Java-based application that leverages JDBC to interact with a MySQL database. The system provides essential functionalities for managing student details, including adding new students, displaying all student details, retrieving details based on roll number, and updating or deleting student information.

## Functionality

### 1. Adding Student Details

- Users can add new students to the system by providing necessary details such as name, university, and other relevant information.
- The application validates the input and inserts the student details into the MySQL database.

### 2. Showing All Student Details

- The system can retrieve and display the details of all students stored in the database.
- Users have the option to view a comprehensive list of all students enrolled.

### 3. Getting Student Details by Roll Number

- Users can search for a specific student by providing their roll number.
- The application retrieves and displays the details of the student with the specified roll number.

### 4. Updating Student Details

- Users have the ability to update the details of a specific student by providing their roll number.
- The system allows modifications to information such as name, percentage, or any other relevant field.

### 5. Deleting Student Details

- Users can delete a student's record by specifying their roll number.
- The application removes the corresponding entry from the MySQL database.

### 6. How it Works

 **Database Connection:**
   - The application establishes a connection to the MySQL database using JDBC.

## Installation

1. **Java Development Kit (JDK):** Ensure you have Java installed on your system.
2. **MySQL Connector/J:** Download and install the MySQL Connector/J from [MySQL Downloads](https://dev.mysql.com/downloads/connector/j/).
3. **Add Connector to Classpath:** Add the MySQL Connector/J JAR file to your project's classpath.

## Usage Example

```java
// Sample code


// Update student details
sms.updateStudentDetails("2023001", "John Smith", "Electrical Engineering");

// Delete student
sms.deleteStudent("2023001");
