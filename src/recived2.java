import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class recived2 {
    DatagramSocket ds=new DatagramSocket(59993);
    int port;
    String s3,msg;
    byte[] receive = new byte[65535];
    public recived2(String mg) throws IOException {
        msg=mg;
        reply c=new reply(1,msg);
        DatagramPacket DpReceive = null;
        while (true)
        {
            System.out.println("got");
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            System.out.println( "yaaa");
            port=DpReceive.getPort();
            String s1 = new String(DpReceive.getData());
            s1 = s1.trim();
            System.out.println( "Recived"+s1);
            InetAddress ip = InetAddress.getLocalHost();
            s3=ip.getHostAddress().trim();
            c.set(s1,s3,port);

            // Clear the buffer after every message.
            receive = new byte[65535];
        }

    }
}
