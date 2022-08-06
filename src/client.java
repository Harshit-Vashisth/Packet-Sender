import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class client implements ActionListener, MouseListener ,Runnable{
    JLabel pal7;
    JTextField tpa7;
    JFrame frame;
    private DefaultTableModel model;
    private DefaultTableCellRenderer cellRenderer;
    //main frames
    JPanel a,b,c,ca,cb;
    String sav1,sav2,sav3,sav4;
    int k=0;

    String mset,ipad,exe;
    int port1;
    String ft;
    ///panell section
    JPanel pa,pb,pc;
    int co=0;
    //sub seciton
    JPanel pa1,pa2,pa3,pa4 ;
    //JPanel pb1,pb2[]=new JPanel[5];
    // JPanel pc1,pc2[]=new JPanel[10];//take one array
    int l=0;
    JTable table,table1;
    //top file tools etc
    JButton a1,a2,a3,a4,a5;
    int mili;
    //pannel pa attributes
    //for pa1
    JLabel pal1;
    JTextField tpa1;
    String spa1;
    //for pa2
    JLabel pal2;
    JTextField tpa2;
    String spa2;
    JButton bpa1;
    String spa4;
    //for pa3
    JLabel pal3;
    JTextField tpa3;
    String spa3;
    //for pa4
    JLabel pal4,pal5,pal6;
    int u=0;
    JComboBox combo;
    String arr[]={"UDP","TCP"};
    JTextField tpa4,tpa5,tpa6;
    Thread th1;

    String s1,s2,s3,s33;
    int s11,s22;
    JButton bpa2,bpa3,bpa4;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
    //for pc1<><><><><>
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    //for pc2
    JTextField t1[]=new JTextField[9],t2[]=new JTextField[9],t3[]=new JTextField[9],t4[]=new JTextField[9],t5[]=new JTextField[9],t6[]=new JTextField[9],t7[]=new JTextField[9],t8[]=new JTextField[9],t9[]=new JTextField[9],t10[]=new JTextField[9];
    //pb2
    JTextField tb1[]=new JTextField[8],tb2[]=new JTextField[8],tb3[]=new JTextField[8],tb4[]=new JTextField[8],tb5[]=new JTextField[8],tb6[]=new JTextField[8],tb7[]=new JTextField[8],tb8[]=new JTextField[8];


    //for c south<><><><><>
    JLabel c1,c2,c3;
    JTextField ct1,ct2,ct3,ct4;
    String exec="NULL";

    int ct=0;
    int count=0;
    //socket prog
    //49152   65535


    //static int n=(int)(Math.random()*10000);
    DatagramSocket ds ;
    String[] colName = new String[] { "      S.No" ,"             Time","               From IP","            From Port","                To IP","            To Port","            Method","               Error", "                                    Message","                                       Ascii" };//harsh
    Object[][] products = new Object[][] {
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA" , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " },
            { " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA " , " NA "  , " NA " }
    };


    String colname2[]={"                  Name","                        To Address","                            To Port","                            Method","                                                Message","                                                      ASCII"};
    Object[][] products1 = new Object[][]{
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"},
            {"NA","NA","NA","NA","NA","NA"}

    };
    JLabel cout;
    JTextField cou,ownz,ownz2,ownz3;


    String es;



    public client(DatagramSocket da,String gg) throws IOException {
        ds=da;
        s33= gg;
        InetAddress add = InetAddress.getLocalHost();
        String address="Packet Sender "+" ://: "+add.getHostAddress().trim();
        frame=new JFrame(address);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());



        //mainn dividing in 3
        a=new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.LEFT));
        b=new JPanel();
        b.setLayout(new BoxLayout(b,BoxLayout.Y_AXIS));
        c=new JPanel();
        c.setLayout(new BorderLayout());
        ca=new JPanel();
        ca.setLayout(new FlowLayout(FlowLayout.RIGHT,10,5));
        cb=new JPanel();
        cb.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));


        //<><><><><><><>uper bouna
        a1=new JButton("File");
        a2=new JButton("Tools");
        a3=new JButton("Multicast");
        a4=new JButton("Pannel");
        a5=new JButton("Help");
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        a2.addActionListener(this);
///<><><><><><><><><
        //first pannel

        Border  line = BorderFactory.createLineBorder(Color.decode("#292B7E"),2);
        pa=new JPanel();
        pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
        pa.setBorder(line);
        //subsection
        pa1=new JPanel();
        pa2=new JPanel();
        pa3=new JPanel();
        pa4=new JPanel();
        pa1.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        pa2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        pa3.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        pa4.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));



        //for pa1
        pal1=new JLabel();
        tpa1=new JTextField();



        //for pa2
        pal2=new JLabel();
        tpa2=new JTextField();
        bpa1=new JButton();

        //for pa3
        pal3=new JLabel();
        tpa3=new JTextField();

        //pa4
        pal4=new JLabel();
        pal5=new JLabel();
        pal6=new JLabel();
        tpa4= new JTextField();
        tpa5=new JTextField();
        tpa6=new JTextField();

        bpa2=new JButton();
        bpa3=new JButton();


        //pa1
        pal1=new JLabel("Name");
        tpa1=new JTextField("     Packet Name");
        tpa1.setPreferredSize(new Dimension(1140,20));
        pa1.add(pal1);
        pa1.add(tpa1);

        //pa2
        pal2=new JLabel("STRING");
        tpa2=new JTextField("     MESSAGE ");
        tpa2.setPreferredSize(new Dimension(1020,20));
        bpa1=new JButton("Load file");
        pa2.add(pal2);
        pa2.add(tpa2);
        pa2.add(bpa1);

        //pa3
        pal3=new JLabel("ASCII");
        tpa3=new JTextField("    ASCII representation");
        tpa3.setPreferredSize(new Dimension(1140,20));
        tpa3.addMouseListener( this);
        pa3.add(pal3);
        pa3.add(tpa3);

        //pa4
        pal4=new JLabel("Address");
        pal5=new JLabel("Port");
        pal6=new JLabel("Resend Delay");
        pal7=new JLabel("Number of Threads ");
        tpa4=new JTextField("  Ip Address  ");
        tpa5=new JTextField("   1 to 65535   ");
        tpa6=new JTextField("0/blank off");
        tpa7 = new JTextField(" 1/blank off ");
        bpa2=new JButton("Send");
        bpa3= new JButton("Save");
        bpa4=new JButton("Stop");
        combo=new JComboBox(arr);

        tpa7.setPreferredSize(new Dimension(100,20));
        combo.setPreferredSize(new Dimension(85,20));
        tpa4.setPreferredSize(new Dimension(100,20));
        tpa5.setPreferredSize(new Dimension(100,20));
        tpa6.setPreferredSize(new Dimension(100,20));
        pa4.add(pal4);
        pa4.add(tpa4);
        pa4.add(pal5);
        pa4.add(tpa5);
        pa4.add(pal6);
        pa4.add(tpa6);
        pa4.add(pal7);
        pa4.add(tpa7);
        pa4.add(combo);
        pa4.add(bpa2);
        pa4.add(bpa3);
        pa4.add(bpa4);
        bpa2.addActionListener(this);
        bpa3.addActionListener(this);
        bpa3.addActionListener(this);
        bpa4.addActionListener(this);

        //String msg,String ip,String exec,int por



        //

        pa.add(pa1);
        pa.add(pa2);
        pa.add(pa3);
        pa.add(pa4);
        pa.setBorder(line);

//><><><><><><><><><>


//><><><><><><><><><>

        //second pannel
        pb=new JPanel();
        pb.setLayout(new BoxLayout(pb,BoxLayout.Y_AXIS));

        pb.setBorder(line);

//        lb1=new JLabel("                Name     ");
//
//        lb4=new JLabel("       To Address    ");
//        lb5=new JLabel("     To Port    ");
//        lb6=new JLabel(" Method   ");
//        lb8=new JLabel("                    Message     ");
//        lb9=new JLabel("                                                            ASCII           ");
//        pb1.add(lb1);
//
//        pb1.add(lb4);
//        pb1.add(lb5);
//        pb1.add(lb6);
//        pb1.add(lb8);
//        pb1.add(lb9);
//
//
//
//        tb1[0]=new JTextField("                  NA              ");
//        tb2[0]=new JTextField("                  NA              ");
//        tb3[0]=new JTextField("                  NA              ");
//        tb4[0]=new JTextField("                  NA              ");
//        tb5[0]=new JTextField("                  NA              ");
//
//
//
//        tb1[1]=new JTextField("                  NA            ");
//        tb2[1]=new JTextField("                  NA            ");
//        tb3[1]=new JTextField("                  NA            ");
//        tb4[1]=new JTextField("                  NA            ");
//        tb5[1]=new JTextField("                  NA            ");
//
//        tb1[2]=new JTextField("      NA     ");
//        tb2[2]=new JTextField("      NA     ");
//        tb3[2]=new JTextField("      NA     ");
//        tb4[2]=new JTextField("      NA     ");
//        tb5[2]=new JTextField("      NA     ");
//
//        tb1[3]=new JTextField("     NA     ");
//        tb2[3]=new JTextField("     NA     ");
//        tb3[3]=new JTextField("     NA     ");
//        tb4[3]=new JTextField("     NA     ");
//        tb5[3]=new JTextField("     NA     ");
//
//
//
//        tb1[4]=new JTextField("                      NA                        ");
//        tb2[4]=new JTextField("                      NA                        ");
//        tb3[4]=new JTextField("                      NA                        ");
//        tb4[4]=new JTextField("                      NA                        ");
//        tb5[4]=new JTextField("                      NA                        ");
//
//
//        tb1[5]=new JTextField("                                            NA                                              ");
//        tb2[5]=new JTextField("                                            NA                                              ");
//        tb3[5]=new JTextField("                                            NA                                              ");
//        tb4[5]=new JTextField("                                            NA                                              ");
//        tb5[5]=new JTextField("                                            NA                                              ");



table1= new JTable(products1,colname2);
        table1.setRowHeight(table1.getRowHeight() + 5);
        table1.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 5));
        table1.setBorder(line);

          table1.getColumnModel().getColumn(0).setPreferredWidth(1);
//        table1.getColumnModel().getColumn(1).setPreferredWidth(1);
//        table1.getColumnModel().getColumn(2).setPreferredWidth(1);
//        table1.getColumnModel().getColumn(3).setPreferredWidth(1);
          table1.getColumnModel().getColumn(4).setPreferredWidth(230);
          table1.getColumnModel().getColumn(5).setPreferredWidth(230);


        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table1.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);


       /// pb2.add(new JScrollPane(table1));

//        for(int i=0;i<5;i++){
//
//        }
//        for(int i=0;i<6;i++){
//
//            pb2[0].add(tb1[i]);
//            pb2[1].add(tb2[i]);
//            pb2[2].add(tb3[i]);
//            pb2[3].add(tb4[i]);
//            pb2[4].add(tb5[i]);
//
//
//        }

//><><><><><><><><><>
        //thrid pannel
        pc=new JPanel();
        pc.setLayout(new BoxLayout(pc,BoxLayout.Y_AXIS));

        pc.setBorder(line);

//        pc1=new JPanel();
//        pc1.setLayout(new FlowLayout(FlowLayout.LEFT,50,5));
//        l1=new JLabel("                Time     ");
//        l2=new JLabel("             From IP   ");
//        l3=new JLabel(" From Port  ");
//        l4=new JLabel("       To Address    ");
//        l5=new JLabel("     To Port    ");
//        l6=new JLabel(" Method   ");
//        l7=new JLabel("         Error   ");
//        l8=new JLabel("                    Message     ");
//        l9=new JLabel("                                                            ASCII           ");
//        pc1.add(l1);
//        pc1.add(l2);
//        pc1.add(l3);
//        pc1.add(l4);
//        pc1.add(l5);
//        pc1.add(l6);
//        pc1.add(l7);
//        pc1.add(l8);
//        pc1.add(l9);
        //<><><><> revive storage

//        t1[0]=new JTextField("                  NA              ");
//        t2[0]=new JTextField("                  NA              ");
//        t3[0]=new JTextField("                  NA              ");
//        t4[0]=new JTextField("                  NA              ");
//        t5[0]=new JTextField("                  NA              ");
//        t6[0]=new JTextField("                  NA              ");
//        t7[0]=new JTextField("                  NA              ");
//        t8[0]=new JTextField("                  NA              ");
//        t9[0]=new JTextField("                  NA              ");
//        /// t10[0]=new JTextField("                  NA              ");
//
//
//        t1[1]=new JTextField("       NA        ");
//        t2[1]=new JTextField("       NA        ");
//        t3[1]=new JTextField("       NA        ");
//        t4[1]=new JTextField("       NA        ");
//        t5[1]=new JTextField("       NA        ");
//        t6[1]=new JTextField("       NA        ");
//        t7[1]=new JTextField("       NA        ");
//        t8[1]=new JTextField("       NA        ");
//        t9[1]=new JTextField("       NA        ");
//        //  t10[1]=new JTextField("       NA        ");
//
//        t1[2]=new JTextField("      NA       ");
//        t2[2]=new JTextField("      NA       ");
//        t3[2]=new JTextField("      NA       ");
//        t4[2]=new JTextField("      NA       ");
//        t5[2]=new JTextField("      NA       ");
//        t6[2]=new JTextField("      NA       ");
//        t7[2]=new JTextField("      NA       ");
//        t8[2]=new JTextField("      NA       ");
//        t9[2]=new JTextField("      NA       ");
//        //  t10[2]=new JTextField("      NA       ");
//
//
//        t1[3]=new JTextField("                  NA            ");
//        t2[3]=new JTextField("                  NA            ");
//        t3[3]=new JTextField("                  NA            ");
//        t4[3]=new JTextField("                  NA            ");
//        t5[3]=new JTextField("                  NA            ");
//        t6[3]=new JTextField("                  NA            ");
//        t7[3]=new JTextField("                  NA            ");
//        t8[3]=new JTextField("                  NA            ");
//        t9[3]=new JTextField("                  NA            ");
//        // t10[3]=new JTextField("                  NA            ");
//
//        t1[4]=new JTextField("      NA     ");
//        t2[4]=new JTextField("      NA     ");
//        t3[4]=new JTextField("      NA     ");
//        t4[4]=new JTextField("      NA     ");
//        t5[4]=new JTextField("      NA     ");
//        t6[4]=new JTextField("      NA     ");
//        t7[4]=new JTextField("      NA     ");
//        t8[4]=new JTextField("      NA     ");
//        t9[4]=new JTextField("      NA     ");
//        // t10[4]=new JTextField("      NA     ");
//
//        t1[5]=new JTextField("     NA     ");
//        t2[5]=new JTextField("     NA     ");
//        t3[5]=new JTextField("     NA     ");
//        t4[5]=new JTextField("     NA     ");
//        t5[5]=new JTextField("     NA     ");
//        t6[5]=new JTextField("     NA     ");
//        t7[5]=new JTextField("     NA     ");
//        t8[5]=new JTextField("     NA     ");
//        t9[5]=new JTextField("     NA     ");
//        // t10[5]=new JTextField("     NA     ");
//
//        t1[6]=new JTextField("            NA          ");
//        t2[6]=new JTextField("            NA          ");
//        t3[6]=new JTextField("            NA          ");
//        t4[6]=new JTextField("            NA          ");
//        t5[6]=new JTextField("            NA          ");
//        t6[6]=new JTextField("            NA          ");
//        t7[6]=new JTextField("            NA          ");
//        t8[6]=new JTextField("            NA          ");
//        t9[6]=new JTextField("            NA          ");
//        //t10[6]=new JTextField("            NA          ");
//
//        t1[7]=new JTextField("                      NA                        ");
//        t2[7]=new JTextField("                      NA                        ");
//        t3[7]=new JTextField("                      NA                        ");
//        t4[7]=new JTextField("                      NA                        ");
//        t5[7]=new JTextField("                      NA                        ");
//        t6[7]=new JTextField("                      NA                        ");
//        t7[7]=new JTextField("                      NA                        ");
//        t8[7]=new JTextField("                      NA                        ");
//        t9[7]=new JTextField("                      NA                        ");
//        //t10[7]=new JTextField("                      NA                        ");
//
//        t1[8]=new JTextField("                                            NA                                              ");
//        t2[8]=new JTextField("                                            NA                                              ");
//        t3[8]=new JTextField("                                            NA                                              ");
//        t4[8]=new JTextField("                                            NA                                              ");
//        t5[8]=new JTextField("                                            NA                                              ");
//        t6[8]=new JTextField("                                            NA                                              ");
//        t7[8]=new JTextField("                                            NA                                              ");
//        t8[8]=new JTextField("                                            NA                                              ");
//        t9[8]=new JTextField("                                            NA                                              ");
//        //t10[8]=new JTextField("                                            NA                                              ");

//        for(int i=0;i<10;i++){
//            pc2[i]=new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
//        }
//        for(int i=0;i<9;i++){
//
//            pc2[0].add(t1[i]);
//            pc2[1].add(t2[i]);
//            pc2[2].add(t3[i]);
//            pc2[3].add(t4[i]);
//            pc2[4].add(t5[i]);
//            pc2[5].add(t6[i]);
//            pc2[6].add(t7[i]);
//            pc2[7].add(t8[i]);
//            pc2[8].add(t9[i]);
//            //   pc2[9].add(t10[i]);
//
//
//        }

        pb.add(new JScrollPane(table1));



         table = new JTable( products, colName );

        table.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 5));
        table.setBorder(line);

       table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
//        table.getColumnModel().getColumn(2).setPreferredWidth(1);
//        table.getColumnModel().getColumn(3).setPreferredWidth(1);
//        table.getColumnModel().getColumn(4).setPreferredWidth(1);
//        table.getColumnModel().getColumn(5).setPreferredWidth(1);
//        table.getColumnModel().getColumn(6).setPreferredWidth(1);
//        table.getColumnModel().getColumn(7).setPreferredWidth(1);
        table.getColumnModel().getColumn(8).setPreferredWidth(230);
         table.getColumnModel().getColumn(9).setPreferredWidth(230);


        cellRenderer = new DefaultTableCellRenderer();
        ownz=new JTextField("  Created By Harshit Vashisth  ");
        ownz2=new JTextField("  Created By Harshit Vashisth  ");
        ownz3=new JTextField(s33);
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(9).setCellRenderer(cellRenderer);
        ownz=new JTextField("  Created By Harshit Vashisth  ");

        // create scroll pane for wrapping the table and add
        // it to the frame
        //table.setAutoResizeMode();
        ownz=new JTextField("  Created By Harshit Vashisth  ");
        ownz2=new JTextField("  Created By Harshit Vashisth  ");
        pc.add( new JScrollPane( table ) );
//        pc.add(pc1);
////        for(int i =0;i<10;i++){
//            pc.add(pc2[i]);
//        }


//><><><><><><><><><>
        c1=new JLabel("UDP:");
        c2=new JLabel("TCP:");
        c3=new JLabel("SSL:");
        cout=new JLabel("  Packet Count ");

        cou=new JTextField("          NA           ");
        ownz=new JTextField("  Created By Harshit Vashisth  ");
        ownz.setLayout(new FlowLayout(FlowLayout.LEFT));
        ct1=new JTextField("       NA      ");
        ct2=new JTextField("       NA      ");
        ct3=new JTextField("       NA      ");
        ct4=new JTextField("       IPV4      ");
        ct1.setText("59999");
        ownz=new JTextField("  Created By Harshit Vashisth  ");
        ownz2=new JTextField("  Created By Harshit Vashisth  ");
        ca.add(ownz);
        cb.add(cout);
        cb.add(cou);
        cb.add(c1);
        cb.add(ct1);
        cb.add(c2);
        cb.add(ct2);
        cb.add(c3);
        cb.add(ct3);
        cb.add(ct4);
        c.add(cb,BorderLayout.EAST);
        c.add(ca,BorderLayout.WEST);
       // ownz=new JTextField("  Created By Harshit Vashisth  ");
        ///<><><><><><><><><>


        b.add(pa);
        b.add(pb);
        b.add(pc);
        frame.add(a,BorderLayout.NORTH);
        frame.add(b,BorderLayout.CENTER);
        frame.add(c,BorderLayout.SOUTH);

       // ownz=new JTextField("  Created By Harshit Vashisth  ");

//780 630pb

        frame.setBackground(Color.decode("#0B0D49"));
        a.setBackground(Color.decode("#0B0D49"));
        b.setBackground(Color.decode("#0B0D49"));
        c.setBackground(Color.decode("#0B0D49"));
        ca.setBackground(Color.decode("#0B0D49"));
        cb.setBackground(Color.decode("#0B0D49"));
        pa.setBackground(Color.decode("#0B0D49"));
        pb.setBackground(Color.decode("#0B0D49"));
        pc.setBackground(Color.decode("#0B0D49"));
        table.setBackground(Color.decode("#0D0F56"));
        table.setForeground(Color.decode("#72FAB8"));
        table1.setBackground(Color.decode("#0D0F56"));
        table1.setForeground(Color.decode("#51F0FF"));
        pa1.setBackground(Color.decode("#0D0F56"));
        pa2.setBackground(Color.decode("#0D0F56"));
        pa3.setBackground(Color.decode("#0D0F56"));
        pa4.setBackground(Color.decode("#0D0F56"));
        pal1.setForeground(Color.decode("#FDCF33"));
        pal2.setForeground(Color.decode("#FDCF33"));
        pal3.setForeground(Color.decode("#FDCF33"));
        pal4.setForeground(Color.decode("#FDCF33"));
        pal5.setForeground(Color.decode("#FDCF33"));
        pal6.setForeground(Color.decode("#FDCF33"));
        c1.setForeground(Color.decode("#FDCF33"));
        c2.setForeground(Color.decode("#FDCF33"));
        c3.setForeground(Color.decode("#FDCF33"));
        cout.setForeground(Color.decode("#FDCF33"));
        tpa1.setBackground(Color.decode("#363994"));
        tpa2.setBackground(Color.decode("#363994"));
        tpa3.setBackground(Color.decode("#363994"));
        tpa4.setBackground(Color.decode("#363994"));
        tpa5.setBackground(Color.decode("#363994"));
        tpa6.setBackground(Color.decode("#363994"));
        tpa7.setBackground(Color.decode("#363994"));
        ct1.setBackground(Color.decode("#363994"));
        ct2.setBackground(Color.decode("#363994"));
        ct3.setBackground(Color.decode("#363994"));
        ownz.setBackground(Color.decode("#363994"));
        ct4.setBackground(Color.decode("#363994"));
        cou.setBackground(Color.decode("#363994"));
        pal7.setForeground(Color.decode("#FDCF33"));
        tpa1.setForeground(Color.decode("#F471FF"));
        tpa2.setForeground(Color.decode("#F471FF"));
        tpa3.setForeground(Color.decode("#F471FF"));
        tpa4.setForeground(Color.decode("#F471FF"));
        tpa5.setForeground(Color.decode("#F471FF"));
        tpa6.setForeground(Color.decode("#F471FF"));
        tpa7.setForeground(Color.decode("#F471FF"));
        ct1.setForeground(Color.decode("#F471FF"));
        ct2.setForeground(Color.decode("#F471FF"));
        ownz.setForeground(Color.decode("#86FCF5"));
        ct3.setForeground(Color.decode("#F471FF"));
        ct4.setForeground(Color.decode("#F471FF"));
        cou.setForeground(Color.decode("#F471FF"));
        a1.setForeground((Color.decode("#94D9A5")));
        a2.setForeground((Color.decode("#94D9A5")));
        a3.setForeground((Color.decode("#94D9A5")));
        a4.setForeground((Color.decode("#94D9A5")));
        a5.setForeground((Color.decode("#94D9A5")));
        bpa1.setForeground((Color.decode("#94D9A5")));
        bpa2.setForeground((Color.decode("#94D9A5")));
        bpa4.setForeground((Color.decode("#94D9A5")));
        bpa3.setForeground((Color.decode("#94D9A5")));
        a1.setBackground((Color.decode("#172033")));
        a2.setBackground((Color.decode("#172033")));
        a3.setBackground((Color.decode("#172033")));
        a4.setBackground((Color.decode("#172033")));
        a5.setBackground((Color.decode("#172033")));
        bpa3.setBackground((Color.decode("#172033")));
        bpa1.setBackground((Color.decode("#172033")));
        bpa2.setBackground((Color.decode("#172033")));
        bpa4.setBackground((Color.decode("#172033")));

//a1,a2,a3,a4,a5; bpa1;bpa2,bpa3
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.decode("#0D0101"));
        headerRenderer.setForeground(Color.decode("#DEFC00"));

        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }


        for (int i = 0; i < table1.getModel().getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        tpa1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tpa2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tpa3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tpa4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tpa5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tpa6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ct1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ct2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ct3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ct4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        cou.setBorder(javax.swing.BorderFactory.createEmptyBorder());








//


        frame.setSize(1540,615);
        frame.setVisible(true);


    }

    void asci(String as){
        es="";


        int a;
        for(int i =0;i<as.length();i++){
            a=(int)as.charAt(i);
            es=es+a;
        }

        tpa3.setText(es);
    }

    public void set(String msg,String ip,String exec,int port) throws UnknownHostException {

        mset=msg;
        ipad=ip;
        exe=exec;
        port1=port;
        Thread th2=new Thread();
        th2.start();

    }
    //    void reciver(DatagramSocket ds) throws IOException {
//        System.out.println("step1");
//        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy//MM//dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dt.format(now));
//
//        byte[] b1 = new byte[2000];
//        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
//
//        ds.receive(dp1);
//
//        String s1 = new String(dp1.getData());
//        s1 = s1.trim();
//
//        InetAddress ip = InetAddress.getLocalHost();
//
//
//
//        if (ct == 0) {
//
//            products[0][0]=0;
//            products[0][1]=dt.format(now);
//            products[0][2]=ip;
//            products[0][3]=String.valueOf(String.valueOf(dp1.getPort()));
//            products[0][4]=ip.getHostAddress().trim();
//            products[0][5]=String.valueOf(ds.getLocalPort());
//            products[0][6]="UDP";
//            products[0][7]=exec;
//            products[0][8]=s1;
//            products[0][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 1) {
//
//            products[1][0]=co;
//            products[1][1]=dt.format(now);
//            products[1][2]=ip;
//            products[1][3]=String.valueOf(dp1.getPort());
//            products[1][4]=ip.getHostAddress().trim();
//            products[1][5]=String.valueOf(ds.getLocalPort());
//            products[1][6]="UDP";
//            products[1][7]=exec;
//            products[1][8]=s1;
//            products[1][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 2) {
//
//            products[2][0]=co;
//            products[2][1]=dt.format(now);
//            products[2][2]=ip;
//            products[2][3]=String.valueOf(dp1.getPort());
//            products[2][4]=ip.getHostAddress().trim();
//            products[2][5]=String.valueOf(ds.getLocalPort());
//            products[2][6]="UDP";
//            products[2][7]=exec;
//            products[2][8]=s1;
//            products[2][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 3) {
//
//            products[3][0]=co;
//            products[3][1]=dt.format(now);
//            products[3][2]=ip;
//            products[3][3]=String.valueOf(dp1.getPort());
//            products[3][4]=ip.getHostAddress().trim();
//            products[3][5]=String.valueOf(ds.getLocalPort());
//            products[3][6]="UDP";
//            products[3][7]=exec;
//            products[3][8]=s1;
//            products[3][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 4) {
//
//            products[4][0]=co;
//            products[4][1]=dt.format(now);
//            products[4][2]=ip;
//            products[4][3]=String.valueOf(dp1.getPort());
//            products[4][4]=ip.getHostAddress().trim();
//            products[4][5]=String.valueOf(ds.getLocalPort());
//            products[4][6]="UDP";
//            products[4][7]=exec;
//            products[4][8]=s1;
//            products[4][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 5) {
//
//            products[5][0]=co;
//            products[5][1]=dt.format(now);
//            products[5][2]=ip;
//            products[5][3]=String.valueOf(dp1.getPort());
//            products[5][4]=ip.getHostAddress().trim();
//            products[5][5]=String.valueOf(ds.getLocalPort());
//            products[5][6]="UDP";
//            products[5][7]=exec;
//            products[5][8]=s1;
//            products[5][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//        else if (ct == 6) {
//
//            products[6][0]=co;
//            products[6][1]=dt.format(now);
//            products[6][2]=ip;
//            products[6][3]=String.valueOf(dp1.getPort());
//            products[6][4]=ip.getHostAddress().trim();
//            products[6][5]=String.valueOf(ds.getLocalPort());
//            products[6][6]="UDP";
//            products[6][7]=exec;
//            products[6][8]=s1;
//            products[6][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//        else if (ct == 7) {
//
//            products[7][0]=co;
//            products[7][1]=dt.format(now);
//            products[7][2]=ip;
//            products[7][3]=String.valueOf(dp1.getPort());
//            products[7][4]=ip.getHostAddress().trim();
//            products[7][5]=String.valueOf(ds.getLocalPort());
//            products[7][6]="UDP";
//            products[7][7]=exec;
//            products[7][8]=s1;
//            products[7][9]=ft;
//            ct = (ct + 1) % 10;
//
//        }
//        else if (ct == 8) {
//
//            products[8][0]=co;
//            products[8][1]=dt.format(now);
//            products[8][2]=ip;
//            products[8][3]=String.valueOf(dp1.getPort());
//            products[8][4]=ip.getHostAddress().trim();
//            products[8][5]=String.valueOf(ds.getLocalPort());
//            products[8][6]="UDP";
//            products[8][7]=exec;
//            products[8][8]=s1;
//            products[8][9]=ft;
//            ct = (ct + 1) % 10;
//
//        } else {
//
//            products[9][0]=co;
//            products[9][1]=dt.format(now);
//            products[9][2]=ip;
//            products[9][3]=String.valueOf(dp1.getPort());
//            products[9][4]=ip.getHostAddress().trim();
//            products[9][5]=String.valueOf(ds.getLocalPort());
//            products[9][6]="UDP";
//            products[9][7]=exec;
//            products[9][8]=s1;
//            products[9][9]=ft;
//            ct = (ct + 1) % 10;
//        }
//
//    }
    void sender(String spa1,String spa2,String spa3,String s1,int s22,int mili,int p) throws IOException, InterruptedException {
        for(int i=0;i<p;i++) {
            send o1 = new send(ds, spa1, spa2, spa3, s1, s22, mili);
            th1 = new Thread(o1);
            th1.start();
        }

    }
    void saved(String spa1,String spa2,String s1,String s2){

        k=1;
        sav1=spa1;
        sav2=spa2;
        sav3=s1;
        sav4=s2;
        asci(spa2);
        table1.repaint();
        if (count == 0) {
            products1[0][0]=sav1;
            products1[0][1]=sav3;
            products1[0][2]= sav4;
            products1[0][3]="UDP";
            products1[0][4]=sav2;
            products1[0][5]=es;
            count = (count + 1) %8 ;
        }
        else  if (count == 1) {
            products1[1][0]=sav1;
            products1[1][1]=sav3;
            products1[1][2]= sav4;
            products1[1][3]="UDP";
            products1[1][4]=sav2;
            products1[1][5]=es;
            count = (count + 1) %8 ;
        }
        else if (count == 2) {
            products1[2][0]=sav1;
            products1[2][1]=sav3;
            products1[2][2]= sav4;
            products1[2][3]="UDP";
            products1[2][4]=sav2;
            products1[2][5]=es;
            count = (count + 1) %8 ;
        }
        else if (count == 3) {
            products1[3][0]=sav1;
            products1[3][1]=sav3;
            products1[3][2]= sav4;
            products1[3][3]="UDP";
            products1[3][4]=sav2;
            products1[3][5]=es;
            count = (count + 1) %8 ;
        }
        else if (count == 4) {
            products1[4][0]=sav1;
            products1[4][1]=sav3;
            products1[4][2]= sav4;
            products1[4][3]="UDP";
            products1[4][4]=sav2;
            products1[4][5]=es;
            count = (count + 1) %8 ;
        }
        else if(count==5){
            products1[5][0]=sav1;
            products1[5][1]=sav3;
            products1[5][2]= sav4;
            products1[5][3]="UDP";
            products1[5][4]=sav2;
            products1[5][5]=es;
            count = (count + 1) %8 ;
        }
        else if(count==6){
            products1[6][0]=sav1;
            products1[6][1]=sav3;
            products1[6][2]= sav4;
            products1[6][3]="UDP";
            products1[6][4]=sav2;
            products1[6][5]=es;
            count = (count + 1) %8 ;
        }
        else if(count==7){
            products1[7][0]=sav1;
            products1[7][1]=sav3;
            products1[7][2]= sav4;
            products1[7][3]="UDP";
            products1[7][4]=sav2;
            products1[7][5]=es;
            count = (count + 1) %8 ;
        }
        else{
            products1[8][0]=sav1;
            products1[8][1]=sav3;
            products1[8][2]= sav4;
            products1[8][3]="UDP";
            products1[8][4]=sav2;
            products1[8][5]=es;
            count = (count + 1) %8 ;
        }
    }
    public static boolean isValidInet4Address(String ip)
    {
        try {
            return Inet4Address.getByName(ip)
                    .getHostAddress().equals(ip);
        }
        catch (UnknownHostException ex) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bpa2){

            spa1=tpa1.getText();
            spa2=tpa2.getText();
            spa3=tpa6.getText();
            String f=tpa7.getText();
            int p=Integer.parseInt(f);
            mili= Integer.parseInt(spa3);


            s1=tpa4.getText();//ip
            s2=tpa5.getText();
            s3=es;
            tpa3.setText(s3);

            if (isValidInet4Address(s1)) {

                s22=Integer.parseInt(s2);
                byte a[]=spa2.getBytes();
                //  s33=Integer.parseInt(s3);

                try {
                    sender(spa1,spa2,spa3,s1,s22,mili,p);
                } catch (IOException ex) {
                    exec=ex.getMessage();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
//                try {
//                    System.out.println("oke");
//                    reciver(ds);
//                } catch (IOException ex) {
//                    exec=ex.getMessage();
//                }
            }
            else {
                JPanel panel = new JPanel();
                String sr1="The IP Address "+s1+" isn't valid !";
                JOptionPane.showMessageDialog(panel, sr1, "Warning",
                        JOptionPane.WARNING_MESSAGE);
                try {
                    new client(ds," BY HARSHIT VASHISTH ");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        if(e.getSource()==bpa3) {
            spa1=tpa1.getText();
            spa2=tpa2.getText();
            // spa3=tpa3.getText();

            s1=tpa4.getText();//ip
            s2=tpa5.getText();//port
            s3=es;
            tpa3.setText(s3);

            if (isValidInet4Address(s1)) {
                s22 = Integer.parseInt(s2);
            }

            saved(spa1,spa2,s1,s2);

        }
        if(e.getSource()==a2){
            spa2=tpa2.getText();
            s1=tpa4.getText();//ip
            s2=tpa5.getText();
            new tools(ds,spa2,s1,s2);
        }
        if(e.getSource()==bpa4){
           // th1.stop();

//            for (Thread th1 : Thread.getAllStackTraces().keySet())
//            {  if (th1.getState()==Thread.State.RUNNABLE)
//                th1.interrupt();
//            }

            for (Thread th1 : Thread.getAllStackTraces().keySet())
            {  if (th1.getState()==Thread.State.RUNNABLE)
                th1.stop();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        String ta=tpa2.getText();
        asci(ta);

    }


    @Override
    public void mousePressed(MouseEvent e) {
        String ta=tpa2.getText();
        asci(ta);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        //////////////////////////
        co++;
        cou.setText(String.valueOf(co));
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy//MM//dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        InetAddress it= null;
        try {
            it = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int a;
        ft=" ";
        for(int i =0;i<mset.length();i++){
            a=(int)mset.charAt(i);
            ft=ft+a;
        }

        table.repaint();
        if (ct == 0) {

            products[0][0]=co;
            products[0][1]=dt.format(now);
            products[0][2]=ipad;
            products[0][3]=String.valueOf(port1);
            products[0][4]=it.getHostAddress().trim();
            products[0][5]=String.valueOf(ds.getLocalPort());
            products[0][6]="UDP";
            products[0][7]=exec;
            products[0][8]=mset;
            products[0][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 1) {

            products[1][0]=co;
            products[1][1]=dt.format(now);
            products[1][2]=ipad;
            products[1][3]=String.valueOf(port1);
            products[1][4]=it.getHostAddress().trim();
            products[1][5]=String.valueOf(ds.getLocalPort());
            products[1][6]="UDP";
            products[1][7]=exec;
            products[1][8]=mset;
            products[1][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 2) {

            products[2][0]=co;
            products[2][1]=dt.format(now);
            products[2][2]=ipad;
            products[2][3]=String.valueOf(port1);
            products[2][4]=it.getHostAddress().trim();
            products[2][5]=String.valueOf(ds.getLocalPort());
            products[2][6]="UDP";
            products[2][7]=exec;
            products[2][8]=mset;
            products[2][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 3) {

            products[3][0]=co;
            products[3][1]=dt.format(now);
            products[3][2]=ipad;
            products[3][3]=String.valueOf(port1);
            products[3][4]=it.getHostAddress().trim();
            products[3][5]=String.valueOf(ds.getLocalPort());
            products[3][6]="UDP";
            products[3][7]=exec;
            products[3][8]=mset;
            products[3][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 4) {

            products[4][0]=co;
            products[4][1]=dt.format(now);
            products[4][2]=ipad;
            products[4][3]=String.valueOf(port1);
            products[4][4]=it.getHostAddress().trim();
            products[4][5]=String.valueOf(ds.getLocalPort());
            products[4][6]="UDP";
            products[4][7]=exec;
            products[4][8]=mset;
            products[4][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 5) {

            products[5][0]=co;
            products[5][1]=dt.format(now);
            products[5][2]=ipad;
            products[5][3]=String.valueOf(port1);
            products[5][4]=it.getHostAddress().trim();
            products[5][5]=String.valueOf(ds.getLocalPort());
            products[5][6]="UDP";
            products[5][7]=exec;
            products[5][8]=mset;
            products[5][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 6) {

            products[6][0]=co;
            products[6][1]=dt.format(now);
            products[6][2]=ipad;
            products[6][3]=String.valueOf(port1);
            products[6][4]=it.getHostAddress().trim();
            products[6][5]=String.valueOf(ds.getLocalPort());
            products[6][6]="UDP";
            products[6][7]=exec;
            products[6][8]=mset;
            products[6][9]=ft;
            ct = (ct + 1) % 15;
        }
        else if (ct == 7) {

            products[7][0]=co;
            products[7][1]=dt.format(now);
            products[7][2]=ipad;
            products[7][3]=String.valueOf(port1);
            products[7][4]=it.getHostAddress().trim();
            products[7][5]=String.valueOf(ds.getLocalPort());
            products[7][6]="UDP";
            products[7][7]=exec;
            products[7][8]=mset;
            products[7][9]=ft;
            ct = (ct + 1) % 15;

        }
        else if (ct == 8) {

            products[8][0]=co;
            products[8][1]=dt.format(now);
            products[8][2]=ipad;
            products[8][3]=String.valueOf(port1);
            products[8][4]=it.getHostAddress().trim();
            products[8][5]=String.valueOf(ds.getLocalPort());
            products[8][6]="UDP";
            products[8][7]=exec;
            products[8][8]=mset;
            products[8][9]=ft;
            ct = (ct + 1) % 15;

        }
        else if(ct==9){

            products[9][0]=co;
            products[9][1]=dt.format(now);
            products[9][2]=ipad;
            products[9][3]=String.valueOf(port1);
            products[9][4]=it.getHostAddress().trim();
            products[9][5]=String.valueOf(ds.getLocalPort());
            products[9][6]="UDP";
            products[9][7]=exec;
            products[9][8]=mset;
            products[9][9]=ft;
            ct = (ct + 1) % 15;
        }

        else if (ct == 10) {

            products[10][0]=co;
            products[10][1]=dt.format(now);
            products[10][2]=ipad;
            products[10][3]=String.valueOf(port1);
            products[10][4]=it.getHostAddress().trim();
            products[10][5]=String.valueOf(ds.getLocalPort());
            products[10][6]="UDP";
            products[10][7]=exec;
            products[10][8]=mset;
            products[10][9]=ft;
            ct = (ct + 1) % 15;
        }

        else  if(ct==11){

            products[11][0]=co;
            products[11][1]=dt.format(now);
            products[11][2]=ipad;
            products[11][3]=String.valueOf(port1);
            products[11][4]=it.getHostAddress().trim();
            products[11][5]=String.valueOf(ds.getLocalPort());
            products[11][6]="UDP";
            products[11][7]=exec;
            products[11][8]=mset;
            products[11][9]=ft;
            ct = (ct + 1) % 15;
        }
        else if (ct == 12) {

            products[12][0]=co;
            products[12][1]=dt.format(now);
            products[12][2]=ipad;
            products[12][3]=String.valueOf(port1);
            products[12][4]=it.getHostAddress().trim();
            products[12][5]=String.valueOf(ds.getLocalPort());
            products[12][6]="UDP";
            products[12][7]=exec;
            products[12][8]=mset;
            products[12][9]=ft;
            ct = (ct + 1) % 15;
        }
        else if(ct==13) {

            products[13][0]=co;
            products[13][1]=dt.format(now);
            products[13][2]=ipad;
            products[13][3]=String.valueOf(port1);
            products[13][4]=it.getHostAddress().trim();
            products[13][5]=String.valueOf(ds.getLocalPort());
            products[13][6]="UDP";
            products[13][7]=exec;
            products[13][8]=mset;
            products[13][9]=ft;
            ct = (ct + 1) % 15;
        }

        else  {

            products[14][0]=co;
            products[14][1]=dt.format(now);
            products[14][2]=ipad;
            products[14][3]=String.valueOf(port1);
            products[14][4]=it.getHostAddress().trim();
            products[14][5]=String.valueOf(ds.getLocalPort());
            products[14][6]="UDP";
            products[14][7]=exec;
            products[14][8]=mset;
            products[14][9]=ft;
            ct = (ct + 1) % 15;
        }
        //String sav1,sav2,sav3,sav4;

    }
}