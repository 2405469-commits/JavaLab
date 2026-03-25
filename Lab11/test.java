package Lab11;

import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args){
        JFrame frame=new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        //Label
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new JButton("Click me"));
        frame.add(new JButton("Click me"));
        frame.add(new JButton("Click me"));
        frame.add(new JButton("Click me"));
        frame.add(new JButton("Click me"));
        frame.add(new JButton("Click me"));


        frame.setVisible(true);
    }
}
