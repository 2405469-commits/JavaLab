package Lab2;

class Calculator {


    void subtract(int a, int b) {
        System.out.println("Result (int - int): " + (a - b));
    }


    void subtract(int a, int b, int c) {
        System.out.println("Result (int - int - int): " + (a - b - c));
    }


    void subtract(double a, double b) {
        System.out.println("Result (double - double): " + (a - b));
    }


    void subtract(int a, double b) {
        System.out.println("Result (int - double): " + (a - b));
    }


    void subtract(double a, int b) {
        System.out.println("Result (double - int): " + (a - b));
    }
}

public class SubtractDemo {
    public static void main(String[] args) {

        Calculator obj = new Calculator();

        obj.subtract(20, 10);          // int - int
        obj.subtract(50, 20, 10);      // int - int - int
        obj.subtract(15.5, 5.2);       // double - double
        obj.subtract(10, 3.5);         // int - double
        obj.subtract(12.75, 2);        // double - int
    }
}
