import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;

public class Main {
    //created by Harshit Vashisth
    public static void main(String[] args) throws IOException {
DatagramSocket ds=new DatagramSocket(59999);
        // created by Harshit
      String s="   Created By Harshit Vashisth  ";

        String s1="   Created By Harshit Vashisth  ";
        String s2="   Created By Harshit Vashisth  ";

       recived r=new recived(ds,s2);

    }
}
