package com.fanqie.dc.service.impl;

import com.fanqie.core.domain.InnActive;
import com.fanqie.core.dto.InnActiveDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.common.Param;
import com.fanqie.dc.dao.IInnDcActiveDao;
import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.util.DateUtil;
import com.fanqie.util.Pagination;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
@Service
public class InnActiveService implements IInnActiveService {
    private static Logger logger = LoggerFactory.getLogger(InnActiveService.class);
    @Autowired
    private IInnPmsActiveDao innPmsActiveDao;
    @Autowired
    private IInnDcActiveDao innDcActiveDao;

    @DataSource(name = DataSource.PMS)
    @Override
    public List<InnActive> findDayInnActive(String startDate, String endDate) {
        return innPmsActiveDao.findDayInnActive(startDate,endDate);
    }

    @Override
    public void saveInnActive(List<InnActive> innActive,String from) {
        if (!CollectionUtils.isEmpty(innActive)){
            long start = System.currentTimeMillis();
            Date date = DateUtil.parseDate(from);
            for (InnActive active:innActive){
                innDcActiveDao.saveInnActive(active,date);
            }
            long end = System.currentTimeMillis();
            logger.info("saveInnActive time :"+(end-start));
            //innDcActiveDao.saveInnActive(innActive,date);
        }

    }

    @Override
    public List<InnActiveDto> findDcInnActive(ParamDto paramDto,Pagination page) {
        List<Date> dates = DateUtil.mouthDays(paramDto.getStartDate());
        String startDate1 = DateUtil.formatDateToString(dates.get(0), "yyyy-MM-dd 00:00:00");
        String endDate1 = DateUtil.formatDateToString(dates.get(dates.size()-1),"yyyy-MM-dd 23:59:59");
        paramDto.setStartDate(startDate1);
        paramDto.setEndDate(endDate1);
        Map<String, Object> objectMap = innDcActiveDao.findDcInnActivePage(paramDto, page);
        List<InnActiveDto> list  =  (List<InnActiveDto>)objectMap.get("list");
        if (!CollectionUtils.isEmpty(dates)){
            if (!CollectionUtils.isEmpty(list)){
                List<Integer>  valueList =null;
                String[] checkInNumList;
                String[] operateNumList;
                String[] orderNumList;
                String checkInNum ;
                String orderNum;
                String operateNum;
                for (InnActiveDto activeDto:list){
                    valueList = new ArrayList<Integer>();
                    String createDates = activeDto.getCreateDates();
                    String[] dateCreate = createDates.split(",");
                    List<String> dateCreateList = Arrays.asList(dateCreate);
                    checkInNumList = activeDto.getCheckInNumList().split(",");
                    operateNumList = activeDto.getOperateNumList().split(",");
                    orderNumList = activeDto.getOrderNumList().split(",");
                    //for (Date date:dates){
                    for (int i=0;i<dates.size();i++){
                        Date date = dates.get(i);
                        String d = DateUtil.formatDateToString(date, "yyyy-MM-dd");
                        if (dateCreate.length>i && dateCreateList.contains(d)){
                            int y = dateCreateList.indexOf(d);
                            checkInNum = checkInNumList[y];
                            orderNum = orderNumList[y];
                            operateNum = operateNumList[y];
                            if (Integer.valueOf(checkInNum)>0){
                                valueList.add(Param.RU_ZHU);
                                continue;
                            }else if (Integer.valueOf(orderNum)>0){
                                valueList.add(Param.CREATE_ORDER);
                                continue;
                            }else if (Integer.valueOf(operateNum)>0){
                                valueList.add(Param.OPERATE);
                                continue;
                            }else {
                                valueList.add(Param.NO_OPERATE);
                                continue;
                            }
                        }else {
                            valueList.add(Param.NO_OPERATE);
                        }
                    }
                    activeDto.setActiveList(valueList);
                }
            }
        }
        return list;
    }
}
