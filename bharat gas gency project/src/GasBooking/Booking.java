package GasBooking;

import Customers.*;


import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {


    public Booking(String name, String street, String area, String pinCode, String mobile, int numberOfCylinders) {
        super(name, street, area, pinCode, mobile, numberOfCylinders);
    }

    public double otp = 5678, amount = 825.0, refund = 0;

    public String dt, delDate, status, DelMobileNo = "3254673454";

    public Date dt_1,dt_2,lastDate;

    public void getDates(){
        System.out.println("Enter Booking Date : ");

        dt = new Scanner(System.in).nextLine();
        dt_1 = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try{
            dt_1 = dateFormat.parse(dt);
        }
        catch (ParseException e){
            System.out.println("The error in getDates function: " + e);
        }

        // Delivery details

        System.out.println("Enter Delivery Date : ");
        delDate = new Scanner(System.in).nextLine();

        try{
            dt_2 = dateFormat.parse(delDate);
        }
        catch (Exception e) {
            System.out.println("Error parsing date dt_2 : " + e);
        }

        //find the difference between two dates

        try{
            long difference = dt_2.getTime() - dt_1.getTime();

            //difference in days
            long newDifference = TimeUnit.DAYS.convert(difference,TimeUnit.MILLISECONDS);
            if (newDifference > 7) {
                status = "P";
            }
        }catch (Exception e){
            System.out.println("Error while finding difference : " + e);
        }
    }

    public void validate(){

        //get the difference between two dates

        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

        System.out.println("The difference between two dates is : " + diff);

        if (numberOfCylinders == 1){
            if (diff < 30) {
                System.out.println("Booking can't be done");
                // numberOfCylinders = 0;
                status = "C";
            }else{
                //System.out.println("status : booked");
                status = "B";
                lastDate = dt_1;
            }
        }else if(numberOfCylinders == 2){
            if(diff < 50){
                System.out.println("Booking can't be done");
                // numberOfCylinders = 0;
                status = "C";
            }else {
                status = "B";
                lastDate = dt_1;
            }
        }
    }
}
