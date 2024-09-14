package com.CodeWithDurgeh.Blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.sql.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
 
	//TemplatePropo
	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKeys() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

private List<SecurityContext> securityContexts(){
		
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}

	private List<SecurityReference> sf() {

		AuthorizationScope scopes = new AuthorizationScope("globle", "accessEvarything");

		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scopes }));
	}

	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();

	}

	private ApiInfo getInfo() {

		return new ApiInfo("Bolgging Application : Backend Course",
				"this project is devloped by learn code with durgesh", "1.0", "terms of Service",
				new Contact("Darshan", "https://learncodewithdurgesh.com", "drathod137@gmail.com"), "License Of APIS",
				"API licens URL", Collections.emptyList());
	}
}
