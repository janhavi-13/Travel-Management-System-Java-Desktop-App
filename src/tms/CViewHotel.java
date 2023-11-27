package tms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class CViewHotel extends JFrame implements ActionListener{
    String username,hName;
    JButton b3;
  
    CViewHotel(String username,String hName){
        this.username=username;
        this.hName=hName;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/view.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle(hName);
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
        b3.setBounds(1000,580,150,40);
        b3.setBorder(BorderFactory.createLineBorder(Color.gray));
        b3.setFont(new Font("Georgia",Font.BOLD,25));
        b3.addActionListener(this);
        la.add(b3);
        
        
            
        //image display
        JLabel l = new JLabel();
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
        
        JLabel l2 = new JLabel("Package :");
        l2.setBounds(90,90,100,25);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l2);
        
        JLabel l3 = new JLabel("");
        l3.setBounds(200,90,250,25);
        l3.setForeground(new Color(0,51,51));
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l3.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l3);
         
        JLabel l4 = new JLabel("Ratings :");
        l4.setBounds(90,155,100,25);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l4);
        
        JLabel l5 = new JLabel("");
        l5.setBounds(200,155,20,25);
        l5.setForeground(new Color(0,51,51));
        l5.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        //l5.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l5);
                
        JLabel l6 = new JLabel("/ 5");
        l6.setBounds(220,155,30,25);
        l6.setForeground(new Color(0,51,51));
        l6.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        //l6.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l6);
                
        JLabel l7 = new JLabel("Available Room Type/s :");
        l7.setBounds(90,210,230,25);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l7);
        
        JLabel l8 = new JLabel("NA");
        l8.setBounds(325,210,120,25);
        l8.setForeground(new Color(0,51,51));
        l8.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l8.setBorder(BorderFactory.createLineBorder(Color.black));
        la.add(l8);
                
        JLabel l9 = new JLabel("NA");
        l9.setBounds(458,210,120,25);
        l9.setForeground(new Color(0,51,51));
        l9.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l9.setBorder(BorderFactory.createLineBorder(Color.black));
        la.add(l9);
                
        JLabel l10 = new JLabel("NA");
        l10.setBounds(592,210,120,25);
        l10.setForeground(new Color(0,51,51));
        l10.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l10.setBorder(BorderFactory.createLineBorder(Color.black));
        la.add(l10);
                
        JLabel l11 = new JLabel("NA");
        l11.setBounds(726,210,120,25);
        l11.setForeground(new Color(0,51,51));
        l11.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l11.setBorder(BorderFactory.createLineBorder(Color.black));
        la.add(l11);
        
        JLabel l12 = new JLabel("Maximum capacity of a room :");
        l12.setBounds(90,270,270,25);
        l12.setForeground(Color.black);
        l12.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l12);
        
        JLabel l13 = new JLabel("1)Standard -");
        l13.setBounds(360,270,120,25);
        l13.setForeground(new Color(0,51,51));
        l13.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l13.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l13);
                
        JLabel l14 = new JLabel("NA");
        l14.setBounds(490,270,30,25);
        l14.setForeground(new Color(0,51,51));
        l14.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l14.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l14);
                
        JLabel l15 = new JLabel("2)Deluxe -");
        l15.setBounds(550,270,100,25);
        l15.setForeground(new Color(0,51,51));
        l15.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l15.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l15);
                
        JLabel l16 = new JLabel("NA");
        l16.setBounds(660,270,30,25);
        l16.setForeground(new Color(0,51,51));
        l16.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l16.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l16);
        
        JLabel l17 = new JLabel("Charges :");
        l17.setBounds(90,333,100,25);
        l17.setForeground(Color.black);
        l17.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l17);
        
        JLabel l18 = new JLabel("Standard Room :");
        l18.setBounds(200,333,160,25);
        l18.setForeground(new Color(0,51,51));
        l18.setFont(new Font("Georgia",Font.PLAIN,20));
        l18.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l18);
        
        JLabel l19 = new JLabel("NA");
        l19.setBounds(373,333,80,25);
        l19.setForeground(new Color(0,51,51));
        l19.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        l19.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l19);
                
        JLabel l20 = new JLabel("Deluxe Room :");
        l20.setBounds(510,333,140,25);
        l20.setForeground(new Color(0,51,51));
        l20.setFont(new Font("Georgia",Font.PLAIN,20));
        l20.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l20);
        
        JLabel l21 = new JLabel("NA");
        l21.setBounds(663,333,80,25);
        l21.setForeground(new Color(0,51,51));
        l21.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        l21.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l21);
        
        JLabel l22 = new JLabel("AC : ");
        l22.setBounds(200,378,50,25);
        l22.setForeground(new Color(0,51,51));
        l22.setFont(new Font("Georgia",Font.PLAIN,19));
        l22.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l22);
                
        JLabel l23 = new JLabel("NA");
        l23.setBounds(263,378,80,25);
        l23.setForeground(new Color(0,51,51));
        l23.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        l23.setBorder(BorderFactory.createLineBorder(Color.gray));
        la.add(l23);
        
        JLabel l24 = new JLabel("Services :");
        l24.setBounds(90,420,100,25);
        l24.setForeground(Color.black);
        l24.setFont(new Font("Georgia",Font.PLAIN,20));
        la.add(l24);
        
        JTextArea t = new JTextArea("");
        t.setBounds(90,455,650,100);
        t.setForeground(new Color(0,51,51));
        t.setFont(new Font("SAN_SERIF",Font.BOLD,19));
        t.setBorder(BorderFactory.createLineBorder(Color.gray));
        t.setEditable(false);
        la.add(t);
        JScrollPane spane = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spane.setBounds(90,455,680,130);
        la.add(spane);
               
        try{
            Conn c = new Conn();
            FileInputStream fis = null;
            ResultSet rs = c.s.executeQuery("select * from Hotel where hName='"+hName+"'");
            while(rs.next()){
                l1.setText(rs.getString("hName"));     //get text from username column and put it in textField
                l3.setText(rs.getString("pname"));
                l5.setText(rs.getString("ratings"));
                if(rs.getString("rStandard").equals("Available")){
                    l8.setText("Standard");
                }
                if(rs.getString("rDeluxe").equals("Available")){
                    l9.setText("Deluxe");
                }
                if(rs.getString("rStandardAC").equals("Available")){
                    l10.setText("Standard AC");
                }
                if(rs.getString("rDeluxeAC").equals("Available")){
                    l11.setText("Deluxe AC");
                }
                if(!rs.getString("nStandard").equals("0")){
                    l14.setText(rs.getString("nStandard"));
                }
                if(!rs.getString("nDeluxe").equals("0")){
                    l16.setText(rs.getString("nDeluxe"));
                }
                if(!rs.getString("pStandard").equals("0.0")){
                    l19.setText(rs.getString("pStandard"));
                }
                if(!rs.getString("pDeluxe").equals("0.0")){
                    l21.setText(rs.getString("pDeluxe"));
                }
                if(!rs.getString("pAC").equals("0.0")){
                    l23.setText(rs.getString("pAC"));
                }
                t.setText(rs.getString("services"));
                
                File file2 = new File(rs.getString("imagePath"));
                fis = new FileInputStream(file2);
                byte[] by = fis.readAllBytes();
                ImageIcon i1 = new ImageIcon(by);
                Image i2 = i1.getImage().getScaledInstance(400,380,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                l.setIcon(i3);
                
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
        new CViewHotel("","");
    }
}
