package Lab2;

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

