package Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator {

    public static void main(String[] args){

        JFrame frame=new JFrame("Calculator");
        frame.setLayout(new GridBagLayout());
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints c= new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(5,5,5,5);


        //Calculator Label
        JLabel cal=new JLabel("Calculator");
        c.gridx=0; c.gridy=0;
        c.gridwidth = 2;
        frame.add(cal,c);



        //Display box
        JTextField dis=new JTextField();
        c.gridx=2; c.gridy=0;
        c.gridwidth = 2;
        dis.setEditable(false);
        frame.add(dis,c);

        //Buttons
        String[] ch = { "1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "/","0","%","=" };

        for(int i=0;i<ch.length;i++){
            JButton calBtn=new JButton(ch[i]);


        }


        frame.setVisible(true);
    }

}
