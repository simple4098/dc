package com.fanqie.dc.service;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.dto.CrmComparePriceDto;

import java.io.IOException;
import java.util.List;

/**
 * DESC : 比价Service 类
 * @author : 番茄木-ZLin
 * @data : 2016/5/12
 * @version: v1.0.0
 */
public interface IComparePriceService {

    /**
     *  比价核心类
     * @param omsComparePriceInnRoom oms 改价数据
     * @param comparePriceConf 比价系统保存的配置信息
     * @throws Exception
     */
    void updateComparePrice( OmsComparePriceInnRoom omsComparePriceInnRoom,ComparePriceConf comparePriceConf) throws Exception;

    /**
     * 保存或者更新比价数据
     * @param list 比价结果集合信息
     */
    void updateOrSaveComparePrice(List<ComparePriceData> list);

    void updateTimerComparePrice();

    CrmComparePriceDto findComparePrice(ComparePriceData comparePriceData)throws Exception;
}
