package com.boot.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket configure() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.boot.ws"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiInfo());
		
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		/*
		 * return new ApiInfo("BootSwagger App", "Sample Desc", "3.1",
		 * "http://nareshit/", 1, 22, new ArrayList<Object>());
		 */
		return new ApiInfo("BootSwagger App", "Sample Desc", "3.1", "http://nareshit/", "contact", "https:/nareshit", "new ArrayList()");
	}
	/*
	 * public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * //enabling swagger-ui part for visual documentation
	 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	 * "classpath:/META-INF/resources/");
	 * registry.addResourceHandler("/webjars/**").addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/"); }
	 */

}
