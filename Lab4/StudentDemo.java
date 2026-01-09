package Lab4;

import java.util.*;

abstract class Student
{
    int rollno,regno;

    void getinput()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Roll no:");
        rollno=sc.nextInt();
        System.out.print("Enter Registration no:");
        regno=sc.nextInt();
    }

    abstract void course();
}

class Kiitian extends Student
{
    void course()
    {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }
}

public class StudentDemo
{
    public static void main(String[] args)
    {
        Student k=new Kiitian();
        k.getinput();
        System.out.println("Rollno - "+k.rollno);
        System.out.println("Registration no - "+k.regno);
        k.course();
    }
}
