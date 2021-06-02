package com.kas.jareddit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.foo.samples.swaggersample"))
                .paths(PathSelectors.any())
                .build();
    }

//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder()
//                .title("JAReddit API")
//                .version("1.0")
//                .description("API for JAReddit Application")
//                .contact(new Contact("Sai Upadhyayula", "https://www.google.com/", "xyz@email.com"))
//                .license("Apache License Version 2.0")
//                .build();
//    }
}
