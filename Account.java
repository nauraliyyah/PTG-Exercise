// Base class: Account
public class Account {
    // Attributes
    private final String accountNumber;
    private String name;
    private double balance;

    // Constructor
    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Method 1: deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Balance: " + balance);
        }
    }

    // Method 2: withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount. Balance: " + balance);
        }
    }

    // Method 3: calculate interest (to be overridden in subclasses)
    public double calculateInterest() {
        return 0.0; 
    }

    // Method 4: getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method 5: getter for name
    public String getName() {
        return name;
    }

    // Method 6: getter for balance
    public double getBalance() {
        return balance;
    }     
}