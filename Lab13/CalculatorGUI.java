package Lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Custom Exception
class CalculationException extends Exception {
    public CalculationException(String msg) {
        super(msg);
    }
}

// Thread class
class CalcThread extends Thread {

    double n1, n2;
    String op;
    JTextField result;

    CalcThread(double n1, double n2, String op, JTextField result) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
        this.result = result;
    }

    public void run() {
        try {
            Thread.sleep(500); // delay

            double ans = 0;

            if (op.equals("square")) {
                if (n1 < 0) throw new CalculationException("Negative number not allowed");
                ans = n1 * n1;
            }

            else if (op.equals("sqrt")) {
                if (n1 < 0) throw new CalculationException("Negative number not allowed");
                ans = Math.sqrt(n1);
            }

            else if (op.equals("power")) {
                ans = Math.pow(n1, n2);
            }

            else if (op.equals("mod")) {
                if (n2 == 0) throw new ArithmeticException("Cannot divide by zero");
                ans = n1 % n2;
            }

            else if (op.equals("log")) {
                if (n1 <= 0) throw new CalculationException("Log not possible");
                ans = Math.log(n1);
            }

            result.setText("" + ans);

        } catch (Exception e) {
            result.setText("Error");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

// Main Class
public class CalculatorGUI {

    public static void main(String[] args) {

        JFrame f = new JFrame("Calculator");
        f.setSize(500, 400);
        f.setLayout(new GridLayout(8,2,5,5));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name and Roll
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField("Swapnil Roy");
        nameField.setEditable(false);

        JLabel rollLabel = new JLabel("Roll No:");
        JTextField rollField = new JTextField("2405469");
        rollField.setEditable(false);

        // Inputs
        JLabel l1 = new JLabel("Enter Number 1:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Enter Number 2:");
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Result:");
        JTextField t3 = new JTextField();
        t3.setEditable(false);

        // Buttons
        JButton b1 = new JButton("Square");
        JButton b2 = new JButton("Square Root");
        JButton b3 = new JButton("Power");
        JButton b4 = new JButton("Modulus");
        JButton b5 = new JButton("Log");

        // Add to frame
        f.add(nameLabel); f.add(nameField);
        f.add(rollLabel); f.add(rollField);
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(b1); f.add(b2);
        f.add(b3); f.add(b4);
        f.add(b5);

        // Actions
        b1.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(t1.getText());
                new CalcThread(n1, 0, "square", t3).start();
            } catch(Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        b2.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(t1.getText());
                new CalcThread(n1, 0, "sqrt", t3).start();
            } catch(Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        b3.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(t1.getText());
                double n2 = Double.parseDouble(t2.getText());
                new CalcThread(n1, n2, "power", t3).start();
            } catch(Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        b4.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(t1.getText());
                double n2 = Double.parseDouble(t2.getText());
                new CalcThread(n1, n2, "mod", t3).start();
            } catch(Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        b5.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(t1.getText());
                new CalcThread(n1, 0, "log", t3).start();
            } catch(Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        f.setVisible(true);
    }
}