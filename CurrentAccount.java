public class CurrentAccount extends Account {
    // Attributes
    private double overdraftLimit;
    private boolean overdraftEnabled;
    private double monthlyFee;

    // Constructor
    public CurrentAccount(String accountNumber, String name, double balance, double overdraftLimit) {
        super(accountNumber, name, balance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftEnabled = true;
        this.monthlyFee = 10.0;
    }

    // Override withdraw method to allow overdraft up to the limit
    @Override
    public void withdraw(double amount) {
        if (!overdraftEnabled) {
            System.out.println("Overdraft is disabled. Withdrawal denied.");
            return;
        }   

        if (amount > 0 && getBalance() - amount >= -overdraftLimit) {
            System.out.println("Withdrawal successful with overdraft. New balance: " + (getBalance() - amount));
        } else {
            System.out.println("Withdrawal would exceed overdraft limit. Withdrawal denied.");
        }
    }

    // Method 1: getter for overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Method 2: getter for account type
    public String getAccountType() {
        return "Current Account";
    }

    // Method 3: calculate monthly fee
    public double calculateMonthlyFee() {
        return monthlyFee;
    }
    // Method 4: calculate monthly fee (to be overridden in subclasses)
    public void deductMonthlyFee() {
        System.out.println("Deducting monthly fee: " + monthlyFee);
        withdraw(monthlyFee);
    }  
}