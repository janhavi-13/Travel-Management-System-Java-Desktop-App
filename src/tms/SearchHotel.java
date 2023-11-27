package tms;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchHotel extends JFrame implements ActionListener{
    String username;
    Choice c1;
    JButton b1,b2;
    
    SearchHotel(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashIcon.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Search Hotel");
        //setLayout(null);
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
        
        b1 = new JButton("Back");
        b1.setBounds(20,20,80,30);
        b1.setBackground(Color.WHITE);
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.addActionListener(this);
        la.add(b1);
        
        JLabel l1 = new JLabel("Select  Hotel :");
        l1.setBounds(50,270,280,40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Rockwell",Font.BOLD,32));
        la.add(l1);
        
        JLabel l = new JLabel("No Hotels to display");
        l.setBounds(50,320,400,80);
        l.setForeground(Color.RED);
        l.setFont(new Font("Rockwell",Font.BOLD,32));
        
        b2 = new JButton("View");
        b2.setBounds(410,320,100,35);
        b2.setBackground(Color.WHITE);
        b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b2.setFont(new Font("Georgia",Font.BOLD,28));
        b2.addActionListener(this);
        la.add(b2);
        
        c1 = new Choice();
        String count = "select count(hName) from Hotel";
        String sql = "select hName from Hotel";
        int hCount=0;
        Conn  c = new Conn();
        try{
           ResultSet rs = c.s.executeQuery(count);
           while(rs.next()){
               hCount=Integer.parseInt(rs.getString("count(hName)"));
           }
           ResultSet rs2 = c.s.executeQuery(sql);
           if(hCount>0){
               while(rs2.next()){
                   c1.add(rs2.getString("hName"));
               }
           }
           else{
               la.add(l);
               b2.setVisible(false);
           }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        c1.setBackground(Color.WHITE);
        c1.setBounds(50,320,400,80);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Tahoma",Font.PLAIN,25));
        la.add(c1);
        
      
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            setVisible(false);
        }
        if(e.getSource()==b2){
            String hName=c1.getSelectedItem();
            new ViewHotel(username,hName).setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new SearchHotel("");
    }
}

