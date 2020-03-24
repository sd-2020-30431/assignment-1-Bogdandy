package dataacess;

import java.sql.*;
import javax.swing.JOptionPane;

public class javaconnect {
    Connection conn;
    
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wateless","root","J@lly98@7");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
}
