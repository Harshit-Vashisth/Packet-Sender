import java.io.IOException;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) throws IOException {
DatagramSocket ds=new DatagramSocket(59999);
        //new trafficgen(ds,"hi","g","cff");
      String s="   Created By Harshit Vashisth  ";
        String s1="   Created By Harshit Vashisth  ";
        String s2="   Created By Harshit Vashisth  ";
       recived r=new recived(ds,s2);

    }
}
