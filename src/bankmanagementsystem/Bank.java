package bankmanagementsystem;

import Exception.amountException;
import Exception.invaild_value;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String code;
    private String address;
    private String name;
    private ArrayList<Account> accounts;

    public Bank(String code, String address, String name) {
        this.code = code;
        this.address = address;
        this.name = name;
        accounts = new ArrayList();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //add account
    public void addAccount(Account account) {
        if (accounts == null) {
            accounts = new ArrayList();
        }
        accounts.add(account);
    }

    //delete account
    public Account deleteAccount(int account_number) {
        Account accDeleted = null;
        if (!accounts.isEmpty()) {
            for (Account acc : accounts) {
                if (acc.getAccountProperty().getAccount_number() == account_number) {
                    accDeleted = acc;
                    accounts.remove(acc);
                    break;
                }
            }
        }
        return accDeleted;
    }

    //search account
    public Account searchAccount(int account_number) {
        try {
            for (Account acc : getAccounts()) {
                if (acc.getAccountProperty().getAccount_number() == account_number) {
                    return acc;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return null;
    }

    //edit account
    public Account editAccount(Account oldAccount, Account newAccount) throws amountException, invaild_value {
        Account account = null;
        if (isContain(oldAccount)) {
            for (Account acc : accounts) {
                if (acc.equals(oldAccount)) {
                    System.out.println("------------found-------------");
                    acc.setAccountProperty(newAccount.getAccountProperty());
                    acc.setCustomer(newAccount.getCustomer());
                    account = acc;
                    break;
                }
            }
            return account;
        }
        return null;
    }

    //get all acounts
    public List<Account> getAccounts() {
        if (accounts.isEmpty() || accounts == null) {
            throw new RuntimeException("Account list is not valid!");
        } else {
            return accounts;
        }
    }

    //get account by number
    public Account getAccount(int account_number) {
        try {
            for (Account acc : getAccounts()) {
                if (acc.getAccountProperty().getAccount_number() == account_number) {
                    return acc;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return null;
    }

    //to verify account contain or not
    public Boolean isContain(Account account) {
        return accounts.contains(account);
    }

    //deposit function
    public void deposit(int acc_num, double amount) throws AccNotFound, InvalidAmount {
        Account acc = searchAccount(acc_num);
        if (acc == null) {
            throw new AccNotFound("Account Not Found");
        } else {
            acc.deposit(amount);
        }
    }

    //withdraw function
    public void withdraw(int acc_num, double amount) throws MaxWithdraw, AccNotFound {
        Account acc = searchAccount(acc_num);
        if (acc == null) {
            throw new AccNotFound("Account Not Found");
        } else {
            acc.withdraw(amount);
        }
    }

    public void displayAllAccounts() {
        try {
            for (int i = 0; i < getAccounts().size(); i++) {
                System.out.println(getAccounts().get(i));
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Bank : \n" + "code : " + code + ",\n address : " + address + ",\n name : " + name + ",\n accounts : " + accounts + '.';
    }

}
