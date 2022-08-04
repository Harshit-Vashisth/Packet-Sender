import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

    public class sendrep implements Runnable{
        DatagramSocket ds;
        //created BY harshit vashisth
        String m1,m2,m3,m4,m5;
        int port;
        int mili;
        public sendrep(DatagramSocket da,String spa2,String s1,int s22){
            ds=da;
            m2=spa2;
            m4=s1;
            port=s22;
            System.out.println(m2);
            System.out.println(m4);
        }


        @Override
        public void run() {
            System.out.println("yoo");
                InetAddress ip = null;
                try {
                    ip = InetAddress.getByName(m4);
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }

                byte[] b1 = m2.getBytes();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, ip, (port-6));
                try {
                    ds.send(dp1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


        }


}
