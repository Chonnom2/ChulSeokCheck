package com.ssafy.chulcheck.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


// 설정파일 불러오기 위한 클래스
@Configuration
public class PropertyConfiguration {
    @Bean(name = "system")
    public PropertiesFactoryBean propertiesFactoryBean() throws Exception{
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        ClassPathResource classPathResource = new ClassPathResource("settings/system.properties"); // 경로 편하게 쓰기 위해서

        propertiesFactoryBean.setLocation(classPathResource);

        return propertiesFactoryBean;
    }
}
