package Lab7;

import java.util.Scanner;

// User-defined exception
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

// Main class
public class ProcessNumber {
    public void ProcessInput() throws NegativeNumberException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num < 0) {
            throw new NegativeNumberException("Negative number entered!");
        } else {
            System.out.println("Double value: " + (num * 2));
        }
    }

    public static void main(String[] args) {
        ProcessNumber obj = new ProcessNumber();
        try {
            obj.ProcessInput();
        } catch (NegativeNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}

