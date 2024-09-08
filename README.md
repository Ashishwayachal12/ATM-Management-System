# ATM Management System

This is a simple ATM and ATM Management System developed in Java using Swing and MySQL. The system provides essential banking functionalities such as withdrawing money, checking balances, and performing transactions. It is designed with a focus on simulating an ATM-like interface for users.

## Features

- **User Registration**: 
  - `SignupOne`, `SignupTwo`, `SignupThree` forms for capturing user information and creating a bank account.
- **Login System**: 
  - User authentication through `login.java` to access their bank account.
- **Balance Enquiry**: 
  - `BalanceEnquiry.java` allows users to check their current account balance.
- **Fast Cash Withdrawal**: 
  - `fastcash.java` provides quick cash withdrawal options.
- **Money Deposit**: 
  - `deposite.java` handles the deposit of money into the user's account.
- **Mini Statement**: 
  - `ministatement.java` shows a brief overview of recent transactions.
- **PIN Change**: 
  - `pinchange.java` allows users to update their ATM PIN.


## Technologies Used

- **Java**: The core programming language used for the system.
- **Swing**: For the graphical user interface (GUI).
- **MySQL**: For storing user and transaction data.
- **JDBC**: To connect Java applications to the MySQL database.

## Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Ashishwayachal12/BankManagementSystem.git
   cd BankManagementSystem
Database Setup:

Create a MySQL database.

Execute the provided SQL file (bank_management.sql) to create the required tables.

Update the database credentials in conn.java.

Run the Application:

Compile and run the Java files from your preferred IDE (e.g., Eclipse, IntelliJ IDEA).

Start with login.java to begin using the system.

File Descriptions

login.java: Handles the login functionality for the users.

signupOne.java, signupTwo.java, signupThree.java: Different stages of user registration for creating a new account.

BalanceEnquiry.java: Allows users to check their current balance.

fastcash.java: Provides an interface for quick cash withdrawals.

deposite.java: Handles deposits made by the user.

ministatement.java: Displays recent transaction details.

pinchange.java: Allows users to change their PIN securely.

transaction.java: Manages banking transactions like balance inquiry, deposits, withdrawals.

**How to Run the Project**:

Prerequisites:

Before running the project, ensure you have the following installed:

Java Development Kit (JDK) (Version 8 or higher)

MySQL (for database)

JCalendar Library (for date functionalities)

MySQL Connector (for database connection)

Setup Instructions:

**1.Clone the repository**:

git clone https://github.com/[Ashishwayachal12]/ATM-Management-System.git

cd ATM-Management-System

**2.Setting up the database**:

Open MySQL Workbench or any MySQL client.

Create a database and table as required by the project.

You can find the SQL script in the /database folder for creating tables and inserting sample data.

EXAMPLE:

CREATE DATABASE atm_system;

USE atm_system;

CREATE TABLE users (

    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100),
    balance DECIMAL(10, 2)
);

**3.Adding External Libraries**:

To run this project, you'll need to add the following libraries to your classpath:

JCalendar: Download JCalendar

MySQL Connector: Download MySQL Connector

**4.Configure Database**:
Open MySQL and execute the SQL scripts located in the /sql/ 

folder of the repository to create the necessary tables.

Modify the DBConnection.java file to include your MySQL username and password:


String url = "jdbc:mysql://localhost:3306/atm_system";

String user = "your_mysql_username";

String password = "your_mysql_password";

EXAMPLE:

conn.java

![image](https://github.com/user-attachments/assets/e8241e8d-c2b2-4d1b-8bee-f760ec494875)

**5.Run the Application**:

Once the above setup is done, you can compile and run the login.java class to start the ATM Management System.

**Screenshots**:

Login :

![image](https://github.com/user-attachments/assets/883eb4ab-cb09-45c8-bdb0-1dc6b723d183)

signupone:

![image](https://github.com/user-attachments/assets/2602e72c-bc63-4e73-91f4-8238ce2ddb61)

signupTwo:

![image](https://github.com/user-attachments/assets/3adea0a5-6c0e-4562-b34b-54eb70365439)

signupThree:(image you can add accounding to your references)

![image](https://github.com/user-attachments/assets/720e376f-d08d-4687-bd26-713b267f99e9)

Transition:

![image](https://github.com/user-attachments/assets/fcadd43e-1f72-4053-89e8-36d9d43d6343)

Deposit:

![image](https://github.com/user-attachments/assets/aa3aaf78-d3c2-45f7-aaf7-2f0075e25c40)

Withdrowal:

![image](https://github.com/user-attachments/assets/38c6d839-7e67-42ef-abb0-c18bf4b558a9)

FastCash:

![image](https://github.com/user-attachments/assets/0281df4f-b69a-46c1-b03a-ad144d932510)

Pinchange:

![image](https://github.com/user-attachments/assets/7672fb3c-e093-4543-a522-dd5750aa9579)

BalanceEnquiry:

![image](https://github.com/user-attachments/assets/8d28ab63-c257-440d-b000-3914388c02e0)

MiniStatement:

![image](https://github.com/user-attachments/assets/b9ab56dc-6896-4abb-ad56-8e147fb4c190)


Author:

Ashish Wayachal
Bengaluru.
Email:ashishwayachal64@gmail.com].



