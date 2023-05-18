package com.example.simpledemo.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.util.DruidDataSourceUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

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

}
