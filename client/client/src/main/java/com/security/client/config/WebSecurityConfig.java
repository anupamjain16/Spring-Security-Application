package com.security.client.config;

import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@EnableWebSecurity
@Component
public class WebSecurityConfig{

    private static  final String[] WHITE_LIST_URL = { "/hello" , "/register"};
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder(11);
    }


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////                http.cors().and().csrf().disable();
//////                .authorizeHttpRequests()
//////                .requestMatchers(WHITE_LIST_URL).permitAll();
//
// http
//                .authorizeRequests(authorize -> authorize
//                        .requestMatchers("/hello/**", "/register/**").permitAll() // Permit access to these URLs
//                        .anyRequest().authenticated()
//                )
//                .csrf().disable();
//
//        return  http.build();
//
//    }


}
