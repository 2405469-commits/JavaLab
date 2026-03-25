package Lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AnimationThread implements Runnable {
    JLabel imageLabel;
    JLabel textLabel;
    String[] images;
    String[] messages;
    boolean running = true;

    AnimationThread(JLabel imgLabel, JLabel txtLabel, String[] imgs, String[] msgs) {
        imageLabel = imgLabel;
        textLabel = txtLabel;
        images = imgs;
        messages = msgs;
    }

    public void run() {
        int i = 0;
        int x = 50, y = 50;

        try {
            while (running) {

                // Change image
                ImageIcon icon = new ImageIcon(images[i]);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));

                // Change text
                textLabel.setText(messages[i]);

                // Move Right
                for (int j = 0; j < 200 && running; j++) {
                    imageLabel.setBounds(x++, y, 100, 100);
                    Thread.sleep(10);
                }

                // Move Down
                for (int j = 0; j < 200 && running; j++) {
                    imageLabel.setBounds(x, y++, 100, 100);
                    Thread.sleep(10);
                }

                // Move Left
                for (int j = 0; j < 200 && running; j++) {
                    imageLabel.setBounds(x--, y, 100, 100);
                    Thread.sleep(10);
                }

                // Move Up
                for (int j = 0; j < 200 && running; j++) {
                    imageLabel.setBounds(x, y--, 100, 100);
                    Thread.sleep(10);
                }

                i = (i + 1) % images.length;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stopThread() {
        running = false;
    }
}

public class MTgui {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Square Animation");
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] images = {
                "Lab13/Icons/thunder.png",
                "Lab13/Icons/storm.png",
                "Lab13/Icons/rain.png",
                "Lab13/Icons/overcast.png"
        };

        String[] messages = {"Welcome", "Enjoy", "Thanks", "Visit Again"};

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(50, 50, 100, 100);

        JLabel textLabel = new JLabel("Welcome");
        textLabel.setBounds(220, 20, 200, 30);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");

        startBtn.setBounds(150, 500, 100, 30);
        stopBtn.setBounds(300, 500, 100, 30);

        frame.add(imageLabel);
        frame.add(textLabel);
        frame.add(startBtn);
        frame.add(stopBtn);

        frame.setVisible(true);

        AnimationThread obj = new AnimationThread(imageLabel, textLabel, images, messages);

        final Thread[] t = new Thread[1];

        // Start Button
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t[0] == null || !t[0].isAlive()) {
                    obj.running = true;
                    t[0] = new Thread(obj);
                    t[0].start();
                }
            }
        });

        // Stop Button
        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.stopThread();
            }
        });
    }
}