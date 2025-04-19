# Address Book Spring Boot App

This is a Spring Boot application for managing an *Address Book*.  
It exposes a RESTful API to perform basic CRUD operations.

---

## 📌 Project Details

- *Project Name:* Address Book App
- *Group:* com.bridgelabz
- *Artifact:* address-book
- *Package Name:* com.bridgelabz.address-book
- *Spring Boot Version:* 3.4.4
- *Java Version:* 17
- *Packaging:* JAR



## 🧩 Dependencies

1. Spring Web
2. Spring Data JPA
3. Lombok
4. MySQL Driver
5. Validation

--- 

## 📋 API Endpoints

| Method | Endpoint                                      | Description                                  |
|--------|-----------------------------------------------|----------------------------------------------|
| GET    | `/address-book/`                              | Welcome message                              |
| GET    | `/address-book/getAllAddress`                 | Get all address book entries                 |
| GET    | `/address-book/getAddressByCountry/{country}` | Get entries filtered by country              |
| GET    | `/address-book/getAddress/{id}`               | Get address entry by ID                      |
| POST   | `/address-book/create`                        | Create a new address entry                   |
| PUT    | `/address-book/update/{id}`                   | Update an existing address entry by ID       |
| DELETE | `/address-book/delete/{id}`                   | Delete a specific address entry by ID        |
| DELETE | `/address-book/deleteAllAddress`              | Delete all address entries                   |

---