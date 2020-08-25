package com.ai.higher.mybatis.v1;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.InterceptorChain;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
@Intercepts({
        @Signature(type= StatementHandler.class,method = "query",args = {Statement.class, ResultHandler.class}),
        @Signature(type= StatementHandler.class,method = "update",args = {Statement.class}),
        @Signature(type= StatementHandler.class,method = "batch",args = {Statement.class})
})
public class SqlCostTimeInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(SqlCostTimeInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        long startTime = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) target;
        try {
            return invocation.proceed();
        }finally {
            long costTime = System.currentTimeMillis() - startTime;
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();
            logger.info("执行SQL：[{}]执行耗时[{}ms]",sql,costTime);
        }
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息： "+properties);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
