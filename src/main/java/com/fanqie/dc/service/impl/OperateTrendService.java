package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IOperateTrendDcDao;
import com.fanqie.dc.dao.IOperateTrendPmsDao;
import com.fanqie.dc.domain.OperateTrend;
import com.fanqie.dc.dto.OperateTrendDto;
import com.fanqie.dc.dto.ParamDto;
import com.fanqie.dc.service.IOperateTrendService;
import com.fanqie.util.DcUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
@Service
public class OperateTrendService implements IOperateTrendService{
    @Autowired
    private IOperateTrendPmsDao operateTrendPmsDao;
    @Autowired
    private IOperateTrendDcDao operateTrendDcDao;

    @Override
    public List<OperateTrend> findOperateTrendService(String date) {
        return operateTrendPmsDao.findOperateDataByDate(date);
    }

    @Override
    public void saveOperateTrend(List<OperateTrend> list) {
        if (!CollectionUtils.isEmpty(list)){
            for (OperateTrend o:list){
                if (o.getRealLiveNum()!=0){
                    o.setAvgPrice(o.getTotalIncome().divide(new BigDecimal(o.getRealLiveNum()), BigDecimal.ROUND_CEILING));
                }
                o.setLivePercent(DcUtil.divide(o.getRealLiveNum(), o.getTotalRoomNum()));
                o.setEmptyRoomNum(o.getTotalRoomNum()-o.getRealLiveNum());
            }
            operateTrendDcDao.saveOperateTrend(list);
        }
    }

    @Override
    public OperateTrend obtGeneralOperateTrend(ParamDto paramDto) {
        OperateTrend operateTrend = operateTrendDcDao.obtGeneralOperateTrend(paramDto);
        if (operateTrend!=null){
            operateTrend.setLivePercent(DcUtil.divide(operateTrend.getRealLiveNum(),operateTrend.getTotalRoomNum()));
            operateTrend.setAvgPrice(DcUtil.divide(operateTrend.getTotalIncome(),operateTrend.getRealLiveNum()));
        }
        return operateTrend;
    }
}
