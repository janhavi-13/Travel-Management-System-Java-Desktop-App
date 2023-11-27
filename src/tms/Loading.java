package tms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar p1;
    Thread t;
    String username;
    JFrame f;
    JLabel la;
    public void run(){
        f = new Dashboard(username);
        f.setVisible(false);
        la.add(p1);
        try{
            for(int i=1;i<=101;i++){
                int max = p1.getMaximum();  //100
                int currValue = p1.getValue();      //32
                if(currValue<max){      //32 < 100
                    p1.setValue(p1.getValue() + 1);     //33
                }
                else{
                    i = 101;
                    f.show();
                    dispose();
                }
                Thread.sleep(25);
            }
        }catch(Exception e){}
}
    Loading(String user){
        username =user;
        t = new Thread(this);
        
        
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashIcon.jpg"));
        Image im = i.getImage();
        setIconImage(im);

        setBounds(80,50,1370,760);
        setTitle("");
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("tms/icons/travel2.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        /*
        JLabel l1 = new JLabel("Travel Management Application");
        l1.setBounds(65,10,470,30);
        l1.setForeground(new Color(255,153,153));
        l1.setFont(new Font("Georgia",Font.TRUETYPE_FONT,25));
        la.add(l1);
        */
        
        p1 = new  JProgressBar();
        p1.setLayout(null);
        p1.setBounds(760,600,500,50);
        p1.setBackground(Color.DARK_GRAY);
        p1.setBorder(BorderFactory.createEtchedBorder());
        p1.setStringPainted(true); //percentage prints
        p1.setForeground(Color.WHITE);
        //la.add(p1);
        
        JLabel l2 = new JLabel("Please Wait....");
        l2.setBounds(760,545,300,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.BOLD,23));
        la.add(l2);
        
        JLabel l3 = new JLabel("Welcome "+username+" ...");
        l3.setBounds(760,300,800,50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Georgia",Font.ITALIC,40));
        la.add(l3);
        
        t.start();
    }
    public static void main(String args[]){
        new Loading("").setVisible(true);
    }
}
