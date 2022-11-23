package com.devsuperior.dsmeta.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private Contact contato() {
		return new Contact("Cristian de Mattos", "https://dsmeta-dev-cristian.netlify.app/", "cristian.prof01@gmail.com");
	}

	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Semana SpringReact Dev Superior");
		apiInfoBuilder.description("API utilizada na Semana Springboot e React");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		apiInfoBuilder.license("Licença - Cristian de Mattos");
		apiInfoBuilder.licenseUrl("https://github.com/CristianSilvDev/dsmeta/pull/1/commits/80a1aeedfb3864c9c3caa06c6da5ae5a8c818866");
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage("com.devsuperior.dsmeta.controllers"))
				.paths(PathSelectors.any()).build().apiInfo(this.informacoesApi().build())
				.consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")));

		return docket;
	}
}