package com.movieflix.Config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        Info info = new Info();
        info.title("Movieflix");
        info.version("v1");
        info.description("Aplicação para gerenciamento de catálogo de fimes");

        Contact contact = new Contact();
        contact.name("Bryan Rodrigues da Rosa");
        contact.email("bryanrodriguesdarosa@gmail.com");
        contact.url("https://github.com/Bryan-Rodrigues97");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
