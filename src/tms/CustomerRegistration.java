package tms;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;                   //number validation
import javax.swing.event.*;
import java.util.Date;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class CustomerRegistration extends JFrame implements ItemListener,ActionListener,DocumentListener{
    Choice ch1,ch2,ch3;
    JRadioButton r1,r2,r3,r4;
    JLabel l6,l21,l23,l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50;
    String username;
    JButton b1,b2,b3,b4,b5,b6;
    JTextField t1,t2,ta,t3,t4,t5;
    com.toedter.calendar.JDateChooser jdc;
    String dp = null,ddate=null;
    
    CustomerRegistration(String username){
        this.username=username;
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("New Registration");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("tms/icons/travel6.jpg"));
        Image b = bi.getImage().getScaledInstance(1540,840,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0,0,1540,840);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1540,840);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        
        //Receipt
        JLabel l18 = new JLabel("Receipt : ");
        l18.setBounds(960,30,150,30);
        l18.setFont(new Font("Georgia",Font.BOLD,25));
        l18.setForeground(Color.BLACK);
        la.add(l18);
        
        JPanel p1 = new JPanel();
        p1.setBounds(1100,10,400,720);
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
        la.add(p1);
        
        JLabel l26 = new JLabel("Ref :");
        l26.setBounds(20,20,150,30);
        l26.setFont(new Font("Georgia",Font.PLAIN,19));
        l26.setForeground(Color.BLACK);
        p1.add(l26);
        
        l27 = new JLabel("");
        l27.setBounds(200,20,300,30);
        l27.setFont(new Font("Georgia",Font.PLAIN,19));
        l27.setForeground(Color.BLACK);
        p1.add(l27);
        
        JLabel l28 = new JLabel("-------------------------------------------------------");
        l28.setBounds(0,50,400,30);
        l28.setFont(new Font("Georgia",Font.PLAIN,19));
        l28.setForeground(Color.BLACK);
        p1.add(l28);
        
        JLabel l24 = new JLabel("Name :");
        l24.setBounds(20,80,150,30);
        l24.setFont(new Font("Georgia",Font.PLAIN,19));
        l24.setForeground(Color.BLACK);
        p1.add(l24);
        
        l29 = new JLabel("");
        l29.setBounds(200,80,200,30);
        l29.setFont(new Font("Georgia",Font.PLAIN,19));
        l29.setForeground(Color.BLACK);
        p1.add(l29);
        
        JLabel l25 = new JLabel("Surname :");
        l25.setBounds(20,127,150,30);
        l25.setFont(new Font("Georgia",Font.PLAIN,19));
        l25.setForeground(Color.BLACK);
        p1.add(l25);
        
        l30 = new JLabel("");
        l30.setBounds(200,127,200,30);
        l30.setFont(new Font("Georgia",Font.PLAIN,19));
        l30.setForeground(Color.BLACK);
        p1.add(l30);
        
        JLabel l31 = new JLabel("Address :");
        l31.setBounds(20,173,150,30);
        l31.setFont(new Font("Georgia",Font.PLAIN,19));
        l31.setForeground(Color.BLACK);
        p1.add(l31);
        
        l32 = new JLabel("");
        l32.setBounds(20,203,370,30);
        l32.setFont(new Font("Georgia",Font.PLAIN,19));
        //l32.setBorder(BorderFactory.createLineBorder(Color.gray));
        l32.setForeground(Color.BLACK);
        p1.add(l32);
        
        JLabel l33 = new JLabel("Pincode :");
        l33.setBounds(20,250,150,30);
        l33.setFont(new Font("Georgia",Font.PLAIN,19));
        l33.setForeground(Color.BLACK);
        p1.add(l33);
        
        l34 = new JLabel("");
        l34.setBounds(200,250,150,30);
        l34.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        l34.setForeground(Color.BLACK);
        p1.add(l34);
        
        JLabel l35 = new JLabel("Mobile No. :");
        l35.setBounds(20,297,150,30);
        l35.setFont(new Font("Georgia",Font.PLAIN,19));
        l35.setForeground(Color.BLACK);
        p1.add(l35);
        
        l36 = new JLabel("");
        l36.setBounds(200,297,150,30);
        l36.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        l36.setForeground(Color.BLACK);
        p1.add(l36);
        
        JLabel l37 = new JLabel("Email :");
        l37.setBounds(20,345,150,30);
        l37.setFont(new Font("Georgia",Font.PLAIN,19));
        l37.setForeground(Color.BLACK);
        p1.add(l37);
        
        l38 = new JLabel("");
        l38.setBounds(20,380,370,30);
        l38.setFont(new Font("Georgia",Font.PLAIN,19));
        l38.setForeground(Color.BLACK);
        p1.add(l38);
        
        JLabel l39 = new JLabel("Destination :");
        l39.setBounds(20,430,370,30);
        l39.setFont(new Font("Georgia",Font.PLAIN,19));
        l39.setForeground(Color.BLACK);
        p1.add(l39);
        
        l40 = new JLabel("");
        l40.setBounds(200,430,370,30);
        l40.setFont(new Font("Georgia",Font.PLAIN,19));
        l40.setForeground(Color.BLACK);
        p1.add(l40);
        
        JLabel l41 = new JLabel("Package :");
        l41.setBounds(20,480,150,30);
        l41.setFont(new Font("Georgia",Font.PLAIN,19));
        l41.setForeground(Color.BLACK);
        p1.add(l41);
        
        l42 = new JLabel("");
        l42.setBounds(200,480,370,30);
        l42.setFont(new Font("Georgia",Font.PLAIN,19));
        l42.setForeground(Color.BLACK);
        p1.add(l42);
        
        JLabel l43 = new JLabel("Hotel :");
        l43.setBounds(20,530,150,30);
        l43.setFont(new Font("Georgia",Font.PLAIN,19));
        l43.setForeground(Color.BLACK);
        p1.add(l43);
        
        l44 = new JLabel("");
        l44.setBounds(200,530,370,30);
        l44.setFont(new Font("Georgia",Font.PLAIN,19));
        l44.setForeground(Color.BLACK);
        p1.add(l44);
        
        JLabel l45 = new JLabel("Room Type :");
        l45.setBounds(20,570,150,30);
        l45.setFont(new Font("Georgia",Font.PLAIN,19));
        l45.setForeground(Color.BLACK);
        p1.add(l45);
        
        l46 = new JLabel("");
        l46.setBounds(200,570,370,30);
        l46.setFont(new Font("Georgia",Font.PLAIN,19));
        l46.setForeground(Color.BLACK);
        p1.add(l46);
        
        JLabel l49 = new JLabel("Total :");
        l49.setBounds(20,620,150,30);
        l49.setFont(new Font("Georgia",Font.PLAIN,19));
        l49.setForeground(Color.BLACK);
        p1.add(l49);
        
        l50 = new JLabel("");
        l50.setBounds(200,620,150,30);
        l50.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        l50.setForeground(Color.BLACK);
        p1.add(l50);
        
        JLabel l47 = new JLabel("-------------------------------------------------------");
        l47.setBounds(0,640,400,30);
        l47.setFont(new Font("Georgia",Font.PLAIN,19));
        l47.setForeground(Color.BLACK);
        p1.add(l47);
        
        JLabel l48 = new JLabel("Date:");
        l48.setBounds(20,670,60,30);
        l48.setFont(new Font("Georgia",Font.PLAIN,19));
        l48.setForeground(Color.BLACK);
        p1.add(l48);
        
        l51 = new JLabel("");
        l51.setBounds(90,670,150,30);
        l51.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        l51.setForeground(Color.BLACK);
        p1.add(l51);
     
        b1 = new JButton("Generate  Receipt");
        b1.setBounds(1100,750,240,40);
        b1.setBackground(Color.DARK_GRAY);
        b1.setFont(new Font("Georgia",Font.BOLD,22));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.addActionListener(this);
        b1.setEnabled(false);
        la.add(b1);
        
        b2 = new JButton("Print");
        b2.setBounds(1360,750,140,40);
        b2.setBackground(Color.DARK_GRAY);
        b2.setFont(new Font("Georgia",Font.BOLD,22));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        b2.setEnabled(false);
        la.add(b2);
         
        //personal details
        JPanel p2 = new JPanel();
        p2.setBounds(30,30,700,430);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        la.add(p2);
        
        JLabel l14 = new JLabel("*");
        l14.setBounds(380,25,150,30);
        l14.setFont(new Font("Tahoma",Font.BOLD,22));
        l14.setForeground(Color.RED);
        p2.add(l14);
        
        JLabel l7 = new JLabel("First  Name :");
        l7.setBounds(20,25,150,30);
        l7.setFont(new Font("Georgia",Font.BOLD,19));
        l7.setForeground(Color.BLACK);
        p2.add(l7);
        
        t1 = new JTextField();
        t1.setBounds(170,25,200,33);
        t1.setFont(new Font("Tahoma",Font.PLAIN,21));
        t1.setForeground(Color.BLACK);
        t1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetter(ch)  || e.getKeyCode()==KeyEvent.VK_SHIFT ){
                    l14.setText("");
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t1.getText().length()==1){
                        l14.setText("*");
                        l14.setFont(new Font("Tahoma",Font.BOLD,21));
                    }
                }
                else{
                    l14.setText("*");
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                }
            }
        });
        t1.getDocument().addDocumentListener(this);
        p2.add(t1);
        
        JLabel l15 = new JLabel("*");
        l15.setBounds(380,93,150,30);
        l15.setFont(new Font("Tahoma",Font.BOLD,22));
        l15.setForeground(Color.RED);
        p2.add(l15);
        
        JLabel l8 = new JLabel("Last  Name :");
        l8.setBounds(20,90,150,30);
        l8.setFont(new Font("Georgia",Font.BOLD,19));
        l8.setForeground(Color.BLACK);
        p2.add(l8);
        
        t2 = new JTextField();
        t2.setBounds(170,90,200,33);
        t2.setFont(new Font("Tahoma",Font.PLAIN,21));
        t2.setForeground(Color.BLACK);
        t2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetter(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT ){
                    l15.setText("");
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t2.getText().length()==1){
                        l15.setText("*");
                        l15.setFont(new Font("Tahoma",Font.BOLD,21));
                    }
                }
                else{
                    l15.setText("*");
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t2.setText("");
                }
            }
        });
        t2.getDocument().addDocumentListener(this);
        p2.add(t2);
        
        JLabel l19 = new JLabel("*");
        l19.setBounds(530,160,150,30);
        l19.setFont(new Font("Tahoma",Font.BOLD,22));
        l19.setForeground(Color.RED);
        p2.add(l19);
        
        JLabel l9 = new JLabel("Address :");
        l9.setBounds(20,160,150,30);
        l9.setFont(new Font("Georgia",Font.BOLD,19));
        l9.setForeground(Color.BLACK);
        p2.add(l9);
        
        ta = new JTextField();
        ta.setBounds(170,160,350,33);
        ta.setFont(new Font("Tahoma",Font.PLAIN,21));
        ta.setForeground(Color.BLACK);
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ta.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT){
                    l19.setText("");
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(ta.getText().length()==1){
                        l19.setText("*");
                        l19.setFont(new Font("Tahoma",Font.BOLD,21));
                    }
                }
            }
        });
        ta.getDocument().addDocumentListener(this);
        p2.add(ta);
        
        JLabel l16 = new JLabel("*");
        l16.setBounds(380,230,150,30);
        l16.setFont(new Font("Tahoma",Font.BOLD,22));
        l16.setForeground(Color.RED);
        p2.add(l16);
        
        JLabel l10 = new JLabel("Pincode :");
        l10.setBounds(20,230,150,30);
        l10.setFont(new Font("Georgia",Font.BOLD,19));
        l10.setForeground(Color.BLACK);
        p2.add(l10);
        
        t3 = new JTextField();
        t3.setBounds(170,230,200,33);
        t3.setFont(new Font("Tahoma",Font.PLAIN,21));
        t3.setForeground(Color.BLACK);
        t3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t3.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
               if(Character.isDigit(ch)){
                  if(t3.getText().length()<5){
                      l16.setFont(new Font("Georgia",Font.BOLD,17));
                      l16.setText("Invalid Pincode");
                  }
                  if(t3.getText().length()==5){
                        l16.setText("");
                  }
                  if(t3.getText().length()>=6){
                      UIManager ui = new UIManager();
                      ui.put("OptionPane.background",Color.WHITE);
                      ui.put("Panel.background",Color.WHITE);
                      //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                      JOptionPane op = new JOptionPane();
                      JLabel msg = new JLabel("Invalid Input");
                      msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                      op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                      t3.setText("");
                      l16.setText("*");
                      l16.setFont(new Font("Tahoma",Font.BOLD,22));
                  }          
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t3.getText().length()==1){
                        l16.setText("*");
                        l16.setFont(new Font("Tahoma",Font.BOLD,22));
                    }
                }
                else{
                    l16.setFont(new Font("Georgia",Font.BOLD,22));
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t3.setText("");
                }
            }
        });
        t3.getDocument().addDocumentListener(this);
        p2.add(t3);
        
        JLabel l11 = new JLabel("Mobile No. :");
        l11.setBounds(20,300,150,30);
        l11.setFont(new Font("Georgia",Font.BOLD,19));
        l11.setForeground(Color.BLACK);
        p2.add(l11);
        
        JLabel l13 = new JLabel("*");
        l13.setBounds(380,302,150,30);
        l13.setFont(new Font("Tahoma",Font.BOLD,22));
        l13.setForeground(Color.RED);
        p2.add(l13);
        
        t4 = new JTextField();
        t4.setBounds(170,300,200,33);
        t4.setFont(new Font("Tahoma",Font.PLAIN,21));
        t4.setForeground(Color.BLACK);
        t4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t4.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                  if(t4.getText().length()<9){
                      l13.setFont(new Font("Georgia",Font.BOLD,17));
                      l13.setText("Invalid Number");
                  }
                  if(t4.getText().length()==9){
                      l13.setText("");
                  }
                  if(t4.getText().length()>=10){
                      UIManager ui = new UIManager();
                      ui.put("OptionPane.background",Color.WHITE);
                      ui.put("Panel.background",Color.WHITE);
                      //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                      JOptionPane op = new JOptionPane();
                      JLabel msg = new JLabel("Invalid Input");
                      msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                      op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                      l13.setFont(new Font("Tahoma",Font.BOLD,22));
                      l13.setText("*");
                      t4.setText("");
                  }          
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t4.getText().length()==1){
                        l13.setText("*");
                        l13.setFont(new Font("Tahoma",Font.BOLD,21));
                    }
                }
                else{
                    l13.setFont(new Font("Georgia",Font.BOLD,22));
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p2,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t4.setText("");
                }
            }
        });
        t4.getDocument().addDocumentListener(this);
        p2.add(t4);
        
        JLabel l17 = new JLabel("*");
        l17.setBounds(530,370,150,30);
        l17.setFont(new Font("Tahoma",Font.BOLD,22));
        l17.setForeground(Color.RED);
        p2.add(l17);
        
        JLabel l12 = new JLabel("Email :");
        l12.setBounds(20,370,150,30);
        l12.setFont(new Font("Georgia",Font.BOLD,19));
        l12.setForeground(Color.BLACK);
        p2.add(l12);
        
        t5 = new JTextField();
        t5.setBounds(170,370,350,33);
        t5.setFont(new Font("Tahoma",Font.PLAIN,21));
        t5.setForeground(Color.BLACK);
        t5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t5.getDocument().addDocumentListener(this);
        p2.add(t5);
        
        t5.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT  || e.getKeyCode()==KeyEvent.VK_AT){
                    l17.setText("");
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t5.getText().length()==1){
                        l17.setText("*");
                        l17.setFont(new Font("Tahoma",Font.BOLD,21));
                    }
                }
            }
        });
        
        //package details
        JPanel p3 = new JPanel();
        p3.setBounds(30,500,700,280);
        p3.setBackground(Color.WHITE);
        p3.setLayout(null);
        la.add(p3);
        
        JLabel l1 = new JLabel("Destination :");
        l1.setBounds(20,20,140,25);
        l1.setFont(new Font("Georgia",Font.BOLD,19));
        l1.setForeground(Color.BLACK);
        p3.add(l1);
        
        //todays date
        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        p5.setBounds(110,240,180,30);
        //p3.add(p5);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        Date d = new Date();
        jdc.setMaxSelectableDate(d);
        jdc.setMinSelectableDate(d);
        jdc.setDate(d);
        //p5.add(jdc);
        
        
        Conn  c = new Conn();
        
        ch1 = new Choice();
        ch1.add("None");
         //date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jdc.getDate());
        System.out.println(date);
        String sql4 = "select count(pname) from bCapacity where available > 0 && ddate > '"+date+"'";
        String sql = "select pname from bCapacity where available > 0 && ddate > '"+date+"'";
        try{
           ResultSet rs4 = c.s.executeQuery(sql4);
           int n = 0;
           if(rs4.next()){
               n = rs4.getInt("count(pname)");
           }
           //System.out.println(n);
           String[] pname = new String[n];
           ResultSet rs2 = c.s.executeQuery(sql);
           int j=0;
           while(rs2.next()){
              pname[j]=rs2.getString("pname");
              //System.out.println(pname[j]);
              j++;
           }
           int k=0;
           while(k<pname.length){
               //System.out.println(pname[k]);
               String sql3 = "select lTo,pName from addPackage where pName='"+pname[k]+"'";
               ResultSet rs3 = c.s.executeQuery(sql3);
               if(rs3.next()){
                   ch1.add(rs3.getString("lTo"));
               }
               k++;
           }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        ch1.setBackground(Color.WHITE);
        ch1.setBounds(170,20,300,25);
        ch1.setForeground(Color.BLACK);
        ch1.setFont(new Font("Tahoma",Font.PLAIN,19));
        ch1.addItemListener(this);
        p3.add(ch1);
        
        JLabel l2 = new JLabel("Package :");
        l2.setBounds(20,70,140,25);
        l2.setFont(new Font("Georgia",Font.BOLD,19));
        l2.setForeground(Color.BLACK);
        p3.add(l2);
        
        ch2 = new Choice();
        ch2.add("None");
        ch2.setBackground(Color.WHITE);
        ch2.setBounds(170,70,300,25);
        ch2.setForeground(Color.BLACK);
        ch2.setFont(new Font("Tahoma",Font.PLAIN,19));
        ch2.addItemListener(this);
        ch2.setEnabled(false);
        String sql2 = "select pName from addPackage where lTo='"+ch1.getSelectedItem()+"'";
        try{
           
            ResultSet rs2 = c.s.executeQuery(sql2);
            if(rs2.next()){
                ch2.add(rs2.getString("pName"));
            }   
        }
            catch(Exception e){
                System.out.println(e);
        }   
        p3.add(ch2);
        
        b5 = new JButton("View Package");
        b5.setBounds(460,70,150,30);
        b5.setBackground(Color.DARK_GRAY);
        b5.setFont(new Font("Georgia",Font.BOLD,19));
        b5.setForeground(Color.WHITE);
        b5.setBorder(BorderFactory.createRaisedBevelBorder());
        b5.addActionListener(this);
        b5.setEnabled(false);
        p3.add(b5);
        
        JLabel l3 = new JLabel("Hotel :");
        l3.setBounds(20,120,140,25);
        l3.setFont(new Font("Georgia",Font.BOLD,19));
        l3.setForeground(Color.BLACK);
        p3.add(l3);
        
        ch3 = new Choice();
        ch3.add("None");
        ch3.setBackground(Color.WHITE);
        ch3.setBounds(170,120,300,25);
        ch3.setForeground(Color.BLACK);
        ch3.addItemListener(this);
        ch3.setEnabled(false);
        ch3.setFont(new Font("Tahoma",Font.PLAIN,19));
        String sql5 = "select hName from hotel where pname='"+ch2.getSelectedItem()+"'";
        try{
           ResultSet rs5 = c.s.executeQuery(sql5);
           if(rs5.next()){
               //System.out.println(rs5.getString("hName"));
               ch3.add(rs5.getString("hName"));
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
        p3.add(ch3);
        
        b6 = new JButton("View Hotel");
        b6.setBounds(460,120,150,30);
        b6.setBackground(Color.DARK_GRAY);
        b6.setFont(new Font("Georgia",Font.BOLD,19));
        b6.setForeground(Color.WHITE);
        b6.setBorder(BorderFactory.createRaisedBevelBorder());
        b6.addActionListener(this);
        b6.setEnabled(false);
        p3.add(b6);
        
        JLabel l4 = new JLabel("Available Room Types : ");
        l4.setBounds(20,170,250,25);
        l4.setFont(new Font("Georgia",Font.BOLD,19));
        l4.setForeground(Color.BLACK);
        p3.add(l4);
        
        r1 = new JRadioButton("Standard");
        r1.setBounds(20,210,150,25);
        r1.setFont(new Font("Georgia",Font.BOLD,19));
        r1.setBackground(Color.WHITE);
        r1.setForeground(Color.BLACK);
        r1.setEnabled(false);
        r1.addItemListener(this);
        p3.add(r1);
        
        r2 = new JRadioButton("Deluxe");
        r2.setBounds(180,210,115,25);
        r2.setFont(new Font("Georgia",Font.BOLD,19));
        r2.setBackground(Color.WHITE);
        r2.setForeground(Color.BLACK);
        r2.setEnabled(false);
        r2.addItemListener(this);
        p3.add(r2);
        
        r3 = new JRadioButton("StandardAC");
        r3.setBounds(315,210,150,25);
        r3.setFont(new Font("Georgia",Font.BOLD,19));
        r3.setBackground(Color.WHITE);
        r3.setForeground(Color.BLACK);
        r3.setEnabled(false);
        r3.addItemListener(this);
        p3.add(r3);
        
        r4 = new JRadioButton("DeluxeAC");
        r4.setBounds(500,210,150,25);
        r4.setFont(new Font("Georgia",Font.BOLD,19));
        r4.setBackground(Color.WHITE);
        r4.setForeground(Color.BLACK);
        r4.setEnabled(false);
        r4.addItemListener(this);
        p3.add(r4);
        
        //Price details
        JPanel p4 = new JPanel();
        p4.setBounds(765,200,300,400);
        p4.setBackground(Color.WHITE);
        p4.setLayout(null);
        la.add(p4);
        
        JLabel l20 = new JLabel("Package : ");
        l20.setBounds(20,60,150,25);
        l20.setFont(new Font("Georgia",Font.BOLD,22));
        l20.setForeground(Color.BLACK);
        p4.add(l20);
        
        l21 = new JLabel();
        l21.setBounds(20,100,250,35);
        l21.setFont(new Font("Tahoma",Font.BOLD,26));
        l21.setForeground(Color.BLACK);
        l21.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        p4.add(l21);
        
        JLabel l22 = new JLabel("Hotel : ");
        l22.setBounds(20,155,150,25);
        l22.setFont(new Font("Georgia",Font.BOLD,22));
        l22.setForeground(Color.BLACK);
        p4.add(l22);
        
        l23 = new JLabel();
        l23.setBounds(20,190,250,35);
        l23.setFont(new Font("Tahoma",Font.BOLD,26));
        l23.setForeground(Color.BLACK);
        l23.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        p4.add(l23);
        
        JLabel l5 = new JLabel("Total : ");
        l5.setBounds(20,245,150,25);
        l5.setFont(new Font("Georgia",Font.BOLD,22));
        l5.setForeground(Color.BLACK);
        p4.add(l5);
        
        l6 = new JLabel();
        l6.setBounds(20,290,250,35);
        l6.setFont(new Font("Tahoma",Font.BOLD,26));
        l6.setForeground(Color.BLACK);
        l6.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        p4.add(l6);
        
        b3 = new JButton("Save");
        b3.setBounds(773,620,120,40);
        b3.setBackground(Color.DARK_GRAY);
        b3.setFont(new Font("Georgia",Font.BOLD,26));
        b3.setForeground(Color.WHITE);
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.setEnabled(false);
        b3.addActionListener(this);
        la.add(b3);
        
        b4 = new JButton("Back");
        b4.setBounds(935,620,120,40);
        b4.setBackground(Color.DARK_GRAY);
        b4.setFont(new Font("Georgia",Font.BOLD,26));
        b4.setForeground(Color.WHITE);
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.addActionListener(this);
        la.add(b4);
        
        if(isValidEmail("janhavijoshi137gmail.com"))
            System.out.println("Yayyy");
        
        setVisible(true);
    }
    
    public static boolean isValidEmail(String str){
        Pattern ptr = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    
    public static boolean isValidMobileNo(String str){
        Pattern ptr = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    
    public static boolean isValidPincode(String str){
        //must start with 1-9 , next 2 digits 0-9 ,then one space and t=next 3 digits 0-9
        Pattern ptr = Pattern.compile("^[1-9]{1}[0-9]{2}{0,1}[0-9]{3}$");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    
    public void itemStateChanged(ItemEvent ie){
        Conn c = new Conn();
        if(ie.getSource()==ch1){
            b5.setEnabled(false);   b6.setEnabled(false);
            r1.setEnabled(false);   r2.setEnabled(false);   r3.setEnabled(false);   r4.setEnabled(false);
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(false);
            l6.setText("");
            l21.setText("");
            l23.setText("");
            ch2.removeAll();
            ch2.add("None");
            ch2.setEnabled(true);
            ch3.setEnabled(false);
            ch3.select(0);
            //date condition
            String sql2 = "select pName from addPackage where lTo='"+ch1.getSelectedItem()+"'";
            try{
               ResultSet rs2 = c.s.executeQuery(sql2);
               while(rs2.next()){
                   ch2.add(rs2.getString("pName"));
               }
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(ch1.getSelectedItem().equals("None")){
                b1.setEnabled(false);
            }
            changed();
        }
        if(ie.getSource()==ch2){
            b6.setEnabled(false);
            r1.setEnabled(false);   r2.setEnabled(false);   r3.setEnabled(false);   r4.setEnabled(false);
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            l6.setText(""); l21.setText(""); l23.setText("");
            System.out.println(ch2.getSelectedItem());
            ch3.removeAll();
            ch3.add("None");
            ch3.setEnabled(true);
            String sql2 = "select hName from hotel where pName='"+ch2.getSelectedItem()+"'";
            String sql3 = "select price from addPackage where pName='"+ch2.getSelectedItem()+"'";
            try{
               ResultSet rs2 = c.s.executeQuery(sql2);
               while(rs2.next()){
                   ch3.add(rs2.getString("hName"));
               }
               ResultSet rs3 = c.s.executeQuery(sql3);
               if(rs3.next()){
                   l21.setText(rs3.getString("price"));
                   l6.setText(rs3.getString("price"));
               }
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(ch2.getSelectedItem().equals("None")){
                r1.setSelected(false);
                r2.setSelected(false);
                r3.setSelected(false);
                r4.setSelected(false);
                b1.setEnabled(false);
                l6.setText("");
                b5.setEnabled(false);
            }
            if(!ch2.getSelectedItem().equals("None")){
                b5.setEnabled(true);
            }
            changed();
        }
        if(ie.getSource()==ch3){
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(false);
            r1.setEnabled(false);   r2.setEnabled(false);   r3.setEnabled(false);   r4.setEnabled(false);
            String sql3 = "select price from addPackage where pName='"+ch2.getSelectedItem()+"'";
            String sql6 = "select rStandard,rDeluxe,rStandardAC,rDeluxeAC from hotel where hName='"+ch3.getSelectedItem()+"'";
            try{
                ResultSet rs3 = c.s.executeQuery(sql3);
                if(rs3.next()){
                   l21.setText(rs3.getString("price"));
                   l6.setText(rs3.getString("price"));
               }
                
               ResultSet rs6 = c.s.executeQuery(sql6);
               if(rs6.next()){
                    //System.out.println(rs6.getString("rStandard"));
                    if(rs6.getString("rStandard").equals("Available")){
                        r1.setEnabled(true);
                    }
                    else
                        r1.setEnabled(false);
                    if(rs6.getString("rDeluxe").equals("Available")){
                        r2.setEnabled(true);
                    }
                    else
                        r2.setEnabled(false);
                    if(rs6.getString("rStandardAC").equals("Available")){
                        r3.setEnabled(true);
                    }
                    else
                        r3.setEnabled(false);
                    if(rs6.getString("rDeluxeAC").equals("Available")){
                        r4.setEnabled(true);
                    }
                    else
                        r4.setEnabled(false);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(ch3.getSelectedItem().equals("None")){ 
                l23.setText("");
                l6.setText(l21.getText());
                b6.setEnabled(false);
            }
            if(!ch3.getSelectedItem().equals("None")){
                b6.setEnabled(true);
            }
             
        }
        if(ie.getSource()==r1){
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            if(r1.isSelected()){
                r2.setSelected(false);
                r3.setSelected(false);
                r4.setSelected(false);
                String sql3 = "select pStandard from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    if(rs.next()){
                        float total = Float.parseFloat(l6.getText()) + rs.getFloat("pStandard");
                        l23.setText(rs.getString("pStandard"));
                        l6.setText(Float.toString(total));
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                String sql3 = "select pStandard from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    float total;
                    if(rs.next()){
                        if(Float.parseFloat(l6.getText()) > rs.getFloat("pStandard")){
                            total = Float.parseFloat(l6.getText()) - rs.getFloat("pStandard");
                        }
                        else
                            total =  rs.getFloat("pStandard") - Float.parseFloat(l6.getText());
                        l23.setText("");
                        l6.setText(Float.toString(total));
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        if(ie.getSource()==r2){
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            if(r2.isSelected()){
                r1.setSelected(false);
                r3.setSelected(false);
                r4.setSelected(false);
                String sql3 = "select pDeluxe from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    if(rs.next()){
                        float total = Float.parseFloat(l6.getText()) + rs.getFloat("pDeluxe");
                        l23.setText(rs.getString("pDeluxe"));
                        l6.setText(Float.toString(total));
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                String sql3 = "select pDeluxe from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    float total;
                    if(rs.next()){
                        if(Float.parseFloat(l6.getText()) > rs.getFloat("pDeluxe")){
                            total = Float.parseFloat(l6.getText()) - rs.getFloat("pDeluxe");
                        }
                        else
                            total =  rs.getFloat("pDeluxe") - Float.parseFloat(l6.getText());
                        l23.setText("");
                        l6.setText(Float.toString(total));
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        if(ie.getSource()==r3){
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            if(r3.isSelected()){
                r2.setSelected(false);
                r1.setSelected(false);
                r4.setSelected(false);
                String sql3 = "select pStandard from hotel where hName='"+ch3.getSelectedItem()+"'";
                String sql4 = "select pAC from hotel where hName='"+ch3.getSelectedItem()+"'";
                float total=0;
                float hotel=0;
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    if(rs.next()){
                        hotel = rs.getFloat("pStandard");
                        total = Float.parseFloat(l6.getText()) + rs.getFloat("pStandard");
                    }  
                    ResultSet rs2 = c.s.executeQuery(sql4);
                    if(rs2.next()){
                        hotel = hotel + rs2.getFloat("pAC");
                        total = total + rs2.getFloat("pAC");
                    }
                    l23.setText(Float.toString(hotel));
                    l6.setText(Float.toString(total));
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                String sql3 = "select pStandard from hotel where hName='"+ch3.getSelectedItem()+"'";
                String sql4 = "select pAC from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    float total=0;
                    if(rs.next()){
                        if(Float.parseFloat(l6.getText()) > rs.getFloat("pStandard")){
                            total = Float.parseFloat(l6.getText()) - rs.getFloat("pStandard");
                        }
                        else
                            total =  rs.getFloat("pStandard") - Float.parseFloat(l6.getText());
                    }
                    ResultSet rs2 = c.s.executeQuery(sql4);
                    if(rs2.next()){
                        if(total > rs2.getFloat("pAC")){
                            total = total - rs2.getFloat("pAC");
                        }
                        else
                            total =  rs2.getFloat("pAC") - total;
                    }
                    l23.setText("");
                    l6.setText(Float.toString(total));
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        if(ie.getSource()==r4){
            resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
            if(r4.isSelected()){
                r2.setSelected(false);
                r1.setSelected(false);
                r3.setSelected(false);
                String sql3 = "select pDeluxe from hotel where hName='"+ch3.getSelectedItem()+"'";
                String sql4 = "select pAC from hotel where hName='"+ch3.getSelectedItem()+"'";
                float total=0;
                float hotel=0;
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    if(rs.next()){
                        hotel = rs.getFloat("pDeluxe");
                        total = Float.parseFloat(l6.getText()) + rs.getFloat("pDeluxe");
                    }
                    ResultSet rs2 = c.s.executeQuery(sql4);
                    if(rs2.next()){
                        hotel = hotel + rs2.getFloat("pAC");
                        total = total + rs2.getFloat("pAC");
                    }
                    l23.setText(Float.toString(hotel));
                    l6.setText(Float.toString(total));
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                String sql3 = "select pDeluxe from hotel where hName='"+ch3.getSelectedItem()+"'";
                String sql4 = "select pAC from hotel where hName='"+ch3.getSelectedItem()+"'";
                try{
                    ResultSet rs = c.s.executeQuery(sql3);
                    float total=0;
                    if(rs.next()){
                        if(Float.parseFloat(l6.getText()) > rs.getFloat("pDeluxe")){
                            total = Float.parseFloat(l6.getText()) - rs.getFloat("pDeluxe");
                        }
                        else
                            total =  rs.getFloat("pDeluxe") - Float.parseFloat(l6.getText());
                    }
                    ResultSet rs2 = c.s.executeQuery(sql4);
                    if(rs2.next()){
                        if(total > rs2.getFloat("pAC")){
                            total = total - rs2.getFloat("pAC");
                        }
                        else
                            total =  rs2.getFloat("pAC") - total;
                    }
                    l23.setText("");
                    l6.setText(Float.toString(total));
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public void resetReceipt(JLabel l27,JLabel l29,JLabel l30,JLabel l32,JLabel l34,JLabel l36,JLabel l38,JLabel l40,JLabel l42,JLabel l44,JLabel l46,JLabel l51,JLabel l50){
        l27.setText("");
        l29.setText("");
        l30.setText("");
        l32.setText("");
        l34.setText("");
        l36.setText("");
        l38.setText("");
        l40.setText("");
        l42.setText("");
        l44.setText("");
        l46.setText("");
        l50.setText("");
        l51.setText("");
        b3.setEnabled(false);
        dp = null;
        ddate = null;
    }
    
   
    public void changedUpdate(DocumentEvent de){
        resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
        changed();
    }
    public void removeUpdate(DocumentEvent de){
        resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
        changed();
    }
    public void insertUpdate(DocumentEvent de){
        resetReceipt(l27,l29,l30,l32,l34,l36,l38,l40,l42,l44,l46,l51,l50);
        changed();
    }
    public void changed(){
        if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || ta.getText().equals("") || ch2.getSelectedItem().equals("None")){
           b1.setEnabled(false);
        }
        else{
           b1.setEnabled(true);
        }
    }
    
    public boolean isRoomSelected(){
         if(!ch3.getSelectedItem().equals("None") && (!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Please select the room type");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                return false;
        }
        return true;
    }
    
    
    public void actionPerformed(ActionEvent e){
        //generate receipt
        if(e.getSource()==b1){         
            if(!isValidPincode(t3.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Pincode");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b1.setEnabled(false);
            }
            if(!isValidMobileNo(t4.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Mobile Number");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b1.setEnabled(false);
            } 
            if(!isValidEmail(t5.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Email");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b1.setEnabled(false);
            }
            if(isValidPincode(t3.getText()) && isValidMobileNo(t4.getText()) && isValidEmail(t5.getText()) && isRoomSelected()){
               //for ref no.
               int ref=0;
               try{
                   Conn c = new Conn();
                   ResultSet rs = c.s.executeQuery("select count(fName) from customerDetails");
                   if(rs.next()){
                       //System.out.println(rs.getString("count(fName)"));
                       ref = Integer.parseInt(rs.getString("count(fName)")) + 1;
                       //System.out.println(ref);
                   }
                   ResultSet rs2 = c.s.executeQuery("select lFrom,ddate from addPackage where pName='"+ch2.getSelectedItem()+"'");
                   if(rs2.next()){
                       dp = rs2.getString("lFrom");
                       ddate = rs2.getString("ddate");
                   }
               }
               catch(Exception ae){
                   System.out.println(ae);
               }
               l27.setText(Integer.toString(ref));
               l29.setText(t1.getText());
               l30.setText(t2.getText());
               l32.setText(ta.getText());
               l34.setText(t3.getText());
               l36.setText(t4.getText());
               l38.setText(t5.getText());
               l40.setText(ch1.getSelectedItem());
               l42.setText(ch2.getSelectedItem());
               if(ch3.getSelectedItem().equals("None")){
                   l44.setText("-");
                   l46.setText("-");
               }
               else{
                   l44.setText(ch3.getSelectedItem());
               }
               if(r1.isSelected()){
                   l46.setText(r1.getText());
               }
               else if(r2.isSelected()){
                   l46.setText(r2.getText());
               }
               else if(r3.isSelected()){
                   l46.setText(r3.getText());
               }
               else if(r4.isSelected()){
                   l46.setText(r4.getText());
               }
               SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
               String date = sdf.format(jdc.getDate());
               l50.setText(l6.getText());
               l51.setText(date);
               
               b3.setEnabled(true);
            }
        }
        //print
        if(e.getSource()==b2){
            Conn c = new Conn();
            JTextArea receipt = new JTextArea();
            receipt.setBounds(0,0,750,730);
            receipt.setBackground(Color.WHITE);
            receipt.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
            receipt.setText("\nReference No. : "+" "+l27.getText()+"\n ----------------------------------------------------------------------------------------------------------------------"+"\n Name : "+" "+l29.getText()+" "+l30.getText()+"\n\n Address : "+" "+l32.getText()+"\n\n Pincode : "+" "+l34.getText()+"\n\n Mobile Number : "+" "+l36.getText()+"\n\n Email : "+" "+l38.getText()+"\n\n Destination : "+" "+l40.getText()+" \n\n Package : "+" "+l42.getText()+"\n\n Hotel : "+" "+l44.getText()+"\n\n Room Type : "+" "+l46.getText()+" \n\n Departure Point : "+" "+dp+" \n\n Departure Date :  "+" "+ddate+"\n\n Total : "+" "+l50.getText()+"\n----------------------------------------------------------------------------------------------------------------------------"+"\n\n Date : "+" "+l51.getText()+"\n\n\n\n\t\t\t\tSignature");
            int ref=0;
            try{
                ResultSet rs = c.s.executeQuery("select count(fName) from customerDetails");
                if(rs.next()){
                    //System.out.println(rs.getString("count(fName)"));
                    ref = Integer.parseInt(rs.getString("count(fName)"));
                    System.out.println(ref);
                }
                JasperDesign jd = JRXmlLoader.load("G:\\TMS\\src\\tms\\reports\\Reciptt.jrxml");
                String sql = "select * from customerDetails where SrNo='"+ref+"'";
                JRDesignQuery updatequery = new JRDesignQuery();
                updatequery.setText(sql);
                jd.setQuery(updatequery);
                JasperReport jreport = JasperCompileManager.compileReport(jd);
                JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                JasperViewer.viewReport(jprint);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            setVisible(false);
        }
        //save
        if(e.getSource()==b3){
            UIManager ui = new UIManager();
            ui.put("OptionPane.background",Color.WHITE);
            ui.put("Panel.background",Color.WHITE);
            ui.put("OptionPane.minimunSize",new Dimension(300,200));
            JOptionPane op = new JOptionPane();
            JLabel msg = new JLabel("Are you sure");
            msg.setFont(new Font("SAN_SERIF",Font.BOLD,22));
            int a = op.showConfirmDialog(this,msg,"Please Confirm",0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jdc.getDate());
            if(a==op.YES_OPTION){
                String query = "insert into customerDetails (fName,lName,address,pincode,mobileNo,email,pName,hName,rType,total,datee) values('"+l29.getText()+"','"+l30.getText()+"','"+l32.getText()+"','"+Integer.parseInt(l34.getText())+"','"+Long.parseLong(l36.getText())+"','"+l38.getText()+"','"+l42.getText()+"','"+l44.getText()+"','"+l46.getText()+"','"+Double.parseDouble(l50.getText())+"','"+date+"')";
                try{
                    Conn c = new Conn();
                    c.s.execute(query);
                    UIManager ui1 = new UIManager();
                    ui1.put("OptionPane.background",Color.WHITE);
                    ui1.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op1 = new JOptionPane();
                    JLabel msg1 = new JLabel("Customer registered successfully");
                    msg1.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op1.showMessageDialog(this,msg1,"",JOptionPane.PLAIN_MESSAGE);
                    b2.setEnabled(true);
                    b4.setEnabled(false);
                    c.s.executeUpdate("update bCapacity set available=available-1 where pName='"+l42.getText()+"'");
                }
                catch(Exception ae){
                    System.out.println(ae);
                }
                //setVisible(false);
            }
            else{
                UIManager ui1 = new UIManager();
                ui1.put("OptionPane.background",Color.WHITE);
                ui1.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op1 = new JOptionPane();
                JLabel msg1 = new JLabel("Registration Canceled");
                msg1.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op1.showMessageDialog(this,msg1,"",JOptionPane.ERROR_MESSAGE);
            }
        }
        //back
        if(e.getSource()==b4){
            setVisible(false);
        }
        if(e.getSource()==b5){
            new CViewPackage(username,ch2.getSelectedItem());
        }
        if(e.getSource()==b6){
            new CViewHotel(username,ch3.getSelectedItem());
        }
    }
    
    
    public static void main(String[] args){
        new CustomerRegistration("");
    }
}
