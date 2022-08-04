import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class reply1 implements Runnable {
    JFrame frame;
    String msg;
    JLabel l1;
    int g=0;
    JPanel p1,p2,p3;
    int count=0;
    String[] colName2 = new String[] { "      Time","          From IP","      From Port","      Method","     Message Sent","       Reply Recived" };//harsh
    Object[][] products2 = new Object[][] {
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "   },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "   },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "   },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "    },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "    },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "    },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  },

            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " ,   }
    };
    JTable table2;
    JLabel cou;
    JTextField cout;
    int ct=1;


    String s3;
    reply1(int fg, String j) throws IOException {
        frame=new JFrame("Reply Recived");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        msg=j;
        g=fg;
        p1=new JPanel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2=new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3=new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        l1=new JLabel("Packet Replied !");
        table2=new JTable(products2,colName2);
        table2.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 5));
        cout=new JTextField();
        cout.setPreferredSize(new Dimension(100,20));
        cou=new JLabel("Replied Recived");

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table2.setRowHeight(table2.getRowHeight() + 5);
        table2.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        table2.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

        //table2.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        p1.add(new JScrollPane(table2));
        p2.add(cou);
        p2.add(cout);
        p3.add(l1);
        frame.add(p3,BorderLayout.NORTH);
        frame.add(p1,BorderLayout.CENTER);
        frame.add(p2,BorderLayout.SOUTH);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.decode("#6A0035"));
        for (int i = 0; i < table2.getModel().getColumnCount(); i++) {
            table2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        p1.setBackground(Color.decode("#2F0038"));
        p2.setBackground(Color.decode("#2F0038"));
        p3.setBackground(Color.decode("#2F0038"));
        table2.setBackground(Color.decode("#2F0038"));
        table2.setForeground(Color.decode("#56FCFE"));
        cout.setBackground(Color.decode("#52115F"));
        cout.setForeground(Color.decode("#FDF15C"));
        cou.setForeground(Color.decode("#FC8845"));
        l1.setForeground(Color.decode("#FC8845"));



        frame.setSize(900,330);
        frame.setLocation(600,300);

        if(g==1) {
            frame.setVisible(true);
        }
        else
            frame.setVisible(false);


    }
    void set(String s1,String s2,int p1){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy//MM//dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        table2.repaint();
        cout.setText(String.valueOf(ct++));
        DateTimeFormatter d = DateTimeFormatter.ofPattern("h:mm:ss a");
        LocalTime no = LocalTime.now();
        msg=msg+" "+d.format(no);
        if(count==0){

            products2[0][0]=dt.format(now);
            products2[0][1]=s2;
            products2[0][2]=p1;
            products2[0][3]="UDP";
            products2[0][4]=msg;
            products2[0][5]=s1;
            count=(count+1)%10;
        }
        else if(count==1){

            products2[1][0]=dt.format(now);
            products2[1][1]=s2;
            products2[1][2]=p1;
            products2[1][3]="UDP";
            products2[1][4]=msg;
            products2[1][5]=s1;
            count=(count+1)%10;
        }
        else if(count==2){

            products2[2][0]=dt.format(now);
            products2[2][1]=s2;
            products2[2][2]=p1;
            products2[2][3]="UDP";
            products2[2][4]=msg;
            products2[2][5]=s1;
            count=(count+1)%10;
        }
        else if(count==3){

            products2[3][0]=dt.format(now);
            products2[3][1]=s2;
            products2[3][2]=p1;
            products2[3][3]="UDP";
            products2[3][4]=msg;
            products2[3][5]=s1;
            count=(count+1)%10;
        }
        else if(count==4){

            products2[4][0]=dt.format(now);
            products2[4][1]=s2;
            products2[4][2]=p1;
            products2[4][3]="UDP";
            products2[4][4]=msg;
            products2[4][5]=s1;
            count=(count+1)%10;
        }
        else if(count==5){

            products2[5][0]=dt.format(now);
            products2[5][1]=s2;
            products2[5][2]=p1;
            products2[5][3]="UDP";
            products2[5][4]=msg;
            products2[5][5]=s1;
            count=(count+1)%10;
        }
        else if(count==6){

            products2[6][0]=dt.format(now);
            products2[6][1]=s2;
            products2[6][2]=p1;
            products2[6][3]="UDP";
            products2[6][4]=msg;
            products2[6][5]=s1;
            count=(count+1)%10;
        }
        else if(count==7){

            products2[7][0]=dt.format(now);
            products2[7][1]=s2;
            products2[7][2]=p1;
            products2[7][3]="UDP";
            products2[7][4]=msg;
            products2[7][5]=s1;
            count=(count+1)%10;
        }
        else if(count==8){

            products2[8][0]=dt.format(now);
            products2[8][1]=s2;
            products2[8][2]=p1;
            products2[8][3]="UDP";
            products2[8][4]=msg;
            products2[8][5]=s1;
            count=(count+1)%10;
        }
        else if(count==9){

            products2[9][0]=dt.format(now);
            products2[9][1]=s2;
            products2[9][2]=p1;
            products2[9][3]="UDP";
            products2[9][4]=msg;
            products2[9][5]=s1;
            count=(count+1)%10;
        }
        else {

            products2[10][0]=dt.format(now);
            products2[10][1]=s2;
            products2[10][2]=p1;
            products2[10][3]="UDP";
            products2[10][4]=msg;
            products2[10][5]=s1;
            count=(count+1)%10;
        }

    }

    @Override
    public void run() {
        try {
            recived2 r=new recived2(msg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}