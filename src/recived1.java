import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class recived1 {
    DatagramSocket ds ;
    byte[] receive = new byte[65535];
    String str[]={"Hello","Hello buddy","What's up","Who are u","What is your ip"};
    String s3,ownz;

    recived1(DatagramSocket da,String kk) throws IOException {
        ownz="  Created By Harshit Vashisth   ";
        ds=da;
        client c=new client(ds,kk);
        String ph=" ",gg="  Created By Harshit Vashisth   ";
        int port;
        int v=0;
        DatagramPacket DpReceive = null;
        while (true)
        {

            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            port=DpReceive.getPort();
            String s1 = new String(DpReceive.getData());
            s1 = s1.trim();
            //System.out.println(s1);
            if(s1.charAt(0)=='1'&&(s1.substring(1,6)).equals(str[0])){
                ph="Hello sir";
                v=1;
            }
            if(s1.charAt(0)=='1'&&(s1.substring(1,12)).equals(str[1])){
                ph="Hello bro";
                v=1;
            }
            if(s1.charAt(0)=='1'&&(s1.substring(1,10)).equals(str[2])){
                ph="Yess U tell";
                v=1;
            }
            if(s1.charAt(0)=='1'&&(s1.substring(1,10)).equals(str[3])){
                ph="I am a project develop by harshit";
                v=1;

            }
            if(s1.charAt(0)=='1'&&(s1.substring(1,16)).equals(str[4])){
                InetAddress ip = InetAddress.getLocalHost();
                //    ph=ip.getHostAddress().trim();
                v=1;
            }
            if(v==1) {
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("h:mm:ss a");
                LocalTime now = LocalTime.now();
                ph=ph+" "+dt.format(now);
                String ip= String.valueOf(DpReceive.getAddress().getHostAddress());
                int pot=DpReceive.getPort();
                sendrep o=new sendrep(ds,ph,ip,pot);
                Thread t=new Thread(o);
                t.start();
                v=0;


            }
            InetAddress ip = InetAddress.getLocalHost();
            s3=ip.getHostAddress().trim();
            Thread th1=new Thread(c);
            th1.start();
            c.set(s1,s3,"NULL",port);

            // Clear the buffer after every message.
            receive = new byte[65535];
        }
    }
}
