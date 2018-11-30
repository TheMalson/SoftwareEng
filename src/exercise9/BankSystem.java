package exercise9;

import java.util.ArrayList;
import java.util.HashMap;


public class BankSystem {

    private HashMap<Integer,Account> hmCustomerAccount;
    private ArrayList<Customer> customerList;

    public BankSystem() {
        customerList = new ArrayList<Customer>();
        hmCustomerAccount = new HashMap<Integer,Account>();
    }

    public HashMap<Integer, Account> getHmCustomerAccount() {
        return hmCustomerAccount;
    }


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }


    public Customer createCustomer(int customerId,String name){
        Customer newCustomer = new Customer(customerId,name);
        customerList.add(newCustomer);
        return newCustomer;
    }

    public void createAccount(int customerId, double balance){

        if(accountExists(customerId)==false){
            Account newAccount = new Account(balance);
            hmCustomerAccount.put(customerId,newAccount);
        } else{
            System.out.println("Kunden ID nicht gefunden");
        }

    }

    public void transferMoney(int sourceCustomerId,int tragetCustomerId, double amount){

        if(accountExists(sourceCustomerId) && accountExists(tragetCustomerId)) {

            Account accountSource = hmCustomerAccount.get(sourceCustomerId);
            Account accountTarget = hmCustomerAccount.get(tragetCustomerId);

            accountSource.setBalance(accountSource.getBalance() - amount);
            accountTarget.setBalance(accountTarget.getBalance() + amount);
        } else{
            System.out.println("Eine der Kunden IDs existiert nicht");
        }
    }

    public void deleteCustomer(int customerId){

        hmCustomerAccount.remove(customerId);

        for (Customer c : customerList){
            if(c.getCustomerId() == customerId){
                customerList.remove(c);
                break;
            }
        }


    }

    public boolean accountExists(int id){
        return hmCustomerAccount.containsKey(id);
      }

}
