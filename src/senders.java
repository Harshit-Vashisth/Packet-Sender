import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//created BY harshit vashisth
public class senders   implements Runnable{
    int c=0,ht=0;
    DatagramSocket ds;
    String s1,spa1,spa2,spa3;

    int port,k=0;
    int mili;
    int g=0;
    trafficgen o;
    int mi=0;
    public senders(DatagramSocket da,String st1, String st2, String st3, String st4, int p,int a,int mil,int na,int co,int h) throws InterruptedException {

        ds=da;
        s1=st1;
        spa1=st2;
        spa2=st3;
        spa3=st4;
        port=p;
        mili=mil;
        mi=na;
        ht=h;
        k=a;
        c=co;
        System.out.println(spa3);
        System.out.println(spa1);
        System.out.println(spa2);
        o=new trafficgen(ds,s1,spa1,spa2,"  Created  By Harshit Vashisth   ");
        Thread t3=new Thread(o);
        t3.start();
    }

    @Override
    public void run() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("h:mm:ss a");
        LocalTime now = LocalTime.now();
        s1=ht+s1+" "+dt.format(now);
        while(true){
            try {
                g=o.set(c++,mili);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            if(g==1)
                break;

            InetAddress ip = null;
            try {
                ip = InetAddress.getByName(spa1);
            } catch (UnknownHostException ex) {
                throw new RuntimeException(ex);
            }


            byte[] byt = s1.getBytes();
            DatagramPacket dp1 = new DatagramPacket(byt, byt.length, ip, port);
            try {
                ds.send(dp1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            byt = new byte[65535];
            try {
                Thread.sleep(mi,mili);
            } catch (InterruptedException e) {

            }
        }
    }
}
