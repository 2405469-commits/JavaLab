package Lab10;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class Calcu {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My Calc");
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        // Labels
        JLabel l1=new JLabel("Enter the First Number:");
        JLabel l2=new JLabel("Enter the Second Number:");
        JLabel l3=new JLabel("Result:");

        // TextFields
        JTextField t1=new JTextField(10);
        JTextField t2=new JTextField(10);
        JTextField t3=new JTextField(10);
        t3.setEditable(false);

        // Buttons
        JButton addBtn=new JButton("Add");
        JButton subBtn=new JButton("Subtract");
        JButton mulBtn=new JButton("Multiply");
        JButton resetBtn=new JButton("Reset");

        // Panel for inputs
        JPanel inputPanel=new JPanel(new GridLayout(3,2,10,10));
        inputPanel.add(l1);
        inputPanel.add(t1);
        inputPanel.add(l2);
        inputPanel.add(t2);
        inputPanel.add(l3);
        inputPanel.add(t3);

        // Panel for buttons
        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);
        buttonPanel.add(resetBtn);

        // Add panels to frame
        frame.add(inputPanel);
        frame.add(buttonPanel);

        // Button Actions
        addBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                t3.setText(String.valueOf(num1 + num2));
            } catch (Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        subBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                t3.setText(String.valueOf(num1 - num2));
            } catch (Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        mulBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                t3.setText(String.valueOf(num1 * num2));
            } catch (Exception ex) {
                t3.setText("Invalid Input");
            }
        });

        resetBtn.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });

        frame.setVisible(true);
    }
}