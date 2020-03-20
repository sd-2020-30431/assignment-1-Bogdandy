package business;

import dataacess.javaconnect;
import java.sql.*;
import javax.swing.JOptionPane;

public class userDataRequest implements requestService{
    Connection conn = javaconnect.ConnectDb();
    ResultSet rs;
    PreparedStatement pst;
    
    @Override
    public boolean requestLogIn(String userId, String password){
        boolean check = false;
        String sql = "select * from userdata where Username = ? and Password = ?"; 
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, password);
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

    @Override
    public void requestSignUp(userDataStructure data) {
        String sql = "Insert into userdata values (idUser, ?, ?, ?, ?)";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, data.getUsername());
            pst.setString(2, data.getPassword());
            pst.setString(3, data.getEmailAddress());
            pst.setString(4, data.getPhoneNumber());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Registration successful!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error!\n" + ex);
        }
    }
}
