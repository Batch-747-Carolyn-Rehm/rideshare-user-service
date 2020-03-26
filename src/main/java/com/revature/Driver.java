package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.geolocationResponse.GeoLocationResponse;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Driver class is the main class for this project.
 * 
 * @author Adonis Cabreja
 *
 */

@SpringBootApplication
@EnableSwagger2
public class Driver {
	/**
	 * The main method of the Driver class.
	 * 
	 * @param args represents any CLI arguments.
	 * @throws Exception
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(Driver.class, args); 
		
		//test making request to GeoLocationAPI and parse response
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=1001+s+center+st,+Arlington+TX+76010&key=AIzaSyDdU7KMs5IfYmqJXmYZc8MzL_8fN3z5Hec";
		GeoLocationResponse gr = restTemplate.getForObject(url, GeoLocationResponse.class);
		System.out.println(gr.getResults().get(0).getFormatted_address());
	}
	
	/**
	 * apiInfo consists of metadata for the swagger page.
	 * 
	 * @return An ApiInfoBuilder which is used to add custom metadata to a swagger page.
	 */
	
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("RideShare User Service")
            .description("API Documentation for User Service")
            .version("1.0.0")
            .build();
    }
	
    /**
     * api is needed for swagger to know what api it will be working with.
     * 
     * @return A Docket which selects the api, builds it and also adds custom apiInfo.
     */
    
	@Bean
	public Docket api() {
		return new Docket (DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.revature"))
			.build()
			.apiInfo(apiInfo());
	}
	
	
	
}
