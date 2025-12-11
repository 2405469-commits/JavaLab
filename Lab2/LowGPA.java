package Lab2;

import java.util.Scanner;

public class LowGPA {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of Student:");
        int n=sc.nextInt();

        int[] roll=new int[n];
        String[] name=new String[n];
        double[] CGPA=new double[n];
        int least=-1;
        double smallest=11.0;

        System.out.println("Enter All Details:\n");

        for(int i=0;i<n;i++)
        {
            System.out.println("For Student#"+(i+1));
            System.out.print("Enter Name:");
            sc.nextLine();
            name[i]=sc.nextLine();
            System.out.print("Enter RollNo:");
            roll[i]=sc.nextInt();
            System.out.print("Enter CGPA:");
            CGPA[i]=sc.nextDouble();
            if(smallest>CGPA[i])
            {
                smallest=CGPA[i];
                least=i;
            }
            System.out.println();
        }

        System.out.println("All Details:\n");

        for(int i=0;i<n;i++)
        {
            System.out.println("For Student#"+(i+1));
            System.out.println("RollNo:"+roll[i]);
            System.out.println("Name:"+name[i]);
            System.out.println("CGPA:"+CGPA[i]);
            System.out.println();
        }

        System.out.println("The Least GPA is by:");
        System.out.println("RollNo:"+roll[least]);
        System.out.println("Name:"+name[least]);
        System.out.println("CGPA:"+CGPA[least]);
        }
    }

