package com.librarymanagement.librarymanagement;

import com.librarymanagement.librarymanagement.Users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@EnableWebSecurity
public class librarysecurity extends WebSecurityConfigurerAdapter {
    
  @Autowired 
  private UsersService userserve;

  @Autowired
  private JWTfilter jwTfilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        //allow the authenticate endpoint to be accessed without implicit authentication from spring, 
        .antMatchers("/authenticate").permitAll()
        
            .antMatchers(HttpMethod.PATCH, "/total_users/**/**").hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.POST,"/total_users/**", "/books").hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.POST, "/total_users").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/total_users", "/books").hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.DELETE, "/total_users/**", "/books/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/total_users/**", "books/**").hasAnyRole("ADMIN", "USER")
            
            
            

            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.addFilterBefore(jwTfilter, UsernamePasswordAuthenticationFilter.class);
    }


    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    

    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userserve);
        provider.setPasswordEncoder(encoder());
        return provider;
    }

    
    
}
