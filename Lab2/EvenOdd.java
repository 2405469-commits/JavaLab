package Lab2;

public class EvenOdd {
    public static void main(String[] args) {

        if (args.length < 10) {
            System.out.println("Please enter 10 numbers as command line arguments.");
            return;
        }

        int even = 0, odd = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(args[i]);

            if (num % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }
}
