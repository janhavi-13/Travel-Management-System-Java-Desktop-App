package tms;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Receipt extends JFrame implements ActionListener{
    JTextArea receipt;
    Receipt(){
        setBounds(100,0,750,840);
        setLayout(null);
        receipt = new JTextArea();
        receipt.setBounds(0,0,750,730);
        receipt.setBackground(Color.WHITE);
        receipt.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        receipt.setText("\n\t\tRef : "+" 40"+"\n ----------------------------------------------------------------------------------------------------------------------"+"\n Name : "+" Janhavi Joshi"+"\n\n Address : "+" Rajveer Heights,Jaragnagar,Kolhapur"+"\n\n Pincode : "+" 416012"+"\n\n Mobile Number : "+" 7249555132"+"\n\n Email : "+" janhavijoshi137@gmail.com"+"\n\n Destination : "+" Udaipur"+" \n\n Package : "+" Fabulous Udaipur!"+"\n\n Hotel : "+" New Romantics"+"\n\n Room Type : "+" -"+"\n\n Total : "+" 15000"+"\n----------------------------------------------------------------------------------------------------------------------------"+"\n\n Date : "+" 26-05-2001"+"\n\n\n\n\t\t\t\tSignature");
        add(receipt);
        
        JButton b = new JButton("Print");
        b.setBounds(100,740,100,30);
        b.addActionListener(this);
        add(b);
                
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
           receipt.print();
        }
        catch(Exception ae){
        }
        
    }
    public static void main(String args[]){
        new Receipt();
    }
}
