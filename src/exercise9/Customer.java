package exercise9;

public class Customer implements Comparable{

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


    @Override
    public int compareTo(Object o) {
        Customer c = (Customer) o;
        if(customerId==c.getCustomerId()){
            return 0;
        } else if(customerId<c.getCustomerId()){
            return -1;
        }else {
            return 1;
        }
    }
}
