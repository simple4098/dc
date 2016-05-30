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

    /**
     * 查询默认的配置信息
     * @return
     */
    ComparePriceConf selectComparePriceConf();

    /**
     * 根据id查询 比价配置信息
     * @param id
     */
    ComparePriceConf selectComparePriceConfById(String id);

    /**
     * 更新比价配置信息
     * @param comparePriceConf
     */
    void configUpdate(ComparePriceConf comparePriceConf) throws Exception;
}
