package bankmanagementsystem;

public interface Transaction {

    void withdraw(double amount) throws MaxWithdraw;

    void deposit(double amount) throws InvalidAmount;
}
