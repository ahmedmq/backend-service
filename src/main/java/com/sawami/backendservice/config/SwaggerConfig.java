package com.sawami.backendservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI backendServiceApi() {
		return new OpenAPI()
				.info(new Info().title("Sawami Backend Service API Specification")
						.description("Swagger Documentation for Sawami Backend API")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http:/demo.org")))
				.externalDocs(new ExternalDocumentation()
						.description("Sawami Backend Service Wiki Documentation")
						.url("https://sawami.com"));
	}
}