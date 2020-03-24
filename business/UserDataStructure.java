package business;

public class UserDataStructure {
    private String username;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private String passCheck;
    
    public UserDataStructure(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public UserDataStructure(String username, String password, String emailAddress,String phoneNumber, String passCheck){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passCheck = passCheck;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassCheck(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
}
