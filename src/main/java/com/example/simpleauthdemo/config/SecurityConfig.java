package com.example.simpleauthdemo.config;

import com.example.simpleauthdemo.utility.JwtFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/api/**").permitAll().anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
