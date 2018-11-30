package exercise9;

public class Customer {

    private int customerId;
    private String name;

    public Customer(int id, String name){
        this.customerId = id;
        this.name = name;
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getName(){
        return name;
    }



}
