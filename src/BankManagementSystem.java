
import Exception.AccountValidation;
import Exception.InvalidAccount;
import Exception.amountException;
import Exception.invaild_value;
import bankmanagementsystem.AccNotFound;
import bankmanagementsystem.Account;
import bankmanagementsystem.AccountProperty;
import bankmanagementsystem.Bank;
import bankmanagementsystem.Customer;
import bankmanagementsystem.InvalidAmount;
import bankmanagementsystem.MaxWithdraw;
import bankmanagementsystem.custo_Prop;
import java.util.HashMap;
import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) throws MaxWithdraw, InvalidAmount, AccNotFound, amountException, invaild_value, InvalidAccount {
        Scanner input = new Scanner(System.in);

        AccountValidation accountValidation = new AccountValidation();
        Bank bank = new Bank("2334", "22633", "lumi");
        int select = 0;
        HashMap property = new HashMap();
        while (select
                    != 8) {
            System.out.println("--------------------------");
            System.out.println("1-Display all account details.\n2-add account .\n3-search by account number.\n4-delete account.\n5-deposit the amount.\n6-withdraw the amount.\n7-edit account.\n8-exit.");
            System.out.println("--------------------------");
            System.out.print("Enter your select : ");
            select = input.nextInt();
            switch (select) {
                case 1 -> {
                    bank.displayAllAccounts();
                }
                case 2 -> {
                    try {
                        System.out.print("Enter name : ");
                        String customer_name = input.next();
                        System.out.print("Enter username : ");
                        String customer_username = input.next();
                        System.out.print("Enter password : ");
                        String customer_password = input.next();
                        accountValidation.checkPassword(customer_password);
                        System.out.print("Enter email : ");
                        String customer_email = input.next();
                        accountValidation.checkEmail(customer_email);
                        System.out.print("Enter address : ");
                        String customer_address = input.next();
                        System.out.print("Enter card number : ");
                        String customer_cardNo = input.next();
                        accountValidation.checkCardNum(customer_cardNo);
                        System.out.print("Enter phone number : ");
                        String customer_phone_no = input.next();
                        accountValidation.checkPhoneNum(customer_phone_no);
                        System.out.print("Enter balance : ");
                        double accountBalance = input.nextDouble();
                        System.out.print("Enter account type : ");
                        String accTyp = input.next();
                        custo_Prop customer_Prop = new custo_Prop(customer_name, customer_username, customer_password, customer_email, customer_address, customer_cardNo, customer_phone_no);
                        Customer customer = new Customer(customer_Prop, property);
                        AccountProperty accProp = new AccountProperty(accTyp, accountBalance);
                        Account acc = new Account(accProp, customer);
                        bank.addAccount(acc);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number : ");
                    int acc_num = input.nextInt();
                    Account acc = bank.searchAccount(acc_num);
                    System.out.println(acc);
                }
                case 4 -> {
                    System.out.print("Enter account number : ");
                    int acc_num = input.nextInt();
                    Account acc = bank.deleteAccount(acc_num);
                    System.out.println("this account : " + acc + " is Deleted!");
                }
                case 5 -> {
                    System.out.print("Enter account number : ");
                    int acc_num = input.nextInt();
                    Account acc = bank.searchAccount(acc_num);
                    if (acc == null) {
                        break;
                    }
                    System.out.print("Enter deposit value : ");
                    double ds = input.nextDouble();
                    acc.deposit(ds);
                    System.out.println(acc.getAccountProperty());
                }
                case 6 -> {
                    System.out.print("Enter account number : ");
                    int acc_num = input.nextInt();
                    Account acc = bank.searchAccount(acc_num);
                    if (acc == null) {
                        break;
                    }
                    System.out.print("Enter withdraw value : ");
                    double ws = input.nextDouble();
                    acc.withdraw(ws);
                    System.out.println(acc.getAccountProperty());
                }
                case 7 -> {
                    try{
                    System.out.print("Enter old account number : ");
                    int acc_num = input.nextInt();
                    Account old_acc = bank.searchAccount(acc_num);
                    if (old_acc == null) {
                        System.out.println("Not found!");
                        break;
                    }
                    System.out.print("Enter new name : ");
                    String customer_name = input.next();
                    System.out.print("Enter new username : ");
                    String customer_username = input.next();
                    System.out.print("Enter new password : ");
                    String customer_password = input.next();
                    accountValidation.checkPassword(customer_password);
                    System.out.print("Enter new email : ");
                    String customer_email = input.next();
                    accountValidation.checkEmail(customer_email);
                    System.out.print("Enter new address : ");
                    String customer_address = input.next();
                    System.out.print("Enter new card number : ");
                    String customer_cardNo = input.next();
                    accountValidation.checkCardNum(customer_cardNo);
                    System.out.print("Enter new phone number : ");
                    String customer_phone_no = input.next();
                    accountValidation.checkPhoneNum(customer_phone_no);
                    System.out.print("Enter new balance : ");
                    double accountBalance = input.nextDouble();
                    System.out.print("Enter new account type : ");
                    String accTyp = input.next();
                    custo_Prop customer_Prop = new custo_Prop(customer_name, customer_username, customer_password, customer_email, customer_address, customer_cardNo, customer_phone_no);
                    Customer customer = new Customer(customer_Prop, property);
                    AccountProperty accProp = new AccountProperty(accTyp, accountBalance);
                    Account ac = new Account(accProp, customer);
                    Account accou = bank.editAccount(old_acc, ac);
                    System.out.print("New Account : " + accou);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

}
