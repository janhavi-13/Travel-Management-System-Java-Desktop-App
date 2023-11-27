package tms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class HotelReports extends JFrame implements ActionListener{
    String username;
    JPanel p1;
    Choice c1;
    JButton b4,b2,b1;
    
    HotelReports(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashIcon.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Dashboard");
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("tms/icons/dashboard.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        b4 = new JButton("Back");
        b4.setBounds(20,20,120,40);
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Rockwell",Font.BOLD,23));
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.addActionListener(this);
        la.add(b4);
 
        p1 = new JPanel();
        p1.setBounds(30,150,500,280);
        p1.setLayout(null);
        p1.setBackground(new Color(102,51,0));
        la.add(p1);
        
        JLabel l = new JLabel("Hotel  Name :");
        l.setBounds(40,30,400,30);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Georgia",Font.BOLD,25));
        p1.add(l);
        
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
        c1.setBounds(40,80,370,60);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(c1);
        
        b1 = new JButton("Check");
        b1.setBounds(360,78,100,35);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("All Hotels Details");
        b2.setBounds(40,210,320,40);
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Rockwell",Font.BOLD,23));
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        p1.add(b2);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b4){
            setVisible(false);
        }
        if(e.getSource()==b1){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("G:\\TMS\\src\\tms\\reports\\HNameReport.jrxml");
                String sql = "select * from hotel where hName = '"+c1.getSelectedItem()+"'";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(sql);
                jd.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jd);
                JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                JasperViewer.viewReport(jprint);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
         if(e.getSource()==b2){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("G:\\TMS\\src\\tms\\reports\\HReport.jrxml");
                String sql = "select * from hotel";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(sql);
                jd.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jd);
                JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                JasperViewer.viewReport(jprint);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
    }
    
    
    public static void main(String[] args){
        new HotelReports("");
    }
}
