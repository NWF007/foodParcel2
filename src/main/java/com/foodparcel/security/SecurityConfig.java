package com.foodparcel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "User";
    private static final String ADMIN_ROLE = "Admin";



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("admin123"))
                .roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("User")
                .password(encoder().encode("12345"))
                .roles(USER_ROLE);

    }

    @Override
    protected void configure(HttpSecurity http)  throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/application/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/application/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/application/getApplications").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE,"/application/delete/**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
