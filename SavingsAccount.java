public class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance;
    private boolean active;

    // Constructor
    public SavingsAccount(String accountNumber, String name, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, name, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.active = balance >= minimumBalance;
    }

    // Override calculate interest method
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;

    }

    // Ovverride withdraw method to prevent overdraft
    @Override
    public void withdraw(double amount) {
        if (!active) {
            System.out.println("Account is inactive. Withdrawal denied.");
            return;
        }

        if (getBalance() - amount < minimumBalance) {
            System.out.println("Withdrawal would breach minimum balance. Withdrawal denied.");
        } else {
            super.withdraw(amount);
        }
    }

    // Method 1: getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Method 2: getter for account type
    public String getAccountType() {
        return "Savings Account";
    }

    // Method 3: check if account is active
    public boolean isActive() {
        return active;
    }
} 