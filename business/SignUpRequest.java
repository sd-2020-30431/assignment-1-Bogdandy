package business;

import dataaccess.SignUpQuery;
import javax.swing.JOptionPane;

public class SignUpRequest implements RequestService {
    
    @Override
    public boolean userRequest(UserDataStructure data) {
        boolean successful = false;
       
        AccountChecker accountChecker = new AccountChecker(data);
        
        if(accountChecker.checkAllFields() == true){
            SignUpQuery signUpQuery = new SignUpQuery(data);
            successful = signUpQuery.doQuery();
        }else{
            JOptionPane.showMessageDialog(null, "CE PLM");
        }
        
        return successful;
    }
}

