package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class AreaOfRec {
    double l,b,area;
    AreaOfRec()
    {
        l=0;
        b=0;
        area=0;
    }
    AreaOfRec(double len,double bre)
    {
        l=len;
        b=bre;
        area=l*b;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Length:");
        double l=sc.nextDouble();
        System.out.print("Enter Length:");
        double b=sc.nextDouble();
        AreaOfRec o1=new AreaOfRec(l,b);
        System.out.println("Length:"+l+"\nBreadth:"+b+"\nArea of Rectangle:"+o1.area);
    }
}
