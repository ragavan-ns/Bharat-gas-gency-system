package Customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer {

    static int connectionNumber = 100;

    String date;

    public int numberOfCylinders;

    public GasConnection(String name, String street, String area, String pinCode, String mobile, int numberOfCylinders) {
        super(name, street, area, pinCode, mobile);
        this.numberOfCylinders = numberOfCylinders;
    }

    {
        connectionNumber += 1;
    }

    Date lastDate = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void getlastDate(){
        System.out.println("Enter the last Date");

        date = new Scanner(System.in).nextLine();

        try{
            lastDate = dateFormat.parse(date);
        }
        catch (Exception e){
            System.out.println("Error in getLastDate : " + e);
        }
    }



}
