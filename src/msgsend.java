import java.io.IOException;
import java.net.*;


public class msgsend implements Runnable{
    DatagramSocket ds;
    String m1,m2,m3,m4,m5;
    int port;
    int mili;
    int c,i=0;
    public msgsend(DatagramSocket da,String spa2,String s1,int s22,int ct) throws SocketException {
        i=0;
        m2=spa2;
        m4=s1;
        port=s22;
        c=ct;
        System.out.println("PORT "+s22);
    }


    @Override
    public void run() {
        while(i<c) {
            InetAddress ip = null;
            try {
                ip = InetAddress.getByName(m4);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            byte[] b1 = m2.getBytes();
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length, ip, port);
            try {
                ds.send(dp1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            i++;
        }


    }


}
