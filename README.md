# Finance Dashboard

## 📌 Overview

This project is a backend system for a finance dashboard application.
It allows users to manage financial records, apply role-based access control, and view summary analytics.

The system is designed with clean architecture, proper API design, and scalable structure using Spring Boot.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman (for testing)

---

## 👥 User & Role Management

Roles supported:

* **ADMIN** → Full access (create, update, delete)
* **ANALYST** → View records and summaries
* **VIEWER** → Read-only access

Role-based access is implemented using **HTTP Headers**.

Example:

```
role: ADMIN
```

---

## 💰 Financial Records

Each record contains:

* Amount
* Type (INCOME / EXPENSE)
* Category
* Date
* Notes
* User ID

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

## 🔐 Access Control

Implemented using:

* Role-based checks
* HTTP Headers instead of query parameters

---

## ✅ Validation

Input validation is implemented using:

* `@Valid`
* `@NotNull`

Invalid requests return:

```
400 Bad Request
```

---

## 📊 Pagination

Pagination is implemented using Spring Data JPA.

Example response includes:

* content
* totalPages
* totalElements

---

## ⚠️ Error Handling

| Scenario          | Response        |
| ----------------- | --------------- |
| Invalid input     | 400 Bad Request |
| Unauthorized role | 403 Forbidden   |
| Record not found  | 404 Not Found   |

---

## ❌ Optional Features Not Implemented

* Authentication (JWT)
* Soft delete
* Rate limiting
* Unit testing

### Reason:

Focus was on core backend functionality, API design, and business logic.

---

## 🧠 Design Decisions

* Clean separation: Controller → Service → Repository
* Used ResponseEntity for proper HTTP responses
* Header-based role for realistic API design
* Pagination for scalability

---

## ▶️ How to Run

1. Clone repository
2. Configure MySQL in `application.properties`
3. Run Spring Boot application
4. Test APIs using Postman

---

## 🧪 Sample Header

```
Key: role
Value: ADMIN
```

---

## 📌 Conclusion

This project demonstrates:

* Backend architecture
* API design
* Role-based access control
* Data handling and validation

---
