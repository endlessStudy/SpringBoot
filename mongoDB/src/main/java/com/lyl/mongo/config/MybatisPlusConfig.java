package com.lyl.mongo.config;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.Format;


/**
 * @Author liuyl
 * @date 2018-10-30-16:13
 * @description
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.lyl.mongo.mapper")
public class MybatisPlusConfig {
    /**
     * SQL执行效率插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
     @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
