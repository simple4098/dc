package com.fanqie.dc.aop;

import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.dao.dynamic.DataSourceHolder;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * desc:
 * author:lzb
 * date:2015/9/14
 */
public class DynamicDataSourceAop {

    /**
     * 设置动态数据源指定数据源
     * @param joinPoint
     */
    public void beforeAdvice(JoinPoint joinPoint){
        Class<?> aClass = joinPoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Method declaredMethod = null;
        try {
            //获取当前service方法
            declaredMethod = aClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            logger.debug("=============beforeServiceAdvice=========获取当前方法出错============");
            logger.debug("错误信息:" + e.getMessage());
        }
        //判断当前方法是否含有指定注解标签
        if(declaredMethod.isAnnotationPresent(DataSource.class)){
            DataSource annotation = declaredMethod.getAnnotation(DataSource.class);
            DataSourceHolder.setDataSource(annotation.name());
        }else{
            DataSourceHolder.setDataSource(DataSource.DC);
        }
    }

    /**
     * 清空数据源设置
     */
    public void afterAdvice(){
        DataSourceHolder.clearDataSource();
    }

    protected transient final Logger logger  =  Logger.getLogger(this.getClass());

}
