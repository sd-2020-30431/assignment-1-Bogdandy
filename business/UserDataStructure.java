/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author User
 */
public class UserDataStructure {
    private String username;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    
    public UserDataStructure(String username, String password, String emailAddress,String phoneNumber){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String username){
        this.username = username;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    
    public String getUsername(){
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
