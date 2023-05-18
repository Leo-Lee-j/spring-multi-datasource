package com.example.basemybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Leo
 */
@Configuration
public class DynamicDatasourceConfig {

    /**
     * 注入自定义不同的数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.write-db")
    public DataSource writeDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 注入自定义不同的数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.read-db")
    public DataSource readDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * Mybatis 自动装配类自动注入插件
     * {@link MybatisPlusAutoConfiguration}
     * @return
     */
    @Bean
    public Interceptor dynamicDataSourcePlugin() {
        return new DynamicDataSourceInterceptor();
    }

}
