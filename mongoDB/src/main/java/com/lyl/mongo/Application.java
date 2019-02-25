package com.lyl.mongo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liuyl
 * @date 2018-10-22-17:50
 * @description
 */
@SpringBootApplication
@MapperScan("com.lyl.mongo.mapper")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


     @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
