package com.iprogrammer.javatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Employee Management API")
						.description("Documenatation(service contract) for Employee Management API").version("v0.0.1")
						.license(new License().name("Test 1.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("").url("https://github.com/PrasadRBhojane/i_programmer_test.git"));
	}
}
