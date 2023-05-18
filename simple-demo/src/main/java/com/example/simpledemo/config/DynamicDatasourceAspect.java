package com.example.simpledemo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 利用注解方式切换数据源
 * @author Leo
 */
@Aspect
@Component
public class DynamicDatasourceAspect {

    /**
     * 指定作用于指定 package, 和注解
     * @param joinPoint
     * @param db 注入使用的注解
     */
    @Before("within(com.example.simpledemo.service.*) && @annotation(db)")
    public void before(JoinPoint joinPoint, DB db) {
        String targetDB = db.value();
        DynamicDatasource.sqlType.set(targetDB);
        System.out.println("目标数据源：" + targetDB);
    }

}
