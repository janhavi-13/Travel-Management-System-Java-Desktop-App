package tms;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UpdatePackage extends JFrame implements ActionListener,ItemListener,DocumentListener,MouseListener{
    String username,pName;
    int SrNo;
    JTextField f1,f2,f3,f4,f5,f6;
    JTextArea a1;
    JCheckBox c1;
    JRadioButton r1,r2;
    JLabel l1,la,l19;
    Choice c3,c2;
    JButton b1,b2,b3,b4;
    ImageIcon i3;
    com.toedter.calendar.JDateChooser jdc;
    
    UpdatePackage(String username,String pName){
        this.username=username;
        this.pName=pName;
        System.out.println(pName);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/undo.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Update Package");
        setLayout(null);
        setBounds(80,50,1370,760);
        setResizable(false);
        setUndecorated(true);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashboard.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        la = new JLabel(bii);
        la.setBounds(0,0,1700,900);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        
        f1 = new JTextField("");
        f1.setBounds(450,20,280,30);
        f1.setForeground(new Color(204,51,0));
        f1.setFont(new Font("Rockwell",Font.BOLD,24));
        f1.getDocument().addDocumentListener(this);
        la.add(f1);
        
        JLabel l2 = new JLabel("From :");
        l2.setBounds(80,90,80,25);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l2);
        
        f2 = new JTextField("");
        f2.setBounds(170,90,250,25);
        f2.setForeground(new Color(0,51,51));
        f2.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        f2.setBorder(BorderFactory.createLineBorder(Color.gray));
        f2.getDocument().addDocumentListener(this);
        la.add(f2);
        
        JLabel l3 = new JLabel("To :");
        l3.setBounds(440,90,40,25);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l3);
        
        f3 = new JTextField("");
        f3.setBounds(490,90,250,25);
        f3.setForeground(new Color(0,51,51));
        f3.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        f3.setBorder(BorderFactory.createLineBorder(Color.gray));
        f3.getDocument().addDocumentListener(this);
        la.add(f3);
        
        JLabel l18 = new JLabel("Departure Date :");
        l18.setBounds(450,145,160,25);
        l18.setForeground(Color.black);
        l18.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l18);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBounds(620,145,150,25);
        la.add(p1);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        ((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        //java.util.Date d = new java.util.Date();
        //jdc.setMinSelectableDate(d);
        p1.add(jdc);
        
        l19 = new JLabel();
        l19.setBounds(640,170,150,20);
        l19.setForeground(Color.RED);
        l19.setFont(new Font("SAN_SERIF",Font.PLAIN,17));
        la.add(l19);
        
        JLabel l20 = new JLabel("Booking Capacity :");
        l20.setBounds(450,200,180,25);
        l20.setForeground(Color.black);
        l20.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l20);
        
        f6 = new JTextField("");
        f6.setBounds(620,200,150,25);
        f6.setForeground(new Color(0,51,51));
        f6.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        f6.setBorder(BorderFactory.createLineBorder(Color.gray));
        f6.getDocument().addDocumentListener(this);
        f6.setEnabled(true);
        f6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("") || f5.getText().equals("") || a1.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b2.setEnabled(false);
                         if(f6.getText().length()>1){
                            b2.setEnabled(false);
                            JOptionPane.showMessageDialog(la, "Invalid input");
                            f6.setText("");
                        }
                    }
                    else
                        if(f6.getText().length()>1){
                            b2.setEnabled(false);
                            JOptionPane.showMessageDialog(la, "Invalid input");
                            f6.setText("");
                        }
                        else{
                            b2.setEnabled(true);
                        }
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f6.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(la, "Invalid input");
                    f6.setText("");
                }
            }
        });
        la.add(f6);
        
        JLabel l4 = new JLabel("Price :");
        l4.setBounds(80,145,100,25);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l4);
        
        f4 = new JTextField("");
        f4.setBounds(170,145,250,25);
        f4.setForeground(new Color(0,51,51));
        f4.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        f4.setBorder(BorderFactory.createLineBorder(Color.gray));
        f4.getDocument().addDocumentListener(this);
        f4.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f5.getText().equals("") || a1.getText().equals("") || f6.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b2.setEnabled(false);
                    }
                    else
                        b2.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(f4.getText().length()==1){
                        b2.setEnabled(false);
                    }
                }
                else{
                    b2.setEnabled(false);
                    JOptionPane.showMessageDialog(la, "Invalid input");
                    f4.setText("");
                }
            }
        });
        la.add(f4);
        
        JLabel l5 = new JLabel("Duration :");
        l5.setBounds(80,200,100,25);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l5);
        
        f5 = new JTextField("");
        f5.setBounds(180,200,240,25);
        f5.setForeground(new Color(0,51,51));
        f5.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        f5.setBorder(BorderFactory.createLineBorder(Color.gray));
        f5.getDocument().addDocumentListener(this);
        la.add(f5);
        
        JLabel l6 = new JLabel("Transporatation :");
        l6.setBounds(80,255,180,25);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l6);
        
        r1 = new JRadioButton("Public -");
        r1.setBounds(250,255,100,25);
        r1.setBackground(Color.white);
        r1.setFont(new Font("Tahoma",Font.PLAIN,19));
        r1.setForeground(Color.black);
        r1.addItemListener(this);
        la.add(r1);
        
        c2 = new Choice();
        c2.add("Train");
        c2.add("Flight");
        c2.add("Bus");
        c2.setBounds(360,255,90,77);
        c2.setForeground(Color.black);
        c2.setFont(new Font("Tahoma",Font.PLAIN,19));
        la.add(c2);
        
        r2 = new JRadioButton("Private -");
        r2.setBounds(250,295,100,25);
        r2.setBackground(Color.white);
        r2.setFont(new Font("Tahoma",Font.PLAIN,19));
        r2.setForeground(Color.black);
        r2.addItemListener(this);
        la.add(r2);
        
        c3 = new Choice();
        c3.add("Car");
        c3.add("Bus");
        c3.setBounds(360,295,90,75);
        c3.setFont(new Font("Tahoma",Font.PLAIN,19));
        c3.setForeground(Color.black);
        la.add(c3);
        
        c1 = new JCheckBox("Meals Included ?");      
        c1.setLayout(null);
        c1.setBounds(80,365,180,30);
        c1.setFont(new Font("Georgia",Font.PLAIN,20));
        c1.setForeground(Color.black);
        la.add(c1);
        c1.addItemListener(this);
        
        JLabel l8 = new JLabel("Activities :");
        l8.setBounds(80,420,100,25);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l8);
        
        a1 = new JTextArea("");
        a1.setBounds(80,455,650,200);
        a1.setForeground(new Color(0,51,51));
        a1.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        a1.setBorder(BorderFactory.createLineBorder(Color.gray));
        a1.getDocument().addDocumentListener(this);
        la.add(a1);
        JScrollPane spane = new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spane.setBounds(80,455,650,200);
        la.add(spane);
        
        l1 = new JLabel();
        l1.setBounds(860,60,400,380);
        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("Rockwell",Font.BOLD,13));
        l1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        la.add(l1);
        
        b1 = new JButton("Add Image");   //database conn -> fill name and questio
        b1.setLayout(null);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia",Font.BOLD,17));
        b1.setBounds(958,460,150,30);
        b1.addActionListener(this);
        la.add(b1);
        
        b4 = new JButton();   //database conn -> fill name and question
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("tms/icons/undo.png"));
        Image ic2 = ic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon ic3 = new ImageIcon(ic2);
        b4.setIcon(ic3);
        b4.setLayout(null);
        b4.setBackground(Color.WHITE);
        b4.setBorder(BorderFactory.createLineBorder(Color.white));
        b4.setBounds(1118,460,40,30);
        b4.addActionListener(this);
        la.add(b4);
        
        b2 = new JButton("Save");   //database conn -> fill name and question
        b2.setBackground(Color.DARK_GRAY);
        b2.setBorder(BorderFactory.createLineBorder(Color.white));
        b2.setFont(new Font("Georgia",Font.BOLD,25));
        b2.setBounds(945,570,100,50);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setEnabled(false);
        la.add(b2);
        
        b3 = new JButton("Back");   //database conn -> fill name and question
        b3.setBackground(Color.DARK_GRAY);
        b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.setFont(new Font("Georgia",Font.BOLD,25));
        b3.setBounds(1075,570,100,50);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        la.add(b3);
        
        try{
            Conn c =new Conn();
            FileInputStream fis = null;
            ResultSet rs = c.s.executeQuery("select * from addPackage where pName= '"+pName+"'");
            while(rs.next()){
                
                File file2 = new File(rs.getString("imagePath"));
                fis = new FileInputStream(file2);
                byte[] by = fis.readAllBytes();
                ImageIcon i1 = new ImageIcon(by);
                Image i2 = i1.getImage().getScaledInstance(400,380,Image.SCALE_DEFAULT);
                i3 = new ImageIcon(i2);
                
                l1.setIcon(i3);
                f1.setText(rs.getString("pName"));     //get text from username column and put it in textField 
                f2.setText(rs.getString("lFrom"));
                f3.setText(rs.getString("lTo"));
                f4.setText(rs.getString("price"));
                f5.setText(rs.getString("duration"));
                a1.setText(rs.getString("attractions"));
                f6.setText(rs.getString("bCapacity"));
                String datee = rs.getString("ddate");
                System.out.println(datee);
                Date da = null;
                try{
                    da = new SimpleDateFormat("dd/MM/yyyy").parse(datee);
                }catch(Exception e){}
                ((JTextField)jdc.getDateEditor().getUiComponent()).setText(datee);
                System.out.println(jdc.getDate());
                
                if(!rs.getString("tType").equals("")){
                    if(rs.getString("tType").equals("Public")){
                        r1.setSelected(true);
                    }
                    else if(rs.getString("tType").equals("Private")){
                        r2.setSelected(true);
                    }
                }
                if(!rs.getString("meals").equals("")){
                    if(rs.getString("meals").equals("Included")){
                        c1.setSelected(true);
                    }
                    else if(rs.getString("meals").equals("Not Included")){
                        c1.setSelected(false);
                    }
                }
                c2.select(rs.getString("tMode"));
                c3.select(rs.getString("tMode"));
                
                
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
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
            if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("") || f5.getText().equals("") || f6.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
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
        if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") || f4.getText().equals("") || f5.getText().equals("") || a1.getText().equals("") || f6.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") ){
            b2.setEnabled(false);
        }
        else{
              if(jdc.getDate()==null){
                  l19.setText("Reselect the date");
                  b2.setEnabled(false);
              }
              else{
                  l19.setText("");
                  b2.setEnabled(true);
              }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        String filePath="";
        
        if(ae.getSource()==b1){
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
                 ImageIcon i4 = new ImageIcon(b);
                 Image i5 = i4.getImage().getScaledInstance(400,380,Image.SCALE_DEFAULT);
                 ImageIcon i6 = new ImageIcon(i5);
                 l1.setIcon(i6);
             }catch(Exception ex){} 
           }
        }
        
        System.out.println(filePath);

        if(ae.getSource()==b2){
               System.out.println(filePath);
               String pname = f1.getText();
               String lFrom = f2.getText();
               String lTo = f3.getText();
               String  duration = f5.getText();
               String activities = a1.getText();
               String tType = null;
               String tMode = null;    
               double price = Double.parseDouble(f4.getText());
               Integer bCapacity = Integer.parseInt(f6.getText());
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
               //date
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
                        //System.out.println(loc);
                    }
                    //System.out.println(loc);
                    
                    if(!loc.equals("")){
                        String query2 = "update bCapacity set pName='"+pname+"' where pName='"+pName+"'";
                        c.s.executeUpdate(query2);
                        String query = "update addPackage set pName='"+pname+"',duration='"+duration+"',attractions='"+activities+"',meals='"+meals+"',price='"+price+"',imagePath='"+loc+"',tMode='"+tMode+"',tType='"+tType+"',lFrom='"+lFrom+"',lTo='"+lTo+"',ddate='"+date+"',bCapacity='"+bCapacity+"' where pName='"+pName+"'";
                        c.s.executeUpdate(query);
                        c.s.execute(sql3);
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Package updated successfully");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                        setVisible(false);
                        new ViewPackage(username,pname).setVisible(true);
                    }
                    else if(loc.equals("") && l1.getIcon()==i3){
                        String query2 = "update bCapacity set pName='"+pname+"',ddate='"+date+"' where pName='"+pName+"'";
                        c.s.executeUpdate(query2);
                        String query = "update addPackage set pName='"+pname+"',duration='"+duration+"',attractions='"+activities+"',meals='"+meals+"',price='"+price+"',tMode='"+tMode+"',tType='"+tType+"',lFrom='"+lFrom+"',lTo='"+lTo+"',ddate='"+date+"',bCapacity='"+bCapacity+"' where pName='"+pName+"'";
                        c.s.executeUpdate(query);
                        c.s.execute(sql3);
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Package updated successfully");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                        //System.out.println(";;;"+pname);
                        setVisible(false);
                        new ViewPackage(username,pname).setVisible(true);
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
                    
               }catch(Exception e){
                    System.out.println(e);
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
        if(ae.getSource()==b4){
               l1.setIcon(null);
               Conn c = new Conn();
               String sql4 = "delete from filePath";
               try{
                   c.s.execute(sql4);
               }catch(Exception ex){
                   System.out.println(ex);
               }
        }
        if(ae.getSource()==b3){
            setVisible(false);
            new ViewPackage(username,pName).setVisible(true);
        }
    }
    public static void main(String[] args){
        new UpdatePackage("","");
    }
}
