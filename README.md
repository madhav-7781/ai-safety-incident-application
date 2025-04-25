# AI Safety Incident Log API

A simple RESTful API built with **Java Spring Boot** and **MySQL** to log and manage hypothetical AI safety incidents. This project is developed as part of the backend intern take-home assignment for **HumanChain AI**.

---

## 🚀 Tech Stack

- **Language**: Java 17+
- **Framework**: Spring Boot
- **Database**: MySQL (`sparklehood_db`)
- **Build Tool**: Maven

---

## 📦 Dependencies (via Spring Initializr)

Make sure you add these dependencies when generating the project using [https://start.spring.io](https://start.spring.io):

- Spring Web
- Spring Data JPA
- MySQL Driver
- Validation (Jakarta Bean Validation)

---

## 🔧 Project Setup & Run Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/madhav-7781/sparklehood-incident-log.git
cd sparklehood-incident-log
```

### 2. Set Up MySQL Database
```sql
CREATE DATABASE sparklehood_db;
```
Ensure MySQL is running and accessible.


### 3. Configure (```application.properties```)
Update ```src/main/resources/application.properties``` with your MySQL credentials:

```properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

### 4. Build and Run
```bash
./mvnw spring-boot:run
```
Or in IDE: Run ```AiSafetyIncidentApplication.java```


## 🌐 API Endpoints

### 1. Get All incidents
- # Method # -> **`GET`**
