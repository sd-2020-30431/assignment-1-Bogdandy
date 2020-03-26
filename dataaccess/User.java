package dataaccess;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="userdata")
public class User {
    @Id
    @Column(name = "idUser")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int idUser;
    
    public int getIdUser(){
        return idUser;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    @Column(name = "Username")
    private String username;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    @Column(name = "Password")
    private String password;
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    @Column(name="EmailAddress")
    private String emailAddress;
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    
    @Column(name = "PhoneNumber")
    private int phoneNumber;
    
    public int getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}


