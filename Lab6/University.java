package Lab6;

import java.util.Scanner;

public class University {

    String universityName, location;

    University(String universityName, String location) {
        this.universityName=universityName;
        this.location=location;
    }

    class Department {

        String deptName,hodName;
        Department(String deptName,String hodName) {
            this.deptName=deptName;
            this.hodName=hodName;
        }

        void display() {
            System.out.println("University Name: "+universityName);
            System.out.println("Location: "+location);
            System.out.println("Department Name: "+deptName);
            System.out.println("HOD Name: "+hodName);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter University name :");
        String n=sc.nextLine();
        System.out.print("Enter Location :");
        String l= sc.nextLine();
        University u=new University(n, l);

        System.out.print("Enter Department name :");
        String dn=sc.nextLine();
        System.out.print("Enter HOD name :");
        String h=sc.nextLine();
        University.Department d=u.new Department(dn, h);

        d.display();
    }
}
