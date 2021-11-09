package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Connected");
	}
		@Bean
		public ObjectMapper serializingObjectMapper() {
		    ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		    objectMapper.registerModule(new JavaTimeModule());
		    return objectMapper;
		}
		@Bean
		   public Docket productApi() {
		      return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com")).build();
		   }
	

	}


