package Lab2;

import java.util.Scanner;

public class Demo{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter Length:");
        double l=sc.nextDouble();
        System.out.print("Enter Breadth:");
        double b=sc.nextDouble();
        System.out.print("Enter Height:");
        double h =sc.nextDouble();
        
        box o1=new box(l,b,h);

        System.out.print("\nVolume:"+o1.volume());
    
    }
}
