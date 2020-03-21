package business;

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

public class AccountChecker {
    private userDataStructure data;
    private String passCheck = null;
    
    public AccountChecker(userDataStructure data, String passCheck){
        this.data = data;
        this.passCheck = passCheck;
    }
    
    public AccountChecker(userDataStructure data){
        this.data = data;
    }
    
    public boolean checkPassword(){
        if(data.getPassword().compareTo("")==0 || data.getPassword().length()<5 || data.getPassword().length()>80)
            return false;
        return true;
    }
    
    public boolean checkEmail(){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (data.getEmailAddress().compareTo("")==0) 
            return false; 
        return pat.matcher(data.getEmailAddress()).matches(); 
    }
    
    public boolean checkUsername(){
        if(data.getUsername().compareTo("")==0 || data.getUsername().length()<5 || data.getUsername().length()>80)
            return false;
        return true;
    }
    
    public boolean checkPhoneNumber(){
        if(data.getPhoneNumber().compareTo("")==0 ||  data.getPhoneNumber().length() < 9)
            return false;
        return data.getPhoneNumber().matches("[0-9]+");
    }
}