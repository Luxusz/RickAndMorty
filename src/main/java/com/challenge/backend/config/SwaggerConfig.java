package com.challenge.backend.config;

import org.springframework.context.annotation.Bean;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(regex("/proyecto.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Backend Challenge API",
				"Find Data API description",
				"1.0",
				"",
				"Francisco",
				"License",
			    "License url")
			   ;
				
	}

}
