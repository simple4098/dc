package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.IComparePriceConfDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IComparePriceConfService;
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
    @Resource
    private IComparePriceConfDao comparePriceConfDao;

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
        comparePriceConfDao.configUpdate(comparePriceConf);
    }
}
