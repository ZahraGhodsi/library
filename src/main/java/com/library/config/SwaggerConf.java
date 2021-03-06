package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.library.controller"))
                .paths(PathSelectors.any())
                .build().enableUrlTemplating(true);
    }
}
