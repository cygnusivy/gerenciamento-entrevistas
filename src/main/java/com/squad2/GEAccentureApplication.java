package com.squad2;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@AllArgsConstructor
@Configuration
public class GEAccentureApplication {

        public static void main(String[] args) {
            SpringApplication.run(GEAccentureApplication.class, args);
        }
    }