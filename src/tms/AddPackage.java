package tms;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class AddPackage extends JFrame implements ActionListener,ItemListener,DocumentListener,MouseListener{
    JButton b1,b2,b3,b4;
    JLabel l1;
    JPanel p1,p2,p3,p4,p5;
    JTextField f1,f2,f4,f5,f6,f7;
    JTextArea f3;
    JCheckBox c1;
    Choice c2,c3;
    JRadioButton r1,r2;
    String username;
    com.toedter.calendar.JDateChooser jdc;
    
    AddPackage(String username){
        this.username=username;
        setBounds(320,80,900,720);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Add Package");
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
      
        f3 = new JTextArea();
        //f3.setBounds(20,145,370,210);
        f3.setBorder(BorderFactory.createEmptyBorder());
        f3.setFont(new Font("Tahoma",Font.PLAIN,15));
        f3.getDocument().addDocumentListener(this);
        f3.setForeground(Color.BLACK);
        JScrollPane pane = new JScrollPane(f3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //pane.setLayout(null);
        pane.setBounds(20,145,480,210);
        add(pane);
        
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(530,0,370,660);
        p1.setBackground(Color.LIGHT_GRAY);
        add(p1);
        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,0,370,460);
        p2.setBackground(Color.white);
        p1.add(p2);
        
        //image add
        l1 = new JLabel();
        l1.setBounds(0,5,370,375);
        l1.setLayout(null);
        p2.add(l1);
                    
        b1 = new JButton("Add Image");   
        b1.setLayout(null);
        b1.setBackground(new Color(0,102,102));
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia",Font.BOLD,16));
        b1.setBounds(98,380,150,30);
        b1.addActionListener(this);
        p2.add(b1);
      
        b4 = new JButton();   
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("tms/icons/undo.png"));
        Image i2 = ic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        b4.setIcon(i3);
        b4.setLayout(null);
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.RED);
        b4.setBorder(BorderFactory.createLineBorder(Color.white));
        b4.setFont(new Font("Georgia",Font.BOLD,10));
        b4.setBounds(255,378,40,40);
        b4.addActionListener(this);
        p2.add(b4);
        
        JLabel l9 = new JLabel("Price :");
        l9.setBounds(20,550,80,30);
        l9.setForeground(Color.black);
        l9.setFont(new Font("Georgia",Font.BOLD,19));
        p1.add(l9);
        
        f6 = new JTextField();
        f6.setBounds(110,550,180,30);
        f6.setBorder(BorderFactory.createEmptyBorder());
        f6.setFont(new Font("Tahoma",Font.PLAIN,17));
        f6.setBackground(Color.white);
        f6.setForeground(Color.BLACK);
        f6.getDocument().addDocumentListener(this);
        f6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    if(f2.getText().isEmpty() || f1.getText().isEmpty() || f4.getText().isEmpty() || f5.getText().isEmpty() || f3.getText().isEmpty() || f7.getText().isEmpty() || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b2.setEnabled(false);
                    }
                    else
                        b2.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f6.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f6.setText("");
                }
            }
        });
        p1.add(f6);
        
        JLabel l10 = new JLabel("Date :");
        l10.setBounds(20,500,80,30);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia",Font.BOLD,19));
        p1.add(l10);
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(110,500,180,30);
        p1.add(p);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        ((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
        jdc.setMinSelectableDate(d);
        
        p.add(jdc);
        
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(0,0,530,145);
        p3.setBackground(Color.LIGHT_GRAY);
        add(p3);
        
        JLabel l2 = new JLabel("Name :");
        l2.setBounds(20,20,100,25);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Georgia",Font.BOLD,17));
        p3.add(l2);
                    
        f1 = new JTextField();
        f1.setBounds(130,20,300,25);
        f1.setBorder(BorderFactory.createEmptyBorder());
        f1.setFont(new Font("Tahoma",Font.PLAIN,15));
        f1.setForeground(Color.BLACK);
        f1.getDocument().addDocumentListener(this);
        p3.add(f1);
        
        JLabel l3 = new JLabel("Duration :");
        l3.setBounds(20,65,110,25);
        l3.setFont(new Font("Georgia",Font.BOLD,17));
        l3.setForeground(Color.BLACK);
        p3.add(l3);
                    
        f2 = new JTextField();
        f2.setBounds(130,65,300,25);
        f2.setBorder(BorderFactory.createEmptyBorder());
        f2.setFont(new Font("Tahoma",Font.PLAIN,15));
        f2.setForeground(Color.BLACK);
        f2.getDocument().addDocumentListener(this);
        p3.add(f2);
        
        JLabel l4 = new JLabel("Activities :");
        l4.setBounds(20,105,110,25);
        l4.setFont(new Font("Georgia",Font.BOLD,17));
        l4.setForeground(Color.BLACK);
        p3.add(l4);
                    
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0,355,530,305);
        p4.setBackground(Color.LIGHT_GRAY);
        add(p4);

        c1 = new JCheckBox("Meals Included ?");      
        c1.setLayout(null);
        c1.setBounds(20,380,185,30);
        c1.setFont(new Font("Georgia",Font.BOLD,17));
        c1.setForeground(Color.black);
        p4.add(c1);
        c1.addItemListener(this);
        
        JLabel l5 = new JLabel("Transportation:");
        l5.setBounds(20,430,160,25);
        l5.setFont(new Font("Georgia",Font.BOLD,17));
        l5.setForeground(Color.black);
        p4.add(l5);
                    
        r1 = new JRadioButton("Public-");
        r1.setBounds(170,430,80,25);
        r1.setBackground(Color.white);
        r1.setFont(new Font("Tahoma",Font.PLAIN,15));
        r1.setForeground(Color.black);
        r1.setSelected(true);
        r1.addItemListener(this);
        p4.add(r1);
        
        c2 = new Choice();
        c2.add("Train");
        c2.add("Flight");
        c2.add("Bus");
        c2.setBounds(270,431,90,77);
        c2.setForeground(Color.black);
        c2.setFont(new Font("Tahoma",Font.PLAIN,15));
        p4.add(c2);
        
        r2 = new JRadioButton("Private-");
        r2.setBounds(170,460,80,25);
        r2.setBackground(Color.white);
        r2.setFont(new Font("Tahoma",Font.PLAIN,15));
        r2.setForeground(Color.black);
        r2.addItemListener(this);
        p4.add(r2);
        
        c3 = new Choice();
        c3.add("Car");
        c3.add("Bus");
        c3.setBounds(270,461,90,75);
        c3.setFont(new Font("Tahoma",Font.PLAIN,15));
        c3.setForeground(Color.black);
        p4.add(c3);
        
        JLabel l6 = new JLabel("Travel :");
        l6.setBounds(20,500,110,25);
        l6.setFont(new Font("Georgia",Font.BOLD,17));
        l6.setForeground(Color.black);
        p4.add(l6);
        
        JLabel l7 = new JLabel("From");
        l7.setBounds(20,530,50,25);
        l7.setFont(new Font("Georgia",Font.BOLD,17));
        l7.setForeground(Color.black);
        p4.add(l7);
                    
        f4 = new JTextField();
        f4.setBounds(75,530,190,25);
        f4.setBorder(BorderFactory.createEmptyBorder());
        f4.setFont(new Font("Tahoma",Font.PLAIN,15));
        f4.getDocument().addDocumentListener(this);
        f4.setForeground(Color.black);
        p4.add(f4);
        
        JLabel l8 = new JLabel("To");
        l8.setBounds(278,530,30,25);
        l8.setFont(new Font("Georgia",Font.BOLD,17));
        l8.setForeground(Color.black);
        p4.add(l8);
                    
        f5 = new JTextField();
        f5.setBounds(310,530,190,25);
        f5.setBorder(BorderFactory.createEmptyBorder());
        f5.setFont(new Font("Tahoma",Font.PLAIN,15));
        f5.getDocument().addDocumentListener(this);
        f5.setForeground(Color.black);
        p4.add(f5);
        
        JLabel l11 = new JLabel("Booking Capacity :");
        l11.setBounds(20,580,160,25);
        l11.setFont(new Font("Georgia",Font.BOLD,17));
        l11.setForeground(Color.black);
        p4.add(l11);
                    
        f7 = new JTextField();
        f7.setBounds(190,580,190,25);
        f7.setBorder(BorderFactory.createEmptyBorder());
        f7.setFont(new Font("Tahoma",Font.PLAIN,15));
        f7.getDocument().addDocumentListener(this);
        f7.setForeground(Color.black);
        f7.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    if(f2.getText().isEmpty() || f1.getText().isEmpty() || f4.getText().isEmpty() || f5.getText().isEmpty() || f3.getText().isEmpty() || f6.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b2.setEnabled(false);
                         if(f7.getText().length()>1){
                            b2.setEnabled(false);
                            JOptionPane.showMessageDialog(p4, "Invalid input");
                            f7.setText("");
                        }
                    }
                    else
                        if(f7.getText().length()>1){
                            b2.setEnabled(false);
                            JOptionPane.showMessageDialog(p4, "Invalid input");
                            f7.setText("");
                        }
                        else{
                            b2.setEnabled(true);
                        }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f7.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f7.setText("");
                }
            }
        });
        p4.add(f7);
       
        
        b2 = new JButton("Add Package");   
        b2.setBackground(new Color(0,102,102));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.white));
        b2.setFont(new Font("Georgia",Font.BOLD,19));
        b2.setBounds(100,625,180,35);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        b2.setEnabled(false);
        p4.add(b2);
        
        b3 = new JButton("Back");   
        b3.setBackground(new Color(0,102,102));
        b3.setForeground(Color.WHITE);
        b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.setFont(new Font("Georgia",Font.BOLD,19));
        b3.setBounds(300,625,180,35);
        b3.setForeground(Color.black);
        b3.addActionListener(this);
        p4.add(b3);
        
        
        setVisible(true);
      
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please select the date");
        }
        if(e.getSource()==jdc.getComponent(0)){
            System.out.println(jdc.getDate());
            jdc.getComponent(1).setEnabled(true);
            if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("") || f5.getText().equals("") || f6.getText().equals("") || f7.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                b2.setEnabled(false);
            }
            else{
                b2.setEnabled(true);
            }
        }
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    
    
    public void itemStateChanged(ItemEvent ie){
        if(ie.getSource()==r1){
            
            if(ie.getStateChange()==ItemEvent.SELECTED){
                r2.setSelected(false);
                changed();
                //b2.setEnabled(true);
            }
            else if(ie.getStateChange()==ItemEvent.DESELECTED){
                r2.setSelected(true);
                //b2.setEnabled(false);
            }
        }
        else if(ie.getSource()==r2){
            
            if(ie.getStateChange()==ItemEvent.SELECTED){
                r1.setSelected(false);
                changed();
                //b2.setEnabled(true);
            }
            else if(ie.getStateChange()==ItemEvent.DESELECTED){
                r1.setSelected(true);
                //b2.setEnabled(false);
            }
        }
        else if(ie.getSource()==c1){
            
            }
    }
    
    //if any text fields are empty then disable the add package button
    public void changedUpdate(DocumentEvent de){
        changed();
    }
    public void removeUpdate(DocumentEvent de){
        changed();
    }
    public void insertUpdate(DocumentEvent de){
        changed();
    }
    public void changed(){
        if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("") || f5.getText().equals("") || f6.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") || f7.getText().equals("") ){
            b2.setEnabled(false);
        }
        else{
            b2.setEnabled(true);
        }
    }
    
    //for checkbox
   
    
    public void actionPerformed(ActionEvent e){
            String filePath="";
            
            if(e.getSource()==b1){
                JFileChooser fc = new JFileChooser("G:\\tms\\src\\tms\\icons");       //path given
                if(fc.showOpenDialog(this)==fc.APPROVE_OPTION){     //open files menu, if selected then
                    File f = fc.getSelectedFile();      //selected file
                    filePath = f.getPath();      //path in string type
                    System.out.println(filePath);
                    int i=0; 
                   
                    StringBuilder s = new StringBuilder(filePath);
                    while(i<s.length()){
                        if(s.charAt(i)=='\\'){
                            
                              s.setCharAt(i,'/');
                              i+=2;
                        }
                        i++;
                    }
                    filePath=s.toString();
                    
                    
                 String sql = "insert into filePath values('"+filePath+"')";
                 FileInputStream fis = null;
                 try{
                     Conn c = new Conn();
                     c.s.executeUpdate(sql);
                     setVisible(false);
                     setVisible(true);
                     String s2 = "select * from filePath";
                     ResultSet rs = c.s.executeQuery(s2);
                     String p="";
                     if(rs.next()){
                        p = rs.getString("loc");
                     }
                     File file2 = new File(p);
                     //fis is reference variable
                     //import java.io.*;
                     fis = new FileInputStream(file2);
                     byte[] b = fis.readAllBytes();
                     ImageIcon i1 = new ImageIcon(b);
                     Image i2 = i1.getImage().getScaledInstance(370,340,Image.SCALE_DEFAULT);
                     ImageIcon i3 = new ImageIcon(i2);
                     l1.setIcon(i3);
                     
                 }catch(Exception ex){} 
               }
            }
            
            //System.out.println(filePath);
            if(e.getSource()==b2){
               System.out.println(filePath);
               //System.out.println(pName);
               String pName = f1.getText();
               String duration = f2.getText();
               String activities = f3.getText();
               String lFrom = f4.getText();
               String lTo = f5.getText();
               String tType = null;
               String tMode = null;    
               double price = Double.parseDouble(f6.getText());
               Integer bCapacity = Integer.parseInt(f7.getText());
               if(r1.isSelected()){
                   tType = "Public";
                   tMode = c2.getSelectedItem();
               }else if(r2.isSelected()){
                   tType = "Private";
                   tMode = c3.getSelectedItem();
               }
               String meals = null;
               if(c1.isSelected()){
                   meals = "Included";
               }
               else{
                   meals = "Not Included";
               }
               //selecting date
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               String date = sdf.format(jdc.getDate());
               System.out.println(date);
               String loc ="";
               try{
                    Conn c =new Conn();
                    String sql2 = "select * from filePath";
                    String sql3 = "delete from filePath";
                    ResultSet rs = c.s.executeQuery(sql2);       //whole row
                    //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                    while(rs.next()){   //column to column jump
                        loc = rs.getString("loc");
                        System.out.println(loc);
                    }
                    System.out.println(loc);
                    
                    String count = "select count(pName) from addPackage";
                    
                    int pCount=0;
                    try{
                       rs = c.s.executeQuery(count);
                       while(rs.next()){
                           pCount=Integer.parseInt(rs.getString("count(pName)"));
                       }
                       //resetting auto increment
                       String reset ="alter table addPackage auto_increment="+(pCount+1)+"";
                       c.s.execute(reset);

                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    if(!loc.equals("")){
                        String query = "insert into addPackage (pName,duration,attractions,meals,price,imagepath,tMode,tType,lFrom,lTo,ddate,bCapacity) values('"+pName+"','"+duration+"','"+activities+"','"+meals+"','"+price+"','"+loc+"','"+tMode+"','"+tType+"','"+lFrom+"','"+lTo+"','"+date+"','"+bCapacity+"')";
                        c.s.executeUpdate(query);
                        c.s.execute(sql3);
                        //booking capacity
                        String sql5 = "insert into bCapacity(pname,bCapacity,available,ddate) values('"+pName+"','"+bCapacity+"','"+bCapacity+"','"+date+"')";
                        c.s.executeUpdate(sql5);
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Package added successfully");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                        setVisible(false);
                    }
                    else{
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("please add an image");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                    }
                    
               }catch(Exception ae){
                    System.out.println(ae);
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("You didn't fill in all the details");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
               }
           }
           if(e.getSource()==b4){
               l1.setIcon(null);
               Conn c = new Conn();
               String sql4 = "delete from filePath";
               try{
                   c.s.execute(sql4);
               }catch(Exception ex){
                   System.out.println(ex);
               }
           }
           if(e.getSource()==b3){
               setVisible(false);
           }
    }
               
           
    public static void main(String[] args){
        new AddPackage("");
    }
}
