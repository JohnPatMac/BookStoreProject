package com.bookstore;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to set up Swagger/OpenAPI documentation
 * for the Bookstore REST API.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Creates the OpenAPI bean to configure API documentation details
     * such as title, description, and version.
     *
     * @return the configured OpenAPI instance
     */
    @Bean
    public OpenAPI bookstoreOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Bookstore API")
                .description("REST API documentation for Bookstore project")
                .version("1.0"));
    }
}
