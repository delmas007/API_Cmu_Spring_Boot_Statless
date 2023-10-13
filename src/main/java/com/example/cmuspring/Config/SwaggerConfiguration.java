package com.example.cmuspring.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.example.cmuspring.Utils.Constants.Api;


@Configuration
public class SwaggerConfiguration {

   Contact cont = new Contact("By delmas","https://github.com/delmas007/API_Cmu_Spring_Boot","angamancedrick@gmail.com");

    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion dossier patient service CMU")
                                .title("Gestion dossier patient REST API")
                                .contact(cont)
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.delmas.gestiondestock.Controller"))
                .paths(PathSelectors.ant(Api+"/**"))
                .build();
    }

}
