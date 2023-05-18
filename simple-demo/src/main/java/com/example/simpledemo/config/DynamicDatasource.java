package com.example.simpledemo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * 目前存在三个 DataSource
 * Primary 设定主要 DataSource
 * @author Leo
 */
@Component
@Primary
public class DynamicDatasource implements DataSource, InitializingBean {

    // 当前执行 SQL 类型
    public static ThreadLocal<Object> sqlType = new ThreadLocal<>();

    @Autowired
    private DataSource writeDataSource;

    @Autowired
    private DataSource readDataSource;

    @Override
    public Connection getConnection() throws SQLException {
        if (sqlType.get().equals("W")) {
            return writeDataSource.getConnection();
        }
        return readDataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }


    /**
     * Bean 初始化后执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 设置默认数据库
        sqlType.set("W");
    }
}
