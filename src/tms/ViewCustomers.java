package tms;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ViewCustomers extends JFrame implements ActionListener,MouseListener{
    String username;
    JTextField t1,t2,t3;
    JButton b1,b2;
    JTable t;
    String data[][]={};
    JPanel panel;
    com.toedter.calendar.JDateChooser jdc;
    JScrollPane sp;
    DefaultTableModel dm ;
    
    ViewCustomers(String username){
        this.username=username;
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("tms/icons/view.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("");
        getContentPane().setBackground(new Color(102,51,0));
        setLayout(null);
        setResizable(false);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
        JLabel l1 = new JLabel("Search By -");
        l1.setBounds(30,30,200,30);
        l1.setFont(new Font("Georgia",Font.BOLD,27));
        l1.setForeground(Color.WHITE);
        add(l1);
        
        JLabel l2 = new JLabel("ID :");
        l2.setBounds(250,30,50,30);
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setForeground(Color.WHITE);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(310,30,120,30);
        t1.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        t1.setForeground(Color.BLACK);
        t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                   if(((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b1.setEnabled(true);
                    }
                    else
                        b1.setEnabled(false);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t1.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(panel,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                }
            }
        });
        add(t1);
        
        JLabel l3 = new JLabel("Date :");
        l3.setBounds(450,30,100,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.WHITE);
        add(l3);
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(560,30,180,30);
        add(p);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        //((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
       // jdc.setMinSelectableDate(d);
        
        p.add(jdc);
        
        b1 = new JButton("Search");
        b1.setBounds(1240,30,120,40);
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.setBackground(Color.white);
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        //b1.setEnabled(false);
        add(b1);
        
        b2 = new JButton("Show All");
        b2.setBounds(1370,30,130,40);
        b2.setFont(new Font("Georgia",Font.BOLD,25));
        b2.setBackground(Color.white);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        
        //Table
        panel = new JPanel();
        panel.setBounds(27,110,1480,700);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.GRAY);
        
        int cCount=0;
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select count(fName) from customerDetails");
            if(rs.next()){
                cCount = Integer.parseInt(rs.getString("count(fName)"));
            }
            int j = 0;
            data = new String [cCount][12];
            ResultSet rs2;
            while(j<cCount){
                rs2 = c.s.executeQuery("select * from customerDetails where SrNo='"+(j+1)+"'");
                while(rs2.next()){
                    data[j][0] = rs2.getString("SrNo");
                    data[j][1] = rs2.getString("fName");
                    data[j][2] = rs2.getString("lName");
                    data[j][3] = rs2.getString("address");
                    data[j][4] = rs2.getString("pincode");
                    data[j][5] = rs2.getString("mobileNo");
                    data[j][6] = rs2.getString("email");
                    data[j][7] = rs2.getString("pName");
                    data[j][8] = rs2.getString("hName");
                    data[j][9] = rs2.getString("rType");
                    data[j][10] = rs2.getString("total");
                    data[j][11] = rs2.getString("datee");
                }
                j++;
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
        
        dm = new DefaultTableModel();
        t = new JTable(dm);
        dm.addColumn("SrNo");
        dm.addColumn("Name");
        dm.addColumn("Surname");
        dm.addColumn("Address");
        dm.addColumn("Pincode");
        dm.addColumn("Mobile No.");
        dm.addColumn("Email");
        dm.addColumn("Package");
        dm.addColumn("Hotel");
        dm.addColumn("Room Type");
        dm.addColumn("Total");
        dm.addColumn("Date");
        t.setBounds(27,100,1480,700);
        t.setFont(new Font("SAN_SERIF",Font.BOLD,23));
        //t.setIntercellSpacing();
        t.setShowHorizontalLines(true);
        t.setShowVerticalLines(true);
        t.setBackground(Color.WHITE);
        t.setEnabled(false);
        t.getTableHeader().setFont(new Font("Georgia",Font.BOLD,25));
        t.getTableHeader().setBackground(Color.DARK_GRAY);
        t.getTableHeader().setForeground(Color.WHITE);
        t.setRowHeight(30);
        
        t.getColumnModel().getColumn(0).setPreferredWidth(90);
        t.getColumnModel().getColumn(1).setPreferredWidth(200);
        t.getColumnModel().getColumn(2).setPreferredWidth(200);
        t.getColumnModel().getColumn(3).setPreferredWidth(500);
        t.getColumnModel().getColumn(4).setPreferredWidth(200);
        t.getColumnModel().getColumn(5).setPreferredWidth(300);
        t.getColumnModel().getColumn(6).setPreferredWidth(500);
        t.getColumnModel().getColumn(7).setPreferredWidth(200);
        t.getColumnModel().getColumn(8).setPreferredWidth(200);
        t.getColumnModel().getColumn(9).setPreferredWidth(200);
        t.getColumnModel().getColumn(10).setPreferredWidth(200);
        t.getColumnModel().getColumn(11).setPreferredWidth(200);
        
        sp = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.getHorizontalScrollBar().setBackground(Color.gray);
        panel.add(sp,BorderLayout.CENTER);
        add(panel);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        /*for(String[] x : data){
            for(String y : x){
                System.out.println(y);
            }
        }*/
    
        createTable(data);
        
        setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please select the date");
        }
        if(e.getSource()==jdc.getComponent(0)){
            jdc.getComponent(1).setEnabled(true);
            t1.setText("");
            b1.setEnabled(true);
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
    
    public void createTable(String data2[][]){
        int i = 0;
        while(i<data2.length){
            dm.addRow(data2[i]);
            i++;
        }   
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            Conn c = new Conn();  
            dm.setRowCount(0);
            setVisible(false);
            setVisible(true);
            try{
                if(!t1.getText().equals("")  && ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                    data = new String[1][12];
                    ResultSet rs2 = c.s.executeQuery("select * from customerDetails where SrNo='"+t1.getText()+"'");  
                    while(rs2.next()){
                        data[0][0] = rs2.getString("SrNo");
                        data[0][1] = rs2.getString("fName");
                        data[0][2] = rs2.getString("lName");
                        data[0][3] = rs2.getString("address");
                        data[0][4] = rs2.getString("pincode");
                        data[0][5] = rs2.getString("mobileNo");
                        data[0][6] = rs2.getString("email");
                        data[0][7] = rs2.getString("pName");
                        data[0][8] = rs2.getString("hName");
                        data[0][9] = rs2.getString("rType");
                        data[0][10] = rs2.getString("total");
                        data[0][11] = rs2.getString("datee");
                    }
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(SrNo) from customerDetails");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(SrNo)"));
                    }    
                    if(Integer.parseInt(t1.getText()) > count){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Invalid input");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(panel,msg ,"",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                        dm.setRowCount(0);
                    }else
                        createTable(data);
                }
                
                if(t1.getText().equals("")  && !((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(jdc.getDate());
                    
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(SrNo) from customerDetails where datee='"+date+"'");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(SrNo)"));
                    }    
                    if(count==0){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("No Data Available");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(panel,msg ,"",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                        dm.setRowCount(0);
                    }else{
                        data = new String[count][12];
                        //System.out.println(count);
                        int j = 0;
                        ResultSet rs2 = c.s.executeQuery("select * from customerDetails where datee='"+date+"'"); 
                        while(j < count){
                            while(rs2.next()){
                                data[j][0] = rs2.getString("SrNo");
                                data[j][1] = rs2.getString("fName");
                                data[j][2] = rs2.getString("lName");
                                data[j][3] = rs2.getString("address");
                                data[j][4] = rs2.getString("pincode");
                                data[j][5] = rs2.getString("mobileNo");
                                data[j][6] = rs2.getString("email");
                                data[j][7] = rs2.getString("pName");
                                data[j][8] = rs2.getString("hName");
                                data[j][9] = rs2.getString("rType");
                                data[j][10] = rs2.getString("total");
                                data[j][11] = rs2.getString("datee");
                                j++;
                            }
                            
                        }
                        
                        createTable(data);
                    }
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            
        }
        if(e.getSource()==b2){
            t1.setText("");
            dm.setRowCount(0);
            setVisible(false);
            setVisible(true);
            int cCount=0;
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select count(fName) from customerDetails");
                if(rs.next()){
                    cCount = Integer.parseInt(rs.getString("count(fName)"));
                }
                int j = 0;
                data = new String [cCount][12];
                ResultSet rs2;
                while(j<cCount){
                    rs2 = c.s.executeQuery("select * from customerDetails where SrNo='"+(j+1)+"'");
                    while(rs2.next()){
                        data[j][0] = rs2.getString("SrNo");
                        data[j][1] = rs2.getString("fName");
                        data[j][2] = rs2.getString("lName");
                        data[j][3] = rs2.getString("address");
                        data[j][4] = rs2.getString("pincode");
                        data[j][5] = rs2.getString("mobileNo");
                        data[j][6] = rs2.getString("email");
                        data[j][7] = rs2.getString("pName");
                        data[j][8] = rs2.getString("hName");
                        data[j][9] = rs2.getString("rType");
                        data[j][10] = rs2.getString("total");
                        data[j][11] = rs2.getString("datee");
                    }
                    j++;
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            createTable(data);
        }
    }
    
    public static void main(String args[]){
        new ViewCustomers("");
    }
}
