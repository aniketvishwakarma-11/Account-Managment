import java.util.*;
import java.io.*;

class Account implements Serializable {
    String AccNo;
    String AccName;
    double balance;

    Account() {}

    Account(String AccNo, String AccName, double balance) {
        this.AccNo = AccNo;
        this.AccName = AccName;
        this.balance = balance;
    }

    public String toString() {
        return "Account no: " + AccNo + "\nName: " + AccName + "\nBalance: " + balance + "\n";
    }
}

public class MenuDrivenAccount {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Account Acc = null;
        HashMap<String, Account> hm = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream("Accounts.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                Acc = (Account) ois.readObject();
                hm.put(Acc.AccNo, Acc);
            }
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("No previous accounts found. Starting fresh.");
        } catch (Exception e) {
            System.out.println("Error reading accounts: " + e.getMessage());
        }

        FileOutputStream fos = new FileOutputStream("Accounts.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.println("MENU");
        int choice;
        String AccNo, AccName;
        double balance;

        do {
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. View Account");
            System.out.println("4. View All Accounts");
            System.out.println("5. Save Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter details AccNo, AccName, balance");
                    AccNo = sc.nextLine();
                    AccName = sc.nextLine();
                    balance = sc.nextDouble();
                    sc.nextLine(); // Consume leftover newline
                    Acc = new Account(AccNo, AccName, balance);
                    hm.put(Acc.AccNo, Acc);
                    System.out.println("Account Created for " + AccName);
                    break;
                case 2:
                    System.out.println("Enter AccNo to delete:");
                    AccNo = sc.nextLine();
                    if (hm.containsKey(AccNo)) {
                        hm.remove(AccNo);
                        System.out.println("Account deleted.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter AccNo to view:");
                    AccNo = sc.nextLine();
                    Acc = hm.get(AccNo);
                    if (Acc != null) {
                        System.out.println(Acc);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    if (hm.isEmpty()) {
                        System.out.println("No accounts to display.");
                    } else {
                        for (Account a : hm.values()) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 5:
                    oos.writeInt(hm.size());
                    for (Account a : hm.values()) {
                        oos.writeObject(a);
                    }
                    System.out.println("Accounts saved successfully.");
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        oos.close();
        fos.close();
        sc.close();
    }
}