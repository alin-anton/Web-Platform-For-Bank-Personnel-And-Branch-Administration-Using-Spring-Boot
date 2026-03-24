# Web Platform For Bank Personnel And Branch Administration Using Spring Boot

This is a university web project developed for the administration of human resources and bank branches. The application provides an intuitive web interface for managing information about banks, branches, and employees, allowing for complete CRUD (Create, Read, Update, Delete) operations.

## 👨‍💻 Author
* **Name:** Anton Alin-Gabriel

## 🛠️ Technologies Used

The project was developed using a modern architecture, combining backend, frontend, and database technologies:

* **Backend:** Java, Spring Boot, Spring Data JPA
* **Frontend:** HTML5, CSS3, Thymeleaf (for templating), Bootstrap 5
* **Database:** MySQL
* **Build Tool:** Maven

## ⚙️ Key Features

The application is structured around three main entities, each with its own management capabilities:

1. **Bank Management (`Bank`)**
   * View the list of banks.
   * Add a new bank (Name, SWIFT Code, CUI).
   * Edit and delete existing banks.

2. **Branch Management (`Branches`)**
   * View branches and their details.
   * Add a new branch (Name, City, Address, Phone) and associate it with an existing bank (Many-to-One relationship).
   * Edit and delete branches.

3. **Employee Management (`Employees`)**
   * View the list of employees.
   * Add new employees with personal and contractual details (First Name, Last Name, CNP, Position, Salary, Employment Date) and link them to a bank.
   * Edit employee records or remove them from the system.

## 🚀 Setup and Installation Instructions

To run this project on your local machine, follow these steps:

### 1. Prerequisites
* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) installed.
* [MySQL Server](https://dev.mysql.com/downloads/mysql/) installed and running.

### 2. Database Configuration
An SQL dump file (e.g., `bancadb.sql`) is included in this repository. You can import it into your MySQL server to easily set up the database structure and any initial data.

* **Option A (Importing the provided SQL file):**
  Open your MySQL client (e.g., MySQL Workbench, command line, or phpMyAdmin), create a database named `bancadb`, and import the provided SQL file into it.

  CREATE DATABASE bancadb;
  -- Then run/import the bancadb.sql script

* **Option B (Auto-generation via Hibernate):**
  If you prefer not to import the file, simply create the empty database using `CREATE DATABASE bancadb;`. Because of the `spring.jpa.hibernate.ddl-auto=update` setting in Spring Boot, all necessary tables will be automatically generated and updated the first time you run the application.

### 3. Application Configuration
Open the `src/main/resources/application.properties` file and verify or update your MySQL database connection credentials (if your local setup uses a different username or password):

spring.datasource.url=jdbc:mysql://localhost:3306/bancadb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=1234567890 

*(Security tip: When pushing code to a public GitHub repository, it's recommended not to leave real passwords in your `application.properties`. You can replace them with environment variables or dummy data.)*

### 4. Running the Project
You can run the project by opening a terminal in the root folder of the application and using the Maven wrapper:

* **On Windows:**
  mvnw.cmd spring-boot:run

* **On Linux / macOS:**
  ./mvnw spring-boot:run

*Alternatively, you can import the project into an IDE (e.g., IntelliJ IDEA, Eclipse) and directly run the `PibdspringApplication.java` class.*

### 5. Accessing the Application
Once the application has successfully started, open a web browser and navigate to:
👉 **http://localhost:8080/**

## 📂 Project Structure
* `controller/` - Contains the controllers that handle HTTP routing (`BankController`, `BranchesController`, `EmployeesController`, `IndexController`).
* `entity/` - Data models (`Bank`, `Branches`, `Employees`) mapped to the database tables.
* `repository/` - Spring Data JPA interfaces for database CRUD operations.
* `service/` - Interfaces and implementations containing the business logic.
* `resources/templates/` - HTML files for the frontend, rendered with Thymeleaf.
* `resources/static/` - Static resources (CSS, images).
