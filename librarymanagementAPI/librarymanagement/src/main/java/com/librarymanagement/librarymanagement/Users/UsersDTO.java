package com.librarymanagement.librarymanagement.Users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="UsersDTO")

public class UsersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer User_ID;
    @Column(name="user_name")
    private String User_name;
    @Column(name="gender")
    
    @Enumerated(EnumType.STRING)
    private Gender  Gender;
    @Column(name="password")
    private String Password;
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Rolegiven Has_role;
    public UsersDTO(Integer user_ID, String user_name, Gender gender,String password, Rolegiven has_role) {
        User_ID = user_ID;
        User_name = user_name;
        Gender = gender;
        Password=password;
        Has_role=has_role;

    }
    public UsersDTO(){

    }
    public Integer getUser_ID() {
        return User_ID;
    }
    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }
    public String getUser_name() {
        return User_name;
    }
    public void setUser_name(String user_name) {
        User_name = user_name;
    }
    public Gender getGender() {
        return Gender;
    }
    public void setGender(Gender gender) {
        Gender = gender;
    }
   
    
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
    public Rolegiven getHas_role() {
        return Has_role;
    }
    public void setHas_role(Rolegiven has_role) {
        Has_role = has_role;
    }
    @Override
    public String toString() {
        return "UsersDTO [Gender=" + Gender + ", Has_role=" + Has_role + ", Password=" + Password + ", User_ID="
                + User_ID + ", User_name=" + User_name + "]";
    }
   
}
    

