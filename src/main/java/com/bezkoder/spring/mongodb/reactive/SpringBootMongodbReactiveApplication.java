package com.bezkoder.spring.mongodb.reactive;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "APIs", version = "1.0", description = "Documentation tutorial APIs v1.0"))
public class SpringBootMongodbReactiveApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMongodbReactiveApplication.class, args);
  }

}
