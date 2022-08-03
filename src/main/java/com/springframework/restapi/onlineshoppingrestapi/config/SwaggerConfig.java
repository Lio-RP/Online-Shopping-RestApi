package com.springframework.restapi.onlineshoppingrestapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI SPRINGsHOPoPENapi(){

        Contact contact = new Contact();
        contact.setName("Liban Abdullahi");
        contact.setEmail("Libanr4243@Gmail.com");

        return new OpenAPI()
                .info(new Info().title("Online Shopping RestAPI Demo")
                        .description("Online Shopping Demo of RESTful web services with Spring")
                        .version("v0.0.1")
                        .termsOfService("Terms of services")
                        .contact(contact)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("More about SpringDoc and OpenAPI 3")
                        .url("https://springdoc.org/"));
    }
}
