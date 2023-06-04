package com.ssafy.chulcheck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private String version = "V1";
    private String title = "출석체크 API " + version;

    private ApiInfo apiInfo(){
        String descript = "출석체크 API Reference for Developers<br>";
        return new ApiInfoBuilder().title(title).description(descript)
                .contact(new Contact("GyeongHoCho", "...", "hyerdd@naver.com")).version("1.0").build();
    }


    @Bean
    public Docket allApi(){
        return null;
    }

    public Docket getDocket(String groupName, Predicate<String> predicate){
        return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any()).paths(predicate).build();
    }
}
