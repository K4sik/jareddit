package com.kas.jareddit;

import com.kas.jareddit.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class JaRedditApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaRedditApplication.class, args);
    }

}
