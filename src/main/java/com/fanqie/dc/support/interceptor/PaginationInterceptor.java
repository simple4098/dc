package com.fanqie.dc.support.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})    
public class PaginationInterceptor implements Interceptor {
	
	/* (non-Javadoc)  
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)  
	 */    
    public Object intercept(Invocation invocation) throws Throwable {    
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();    
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);    
            
        RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");    
        if(rowBounds == null || rowBounds == RowBounds.DEFAULT){    
            return invocation.proceed();    
        }    
        String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");    
//        DefaultParameterHandler defaultParameterHandler = (DefaultParameterHandler)metaStatementHandler.getValue("delegate.parameterHandler");    
//        Map parameterMap = (Map)defaultParameterHandler.getParameterObject();
//        Object sidx = null;
//        Object sord = null;
//        if(parameterMap != null) {
//        	sidx = parameterMap.get("_sidx");    
//            sord = parameterMap.get("_sord");
//        }
//            
//            
//        
//            
//        if(sidx != null && sord != null){    
//            originalSql = originalSql + " order by " + sidx + " " + sord;    
//        }    
            
        Configuration configuration = (Configuration)metaStatementHandler.getValue("delegate.configuration");    
            
        Dialect.Type databaseType  = null;    
        try{    
            databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());    
        } catch(Exception e){    
            //ignore    
        }    
        if(databaseType == null){    
            throw new RuntimeException("the value of the dialect property in mybatisConfig.xml is not defined : " + configuration.getVariables().getProperty("dialect"));    
        }    
        Dialect dialect = null;    
        switch(databaseType){    
            case ORACLE:    
                dialect = new OracleDialect();    
                break;    
            case MYSQL:
            	dialect = new MySqlDialect();
                break;    
            case POSTGRESQL:
            	dialect =new PostgresqlDialect();
            	break;
                    
        }            
            
        metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()) );    
        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );    
        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );    
            
        return invocation.proceed();    
    }    
    
    /* (non-Javadoc)  
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)  
     */    
    public Object plugin(Object target) {    
        return Plugin.wrap(target, this);    
    }    
    
    /* (non-Javadoc)  
     * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)  
     */    
    public void setProperties(Properties arg0) {    
            
    } 

}
