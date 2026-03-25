package Lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Countdown {

    public static void main(String[] args){

        JFrame frame = new JFrame("Countdown Timer App");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cl = new CardLayout();
        JPanel container = new JPanel(cl);

        // DASHBOARD PANEL

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(3,1,10,10));

        JLabel title = new JLabel("Main Dashboard", JLabel.CENTER);

        JButton timerBtn = new JButton("Open Countdown Timer");
        JButton aboutBtn = new JButton("About");

        dashboard.add(title);
        dashboard.add(timerBtn);
        dashboard.add(aboutBtn);

        // TIMER PANEL

        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new GridLayout(5,1,10,10));

        JLabel timerTitle = new JLabel("Enter Time (seconds)", JLabel.CENTER);
        JTextField timeField = new JTextField();

        JLabel timeDisplay = new JLabel("Time: 0", JLabel.CENTER);

        JButton startBtn = new JButton("Start Timer");
        JButton backBtn = new JButton("Back");

        timerPanel.add(timerTitle);
        timerPanel.add(timeField);
        timerPanel.add(timeDisplay);
        timerPanel.add(startBtn);
        timerPanel.add(backBtn);

        // ABOUT PANEL

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(4,1));

        JLabel about1 = new JLabel("Countdown Timer App", JLabel.CENTER);
        JLabel about2 = new JLabel("This application lets you set timers for study or events.", JLabel.CENTER);
        JLabel about3 = new JLabel("", JLabel.CENTER);

        JButton backHome = new JButton("Back");

        aboutPanel.add(about1);
        aboutPanel.add(about2);
        aboutPanel.add(about3);
        aboutPanel.add(backHome);

        // ADD PANELS

        container.add(dashboard, "Dashboard");
        container.add(timerPanel, "Timer");
        container.add(aboutPanel, "About");

        frame.add(container);

        // NAVIGATION

        timerBtn.addActionListener(e -> cl.show(container,"Timer"));
        aboutBtn.addActionListener(e -> cl.show(container,"About"));
        backBtn.addActionListener(e -> cl.show(container,"Dashboard"));
        backHome.addActionListener(e -> cl.show(container,"Dashboard"));

        // TIMER LOGIC

        startBtn.addActionListener(new ActionListener(){

            int timeLeft;
            Timer timer;

            public void actionPerformed(ActionEvent e){

                try{
                    timeLeft = Integer.parseInt(timeField.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Enter valid number");
                    return;
                }

                timer = new Timer(1000, new ActionListener(){

                    public void actionPerformed(ActionEvent e){

                        timeDisplay.setText("Time: " + timeLeft);

                        timeLeft--;

                        if(timeLeft < 0){
                            timer.stop();
                            JOptionPane.showMessageDialog(frame,"Time's Up!");
                        }
                    }
                });

                timer.start();
            }
        });

        frame.setVisible(true);
    }
}