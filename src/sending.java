import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class sending implements Runnable{
    DatagramSocket ds;
    //created BY harshit vashisth
    String m1,m2,m3,m4,m5;
    int port;
    int mili,b=0;
    public sending(DatagramSocket da, String spa1, String spa2, String spa3, String s1, int s22, int mil){
            ds=da;
            m1=spa1;
            m2=spa2;
            m3=spa3;
            m4=s1;
            port=s22;
            mili=mil;
    }


    @Override
    public void run() {
        while(true){
            InetAddress ip = null;
            try {
                ip = InetAddress.getByName(m4);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            if(b==1) {
                b=0;
                break;
            }
            byte[] b1 = m2.getBytes();
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length, ip, port);
            try {
                ds.send(dp1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(mili);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
    public void stop(){
        b=1;
    }

}
