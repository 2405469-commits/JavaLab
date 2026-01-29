package Lab6.Marketing;
import Lab6.General.Employee;
import java.util.Scanner;

public class sales extends Employee{
    sales(double bs){
        super(bs);
    }
    void tallowance(){
        double ta=bs*0.05;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee ID:");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name:");
        String nm=sc.nextLine();
        System.out.print("Enter Basic Salary:");
        double bs= sc.nextInt();
        sales s=new sales(bs);
        s.earnings();
        System.out.println("\nEmployee ID:"+id);
        System.out.println("Total Earning:"+s.earnings());
    }
}

