import javax.swing.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class set implements Runnable {
    DatagramSocket ds;
    JFrame frame;
    //created BY harshit vashisth
    String msg,ip,exec,ft;
    int port,co=0;
JTable table;


    public set(JFrame f1, DatagramSocket da, String m1, String it, String ex, int p1, int c, JTable t) {
        frame=f1;
        ds=da;
        msg=m1;
        ip=it;
        exec=ex;
        port=p1;
        table=t;

    }

    @Override
    public void run() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy//MM//dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            InetAddress it= InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int a;
        for(int i =0;i<msg.length();i++){
            a=(int)msg.charAt(i);
            ft=ft+a;
        }
//        if (ct == 0) {
//            System.out.println("uoi");
//            products[0][0]=co;
//            products[0][1]=dt.format(now);
//            products[0][2]=ip;
//            products[0][3]=String.valueOf(port);
//            products[0][4]=it.getHostAddress().trim();
//            products[0][5]=String.valueOf(ds.getLocalPort());
//            products[0][6]="UDP";
//            products[0][7]=exec;
//            products[0][8]=msg;
//            products[0][9]=ft;
//            ct = (ct + 1) % 10;
//        }
    }
}
