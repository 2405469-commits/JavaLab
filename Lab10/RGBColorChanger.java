package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGBColorChanger {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My Frame");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(83,184,115)); // default color

        Integer[] values = new Integer[256];
        for (int i = 0; i <= 255; i++) {
            values[i] = i;
        }

        // Labels
        JLabel redLabel = new JLabel("Red");
        redLabel.setForeground(Color.RED);

        JLabel greenLabel = new JLabel("Green");
        greenLabel.setForeground(Color.GREEN);

        JLabel blueLabel = new JLabel("Blue");
        blueLabel.setForeground(Color.BLUE);

        // ComboBoxes
        JComboBox<Integer> redBox = new JComboBox<>(values);
        JComboBox<Integer> greenBox = new JComboBox<>(values);
        JComboBox<Integer> blueBox = new JComboBox<>(values);

        // Default selections
        redBox.setSelectedItem(83);
        greenBox.setSelectedItem(184);
        blueBox.setSelectedItem(115);

        // Button
        JButton button = new JButton("Show Output");

        // Button Action
        button.addActionListener(e -> {

            int r = (Integer) redBox.getSelectedItem();
            int g = (Integer) greenBox.getSelectedItem();
            int b = (Integer) blueBox.getSelectedItem();

            panel.setBackground(new Color(r, g, b));
        });

        // Add components
        panel.add(redLabel);
        panel.add(redBox);

        panel.add(blueLabel);
        panel.add(blueBox);

        panel.add(greenLabel);
        panel.add(greenBox);

        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}