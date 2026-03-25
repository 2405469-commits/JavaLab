package Lab10;

import javax.swing.*;
import java.awt.*;

public class regnew {
    public static void main(String[] args){

        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setLayout(new BorderLayout(10,10));

        //Form panel (grid)
        JPanel formPanel = new JPanel(new GridLayout(3,2,20,20));

        //Name
        formPanel.add(new JLabel("Name:"));
        formPanel.add(new JTextField());

        //Gender
        formPanel.add(new JLabel("Gender:"));
        JPanel genderpanel = new JPanel(new GridLayout(1,2,5,5));
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        genderpanel.add(male);
        genderpanel.add(female);

        formPanel.add(genderpanel);

        //Course
        formPanel.add(new JLabel("Course:"));
        JPanel coursePanel = new JPanel(new FlowLayout());
        coursePanel.add(new JCheckBox("Box1"));
        coursePanel.add(new JCheckBox("Box2"));
        coursePanel.add(new JCheckBox("Box3"));
        coursePanel.add(new JCheckBox("Box4"));
        coursePanel.add(new JCheckBox("Box5"));
        coursePanel.add(new JCheckBox("Box6"));

        formPanel.add(coursePanel);

        //Add form to center
        frame.add(formPanel, BorderLayout.CENTER);

        //Button panel (bottom)
        JPanel buttonPanel = new JPanel();
        JButton submit = new JButton("Submit");
        buttonPanel.add(submit);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}