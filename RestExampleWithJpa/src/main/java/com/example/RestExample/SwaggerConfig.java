//steps are as follows 
//1.Configuration
//2.Enable Swagger 
//3.Create a bean called DOCKET
//4.Swagger2 version mention
//5.define all the nedpoints i.e the API or links

package com.example.RestExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

		@Bean
		public Docket api()
		{
			return new Docket(DocumentationType.SWAGGER_2);
		}
	
	
	
	
}
