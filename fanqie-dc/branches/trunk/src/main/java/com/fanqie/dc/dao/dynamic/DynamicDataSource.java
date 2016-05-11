package com.fanqie.dc.dao.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * desc:动态数据源
 * author:lzb
 * date:2015/9/10
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 通过本地数据源配置实现抽象类中数据源key
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }
}
