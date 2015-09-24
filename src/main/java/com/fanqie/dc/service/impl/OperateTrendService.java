package com.fanqie.dc.service.impl;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.IOperateTrendDcDao;
import com.fanqie.dc.dao.IOperateTrendPmsDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IOperateTrendService;
import com.fanqie.util.DateUtil;
import com.fanqie.util.DcUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
@Service
public class OperateTrendService implements IOperateTrendService{
    private static Logger logger = LoggerFactory.getLogger(OperateTrendService.class);
    @Autowired
    private IOperateTrendPmsDao operateTrendPmsDao;
    @Autowired
    private IOperateTrendDcDao operateTrendDcDao;

    @DataSource(name = DataSource.PMS)
    @Override
    public List<OperateTrend> findOperateTrendService(String from,String to) {
        return operateTrendPmsDao.findOperateDataByDate(from, to);
    }

    @Override
    public void saveOperateTrend(List<OperateTrend> list) {
        if (!CollectionUtils.isEmpty(list)){
            long start = System.currentTimeMillis();
            for (OperateTrend o:list){
                if (o.getRealLiveNum()!=0){
                    o.setAvgPrice(o.getTotalIncome().divide(new BigDecimal(o.getRealLiveNum()), BigDecimal.ROUND_CEILING));
                }
                o.setLivePercent(DcUtil.divide(o.getRealLiveNum(), o.getTotalRoomNum()));
                o.setEmptyRoomNum(o.getTotalRoomNum()-o.getRealLiveNum());
                operateTrendDcDao.saveOperateTrend(o);
            }
            long end = System.currentTimeMillis();
            logger.info("总共花费:" + (end - start));
            //operateTrendDcDao.saveOperateTrend(list);
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

    @Override
    public Map<String,Object> obtOpeDetail(ParamDto paramDto) {
        List<OperateTrend> list = operateTrendDcDao.obtOpeDetail(paramDto);
        List<String>  date = new ArrayList<String>();
        List<BigDecimal>  income = new ArrayList<BigDecimal>();
        List<Integer>  realLiveNum = new ArrayList<Integer>();
        List<Integer>  totalRooms = new ArrayList<Integer>();
        List<Integer>  emptyRooms = new ArrayList<Integer>();
        List<BigDecimal>  livePercentList = new ArrayList<BigDecimal>();
        List<BigDecimal>  avgPriceList = new ArrayList<BigDecimal>();
        for (OperateTrend operateTrend:list){
            date.add(DateUtil.formatDateToString(operateTrend.getCreatedDate()));
            income.add(operateTrend.getTotalIncome());
            realLiveNum.add(operateTrend.getRealLiveNum());
            livePercentList.add(DcUtil.format(operateTrend.getLivePercent(), 3).multiply(new BigDecimal(100)));
            avgPriceList.add(DcUtil.format(operateTrend.getAvgPrice(), 2));
            totalRooms.add(operateTrend.getTotalRoomNum());
            emptyRooms.add(operateTrend.getEmptyRoomNum());
        }
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("date",date);
        param.put("realLiveNum",realLiveNum);
        param.put("livePercentList",livePercentList);
        param.put("avgPriceList",avgPriceList);
        param.put("income",income);
        param.put("totalRooms",totalRooms);
        param.put("emptyRooms",emptyRooms);
        return param;
    }
}
