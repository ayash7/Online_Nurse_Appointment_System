package com.ayash7.online_nurse_appointment_system.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    
    @Bean
    AuthenticationProvider authenticationProvider() {
        
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        
        authenticationProvider.setUserDetailsService(userDetailsService);
        
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        
        return authenticationProvider;
        
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/customer/update/*").hasAuthority("CUSTOMER")
                .requestMatchers("/api/customer/delete/*").hasAuthority("CUSTOMER")
                .requestMatchers("/api/nurse/update/*").hasAuthority("NURSE")
                .requestMatchers("/api/nurse/delete/*").hasAuthority("NURSE")
                .requestMatchers("/api/healthcare/*").hasAuthority("ADMIN")
                .anyRequest().authenticated())
            .exceptionHandling(handling -> handling
                .authenticationEntryPoint(authenticationHandler))
            .httpBasic(Customizer.withDefaults());
            
        return http.build();
        
    }
    
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        
        return (web) -> web.ignoring().requestMatchers("/api/customer/register").requestMatchers("/api/nurse/register").requestMatchers("/error");
        
    }
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationHandler authenticationHandler;
    
}