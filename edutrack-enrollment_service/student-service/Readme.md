# 🎓 Student Service - EduTrack Microservice

The **Student Service** is a part of the **EduTrack** platform – a modular Spring Boot-based system designed for managing education processes like course creation, student registration, and enrollment.

---

## 📘 Overview

This service provides RESTful APIs to register students, fetch individual or all student records, and supports validation and global exception handling.

---

## 🔗 Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/students` | Register a new student |
| `GET`  | `/students` | Retrieve all students |
| `GET`  | `/students/{id}` | Get details of a specific student by ID |

---

## 🧱 Project Structure

```
student-service/
├── controller/          # REST Controllers
├── dto/                 # DTOs for request/response
├── model/               # JPA Entity classes
├── repository/          # Spring Data JPA interfaces
├── exception/           # Custom exception handlers and error responses
└── service/             # Business logic (optional)
```

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Hibernate Validator (DTO-based validation)
- H2 Database (in-memory)
- Maven
- Lombok (optional)
- Spring Boot DevTools

---

## 🔄 Request/Response Example

### ✅ Register a Student

**POST** `/students`

```json
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com"
}
```

**Response**

```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane.doe@example.com"
}
```

---

## ⚠️ Validation

- DTO-based validation using annotations like `@NotBlank`, `@Email`, `@Size`, etc.
- Requests that fail validation return `400 Bad Request` with appropriate messages.

---

## 🚨 Global Exception Handling

Handled using `@RestControllerAdvice`. The handler captures:
- Validation errors
- Entity not found
- Generic internal server errors

---

## 🧪 Run Locally

### Step 1: Clone and navigate
```bash
git clone https://github.com/your-repo/edutrack.git
cd student-service
```

### Step 2: Run the app
```bash
./mvnw spring-boot:run
```

OR use IntelliJ or VSCode to run `StudentServiceApplication.java`

---

## 🔍 Test Using Postman or Curl

```bash
curl -X POST http://localhost:8081/students \
-H "Content-Type: application/json" \
-d '{"name": "John Doe", "email": "john@example.com"}'
```

---

## 🧩 Integration with Other Services

This service is used by the **Enrollment Service** to verify student details before enrollment. It is designed to be consumed via REST in a microservice ecosystem.

---

## 💡 Future Enhancements

- Add Swagger documentation
- Support pagination and search
- Authentication and Role-based Authorization
- Docker support

---

## 👨‍💻 Maintainer

**Ashish**

---

## 📄 License

Licensed under the MIT License.

