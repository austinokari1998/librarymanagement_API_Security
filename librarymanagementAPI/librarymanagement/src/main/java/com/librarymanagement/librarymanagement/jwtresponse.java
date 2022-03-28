package com.librarymanagement.librarymanagement;

import org.springframework.stereotype.Component;

//the jwtrequest class is same as the userdto class
@Component
public class jwtresponse {
    private String jwtresponse;

    public jwtresponse(String jwtresponse) {
        this.jwtresponse = jwtresponse;
    }

    public String getJwtresponse() {
        return jwtresponse;
    }

    public void setJwtresponse(String jwtresponse) {
        this.jwtresponse = jwtresponse;
    }
    

    
}
