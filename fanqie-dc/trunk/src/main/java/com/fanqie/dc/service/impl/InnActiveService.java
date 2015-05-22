package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IInnDcActiveDao;
import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.domain.InnActive;
import com.fanqie.dc.dto.InnActiveDto;
import com.fanqie.dc.dto.ParamDto;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
@Service
public class InnActiveService implements IInnActiveService {
    @Autowired
    private IInnPmsActiveDao innPmsActiveDao;
    @Autowired
    private IInnDcActiveDao innDcActiveDao;

    @Override
    public List<InnActive> findDayInnActive(String startDate, String endDate) {
        return innPmsActiveDao.findDayInnActive(startDate,endDate);
    }

    @Override
    public void saveInnActive(List<InnActive> innActive,String from) {
        if (!CollectionUtils.isEmpty(innActive)){
           // Date now = DateUtil.addDay(new Date(), -1);
            Date date = DateUtil.parseDate(from);
            innDcActiveDao.saveInnActive(innActive,date);
        }

    }

    @Override
    public List<InnActiveDto> findDcInnActive(ParamDto paramDto) {
        List<Date> dates = DateUtil.mouthDays(paramDto.getStartDate());
        List<InnActiveDto> list = innDcActiveDao.findDcInnActive(paramDto);
        if (!CollectionUtils.isEmpty(dates)){
            String startDate = DateUtil.formatDateToString(dates.get(0), "yyyy-MM-dd 00:00:00");
            String endDate = DateUtil.formatDateToString(dates.get(dates.size()-1),"yyyy-MM-dd 23:59:59");
            paramDto.setStartDate(startDate);
            paramDto.setEndDate(endDate);
            if (!CollectionUtils.isEmpty(list)){
                List<Integer> valueList = null;
                for (InnActiveDto activeDto:list){
                    valueList = new ArrayList<Integer>();
                    String createDates = activeDto.getCreateDates();
                    String[] dateCreate = createDates.split(",");
                    String[] checkInNumList = activeDto.getCheckInNumList().split(",");
                    String[] operateNumList = activeDto.getOperateNumList().split(",");
                    String[] orderNumList = activeDto.getOrderNumList().split(",");
                    for (Date date:dates){
                        String d = DateUtil.formatDateToString(date, "yyyy-MM-dd");
                        for (int i=0;i<dateCreate.length;i++){
                            if (d.equals(dateCreate[i])){
                                String checkInNum = checkInNumList[i];
                                String orderNum = orderNumList[i];
                                String operateNum = operateNumList[i];
                                if (Integer.valueOf(checkInNum)>0){
                                    valueList.add(3);
                                    continue;
                                }else if (Integer.valueOf(orderNum)>0){
                                    valueList.add(2);
                                    continue;
                                }else if (Integer.valueOf(operateNum)>0){
                                    valueList.add(1);
                                    continue;
                                }else {
                                    valueList.add(0);
                                    continue;
                                }
                            }else {
                                valueList.add(0);
                            }
                        }
                    }
                    activeDto.setActiveList(valueList);
                }
            }
        }
        return list;
    }
}
