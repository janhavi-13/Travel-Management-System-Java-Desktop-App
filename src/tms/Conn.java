package tms;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Registering a JDBC driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","@myServer1328");
            //Statement creation
            s = c.createStatement();
        }catch(Exception e){
            
        }
    }
}
