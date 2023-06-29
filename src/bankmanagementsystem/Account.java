package bankmanagementsystem;

import Exception.invaild_value;

public class Account implements Transaction {

    private AccountProperty accountProperty;
    private Customer customer;

    public Account(AccountProperty accountProperty, Customer customer) {
        this.accountProperty = accountProperty;
        this.customer = customer;
    }

    public Customer getCustomer() throws invaild_value {
        if (customer == null) {
            throw new invaild_value("Invaild value...!");
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountProperty getAccountProperty() {
        return accountProperty;
    }

    public void setAccountProperty(AccountProperty accountProperty) {
        this.accountProperty = accountProperty;
    }

    //deposit function
    @Override
    public void deposit(double amount) throws InvalidAmount {
        accountProperty.deposit(amount);
    }

    //withdraw function
    @Override
    public void withdraw(double amount) throws MaxWithdraw {
        accountProperty.withdraw(amount);
    }

    @Override
    public String toString() {
        return "Account{" + "accountProperty=" + accountProperty + ", customer=" + customer + '}';
    }

}
