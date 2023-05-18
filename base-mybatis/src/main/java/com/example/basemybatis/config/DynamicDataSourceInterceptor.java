package com.example.basemybatis.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 通过 Mybatis Interceptor 拦截器插件方式实现根据SQL类型自动切换数据源
 * 插件目标类： Executor sql 执行类，用于获取SQL类型
 * @author Leo
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class DynamicDataSourceInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取 Executor (query, update 方法) 参数列表
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
            DynamicDatasource.sqlType.set("R");
        } else {
            DynamicDatasource.sqlType.set("W");
        }
        return invocation.proceed();
    }

/*    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }*/
}
