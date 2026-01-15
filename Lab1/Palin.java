package Lab1;
import java.util.Scanner;

public class Palin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int rev=0;
        int tmp=num;

        while(tmp!=0)
        {
            rev*=10;
            rev+=tmp%10;
            tmp/=10;
        }

        if (num == rev)
            System.out.println(num+" is Palindrome");
        else
            System.out.println(num+" is not Palindrome");
    }
}