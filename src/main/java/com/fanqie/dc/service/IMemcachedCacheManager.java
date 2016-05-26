package com.fanqie.dc.service;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import javax.annotation.Resource;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/26
 * @version: v1.0.0
 */
public interface IMemcachedCacheManager {


    void saveObj(ComparePriceConf comparePriceConf) throws Exception;

    ComparePriceConf getCache(String key);
}
