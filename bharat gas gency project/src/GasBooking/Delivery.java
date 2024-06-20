package GasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{

    public String delPersonName;

    int customerOtp;
    public Delivery(String name, String street, String area, String pinCode, String mobile, int numberOfCylinders) {
        super(name, street, area, pinCode, mobile, numberOfCylinders);
    }

    public void amountCalc(){
        long dayDiff = dt_2.getTime() - dt_1.getTime(); //dt_2 is delivery and dt_1 is booking
        long newDiff = TimeUnit.DAYS.convert(dayDiff,TimeUnit.MILLISECONDS);

        if (newDiff > 7){
            refund = 41.25;
            amount = amount - refund;
        }
    }

    public void verifyOtp(){
        if (status.equals("B")){
            System.out.println("Enter OTP : ");
            customerOtp = new Scanner(System.in).nextInt();

            if (customerOtp != otp){
                status = "C";
            }else{
                status = "D";
            }
        }else {
            System.out.println("No booking is found ....");
        }
    }

    public void delPersonDetails(){
        System.out.println("\n Enter the delivery person name : ");
        delPersonName = new Scanner(System.in).nextLine();
    }
}
