package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.IComparePriceConfDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.service.IMemcachedCacheManager;
import com.fanqie.util.JacksonUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
@Service
public class ComparePriceConfService implements IComparePriceConfService {
    private static final Logger log = LoggerFactory.getLogger(ComparePriceConfService.class);
    @Resource
    private IComparePriceConfDao comparePriceConfDao;
    @Resource
    private IMemcachedCacheManager memcachedCacheManager;

    @DataSource(name = DataSource.CP)
    @Override
    public int saveComparePriceConf(ComparePriceConf comparePriceConf) {
        return comparePriceConfDao.saveComparePriceConf(comparePriceConf);
    }
    @DataSource(name = DataSource.CP)
    @Override
    public ComparePriceConf selectComparePriceConf() {
        return comparePriceConfDao.selectComparePriceConf();
    }

    @DataSource(name = DataSource.CP)
    @Override
    public ComparePriceConf selectComparePriceConfById(String id) {
        return comparePriceConfDao.selectComparePriceConfById(id);
    }
    
    @DataSource(name = DataSource.CP)
    @Override
    public void configUpdate(ComparePriceConf comparePriceConf)throws  Exception{
        try{
            //保存配置信息
            comparePriceConfDao.configUpdate(comparePriceConf);
            //保存成功后 存到 memcache里面
            memcachedCacheManager.saveObj(comparePriceConf);
        }catch (Exception e){
            log.error("报错配置信息异常",e);
        }

    }
}
