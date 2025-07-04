# SpringBootProjects

This repository contains multiple Java projects demonstrating various Spring Boot concepts, including REST APIs, dependency injection, JPA integration, and more. Each folder is a self-contained example or mini-application, making this repo a great resource for learning and reference.

---

## 📁 Folder Overview

| Folder                   | Description                                                                                                         | Key Files / Features                                                                                                    |
|--------------------------|---------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| `demo/`                  | A basic Spring Boot project to demonstrate Dependency Injection via XML and Java config.                            | `DemoApplication.java`, `Car.java`, `beans.xml` - shows annotation/XML config and constructor injection.                |
| `SimpleSpringJPA/`       | A RESTful User Management API using Spring Boot, Spring Data JPA, and PostgreSQL.                                   | `User.java` (entity), `UserController.java` (REST), `UserRepository.java` (JPA), `MOCK_DATA.json`, `application.properties` for DB config. Supports CRUD, pagination, bulk inserts, and validation. |
| `ProductManagemnetApi/`  | (Work in progress) Prototype for a Product Management API. Currently includes a domain model for products.          | `Product.java` - basic entity definition. Implementation pending.                                                       |

---

## 📂 Detailed Folder and Feature Description

### demo/
- **Purpose:** Introduces core Spring Boot and basic dependency injection. Illustrates both XML and annotation config styles.
- **Highlights:**  
  - `DemoApplication.java`: Main bootstrapper using annotation config.
  - `Car.java`, `Engine.java`: Simple POJOs with constructor injection.
  - `beans.xml`: XML bean configuration alternative.

### SimpleSpringJPA/
- **Purpose:** Provides a full working example of a REST API with user management, including persistence and validation.
- **Highlights:**  
  - `User.java`: JPA entity with fields, validation, and timestamping.
  - `UserRepository.java`: Custom finder methods using Spring Data JPA.
  - `UserController.java`: REST endpoints for CRUD, batch import, and pagination.
  - `MOCK_DATA.json`: Sample user data for testing.
  - `application.properties`: PostgreSQL DB configuration.
- **Techniques:**  
  - RESTful design, pagination for APIs, input validation, JPA mappings, real-world DB setup.

### ProductManagemnetApi/
- **Purpose:** Early-stage product management microservice.
- **Highlights:**  
  - `Product.java`: Simple product entity, placeholder for future CRUD/API implementation.

---

## 🛠️ How to Use

1. **Clone the repo:**
   ```bash
   git clone https://github.com/hardik118/SpringBootProjects.git
   ```

2. **Navigate to a project and run it:**
   ```bash
   cd SpringBootProjects/SimpleSpringJPA/demo
   ./mvnw spring-boot:run
   ```

3. **Database:**  
   Edit `application.properties` to match your PostgreSQL setup, or use defaults.

---

## 🚀 Closed Pull Requests

| PR Number | Title                                                         | Description & Key Code Changes                                                                                                                        | Link                                                                                                 |
|-----------|---------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| #2        | added_pagination_features                                     | Introduced pagination to User API endpoints to reduce load and improve scalability. <br>**Code:** Added paginated endpoints in `UserController.java`. | [View PR](https://github.com/hardik118/SpringBootProjects/pull/2)                                    |
| #1        | added timestamp for creation and updation of records           | Added `createdAt` and `updatedAt` (LocalDateTime) fields to User entity for record tracking. <br>**Code:** Updated `User.java`, JPA annotations.      | [View PR](https://github.com/hardik118/SpringBootProjects/pull/1)                                    |

---

## 🔮 Future Enhancements

- Complete the Product Management API with full CRUD and database integration.
- Add examples covering Spring Security, testing, and advanced data operations.
- Docker Compose for easier local setup.
- API documentation and OpenAPI specs.
- More comprehensive test coverage and CI/CD integration.
- Refined code structure as the repo expands.

---

## 🤝 Contributing

Pull requests and suggestions are welcome! Explore, fork, and submit improvements or new Spring Boot project examples.

---

## 📄 License

No license specified yet.

---

**Note:** For a full view of all files/folders, visit the [SpringBootProjects repository on GitHub](https://github.com/hardik118/SpringBootProjects).  
Search result responses for folder contents are limited; some subfolders may not be listed in this README.
