package com.epam.wca.todo.todo_list.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwaggerConfig.class)
public class AppConfig {

}
