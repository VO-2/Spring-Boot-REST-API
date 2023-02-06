package com.example.ecommerce_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ecommerce_app.user.ApplicationUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    ApplicationUserService applicationUserService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(ApplicationUserService applicationUserService, PasswordEncoder passwordEncoder) {
        this.applicationUserService = applicationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf().disable()
            .authorizeRequests((auth) -> auth
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated())
            .userDetailsService(applicationUserService)
            .headers(headers -> headers.frameOptions().sameOrigin())
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    // @Bean
    // public DaoAuthenticationProvider daoAuthenticationProvider() {
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    //     provider.setUserDetailsService(applicationUserService);
    //     provider.setPasswordEncoder(passwordEncoder);
    //     return provider;
    // }

    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.authenticationProvider(daoAuthenticationProvider());
    // }

}
