# Smart Inventory & Sales Management System

## Project Description

This project focuses on developing a Java-based console program to manage products, inventories, and sales information effectively.

The software allows the addition of products, management of products, search of products from inventory, sale logging, sale history view, and products that have stock equivalent to the minimum threshold limit are marked.

The project is created with the use of Java programming language version 17, and all data in the application is saved in text files.

## Features

- Include new items in the stock
- Browse through all items available
- Search for items based on Product ID
- Edit existing item information
- Remove items from the stock
- Register sales of items
- Get the whole sales report
- Create low stock report
- Total sale amount is calculated automatically
- Automatic date and time record for sale entry
- Data persistency via text files
- Numeric input validation

## Technologies Employed

- Java 17
- Object Oriented Programming (OOP)
- ArrayList
- File Handling
- Exception Handling
- Java Date & Time API
- Text Files
- VS Code

## Requirements

- JDK 17 or later
- Visual Studio Code or any other Java IDE
- Windows/Linux/MacOS
- External database not needed
- No extra libraries needed

## Project Structure

```text
SmartInventorySalesManagement/
│
├── src/
│   ├── Main.java
│   ├── Product.java
│   ├── Sale.java
│   ├── InventoryManager.java
│   └── FileManager.java
│
├── data/
│   ├── products.txt
│   └── sales.txt
│
├── .gitignore
└── README.md

Responsibilities of Classes
Main.java – Deals with menu handling on the console and the user interface.
Product.java – Deals with product details and inventory.
Sale.java – Deals with individual transaction handling.
InventoryManager.java – Deals with the sale and inventory handling.
FileManager.java – Deals with the file input-output operations.

## Running the Program

### Step 1: Open the Project
You only need to open the `SmartInventorySalesManagement` directory in any IDE that works with Java code, like Visual Studio Code.
### Step 2: Compilation
Enter the below-given command in the terminal for compilation:
```bash
javac -d out src/*.java
```
### Step 3: Run the Application

After successful compilation, run:

```bash
java -cp out Main

## Main Menu & Its Functions

The menu provides the options for:

1. **Create Product** – Creates a new product entry.
2. **List Products** – Displays all products along with the stock levels.
3. **Find Product** – Find a particular product with the Product ID.
4. **Update Product** – Updates the details of the product.
5. **Delete Product** – Deletes a product from the list.
6. **Register Sales** – Registers a sale transaction and also updates the stock level.
7. **List of Sales** – Display the transactions of all registered sales.
8. **Low Stock Report** – Display all the products with the low stock levels compared to the minimum stock level.
9. **Exit Program** – Exit the program.

## Data Storage

The application uses text files to keep data for a time.

- products txt keeps information about products and what is in stock.

- Sales txt keeps records of sales transactions.

The information is brought in when the application begins and it is changed whenever details, about products or sales are updated.

## Concepts of Java Utilized

- Class and Objects: the idea of making pretend things.

- Encapsulation: keeping the facts inside a box.

- Constructor: the method that builds a new thing.

- ArrayList and Collections: a list that can grow.

- Method: a small set of steps that does a job.

- Conditionals: choosing between different paths.

- Looping: doing something over and over.

- Switch Case: a way to pick from many options.

- Exceptions: handling unexpected problems.

- File I/O: reading from and writing to files.

- Dates and Times: working with moments, on the calendar.

