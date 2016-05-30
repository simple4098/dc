package com.fanqie.dc.dao;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.dao.base.IBaseDao;

/**
 * DESC : 渠道配置比价配置dao层
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
public interface IComparePriceConfDao extends IBaseDao<ComparePriceConf> {

    /**
     * 保存比价配置信息
     * @param comparePriceConf
     */
    int saveComparePriceConf(ComparePriceConf comparePriceConf);

    /**
     * 查询默认的比较配置信息
     * @return
     */
    ComparePriceConf selectComparePriceConf();

    /**
     *
     * @param id 根据id查询比价配置信息
     * @return
     */
    ComparePriceConf selectComparePriceConfById(String id);

    /**
     * 更新比价配置
     * @param comparePriceConf
     */
    void configUpdate(ComparePriceConf comparePriceConf)throws Exception;
}
