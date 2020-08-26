/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.swaroopwardhinee.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({ "dev", "sit", "uat" })
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(regex("/.*"))
				.build().pathMapping("/")
				.apiInfo(metadata());/*
									 * .securitySchemes(Arrays.asList(apiKey()))
									 * .securityContexts(Collections.singletonList(securityContext()))
									 */
	}

	private ApiInfo metadata() {

		return new ApiInfoBuilder().title("API Services of Swaroopwardhinee")
				.description("This is used to interact with API url's for Testing").version("1.0").build();
	}

	/*
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).forPaths(
	 * PathSelectors.regex("/.*")).build(); }
	 * 
	 * private List<SecurityReference> defaultAuth() { final AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global", "accessEverything");
	 * final AuthorizationScope[] authorizationScopes = new AuthorizationScope[] {
	 * authorizationScope }; return Collections.singletonList(new
	 * SecurityReference("Bearer", authorizationScopes)); }
	 * 
	 * private ApiKey apiKey() { return new ApiKey("Bearer", "Authorization",
	 * "header"); }
	 */
}
