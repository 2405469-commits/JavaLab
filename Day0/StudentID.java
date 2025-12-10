import java.util.Scanner;
public class StudentID {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Name:");
        String name=sc.nextLine();

        System.out.print("Enter Branch:");
        String branch=sc.nextLine();

        System.out.print("Enter Roll No:");
        int roll=sc.nextInt();

        System.out.print("Enter Section: CSE-");
        int section=sc.nextInt();

        System.out.println("\nName:"+name+"\nRoll no:"+roll+"\nSection:"+section+"\nBranch:"+branch);
    }
}
