package Lab6;

import java.util.Scanner;

public class Bank{

    int accNo;

    public static class InterestCalculator{

        static void calc(double P,double r,int t) {
            double SI=(P*r*t)/100;
            System.out.println("Simple Interest: "+SI);
        }
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int acc=sc.nextInt();
        System.out.print("Enter Principal Amount: ");
        double P=sc.nextDouble();
        System.out.print("Enter Time Period: ");
        int t=sc.nextInt();
        double r=5.0;
        Bank.InterestCalculator.calc(P,r,t);
    }
}
