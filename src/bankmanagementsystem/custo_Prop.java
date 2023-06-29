package bankmanagementsystem;

import Exception.InvalidAccount;

public class custo_Prop {

    private String customer_name;
    private String customer_username;
    private String customer_password;
    private String customer_email;
    private String customer_address;
    private String customer_cardNo;
    private String customer_phone_no;

    public custo_Prop(String customer_name, String customer_username, String customer_password, String customer_email, String customer_address, String customer_cardNo, String customer_phone_no) throws InvalidAccount {
        this.customer_name = customer_name;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_cardNo = customer_cardNo;
        this.customer_phone_no = customer_phone_no;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password){
        this.customer_password = customer_password;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email){
        this.customer_email = customer_email;
    }

    public String getCustomer_cardNo() {
        return customer_cardNo;
    }

    public void setCustomer_cardNo(String customer_cardNo) {
        this.customer_cardNo = customer_cardNo;
    }

    public String getCustomer_phone_no() {
        return customer_phone_no;
    }

    public void setCustomer_phone_no(String customer_phone_no) {
        this.customer_phone_no = customer_phone_no;
    }

    @Override
    public String toString() {
        return "custo_Prop{" + "customer_name=" + customer_name + ", customer_username=" + customer_username + ", customer_password=" + customer_password + ", customer_email=" + customer_email + ", customer_address=" + customer_address + ", customer_cardNo=" + customer_cardNo + ", customer_phone_no=" + customer_phone_no + '}';
    }

}
