import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class trafficgenerate implements ActionListener,Runnable {
    JFrame frame;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10;
    int h=0,ht=0,yop=0;
    senders c;
    long count=0;
    long mili=0,nano=0;
    String spa4;
    int port=0;
    int yp=0,co=0;
    JPanel p1,p2,p3;
    JPanel p11,p12,p13,p14,b;
    JPanel p21,p22,p23,p24,p25;
    JRadioButton r1,r2;
    JButton b1,b2,b3,b4;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String spa1,spa2,spa3,msg,gt,ft;
    DatagramSocket ds;
    trafficgenerate(DatagramSocket da, String s1, String s2, String s3){
        ds=da;
        frame=new JFrame("UDP Traffic Generator ");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        msg=s1;

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));


        p11=new JPanel();
        p12=new JPanel();
        p13=new JPanel();
        p14=new JPanel();
        p11.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p12.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p13.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p14.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));


        p21=new JPanel();
        p22=new JPanel();
        p23=new JPanel();
        p24=new JPanel();
        p25=new JPanel();
        p21.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p22.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p23.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p24.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        p25.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));

        b=new JPanel();
        b.setLayout(new BoxLayout(b,BoxLayout.Y_AXIS));


        l1=new JLabel("IP    ");
        l2=new JLabel("PORT");
        l10=new JLabel("MESSAGE");
        l3=new JLabel("Ascii");
        l4=new JLabel("UDP : 59999 //");
        l5=new JLabel("Total sent     ");
        l6=new JLabel("Run Time      ");
        l7=new JLabel("Send Rate     ");


        t1=new JTextField("                                  NA                                    ");
        t2=new JTextField("                                  NA                                    ");
        t10=new JTextField("                                           NA                                       ");
        t3=new JTextField("                                            NA                                       ");
        t4=new JTextField("                                NA                             ");
        t5=new JTextField("                NA              ");
        t6=new JTextField("                NA              ");
        t7=new JTextField("                NA              ");
        t8=new JTextField("                NA              ");
        t9=new JTextField("                NA              ");

        t1.setPreferredSize(new Dimension(100,20));
        t3.setPreferredSize(new Dimension(150,20));
        t4.setPreferredSize(new Dimension(170,20));
        t5.setPreferredSize(new Dimension(150,20));
        t6.setPreferredSize(new Dimension(150,20));
        t7.setPreferredSize(new Dimension(150,20));
        t8.setPreferredSize(new Dimension(150,20));
        //t9.setPreferredSize(new Dimension(150,20));
        t10.setPreferredSize(new Dimension(150,20));
        t10.setText(s1);
        t1.setText(s2);
        t2.setText(s3);
        asci(s1);


        b1=new JButton("  SEND  ");
        b2=new JButton("  STOP  ");
        b3=new JButton("  CANCEL  ");
        b4=new JButton("   Different Message  ");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        r1=new JRadioButton( "  D E L A Y  ( n s )  ");
        r2=new JRadioButton(" S P E E D  ( mb/sec ) ");

        p11.add(l1);
        p11.add(t1);
        p11.add(l2);
        p11.add(t2);

        p12.add(l3);
        p12.add(t3);
        p12.add(l10);
        p12.add(t10);

        p13.add(r1);
        p13.add(r2);

        p14.add(t4);
        p14.add(b1);
        p14.add(b2);


        p1.add(p11);
        p1.add(p12);
        p1.add(p13);
        p1.add(p14);

        p21.add(l4);
        p21.add(t5);
        p21.add(b4);

        p22.add(l5);
        p22.add(t6);

        p23.add(l6);
        p23.add(t7);

        p24.add(l7);
        p24.add(t8);

//        p25.add(l8);
//        p25.add(t9);

        p2.add(p21);
        p2.add(p22);
        p2.add(p23);
        p2.add(p24);
        //p2.add(p25);

        p3.add(b3);

        b.add(p1);
        b.add(p2);


        frame.add(b,BorderLayout.CENTER);
        frame.add(p3,BorderLayout.SOUTH);


        frame.setBackground((Color.decode("#302c34")));
        b.setBackground((Color.decode("#302c34")));
        p1.setBackground((Color.decode("#302c34")));
        p2.setBackground((Color.decode("#302c34")));
        p3.setBackground((Color.decode("#302c34")));
        p11.setBackground((Color.decode("#302c34")));
        p12.setBackground((Color.decode("#302c34")));
        p13.setBackground((Color.decode("#302c34")));
        p14.setBackground((Color.decode("#302c34")));
        p21.setBackground((Color.decode("#302c34")));
        p22.setBackground((Color.decode("#302c34")));
        p23.setBackground((Color.decode("#302c34")));
        p24.setBackground((Color.decode("#302c34")));
        p25.setBackground((Color.decode("#302c34")));
        l1.setForeground((Color.decode("#70BBFC")));
        l2.setForeground((Color.decode("#70BBFC")));
        l3.setForeground((Color.decode("#70BBFC")));
        l4.setForeground((Color.decode("#70BBFC")));
        l5.setForeground((Color.decode("#70BBFC")));
        l6.setForeground((Color.decode("#70BBFC")));
        l7.setForeground((Color.decode("#70BBFC")));
        //l8.setForeground((Color.decode("#70BBFC")));
        l10.setForeground((Color.decode("#70BBFC")));
        r1.setBackground(Color.decode("#402E52"));
        r2.setBackground(Color.decode("#402E52"));
        r1.setForeground((Color.decode("#70BBFC")));
        r2.setForeground((Color.decode("#70BBFC")));
        t1.setForeground((Color.decode("#FB7D87")));
        t2.setForeground((Color.decode("#FB7D87")));
        t3.setForeground((Color.decode("#FB7D87")));
        t4.setForeground((Color.decode("#FB7D87")));
        t5.setForeground((Color.decode("#FB7D87")));
        t6.setForeground((Color.decode("#FB7D87")));
        t7.setForeground((Color.decode("#FB7D87")));
        t8.setForeground((Color.decode("#FB7D87")));
       // t9.setForeground((Color.decode("#FB7D87")));
        t10.setForeground((Color.decode("#FB7D87")));
        t1.setBackground(Color.decode("#464A5B"));
        t2.setBackground(Color.decode("#464A5B"));
        t3.setBackground(Color.decode("#464A5B"));
        t4.setBackground(Color.decode("#464A5B"));
        t5.setBackground(Color.decode("#464A5B"));
        t6.setBackground(Color.decode("#464A5B"));
        t7.setBackground(Color.decode("#464A5B"));
        t8.setBackground(Color.decode("#464A5B"));
        t9.setBackground(Color.decode("#464A5B"));
        t10.setBackground(Color.decode("#464A5B"));
        b1.setForeground((Color.decode("#94D9A5")));
        b2.setForeground((Color.decode("#94D9A5")));
        b3.setForeground((Color.decode("#94D9A5")));
        b4.setForeground((Color.decode("#94D9A5")));
        b1.setBackground((Color.decode("#172033")));
        b2.setBackground((Color.decode("#172033")));
        b3.setBackground((Color.decode("#172033")));
        b4.setBackground((Color.decode("#172033")));





        frame.setSize(480,470);
        frame.setLocation(90, 250 );
        frame.setVisible(true);

    }
    void asci(String as){
        String es="";


        int a;
        for(int i =0;i<as.length();i++){
            a=(int)as.charAt(i);
            es=es+a;
        }

        t3.setText(es);
    }

   public int set(int count,int j) throws InterruptedException, UnknownHostException {
       InetAddress ip = InetAddress.getLocalHost();
       String s3=ip.getHostAddress().trim();
        co=count;
        t6.setText(String.valueOf(co));
       t4.setText(String.valueOf(j));

        t5.setText(s3);
        return yp;
    }
    void sender(String spa1,String spa2,int port) throws InterruptedException {

         c = new senders(ds, msg, spa1, spa2, spa3, port, 0, (int) nano, 0, co, h);
         Thread th = new Thread(c);
         th.start();


    }
//    private void reciver() throws InterruptedException {
//        int s=1;
//         c=new senders(ds,msg,spa1,spa2,spa3,port,1, (int) mili,0);
//        Thread th=new Thread(c);
//        th.start();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            spa1=t1.getText();
            spa2=t2.getText();
            spa3=t3.getText();
            spa4=t4.getText();
            yp=0;
            port= Integer.parseInt(spa2);
            nano= Long.parseLong(spa4);
            mili = TimeUnit.NANOSECONDS.toMillis(nano);
            b1.setEnabled(false);
            try {
                sender(spa1,spa2,port);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            //frame.setVisible(false);

//                try {
//                    autoclick(1);
//                } catch (AWTException ex) {
//                    throw new RuntimeException(ex);
//                }
//                while(true){
//                    sender(spa1,spa2,port);
//                    try {
//                        Thread.sleep(mili * 10000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
            //              }
        }
        if(e.getSource()==b2){
            yp=1;
        }
        if(e.getSource()==b4){
            //DatagramSocket da,String st1, String st2, String st3, String st4, int p,int a,int mil
            spa1=t1.getText();
            spa2=t2.getText();
            port= Integer.parseInt(spa2);
                newmsg n=new newmsg(ds,spa1,port);


        }

    }



    @Override
    public void run() {
       // t4.setText(String.valueOf(((int)yop)));
       // t6.setText(String.valueOf(count));
        while(yp!=1){
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            h++;
            gt="  " +String.valueOf(h)+" Seconds";
            t7.setText(gt);
            if(h==5){
                ht=co/5;
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";

                t8.setText(ft);
            }
            if(h==10){
                ht=co/10;
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==15){
                ht=co/15;
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==20){
                ht=co/20;
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==25){
                ht=co/25;
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==30){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==35){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==40){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==45){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==50){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==55){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==60){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==65){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==70){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
            if(h==75){
                int speed=(ht*(msg.length())*8)/1000;
                ft="  " +String.valueOf(speed)+" kb/sec";
                t8.setText(ft);
            }
        }
    }
}

