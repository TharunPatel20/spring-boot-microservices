# 📚 Course Service - Spring Boot Microservice

The **Course Service** is a Spring Boot-based RESTful microservice for managing course-related operations. It supports creation, retrieval (single and all), and implements DTOs, validation, and a global exception handler. This is a part of a larger microservices architecture where other services (like Student or Enrollment) may communicate with this Course Service via REST or Feign Clients.

---

## 🚀 Features

- 📦 REST APIs to manage courses (Create, Get by ID, List all)
- ✅ Request validation using JSR-380 (Jakarta Validation)
- 📅 DTOs for clean request/response payloads
- ❌ Centralized error handling via `@RestControllerAdvice`
- 🗂️ In-memory H2 database for quick testing
- 🔎 API logs with SQL visibility

---

## 🧱 Technology Stack

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Jakarta Bean Validation (`jakarta.validation`)
- MySQL Database
- Maven

---

## 🗓️ Project Structure

```
src/main/java/com/edutrack/course/
├— CourseServiceApplication.java         # Main Spring Boot app
├— controller/
│   └— CourseController.java             # API endpoints
├— dto/
│   ├— RequestDTO.java                   # Incoming request structure
│   └— ResponseDTO.java                  # Outgoing response structure
├— model/
│   └— Course.java                       # JPA Entity
├— repository/
│   └— CourseRepository.java             # JPA Repository
└— exception/
    └— GlobalExceptionHandler.java       # Validation & general exception handling
```

---

## 🥪 API Endpoints

### 🔹 Create a Course

**POST** `/courses`

**Request Body**:
```json
{
  "title": "Java Fundamentals",
  "description": "Introduction to core Java",
  "trainerName": "John Doe"
}
```

**Validations**:
- All fields are required (`@NotBlank`)

**Response**:
```json
{
  "id": 1,
  "title": "Java Fundamentals",
  "description": "Introduction to core Java",
  "trainerName": "John Doe"
}
```

---

### 🔹 Get Course by ID

**GET** `/courses/{id}`

**Response**:
```json
{
  "status": "OK",
  "payload": {
    "id": 1,
    "title": "Java Fundamentals",
    "description": "Introduction to core Java",
    "trainerName": "John Doe"
  }
}
```

---

### 🔹 List All Courses

**GET** `/courses`

**Response**:
```json
{
  "status": "OK",
  "payload": [
    {
      "id": 1,
      "title": "Java Fundamentals",
      "description": "Introduction to core Java",
      "trainerName": "John Doe"
    },
    {
      "id": 2,
      "title": "Spring Boot Mastery",
      "description": "Deep dive into Spring Boot",
      "trainerName": "Jane Smith"
    }
  ]
}
```

---

## ⚠️ Global Exception Handling

- **Validation errors** return `400 Bad Request` with field-wise messages
- **General exceptions** return `500 Internal Server Error`

**Sample Validation Error**:
```json
{
  "title": "Title is mandatory",
  "description": "Description is mandatory",
  "trainerName": "Trainer name is mandatory"
}
```

---

## 🛠️ Configuration - `application.properties`

```properties
spring.application.name=course-service
server.port=8090

logging.pattern.console= %logger{36} - %msg%n

logging.level.root=WARN
logging.level.com.edutrack.course_service=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.show_sql=false

spring.datasource.url=jdbc:mysql://localhost:3306/edutrack_courses
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.error.include-message=always
```

- Access the H2 Console: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:coursesdb`

---

## 🔧 Running the Service

### Prerequisites

- Java 17+
- Maven 3+

### Run the Application

```bash
mvn spring-boot:run
```

### Or Build & Run

```bash
mvn clean install
java -jar target/course-service-0.0.1-SNAPSHOT.jar
```

---

## 📆 Future Enhancements

- Add `update` and `delete` operations
- Integrate with `Student` or `Enrollment` service
- Implement Feign Clients for inter-service communication
- Add Swagger/OpenAPI documentation

---

## 👨‍💻 Author

**Ashish**

---

## 📃 License

This project is licensed under the MIT License.

