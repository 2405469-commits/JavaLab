package Lab12;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bleh {

    public static void main(String[] args){

        JFrame frame = new JFrame("Countdown Timer");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1,10,10));

        JLabel title = new JLabel("Enter Time (seconds)", JLabel.CENTER);
        JTextField timeField = new JTextField();
        JLabel timeDisplay = new JLabel("Time: 0", JLabel.CENTER);
        JButton startBtn = new JButton("Start Timer");

        frame.add(title);
        frame.add(timeField);
        frame.add(timeDisplay);
        frame.add(startBtn);

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
