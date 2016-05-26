package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.IComparePriceConfDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.service.IMemcachedCacheManager;
import com.fanqie.util.JacksonUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/26
 * @version: v1.0.0
 */
@Service
public class MemcachedCacheManager implements IMemcachedCacheManager {

    @Resource
    private MemcachedClient memcachedClient;
    @Resource
    private IComparePriceConfDao comparePriceConfDao;


    @Override
    public void saveObj(ComparePriceConf comparePriceConf) throws Exception {
        memcachedClient.setWithNoReply(comparePriceConf.getOtaCode(), 30*24 * 60 * 60, JacksonUtil.obj2json(comparePriceConf));
    }

    @DataSource(name = DataSource.CP)
    @Override
    public ComparePriceConf getCache(String key) {
        ComparePriceConf comparePriceConf = null;
        try {
            String json = memcachedClient.get(key);
            comparePriceConf = JacksonUtil.json2obj(json, ComparePriceConf.class);
            if (comparePriceConf==null){
                comparePriceConf = comparePriceConfDao.selectComparePriceConf();
            }
        } catch (Exception e) {
            comparePriceConf = comparePriceConfDao.selectComparePriceConf();
        }

        return comparePriceConf;
    }
}
