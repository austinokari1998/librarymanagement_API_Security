package com.librarymanagement.librarymanagement;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.librarymanagement.Users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
@Component
public class JWTfilter extends OncePerRequestFilter{
    @Autowired
    private UsersService userserve;

    @Autowired
    private JWTUtility jwtutils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                final String authheader=request.getHeader("Authorization");
                String Username=null;
                String jwt=null;


                if(authheader!=null && authheader.startsWith("Bearer ")){
                    jwt=authheader.substring(7);
                    Username=jwtutils.extractUsername(jwt);
                }

                if(Username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UserDetails userdet=userserve.loadUserByUsername(Username);
                    if (jwtutils.validateToken(jwt, userdet)){

                        UsernamePasswordAuthenticationToken userpasswordauthtoken=new UsernamePasswordAuthenticationToken(userdet, null, userdet.getAuthorities());
                        userpasswordauthtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(userpasswordauthtoken);
                   
                   
                    }

                }
                filterChain.doFilter(request, response);

    }

    

}
