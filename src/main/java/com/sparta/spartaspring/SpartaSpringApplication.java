package com.sparta.spartaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpartaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpringApplication.class, args);
    }

}
