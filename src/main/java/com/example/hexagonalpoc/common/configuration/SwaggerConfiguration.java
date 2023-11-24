package com.example.hexagonalpoc.common.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(getInfo()).servers(getServerList());
    }

    private Info getInfo() {
        return new Info().title("BookSpider - PISS").description("PISS API 명세서").version("v1");
    }

    private List<Server> getServerList() {
        // TODO: 변경
        Server devServer = new Server().url("http://www.dev.bookspider.co.kr");
        Server prodServer = new Server().url("http://www.bookspider.co.kr");
        return List.of(devServer, prodServer);
    }
}
