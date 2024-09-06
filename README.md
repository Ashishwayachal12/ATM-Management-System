# Bank Management System

This is a simple ATM and Bank Management System developed in Java using Swing and MySQL. The system provides essential banking functionalities such as withdrawing money, checking balances, and performing transactions. It is designed with a focus on simulating an ATM-like interface for users.

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
- **Transactions**: 
  - `transaction.java` manages other banking operations such as balance inquiry, deposits, and fund transfers.

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
transaction.java: Manages banking transactions like balance inquiry, deposits, withdrawals, and transfers.

Screenshots:
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


Author
[Ashish]



