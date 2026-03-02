package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Colour {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My frame");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout());

        String[] colors = {"white", "orange", "red", "blue"};
        JList<String> colorList = new JList<>(colors);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(colorList);
        scrollPane.setPreferredSize(new Dimension(100, 80));

        JButton button = new JButton("Click");

        button.addActionListener(e -> {
            String selectedColor = colorList.getSelectedValue();

            if (selectedColor != null) {
                switch (selectedColor) {
                    case "white":
                        panel.setBackground(Color.WHITE);
                        break;
                    case "orange":
                        panel.setBackground(Color.ORANGE);
                        break;
                    case "red":
                        panel.setBackground(Color.RED);
                        break;
                    case "blue":
                        panel.setBackground(Color.BLUE);
                        break;
                }
            }
        });

        panel.add(scrollPane);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}