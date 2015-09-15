package com.fanqie.dc.dao.dynamic;

/**
 * desc:数据源类型监控
 * author:lzb
 * date:2015/9/10
 */
public class DataSourceHolder {

    //持有本地线程环境
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getDataSource(){
        if(threadLocal.get() != null && threadLocal.get().length() >= 0){
            return threadLocal.get();
        }else{
            return DataSource.DC;
        }
    }

    public static void setDataSource(String dataSource){
        threadLocal.set(dataSource);
    }

    public static void clearDataSource(){
        threadLocal.remove();
    }


}
