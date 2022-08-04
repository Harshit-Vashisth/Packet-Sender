import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;

public class tools implements ActionListener {
    //created BY harshit vashisth
    JFrame frame;
    JPanel p1; //created by Harshit Vashisth
    JButton b1,b2,b3,b4,b5;
    String st1="NA",st2="NA",st3="NA";
    DatagramSocket ds;
    tools(DatagramSocket da,String spa2,String s1,String s2) {

        ds=da;

        st1=spa2;
        st2=s1;
        st3=s2;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        b1 = new JButton("   Cloud save adn share    ");
        b2 = new JButton("      Subnet Calculator        ");
        b3 = new JButton(" Intense Traffic Gernator  ");
        b4 = new JButton("            Android  app            ");
        b5 = new JButton("              IOS  APP                ");
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        b3.addActionListener(this);

        frame.add(p1);
        frame.setUndecorated(true);
        b1.setForeground((Color.decode("#94D9A5")));
        b2.setForeground((Color.decode("#94D9A5")));
        b3.setForeground((Color.decode("#94D9A5")));
        b4.setForeground((Color.decode("#94D9A5")));
        b5.setForeground((Color.decode("#94D9A5")));
        b1.setBackground((Color.decode("#172033")));
        b2.setBackground((Color.decode("#172033")));
        b3.setBackground((Color.decode("#172033")));
        b4.setBackground((Color.decode("#172033")));
        b5.setBackground((Color.decode("#172033")));
        frame.setSize(180, 130);
        frame.setLocation(73, 62);
        frame.setVisible(true);


    } //created by Harshit Vashisth

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b3)
        {

                new trafficgen(ds,st1,st2,st3,"  Created By Harshit Vashisth  ");


        }
    }
}
