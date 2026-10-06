package com.lakshmikandan.primepass.configuration;

import com.lakshmikandan.primepass.security.AuthFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PrimepassConfiguration {

    @Bean
    public LocalDate today(){
        return LocalDate.now();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthFilterChain authFilter){
        http.csrf(customizer->customizer.disable())
                .authorizeHttpRequests(request->request
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/users/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder(12);
    }
//    @Bean
//    public CorsConfigurationSource corsConfig(){
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of("http://localhost:5173"));
//        config.setAllowedHeaders(List.of("*"));
//        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",config);
//        return source;
//    }
}
