import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramSocket;

public class newmsg implements ActionListener {

    JFrame frame;
    //created BY harshit vashisth
    JPanel p1,p2,p3,b;
    JButton b1;
    JTextField t1,t2;
    senders c;
    int micro,nano;
    DatagramSocket ds;

    JLabel l1,l2,l3;
    String msg,ip;
    int port;

    public newmsg(DatagramSocket da,String spa1,int p){
        frame=new JFrame( "Addtional message ");
        frame.setLayout(new BorderLayout());


        ds=da;
        ip=spa1;
        port=p;

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        b=new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
        b.setLayout(new BoxLayout(b,BoxLayout.Y_AXIS));

        l1=new JLabel(" MESSAGE   :");
        l2=new JLabel("DELAY TIME :");
        l3=new JLabel("                                              CHAT BOT");

        b1=new JButton("    SEND     ");
        b1.addActionListener(this);

        t1=new JTextField("NA");
        t2=new JTextField("NA");
        t1.setPreferredSize(new Dimension(200,20));
        t2.setPreferredSize(new Dimension(200,20));

        p1.add(l1);
        p1.add(t1);

        p2.add(l2);
        p2.add(t2);

        p3.add(b1);
        b.add(p1);
        b.add(p2);
        b.add(p3);

        frame.add(l3,BorderLayout.NORTH);
        frame.add(b,BorderLayout.CENTER);


        frame.setSize(400,200);
        frame.setVisible(true);

        frame.setBackground(Color.decode("#280E5C"));
        l3.setBackground(Color.decode("#280E5C"));
        b.setBackground(Color.decode("#280E5C"));
        p1.setBackground(Color.decode("#280E5C"));
        p3.setBackground(Color.decode("#280E5C"));
        p2.setBackground(Color.decode("#280E5C"));
        l1.setForeground(Color.decode("#54e775"));
        l2.setForeground(Color.decode("#54e775"));
        l3.setForeground(Color.decode("#2a3859"));
        t1.setBackground(Color.decode("#3C158A"));
        t2.setBackground(Color.decode("#3C158A"));
        t1.setForeground(Color.decode("#8be9fd"));
        t2.setForeground(Color.decode("#8be9fd"));
        b1.setBackground(Color.decode("#3C158A"));
        b1.setForeground(Color.decode("#ff79c6"));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            msg=t1.getText();
            String s1=t2.getText();
            micro= Integer.parseInt(s1);///msgggggg
            try {
                c=new senders(ds,msg,ip,"","",port,0,0,micro,0,1);
                Thread t=new Thread(c);
                t.start();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            try {
                reply r=new reply(0,msg);
                Thread t=new Thread(r);
                t.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
