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
     * @param comparePriceDataDto innId 客栈id
     * @param comparePriceDataDto otaId 渠道表面
     */
    List<CrmComparePriceDataDto> selectComparePrice(ComparePriceDataDto comparePriceDataDto);

    /**
     * 根据房型分组查询，该客栈下有多少房型
     * @param comparePriceDataDto
     */
    List<ComparePriceData> selectComparePriceType(ComparePriceDataDto comparePriceDataDto);

    /**
     * 查询比价信息的客栈 名称  时间
     * @param comparePriceData innId 客栈id
     * @param comparePriceData otaId 渠道信息
     */
    ComparePriceData selectInnInfo(ComparePriceData comparePriceData);

    /**
     * 根据酒店、房型id 查询
     * @param comparePriceData
     */
    ComparePriceData selectComparePriceInnRoomType(ComparePriceData comparePriceData);

    /**
     * 更新之前的房型名称（保证是一直的房型名称）
     * @param comparePriceData
     */
    void updateComparePrice(ComparePriceData comparePriceData);
}
