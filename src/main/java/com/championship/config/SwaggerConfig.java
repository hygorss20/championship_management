package com.championship.config;

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
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    protected static final String TITLE = "TRABALHO FINAL";
    protected static final String DESCRIPTION = "API REST";
    protected static final String VERSION = "1.0";
    protected static final String LICENSE = "APACHE LICENSE VERSION 2.0";
    protected static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    protected static final String CONTACT_NAME = "PUC MINAS";
    protected static final String URL = "https://gitlab.com/championship_management";
    protected static final String EMAIL = "";

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.championship"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfoBuilder().title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, URL, EMAIL))
                .license(LICENSE)
                .licenseUrl(LICENSE_URL)
                .build();
    }
}
