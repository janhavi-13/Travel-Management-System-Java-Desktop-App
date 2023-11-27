package tms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class AddHotel extends JFrame implements ActionListener,ItemListener{
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JPanel p1,p2,p3,p4;
    JTextField f1,f3,f4,f5,f6,f7,f8;
    JTextArea t;
    JCheckBox c1,c2,c3,c4;
    Choice c5;
    String username;
    
    AddHotel(String username){
        this.username=username;
        setBounds(320,120,900,660);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Add Hotel");
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
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
                    
        b1 = new JButton("Add Image");   
        b1.setLayout(null);
        b1.setBackground(new Color(0,102,102));
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia",Font.BOLD,16));
        b1.setBounds(98,380,150,30);
        b1.addActionListener(this);
        p2.add(b1);
      
        //image reset
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
        
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(0,0,530,145);
        p3.setBackground(Color.LIGHT_GRAY);
        add(p3);
        
        l1 = new JLabel("Name :");
        l1.setBounds(20,20,100,25);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Georgia",Font.BOLD,17));
        p3.add(l1);
                    
        f1 = new JTextField();
        f1.setBounds(130,20,300,25);
        f1.setBorder(BorderFactory.createEmptyBorder());
        f1.setFont(new Font("Tahoma",Font.PLAIN,15));
        f1.setForeground(Color.BLACK);
        f1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) && !f3.getText().isEmpty() && !f4.getText().isEmpty() && !f5.getText().isEmpty() && !f6.getText().isEmpty() && !f7.getText().isEmpty() && !f8.getText().isEmpty() && !t.getText().isEmpty()){
                    b2.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f1.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                }
            }
        });
        p3.add(f1);
        
        l2 = new JLabel("Package :");
        l2.setBounds(20,65,110,25);
        l2.setFont(new Font("Georgia",Font.BOLD,17));
        l2.setForeground(Color.BLACK);
        p3.add(l2);
                    
        JLabel l = new JLabel("Please add the package");
        l.setBounds(130,65,300,25);
        l.setForeground(Color.RED);
        l.setFont(new Font("Rockwell",Font.BOLD,17));
        
        c5 = new Choice();
        String count = "select count(pName) from addPackage";
        String sql = "select pName from addPackage";
        int pCount=0;
        Conn  c = new Conn();
        try{
           ResultSet rs = c.s.executeQuery(count);
           while(rs.next()){
               pCount=Integer.parseInt(rs.getString("count(pName)"));
           }
           ResultSet rs2 = c.s.executeQuery(sql);
           if(pCount>0){
               while(rs2.next()){
                   c5.add(rs2.getString("pName"));
               }
           }
           else{
               p3.add(l);
               b2.setEnabled(false);
           }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        c5.setBackground(Color.WHITE);
        c5.setBounds(130,65,300,25);
        c5.setForeground(Color.BLACK);
        c5.setFont(new Font("Tahoma",Font.PLAIN,17));
        p3.add(c5);
        
        l3 = new JLabel("Services :");
        l3.setBounds(20,105,110,25);
        l3.setFont(new Font("Georgia",Font.BOLD,17));
        l3.setForeground(Color.BLACK);
        p3.add(l3);
        
        t = new JTextArea();
        t.setBorder(BorderFactory.createEmptyBorder());
        t.setFont(new Font("Tahoma",Font.PLAIN,15));
        t.setForeground(Color.BLACK);
        t.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) && !f3.getText().isEmpty() && !f4.getText().isEmpty() && !f5.getText().isEmpty() && !f6.getText().isEmpty() && !f7.getText().isEmpty() && !f8.getText().isEmpty() && !t.getText().isEmpty()){
                    b2.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                }
            }
        });
        JScrollPane pane = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setBounds(20,145,480,140);
        add(pane);
                    
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0,285,530,375);
        p4.setBackground(Color.LIGHT_GRAY);
        add(p4);
        
        l4 = new JLabel("Ratings :");
        l4.setBounds(20,295,80,25);
        l4.setFont(new Font("Georgia",Font.BOLD,17));
        l4.setForeground(Color.black);
        p4.add(l4);
        
        f3 = new JTextField("");
        f3.setBounds(110,295,15,25);
        f3.setBorder(BorderFactory.createEmptyBorder());
        f3.setFont(new Font("Tahoma",Font.PLAIN,15));
        f3.setForeground(Color.black);
        f3.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) && Character.compare(ch, '0')>0 && Character.compare(ch, '6')<0){
                    if( f1.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty() || f8.getText().isEmpty() || t.getText().isEmpty() || !f3.getText().equals("")){
                        b2.setEnabled(false);
                         if(!f3.getText().equals("")){
                            b2.setEnabled(false);
                            JOptionPane.showMessageDialog(p4, "Invalid input");
                            f3.setText("");
                        }
                    }
                    else{
                        b2.setEnabled(true);
                    }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                     b2.setEnabled(false);
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f3.setText("");
                }
            }
        });
        p4.add(f3);
        
        l5 = new JLabel("/5");
        l5.setBounds(132,295,30,25);
        l5.setFont(new Font("Georgia",Font.BOLD,17));
        l5.setForeground(Color.black);
        p4.add(l5);
        
        l6 = new JLabel("Available Room Types :");
        l6.setBounds(20,335,220,25);
        l6.setFont(new Font("Georgia",Font.BOLD,17));
        l6.setForeground(Color.black);
        p4.add(l6);
        
        
        c1 = new JCheckBox("Standard");
        c1.setBounds(20,375,100,25);
        c1.setFont(new Font("Georgia",Font.PLAIN,17));
        c1.setForeground(Color.black);
        c1.setSelected(true);
        c1.addItemListener(this);
        p4.add(c1);
        
        c2 = new JCheckBox("Deluxe");
        c2.setBounds(137,375,80,25);
        c2.setFont(new Font("Georgia",Font.PLAIN,17));
        c2.setForeground(Color.black);
        c2.addItemListener(this);
        p4.add(c2);
        
        c3 = new JCheckBox("Standard AC");
        c3.setBounds(234,375,120,25);
        c3.setFont(new Font("Georgia",Font.PLAIN,17));
        c3.setForeground(Color.black);
        c3.addItemListener(this);
        p4.add(c3);
        
        c4 = new JCheckBox("Deluxe AC");
        c4.setBounds(370,375,120,25);
        c4.setFont(new Font("Georgia",Font.PLAIN,17));
        c4.setForeground(Color.black);
        c4.addItemListener(this);
        p4.add(c4);

       
        l7 = new JLabel("Maximum people per room:");
        l7.setBounds(20,415,250,25);
        l7.setFont(new Font("Georgia",Font.BOLD,17));
        l7.setForeground(Color.black);
        p4.add(l7);
                    
        
        l8 = new JLabel("Standard :");
        l8.setBounds(20,455,100,25);
        l8.setFont(new Font("Georgia",Font.BOLD,17));
        l8.setForeground(Color.black);
        p4.add(l8);
        
        f4 = new JTextField("");
        f4.setBounds(125,455,20,25);
        f4.setBorder(BorderFactory.createEmptyBorder());
        f4.setFont(new Font("Tahoma",Font.PLAIN,15));
        f4.setForeground(Color.black);
        f4.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) && Character.compare(ch, '0')>0){
                    b2.setEnabled(true);
                    if(f1.getText().isEmpty() || f3.getText().isEmpty() || f5.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty() || f8.getText().isEmpty() || t.getText().isEmpty()){
                        b2.setEnabled(false);
                    }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                        b2.setEnabled(false);
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f4.setText("");
                }
            }
        });
        p4.add(f4);
        
        l9 = new JLabel("Deluxe :");
        l9.setBounds(180,455,80,25);
        l9.setFont(new Font("Georgia",Font.BOLD,17));
        l9.setForeground(Color.black);
        p4.add(l9);
        
        f5 = new JTextField("0");
        f5.setBounds(265,455,20,25);
        f5.setBorder(BorderFactory.createEmptyBorder());
        f5.setFont(new Font("Tahoma",Font.PLAIN,15));
        f5.setForeground(Color.black);
        f5.setEnabled(false);
        f5.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) && Character.compare(ch, '0')>0){
                    b2.setEnabled(true);
                    if(f1.getText().isEmpty() || f4.getText().isEmpty() || f3.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty() || f8.getText().isEmpty() || t.getText().isEmpty()){
                        b2.setEnabled(false);
                    }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                        b2.setEnabled(false);
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f5.setText("");
                }
            }
        });
        p4.add(f5);
        
        l10 = new JLabel("Charges :");
        l10.setBounds(20,495,90,25);
        l10.setFont(new Font("Georgia",Font.BOLD,17));
        l10.setForeground(Color.black);
        p4.add(l10);
        
        l11 = new JLabel("Standard");
        l11.setBounds(130,495,90,25);
        l11.setFont(new Font("Georgia",Font.BOLD,17));
        l11.setForeground(Color.black);
        p4.add(l11);
                    
        f6 = new JTextField("");
        f6.setBounds(225,495,110,25);
        f6.setBorder(BorderFactory.createEmptyBorder());
        f6.setFont(new Font("Tahoma",Font.PLAIN,15));
        f6.setForeground(Color.black);
        f6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b2.setEnabled(true);
                    if(f1.getText().isEmpty() || f4.getText().isEmpty() || f5.getText().isEmpty() || f3.getText().isEmpty() || f7.getText().isEmpty() || f8.getText().isEmpty() || t.getText().isEmpty()){
                        b2.setEnabled(false);
                    }
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
        p4.add(f6);
        
        l12 = new JLabel("Deluxe");
        l12.setBounds(355,495,80,25);
        l12.setFont(new Font("Georgia",Font.BOLD,17));
        l12.setForeground(Color.black);
        p4.add(l12);
                    
        f7 = new JTextField("0");
        f7.setBounds(423,495,110,25);
        f7.setBorder(BorderFactory.createEmptyBorder());
        f7.setFont(new Font("Tahoma",Font.PLAIN,15));
        f7.setForeground(Color.black);
        f7.setEnabled(false);
        f7.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b2.setEnabled(true);
                    if(f1.getText().isEmpty() || f4.getText().isEmpty() || f5.getText().isEmpty() || f6.getText().isEmpty() || f3.getText().isEmpty() || f8.getText().isEmpty() || t.getText().isEmpty()){
                        b2.setEnabled(false);
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
        
        l13 = new JLabel("AC");
        l13.setBounds(30,496,30,25);
        l13.setForeground(Color.black);
        l13.setFont(new Font("Georgia",Font.BOLD,17));
        p1.add(l13);
        
        f8 = new JTextField("0");
        f8.setBounds(65,495,110,25);
        f8.setBorder(BorderFactory.createEmptyBorder());
        f8.setFont(new Font("Tahoma",Font.PLAIN,15));
        f8.setBackground(Color.white);
        f8.setForeground(Color.BLACK);
        f8.setEnabled(false);
        f8.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b2.setEnabled(true);
                    if(f1.getText().isEmpty() || f4.getText().isEmpty() || f5.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty() || f3.getText().isEmpty() || t.getText().isEmpty()){
                        b2.setEnabled(false);
                    }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f8.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(p4, "Invalid input");
                    f8.setText("");
                }
            }
        });
        p1.add(f8);
        
        b2 = new JButton("Add Hotel");   //database conn -> fill name and question
        b2.setBackground(new Color(0,102,102));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.white));
        b2.setFont(new Font("Georgia",Font.BOLD,18));
        b2.setBounds(100,580,180,30);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        b2.setEnabled(false);
        p4.add(b2);
        
        b3 = new JButton("Back");   //database conn -> fill name and question
        b3.setBackground(new Color(0,102,102));
        b3.setForeground(Color.WHITE);
        b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.setFont(new Font("Georgia",Font.BOLD,18));
        b3.setBounds(300,580,180,30);
        b3.setForeground(Color.black);
        b3.addActionListener(this);
        p4.add(b3);
        
        
        setVisible(true);
      
    }
    
    public void itemStateChanged(ItemEvent ie){
        if(ie.getSource()==c1){
            if(c1.isSelected()){
                f4.setEnabled(true);
                f4.setText("");
                f6.setEnabled(true);
                f6.setText("");
            }
            else{
                f4.setEnabled(false);
                f4.setText("0");
                f6.setEnabled(false);
                f6.setText("0");
                if(!c2.isSelected() || !c3.isSelected() || !c4.isSelected()){
                    b2.setEnabled(false);
                }
            }   
        }
        else if(ie.getSource()==c2){
            if(c2.isSelected()){
                f5.setEnabled(true);
                f5.setText("");
                f7.setEnabled(true);
                f7.setText("");
            }
            else{
                f5.setEnabled(false);
                f5.setText("0");
                f7.setEnabled(false);
                f7.setText("0");
            }
        }
        else if(ie.getSource()==c3){
            if(c3.isSelected() || c4.isSelected()){
                if(c3.isSelected()){
                    f4.setEnabled(true);
                    f4.setText("");
                    f6.setEnabled(true);
                    f6.setText("");
                }
                f8.setEnabled(true);
                f8.setText("");
            }
            else{
                f4.setEnabled(false);
                f4.setText("0");
                f6.setEnabled(false);
                f6.setText("0");
                f8.setEnabled(false);
                f8.setText("0");
            }
        }
        else if(ie.getSource()==c4){
            if(c4.isSelected() || c3.isSelected()){
                if(c4.isSelected()){
                    f5.setEnabled(true);
                    f5.setText("");
                    f7.setEnabled(true);
                    f7.setText("");
                }
                f8.setEnabled(true);
                f8.setText("");
            }
            else{
                f5.setEnabled(false);
                f5.setText("0");
                f7.setEnabled(false);
                f7.setText("0");
                f8.setEnabled(false);
                f8.setText("0");
            }
        }
        if(ie.getSource()==c1 || ie.getSource()==c2 || ie.getSource()==c3 || ie.getSource()==c4){
            if(!c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected()){
                b2.setEnabled(false);
            }
        }
    }
  
    public void actionPerformed(ActionEvent e){
            String filePath="";
            
            if(e.getSource()==b1){
                JFileChooser fc = new JFileChooser("G:\\tms\\src\\tms\\icons");       //path given
                if(fc.showOpenDialog(this)==fc.APPROVE_OPTION){     //open files menu, if selected then
                    File f = fc.getSelectedFile();      //selected file
                    filePath = f.getPath();      //path in string type
                    //System.out.println(filePath);
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
                     fis = new FileInputStream(file2);
                     byte[] b = fis.readAllBytes();
                     ImageIcon i1 = new ImageIcon(b);
                     Image i2 = i1.getImage().getScaledInstance(370,340,Image.SCALE_DEFAULT);
                     ImageIcon i3 = new ImageIcon(i2);
                     l1 = new JLabel(i3);
                     l1.setBounds(0,5,370,375);
                     l1.setLayout(null);
                     p2.add(l1);
                 }catch(Exception ex){
                     System.out.println(ex);
                 } 
               }
            }
            //System.out.println(filePath);
            
            if(e.getSource()==b2){
               System.out.println(filePath);
               String hName = f1.getText();
               String pname = c5.getSelectedItem();
               String services = t.getText();
               int ratings = Integer.parseInt(f3.getText());
               int nStandard = Integer.parseInt(f4.getText());
               int nDeluxe = Integer.parseInt(f5.getText());
               String rStandard = "Not available";
               String rDeluxe = "Not available";
               String rStandardAC = "Not available";
               String rDeluxeAC = "Not available";  
               double pStandard = Double.parseDouble(f6.getText());
               double pDeluxe = Double.parseDouble(f7.getText());
               double pAC = Double.parseDouble(f8.getText());
               if(c1.isSelected()){
                   rStandard = "Available";
               }
               if(c2.isSelected()){
                   rDeluxe = "Available";
               }
               if(c3.isSelected()){
                   rStandardAC = "Available";
               }
               if(c4.isSelected()){
                   rDeluxeAC = "Available";
               }
               String loc ="";
               try{
                    Conn c =new Conn();
                    String sql2 = "select * from filePath";
                    String sql3 = "delete from filePath";
                    ResultSet rs = c.s.executeQuery(sql2);       //whole row
                    //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                    while(rs.next()){   //column to column jump
                        loc = rs.getString("loc");
                    }
                    
                    String count = "select count(hName) from Hotel";
                    
                    int hCount=0;
                    try{
                       rs = c.s.executeQuery(count);
                       while(rs.next()){
                           hCount=Integer.parseInt(rs.getString("count(hName)"));
                       }
                       //resetting auto increment
                       String reset ="alter table Hotel auto_increment="+(hCount+1)+"";
                       c.s.execute(reset);

                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    if(!loc.equals("")){
                        String query = "insert into Hotel(hName,pname,services,ratings,rStandard,rDeluxe,rStandardAC,rDeluxeAC,nStandard,nDeluxe,pStandard,pDeluxe,pAC,imagePath) values('"+hName+"','"+pname+"','"+services+"','"+ratings+"','"+rStandard+"','"+rDeluxe+"','"+rStandardAC+"','"+rDeluxeAC+"','"+nStandard+"','"+nDeluxe+"','"+pStandard+"','"+pDeluxe+"','"+pAC+"','"+loc+"')";
                        c.s.executeUpdate(query);
                        c.s.execute(sql3);
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Hotel added successfully");
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
               }catch(Exception ex1){
                   System.out.println(ex1);
               }
           }
            
            
           if(e.getSource()==b3){
               setVisible(false);
           }
    }
   
    public static void main(String[] args){
        new AddHotel("");
    }
}
