package com.fanqie.dc.dao;

import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.dao.base.IBaseDao;
import com.fanqie.dc.dto.ComparePriceDataDto;
import com.fanqie.dc.dto.CrmComparePriceDataDto;

import java.util.List;

/**
 * DESC : 客栈比价数据数据持久化层
 * @author : 番茄木-ZLin
 * @data : 2016/5/17
 * @version: v1.0.0
 */
public interface IComparePriceDataDao extends IBaseDao<ComparePriceData> {
    /**
     * 保存客栈房型 15天的比价数据
     * @param comparePriceDataDto 15天房价数据
     * @return
     */
    int saveComparePrice(ComparePriceDataDto comparePriceDataDto);

    /**
     * 删除某一个客栈 比价数据
     * @param comparePriceDataDto
     * @return
     */
    int deletedComparePrice(ComparePriceDataDto comparePriceDataDto);

    /**
     * CRM查询房价信息
     * @param priceData innId 客栈id
     * @param priceData otaId 渠道表面
     */
    List<CrmComparePriceDataDto> selectComparePrice(ComparePriceData priceData);

    /**
     * 查询比价信息的客栈 名称  时间
     * @param comparePriceData innId 客栈id
     * @param comparePriceData otaId 渠道信息
     */
    ComparePriceData selectInnInfo(ComparePriceData comparePriceData);


}
