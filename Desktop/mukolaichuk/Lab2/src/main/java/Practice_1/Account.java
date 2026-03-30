package Practice_1;
public class Account {
    private double balance;
    private String accountNumber;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Поповнено на: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Знято: " + amount);
        } else {
            System.out.println("Недостатньо коштів або хибна сума.");
        }
    }

    public void checkBalance() {
        System.out.println("Баланс рахунку " + accountNumber + ": " + balance);
    }
}