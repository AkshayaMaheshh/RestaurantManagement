# 🍽️ RESTAURANT ORDER MANAGEMENT SYSTEM

---

### 🧠 INTRODUCTION
The **Restaurant Order Management System** is a Java-based desktop application that simplifies the process of managing customer food orders.  
It allows customers to place orders, view menu items, and store order information directly in a **MySQL** database using **JDBC connectivity**.  
The system integrates **Java Swing (GUI)** for the user interface and **OOP principles** for modular and efficient code design.

---

### ⚙️ TECHNOLOGIES USED
- **Programming Language:** Java  
- **GUI Framework:** Java Swing  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **Concepts Applied:** OOP, Multithreading, Exception Handling, File I/O

---
### 🧩 MODULES DESCRIPTION

> | **Module** | **Description** |
> |-------------|-----------------|
> | **1. Menu Management** | Defines dishes using classes and inheritance (Veg and Non-Veg dishes). |
> | **2. Order Processing** | Saves and reads orders from files using file handling and exceptions. |
> | **3. Customer Management** | Simulates multiple customers ordering simultaneously using threads. |
> | **4. Database Connection** | Connects Java with MySQL to store and retrieve order details. |
> | **5. GUI Interface** | Provides an interactive graphical interface to place and view orders. |


---

### 🗃️ DATABASE STRUCTURE

**Database Name:** `restaurantdb`  
**Table Name:** `orders`

| Column Name | Data Type | Description |
|--------------|------------|-------------|
| id | INT (AUTO_INCREMENT) | Unique order ID |
| customer_name | VARCHAR(50) | Name of the customer |
| order_details | VARCHAR(100) | Ordered items |
| total_price | DECIMAL(10,2) | Total bill amount |
| order_time | TIMESTAMP | Date & time of the order |

**Sample Data**

| ID | Customer | Order | Total Price | Order Time |
|----|-----------|--------|--------------|-------------|
| 1 | Alice | Pasta, Juice | ₹350.00 | 2025-11-08 21:15:00 |
| 2 | Bob | Chicken Curry, Naan | ₹480.00 | 2025-11-08 21:15:00 |
| 3 | Charlie | Pizza, Coke | ₹420.00 | 2025-11-08 21:15:00 |

---

### 💻 HOW TO RUN THE PROJECT
1. Install **Java JDK** and **MySQL Server**.  
2. Open **MySQL Workbench** and execute:
   ```sql
   CREATE DATABASE restaurantdb;
   USE restaurantdb;
   CREATE TABLE orders (
       id INT AUTO_INCREMENT PRIMARY KEY,
       customer_name VARCHAR(50),
       order_details VARCHAR(100),
       total_price DECIMAL(10,2),
       order_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );

