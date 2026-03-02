package Lab10;

import javax.swing.*;
import java.awt.*;

public class regForm {

    public static void main(String[] args){

        JFrame frame = new JFrame("Registration Form");
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(8,2,10,10));

        // Name
        frame.add(new JLabel("Name:"));
        frame.add(new JTextField());

        // Roll No
        frame.add(new JLabel("Roll No:"));
        frame.add(new JTextField());

        // Email
        frame.add(new JLabel("Email:"));
        frame.add(new JTextField());

        // Gender
        frame.add(new JLabel("Gender:"));

        JPanel genderPanel = new JPanel();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        genderPanel.add(male);
        genderPanel.add(female);

        frame.add(genderPanel);

        // Courses
        frame.add(new JLabel("Enrolled Courses:"));

        JPanel coursePanel = new JPanel();
        coursePanel.setBackground(Color.PINK);
        coursePanel.add(new JCheckBox("Java"));
        coursePanel.add(new JCheckBox("DBMS"));
        coursePanel.add(new JCheckBox("OS"));
        coursePanel.add(new JCheckBox("Economics"));

        frame.add(coursePanel);

        // Empty space
        frame.add(new JLabel(""));
        frame.add(new JButton("Submit"));

        frame.setVisible(true);
    }
}