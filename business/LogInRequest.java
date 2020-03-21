package business;

import dataacess.javaconnect;
import java.sql.*;
import javax.swing.JOptionPane;

public class LogInRequest implements RequestService{
    Connection conn = javaconnect.ConnectDb();
    ResultSet rs;
    PreparedStatement pst;
    
    @Override
    public boolean userRequest(userDataStructure data, String password){
        boolean check = false;
        String sql = "select * from userdata where Username = ? and Password = ?"; 
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, data.getUsername());
            pst.setString(2, data.getPassword());
            rs = pst.executeQuery();
            
            if(rs.next()){
                check = true;
                rs.close();
                pst.close();
            }
            
            if(check == false){
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
            }
            
            return check;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error!\n" + ex);
        }
        return check;
    }
}