public class Main {
    public static void main(String[] args) {
        // Create a SavingsAccount instance
        SavingsAccount savings = new SavingsAccount("SA123", 
                                                    "Alice", 
                                                    1500.0, 
                                                    5.0, 
                                                    500.0);

        // Create a CurrentAccount instance
        CurrentAccount current = new CurrentAccount("CA456",
                                                    "Bob", 
                                                    1000.0, 
                                                    200.0);
    
        // Store accounts in an array
        Account[] accounts = {savings, current};

        // Display initial balances
        System.out.println("=== Initial Balances: ===");
        for (Account acc : accounts) {
            System.out.println(acc.getName() + ": " + acc.getBalance());
        }

        System.out.println("\n=== Calculating Interests: ===");
        // Calculate and display interest for each account
        for (Account acc : accounts) {
            double interest = acc.calculateInterest();
            System.out.println(acc.getName() + " Interest: " + interest);
        }
        System.out.println("\nDepositing calculated interests...");
         // Deposit calculated interest
        for (Account acc : accounts) {
            double interest = acc.calculateInterest();
            acc.deposit(interest);
        }

        System.out.println("\n=== Performing Transactions: ===");
        // Perform deposits
        System.out.println("\nDepositing amounts...");
        savings.deposit(500.0);
        current.deposit(300.0);
        // Perform withdrawals
        System.out.println("\nWithdrawing amounts...");
        savings.withdraw(2000.0); // Should be denied due to minimum balance
        current.withdraw(1200.0); // Should be allowed due to overdraft
        // Deduct monthly fee from current account
        current.deductMonthlyFee();

        System.out.println("\n=== Final Balances: ===");
        // Display final balances
        for (Account acc : accounts) {
            System.out.println(acc.getName() + ": " + acc.getBalance());
        }
    }
}