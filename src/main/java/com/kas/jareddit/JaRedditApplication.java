package com.kas.jareddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JaRedditApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaRedditApplication.class, args);
    }

}
