# EduTrack - Microservices Based Course Management Platform

EduTrack is a microservices-based system built using Spring Boot that allows users to manage **courses**, **students**, and **enrollments**. The services are modular, scalable, and communicate through REST APIs.

---

## 🧩 Microservices Overview

### 1. Course Service
Manages course-related information such as title, description, and trainer name.

- **Endpoints:**
  - `POST /courses`: Create a course (validates input)
  - `GET /courses`: Fetch all courses
  - `GET /courses/{id}`: Get course by ID
- **Tech Stack:**
  - Spring Boot
  - Spring Data JPA (H2 DB)
  - Hibernate Validation (DTO based)
  - Global Exception Handling

### 2. Student Service
Handles student registration and data management.

- **Endpoints:**
  - `POST /students`: Register a new student
  - `GET /students`: List all students
  - `GET /students/{id}`: Fetch student by ID
- **Tech Stack:**
  - Spring Boot
  - Spring Data JPA (H2 DB)
  - Hibernate Validation (DTO based)
  - Global Exception Handling

### 3. Enrollment Service
Manages enrollments of students in courses. Handles the relationship and data transfer between the student and course services.

- **Endpoints:**
  - `POST /enrollments`: Enroll a student in a course (uses Student and Course service)
  - `GET /enrollments`: List all enrollments
  - `GET /enrollments/student/{studentId}`: Courses enrolled by a student
  - `GET /enrollments/course/{courseId}`: Students enrolled in a course
- **Inter-Service Communication:**
  - Uses `RestTemplate` or `OpenFeign` to call Course and Student services.
- **Tech Stack:**
  - Spring Boot
  - Spring Data JPA
  - REST Client (RestTemplate or OpenFeign)
  - DTO & Exception Handling

---

## 🛠 Technologies Used
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Hibernate Validator
- H2 In-Memory DB (for local dev)
- Maven
- OpenFeign / RestTemplate (for inter-service calls)
- Lombok (optional)

---

## 🧪 Running the Services Locally
Each service is a Spring Boot application. Use the following steps:

```bash
# For each service:
cd course-service
./mvnw spring-boot:run

cd student-service
./mvnw spring-boot:run

cd enrollment-service
./mvnw spring-boot:run
```

Or use IntelliJ/VSCode to run `main()` classes directly.

---

## 📦 Sample Request

### Create Course
```http
POST /courses
Content-Type: application/json

{
  "title": "Spring Boot Basics",
  "description": "Learn the basics of Spring Boot",
  "trainerName": "Ashish Mehta"
}
```

### Register Student
```http
POST /students
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### Enroll Student
```http
POST /enrollments
Content-Type: application/json

{
  "studentId": 1,
  "courseId": 2
}
```

---

## 🔐 Validation and Error Handling
All input data is validated via `@Valid` and constraint annotations like `@NotBlank`. A global exception handler captures and formats validation and runtime errors.

---

## 📚 Future Enhancements
- Service registry with Eureka
- API Gateway (Spring Cloud Gateway)
- JWT-based authentication
- Swagger/OpenAPI docs
- Docker + Docker Compose setup

---

## 👨‍💻 Maintainer
**Ashish**  

---

## 📄 License
MIT License

