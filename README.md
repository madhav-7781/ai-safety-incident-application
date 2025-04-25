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

The server will start at: **http://localhost:8082**

## 🌐 API Endpoints

### 1. Get All incidents
- Method: **`GET`**
- EndPoint: **`/incidents`**
- Response: **`200 OK`** with list of all incidents

### 2. Get incident By ID
- Method: **`GET`**
- EndPoint: **`/incidents/{id}`**
- Success Response: **`200 OK`**
- Error Response: **`404 Not Found`** if ID does not exist

### 3. Create a new incident
- Method: **`POST`**
- EndPoint: **`/incidents`**
- Request Body:
  ```json
  {
  "title": "your_title",
  "description": "your_description",
  "severity": "Low/Medium/High"
  }
  ```
- Success Response: **`201 Created`**
- Error Response: **`404 Bad Request`** (missing fields or invalid severity)

### 4. Delete an incident by ID
- Method: **`DELETE`*
- EndPoint: **`/incidents/{id}`**
- Success Response: **`204 No Content`**
- Error Response: **`404 Not Found`**
