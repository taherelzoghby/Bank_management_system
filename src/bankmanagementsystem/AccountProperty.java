package bankmanagementsystem;

import Exception.amountException;

public class AccountProperty implements Transaction {

    private final int account_number;
    private String account_type;
    private double account_balance;

    public AccountProperty(String account_type, double account_balance) {
        this.account_number = (int) Math.floor(Math.random() * (9999 - 1111 + 1) + 1111);
        this.account_type = account_type;
        this.account_balance = account_balance;
    }

    public int getAccount_number() {
        return account_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getAccount_balance() {

        return account_balance;
    }

    public void setAccount_balance(double account_balance) throws amountException {
        if (account_balance < 0) {
            throw new amountException("Amount less than zero..!");
        }
        this.account_balance = account_balance;
    }

    //check balance
    public double checkBalance() {
        return this.getAccount_balance();
    }



    //deposit function
    @Override
    public void deposit(double amount) throws InvalidAmount {
        if (amount < 0) {
            throw new InvalidAmount("Invalid Deposit amount");
        } else {
        account_balance += amount;
        }
    }

    //withdraw function
    @Override
    public void withdraw(double amount) throws MaxWithdraw {
        if (amount < 0) {
            throw new MaxWithdraw("Invalid  amount");
        } else if (getAccount_balance() < amount) {
            throw new MaxWithdraw("Insufficient Balance");
        } else {
        account_balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "AccountProperty{" + "account_number=" + account_number + ", account_type=" + account_type + ", account_balance=" + account_balance + '}';
    }

}
