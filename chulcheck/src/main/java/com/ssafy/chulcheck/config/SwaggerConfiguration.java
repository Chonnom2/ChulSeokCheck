package com.ssafy.chulcheck.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info().version("1.0.0").title("출석체크 Api").description("출석체크 Api for Developers");
        return new OpenAPI().info(info);
    }
}
