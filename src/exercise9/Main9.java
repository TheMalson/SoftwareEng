package exercise9;

import java.util.ArrayList;
import java.util.HashMap;

public class Main9 {
    public static void main (String[] args) {
        BankSystem bs = new BankSystem();

        Customer c1 = bs.createCustomer(1,"Erster Kunde");
        Customer c2 = bs.createCustomer(2,"Zweiter Kunde");
        Customer c3 = bs.createCustomer(3,"Dritter Kunde");

        bs.createAccount(c1.getCustomerId(), 200.00);
        bs.createAccount(c2.getCustomerId(), 12.22);
        bs.createAccount(c3.getCustomerId(), 32.22);

        printCustomers(bs);

        bs.transferMoney(1,4,50);
        printCustomers(bs);

        bs.deleteCustomer(3);
        printCustomers(bs);

    }

    public static void printCustomers (BankSystem bs){

        ArrayList<Customer> customerList = bs.getCustomerList();
        HashMap<Integer,Account> hmCustomerAccount = bs.getHmCustomerAccount();

        for(Customer c : customerList){
            System.out.println("KundenID: " + c.getCustomerId());
            System.out.println("Name: " + c.getName());
            System.out.println("Kontostand: " + hmCustomerAccount.get(c.getCustomerId()).getBalance());
            System.out.println("--------------------------------------------------------");
        }

        System.out.println();
        System.out.println();
    }
}
