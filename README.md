# 💰 Finance Dashboard

## 📌 Overview

This project is a backend system for a finance dashboard that allows users to manage financial records, apply role-based access control, and view summarized insights.

It is built using **Spring Boot** with a clean layered architecture and follows best backend practices.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman

---

## 🏗️ Architecture

```
Controller → Service → Repository → Database
```

* **Controller** → Handles API requests
* **Service** → Business logic
* **Repository** → Database interaction

---

## 👥 User Roles

| Role    | Permissions                          |
| ------- | ------------------------------------ |
| ADMIN   | Full access (create, update, delete) |
| ANALYST | View records + dashboard             |
| VIEWER  | Read-only access                     |

---

## 🔐 Role-Based Access

Roles are passed using HTTP headers:

```
Key: role
Value: ADMIN
```

---

## 💰 Financial Record Structure

```json
{
  "amount": 1000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-02",
  "notes": "Monthly salary",
  "userId": 2
}
```

---

## 📡 API Endpoints

### 🔹 Create Record

```
POST /records
Header: role=ADMIN
```

---

### 🔹 Get All Records

```
GET /records
```

---

### 🔹 Update Record

```
PUT /records/{id}
Header: role=ADMIN
```

---

### 🔹 Delete Record

```
DELETE /records/{id}
Header: role=ADMIN
```

---

### 🔹 Filter Records

```
GET /records/filter?type=EXPENSE
GET /records/filter?category=Food
```

---

### 🔹 Pagination

```
GET /records/paginated?page=0&size=5
```

---

### 🔹 Dashboard APIs

* Total Income
* Total Expense
* Net Balance

---

## 📊 Sample Pagination Response

```json
{
  "content": [...],
  "totalElements": 7,
  "totalPages": 4,
  "size": 2,
  "number": 0
}
```

---

## ⚠️ Error Handling

| Scenario          | Response        |
| ----------------- | --------------- |
| Invalid input     | 400 Bad Request |
| Unauthorized role | 403 Forbidden   |
| Record not found  | 404 Not Found   |

---

## ✅ Features Implemented

* User Management
* Financial Records CRUD
* Filtering
* Pagination
* Dashboard Summary APIs
* Role-Based Access Control
* Validation & Error Handling

---

## ❌ Optional Features Not Implemented

* Authentication (JWT)
* Soft delete
* Rate limiting
* Unit testing

**Reason:** Focused on core backend logic and clean design.

---

## ▶️ How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application
4. Test APIs using Postman

---

## 🧠 Design Decisions

* Used layered architecture for maintainability
* Implemented pagination for scalability
* Used header-based role access for realism
* Used ResponseEntity for proper HTTP responses

---

## 📌 Conclusion

This project demonstrates strong backend fundamentals including API design, data handling, access control, and system structure.

---
