package Lab1;
import java.util.Scanner;

public class NameFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String fi = sc.nextLine();
        System.out.print("Enter ln name: ");
        String ln = sc.nextLine();

        System.out.println(ln + " " + fi);
    }
}