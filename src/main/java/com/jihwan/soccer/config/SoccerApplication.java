package com.jihwan.soccer.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class SoccerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerApplication.class, args);

    }

}
