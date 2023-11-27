package tms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class CViewPackage extends JFrame implements ActionListener{
    String username,pName;
    JButton b3;
    JLabel l;
    
    CViewPackage(String username,String pName){
        this.username=username;
        this.pName=pName;
        //System.out.println(pName);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/view.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle(pName);
        getContentPane().setBackground(new Color(0,51,51));
        setLayout(null);
        setResizable(false); 
        setUndecorated(true);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashboard.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0,0,1370,760);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        b3 = new JButton("Back");
        b3.setBounds(1000,570,150,40);
        b3.setBorder(BorderFactory.createLineBorder(Color.gray));
        b3.setFont(new Font("Georgia",Font.BOLD,25));
        b3.addActionListener(this);
        la.add(b3);
        
   
        l = new JLabel();
        l.setBounds(870,60,400,380);
        l.setForeground(Color.white);
        l.setFont(new Font("Rockwell",Font.BOLD,13));
        l.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        la.add(l);
        
        
        JLabel l1 = new JLabel("");
        l1.setBounds(460,20,280,30);
        l1.setForeground(new Color(204,51,0));
        l1.setFont(new Font("Rockwell",Font.BOLD,24));
        la.add(l1);
        
        JLabel l2 = new JLabel("From :");
        l2.setBounds(90,90,80,25);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l2);
        
        JLabel l4 = new JLabel("");
        l4.setBounds(180,90,250,25);
        l4.setForeground(new Color(0,51,51));
        l4.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l4.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l4);
        
        JLabel l3 = new JLabel("To :");
        l3.setBounds(450,90,40,25);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l3);
        
        JLabel l5 = new JLabel("");
        l5.setBounds(520,90,250,25);
        l5.setForeground(new Color(0,51,51));
        l5.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l5.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l5);
        
        JLabel l6 = new JLabel("Price :");
        l6.setBounds(90,145,100,25);
        l6.setForeground(Color.black);
        l6.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l6);
        
        JLabel l7 = new JLabel("");
        l7.setBounds(180,145,250,25);
        l7.setForeground(new Color(0,51,51));
        l7.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l7.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l7);
        
        JLabel l18 = new JLabel("Departure Date :");
        l18.setBounds(450,145,160,25);
        l18.setForeground(Color.black);
        l18.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l18);
        
        JLabel l19 = new JLabel("");
        l19.setBounds(620,145,150,25);
        l19.setForeground(new Color(0,51,51));
        l19.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l19.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l19);
        
        JLabel l20 = new JLabel("Booking Capacity :");
        l20.setBounds(450,200,180,25);
        l20.setForeground(Color.black);
        l20.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l20);
        
        JLabel l21 = new JLabel("");
        l21.setBounds(620,200,150,25);
        l21.setForeground(new Color(0,51,51));
        l21.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l21.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l21);
        
        JLabel l8 = new JLabel("Duration :");
        l8.setBounds(90,200,100,25);
        l8.setForeground(Color.black);
        l8.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l8);
        
        JLabel l9 = new JLabel("");
        l9.setBounds(190,200,240,25);
        l9.setForeground(new Color(0,51,51));
        l9.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l9.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l9);
        
        JLabel l10 = new JLabel("Transporatation Type :");
        l10.setBounds(90,255,250,25);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l10);
        
        JLabel l11 = new JLabel("");
        l11.setBounds(340,255,120,25);
        l11.setForeground(new Color(0,51,51));
        l11.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l11.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l11);
        
        JLabel l12 = new JLabel("Transporatation Mode :");
        l12.setBounds(90,310,250,25);
        l12.setForeground(Color.black);
        l12.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l12);
        
        JLabel l13 = new JLabel("");
        l13.setBounds(340,310,120,25);
        l13.setForeground(new Color(0,51,51));
        l13.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l13.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l13);
        
        JLabel l14 = new JLabel("Meals :");
        l14.setBounds(90,365,80,25);
        l14.setForeground(Color.black);
        l14.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l14);
        
        JLabel l15 = new JLabel("");
        l15.setBounds(180,365,150,25);
        l15.setForeground(new Color(0,51,51));
        l15.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l15.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l15);
        
        JLabel l24 = new JLabel("Available seats :");
        l24.setBounds(450,365,180,25);
        l24.setForeground(Color.black);
        l24.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l24);
        
        JLabel l25 = new JLabel("");
        l25.setBounds(620,365,150,25);
        l25.setForeground(new Color(0,51,51));
        l25.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l25.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l25);
        
        JLabel l16 = new JLabel("Activities :");
        l16.setBounds(90,420,100,25);
        l16.setForeground(Color.black);
        l16.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l16);
        
        JTextArea l17 = new JTextArea("");
        l17.setBounds(90,455,650,200);
        l17.setForeground(new Color(0,51,51));
        l17.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l17.setBorder(BorderFactory.createLineBorder(Color.gray));
        l17.setEditable(false);
        la.add(l17);
        JScrollPane spane = new JScrollPane(l17,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spane.setBounds(90,455,650,200);
        la.add(spane);
            
        Conn c = new Conn();
        FileInputStream fis = null;
        try{
            ResultSet rs = c.s.executeQuery("select * from addPackage where pName='"+pName+"'");
            while(rs.next()){
                l1.setText(rs.getString("pName"));     
                l4.setText(rs.getString("lFrom"));
                l5.setText(rs.getString("lTo"));
                l7.setText(rs.getString("price"));
                l9.setText(rs.getString("duration"));
                l11.setText(rs.getString("tType"));
                l13.setText(rs.getString("tMode"));
                l15.setText(rs.getString("meals"));
                l17.setText(rs.getString("attractions"));
                l19.setText(rs.getString("ddate"));
                l21.setText(rs.getString("bCapacity"));
                
                File file2 = new File(rs.getString("imagePath"));
                //fis is reference variable
                
                fis = new FileInputStream(file2);
                byte[] by = fis.readAllBytes();
                ImageIcon i1 = new ImageIcon(by);
                Image i2 = i1.getImage().getScaledInstance(400,380,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                l.setIcon(i3);    
            }
            ResultSet rs2 = c.s.executeQuery("select available from bCapacity where pname='"+pName+"'");
            if(rs2.next()){
                l25.setText(rs2.getString("available"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
         
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b3){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new CViewPackage("","");
    }
}
