package br.com.fiap.beerguide.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Cervejaria API",
                description = "API de Cervejaria",
                version = "1.0"

        )
)
public class SwaggerConfig {


}
