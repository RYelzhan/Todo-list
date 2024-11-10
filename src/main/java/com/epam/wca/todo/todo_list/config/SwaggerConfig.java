package com.epam.wca.todo.todo_list.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@Configuration
public class SwaggerConfig {

    @Value("${todo.api.server.url}")
    private String serverUrl;

    @Value("${todo.api.server.description}")
    private String serverDescription;

    @Value("${todo.api.title}")
    private String apiTitle;

    @Value("${todo.api.description}")
    private String apiDescription;

    @Value("${todo.api.version}")
    private String apiVersion;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server()
                .url(serverUrl)
                .description(serverDescription);

        Info info = new Info()
                .title(apiTitle)
                .description(apiDescription)
                .version(apiVersion);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
