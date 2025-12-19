 # EasyShop E-Commerce API

### **Project Overview**
EasyShop is a RESTful API backend for an e-commerce platform built with Spring Boot. It provides comprehensive functionality for managing an online store, including product catalog management, user authentication, shopping cart operations, and order processing.

## Technologies & Tools Used
### Backend Framework

Java 17

Spring Boot 2.7.3 - Main application framework

Spring JDBC - Database connectivity and operations

Maven - Dependency management and build automation

### Database

MySQL 8.0 - Relational database management system


## Key Features
1. ### User Management

User Registration - Create new user accounts with role-based access

User Authentication - Secure login with JWT token generation

Profile Management - View and update user profile information

Role-Based Access Control - Admin and User roles with different permissions

2. ### Product Catalog

Product Browsing - View all products with filtering options

Search & Filter - Filter products by:

Category

Price range (min/max)

Subcategory


Product Details - View detailed product information

Featured Products - Highlight special products

Stock Management - Track product inventory

3. ### Category Management

Browse Categories - View all product categories

Category Details - Get specific category information

Category Products - List all products in a category

### Admin Operations (Admin only):

Create new categories

Update existing categories

Delete categories


4. ### Shopping Cart (In Development)

View Cart - Display current user's shopping cart
Add to Cart - Add products to shopping cart
Update Cart - Modify product quantities
Remove from Cart - Delete items from cart
Cart Total - Calculate total cost with discounts


## API Endpoints
### *Authentication*

POST /register - Register new user

POST /login - User login (returns JWT token)

### *Products*

GET /products - List all products (with optional filters)

GET /products/{id} - Get specific product

POST /products - Create product (Admin only)

PUT /products/{id} - Update product (Admin only)

DELETE /products/{id} - Delete product (Admin only)

### *Categories*

GET /categories - List all categories

GET /categories/{id} - Get specific category

GET /categories/{id}/products - Get products in category

POST /categories - Create category (Admin only)

PUT /categories/{id} - Update category (Admin only)

DELETE /categories/{id} - Delete category (Admin only)

### *Profile*

GET /profile - Get current user profile

PUT /profile - Update user profile

### *Shopping Cart*

GET /cart - Get user's shopping cart

POST /cart/products/{id} - Add product to cart

PUT /cart/products/{id} - Update cart item quantity

DELETE /cart - Clear shopping cart

## **Development Notes**
### *Current Status*

✅ User authentication and authorization

✅ Product catalog management

✅ Category management

✅ Profile management

⚠️ Shopping cart (partially implemented)

❌ Order processing (not implemented)

❌ Payment processing (not implemented)

## Screen Shots 

### User Login
<img width="1897" height="993" alt="Screenshot 2025-12-19 000222" src="https://github.com/user-attachments/assets/1cb1dd16-0a08-4775-9086-6db8642432d1" />

### Cart Items
<img width="1920" height="992" alt="Screenshot 2025-12-19 000419" src="https://github.com/user-attachments/assets/d9eec782-e237-417b-a56a-20db361e78b7" />

