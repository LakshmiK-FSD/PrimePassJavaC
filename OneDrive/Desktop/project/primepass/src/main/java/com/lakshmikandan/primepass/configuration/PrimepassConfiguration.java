package com.lakshmikandan.primepass.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class PrimepassConfiguration {
    @Bean
    public LocalDate today(){
        return LocalDate.now();
    }
}
