package bankmanagementsystem;

import java.util.HashMap;

public class Customer {

    private static int counter = 0;
    private final int customer_id;
    private custo_Prop customerProp;
    private HashMap property;

    static {
        counter = 1;
    }

    public Customer(custo_Prop customerProp,HashMap property) {
        this.customer_id = counter;
        this.customerProp=customerProp;
        this.property=property;
        counter++;
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public custo_Prop getCustomerProp() {
        return customerProp;
    }

    public void setCustomerProp(custo_Prop customerProp) {
        this.customerProp = customerProp;
    }

    public HashMap getProperty() {
        return property;
    }

    public void setProperty(HashMap property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", customerProp=" + customerProp + ", property=" + property + '}';
    }   
}
