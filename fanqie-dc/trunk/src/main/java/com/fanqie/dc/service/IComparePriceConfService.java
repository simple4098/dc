package com.fanqie.dc.service;

import com.fanqie.dc.bean.cp.ComparePriceConf;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public interface IComparePriceConfService {

    int saveComparePriceConf(ComparePriceConf comparePriceConf);

    ComparePriceConf selectComparePriceConf();

}
