package Lab2;

import java.util.Scanner;

public class Rectangle {
    double length, breadth;

    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    Rectangle(){
        read();
    }

    void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length:");
        double l = sc.nextDouble();
        System.out.println("Enter Breadth:");
        double b = sc.nextDouble();

        calculate(l, b);
    }

    void calculate(double l,double b) {

        double a=l*b;
        double p=2*(l+b);
        Rectangle o1=new Rectangle(l,b);
        display(a,p);
    }

    void display(double a,double p){

        System.out.println("Area:"+a);
        System.out.println("Perimeter:"+p);

    }

    public static void main(String[] args){

        Rectangle o=new Rectangle();

    }


}