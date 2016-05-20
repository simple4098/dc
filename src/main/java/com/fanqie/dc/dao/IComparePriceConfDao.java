package com.fanqie.dc.dao;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.base.IBaseDao;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
public interface IComparePriceConfDao extends IBaseDao<ComparePriceConf> {

    int saveComparePriceConf(ComparePriceConf comparePriceConf);

    ComparePriceConf selectComparePriceConf();
}
