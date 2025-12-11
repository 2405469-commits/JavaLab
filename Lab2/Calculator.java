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

