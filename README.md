# Menu-Driven Account Management System

This project is a **Menu-Driven Account Management System** implemented in Java. It allows users to manage multiple accounts through a simple console-based interface.
Accounts are stored in a file to ensure data persistence across sessions.
---
## Features

1. **Create Account**:
   - Add new accounts with details like account number, account holder's name, and balance.

2. **Delete Account**:
   - Remove an account using its account number.

3. **View Account**:
   - View the details of a specific account by entering its account number.

4. **View All Accounts**:
   - Display the details of all stored accounts.

5. **Save Accounts**:
   - Save all account data to a file for persistence.

6. **Exit**:
   - Exit the application safely.

---

## Technologies Used

- **Java** for application logic.
- **Serialization** for saving and loading account data.
- **File Handling** for persistent storage.
- **Collections** (HashMap) for managing account records in memory.

---

## Example Usage

### Creating an Account
```
Enter details AccNo, AccName, balance:
12345
John Doe
5000.0
Account Created for John Doe
```

### Viewing an Account
```
Enter AccNo to view:
12345
Account no: 12345
Name: John Doe
Balance: 5000.0
```

### Viewing All Accounts
```
Account no: 12345
Name: John Doe
Balance: 5000.0

Account no: 67890
Name: Jane Smith
Balance: 10000.0
```

---

## File Structure

- **`MenuDrivenAccount.java`**: Contains the main program logic.
- **`Accounts.txt`**: Stores account data (created automatically if it doesn’t exist) It is generated in the same folder as MenuDrivenAccount.java

---

## Future Enhancements

- Add password protection for accounts.
- Implement a graphical user interface (GUI).
- Add transaction history for accounts.
- Include search functionality by account holder name.

---




## Contact

For any queries, please contact:

- **Name**: Aniket Vishwakarma
- **Email**: aniketvis675@gmail.com
- **GitHub**: aniketvishwakarma-11

