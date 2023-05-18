package com.example.simpledemo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 目前存在三个 DataSource
 * Primary 设定主要 DataSource
 * AbstractRoutingDataSource 是 Spring 多数据源的抽象实现
 * @author Leo
 */
//@Component
//@Primary
public class DynamicDatasourceFromAbstractRouting extends AbstractRoutingDataSource implements InitializingBean {

    // 当前执行 SQL 类型
    public static ThreadLocal<Object> sqlType = new ThreadLocal<>();

    @Autowired
    private DataSource writeDataSource;

    @Autowired
    private DataSource readDataSource;

    /**
     * 返回当前数据源的标识
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return sqlType.get();
    }


    /**
     * Bean 初始化后执行
     */
    @Override
    public void afterPropertiesSet() {
        // 设置默认数据库
        sqlType.set("W");
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("W", writeDataSource);
        dataSourceMap.put("R", readDataSource);
        // 设定目标数据源
        super.setTargetDataSources(dataSourceMap);
        // 设定默认数据源
        super.setDefaultTargetDataSource(writeDataSource);
        // 调用父类后置处理器进行父类属性初始化
        super.afterPropertiesSet();
    }
}
