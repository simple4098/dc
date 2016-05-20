package com.fanqie.dc.dao.impl;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.IComparePriceConfDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
@Repository
public class ComparePriceConfDao extends BaseDaoImpl<ComparePriceConf> implements IComparePriceConfDao {
    private String NA = "com.fanqie.dc.dao.IComparePriceConfDao.";
    @Override
    public int saveComparePriceConf(ComparePriceConf comparePriceConf) {
        return this.template.insert(NA.concat("saveComparePriceConf"),comparePriceConf);
    }

    @Override
    public ComparePriceConf selectComparePriceConf() {
        return template.selectOne(NA.concat("selectComparePriceConf"));
    }
}
