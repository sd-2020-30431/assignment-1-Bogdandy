package business;

import dataacess.javaconnect;
import java.sql.*;
import javax.swing.JOptionPane;

public class SignUpRequest implements RequestService {
    Connection conn = javaconnect.ConnectDb();
    ResultSet rs;
    PreparedStatement pst;
    
    @Override
    public boolean userRequest(userDataStructure data, String passCheck) {
        String sql = "Insert into userdata values (idUser, ?, ?, ?, ?)";
        AccountChecker accCheck = new AccountChecker(data);
        
        if( accCheck.checkUsername() && accCheck.checkPassword() == true && accCheck.checkEmail() == true && accCheck.checkPhoneNumber())
            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, data.getUsername());
                pst.setString(2, data.getPassword());
                pst.setString(3, data.getEmailAddress());
                pst.setString(4, data.getPhoneNumber());
                pst.execute();
            
                JOptionPane.showMessageDialog(null,"Registration successful!");
                return true;
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error!\n" + ex);
            }
        
        JOptionPane.showMessageDialog(null,"Registration failed!\nPlease check registration credentials!\nNo empty field is allowed!\nUse a proper email address!");
        return false;
    }
}
