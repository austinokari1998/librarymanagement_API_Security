package com.librarymanagement.librarymanagement.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Myuserdetails implements UserDetails {
    private UsersDTO user;

    


    public Myuserdetails(UsersDTO user) {
        this.user = user;
    }
    public Myuserdetails (){}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        roles.add(new SimpleGrantedAuthority("ROLE" + user.getHas_role()));

        return roles;
        //SimpleGrantedAuthority author=new SimpleGrantedAuthority(user.getHas_role());
        //return Arrays.asList(author);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUser_name();
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
