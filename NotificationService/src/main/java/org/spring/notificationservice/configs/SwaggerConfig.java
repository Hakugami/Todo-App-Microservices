package org.spring.notificationservice.configs;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    OpenAPI CustomOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Employee API").version("1.0.0"))
                .info(new Info().title("Department API").version("1.0.0"));
    }
}
