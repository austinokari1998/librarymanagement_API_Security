package com.librarymanagement.librarymanagement.Users;

import org.springframework.stereotype.Component;

@Component

public class authenticationrequest {

    private String User_name;
    private String Password;
    public authenticationrequest(String user_name, String password) {
        User_name = user_name;
        Password = password;
    }
    public authenticationrequest() {
    }
    public String getUser_name() {
        return User_name;
    }
    public void setUser_name(String user_name) {
        User_name = user_name;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

}
