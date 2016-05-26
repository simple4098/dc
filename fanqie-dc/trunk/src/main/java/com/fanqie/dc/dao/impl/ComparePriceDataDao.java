package com.fanqie.dc.dao.impl;

import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.dao.IComparePriceDataDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import com.fanqie.dc.dto.ComparePriceDataDto;
import com.fanqie.dc.dto.CrmComparePriceDataDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/17
 * @version: v1.0.0
 */
@Repository
public class ComparePriceDataDao extends BaseDaoImpl<ComparePriceData> implements IComparePriceDataDao {

    private String NA = "com.fanqie.dc.dao.IComparePriceDataDao.";
    @Override
    public int saveComparePrice(ComparePriceDataDto param) {
        return template.update(NA+"saveComparePrice",param);
    }

    @Override
    public int deletedComparePrice(ComparePriceDataDto comparePriceData) {
        return template.update(NA+"deletedComparePrice",comparePriceData);
    }

    @Override
    public List<CrmComparePriceDataDto> selectComparePrice(ComparePriceDataDto priceData) {
        return template.selectList(NA+"selectComparePrice",priceData);
    }

    @Override
    public ComparePriceData selectInnInfo(ComparePriceData comparePriceData) {

        return template.selectOne(NA+"selectInnInfo", comparePriceData);
    }
}
