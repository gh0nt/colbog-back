package com.colbog.colbogMs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de COL-BOG")
                        .version("1.0")
                        .description("Documentación de la API de Mi Proyecto")
                        .contact(new Contact()
                                .name("Soporte")
                                .email("soporte@miempresa.com")
                                .url("https://www.miempresa.com"))
                        .license(new License()
                                .name("Licencia MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
