package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IInnCustomerPmsDao;
import com.fanqie.dc.dao.impl.InnCustomerDcDao;
import com.fanqie.dc.domain.InnCustomer;
import com.fanqie.dc.dto.InnCustomerDto;
import com.fanqie.dc.dto.ParamDto;
import com.fanqie.dc.service.IInnCustomerService;
import com.fanqie.dc.support.util.CustomerUtil;
import com.fanqie.util.Constants;
import com.fanqie.util.DcUtil;
import com.fanqie.util.Pagination;
import com.fanqie.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
@Service
public class InnCustomerService implements IInnCustomerService {
    @Autowired
    private IInnCustomerPmsDao innCustomerPmsDao;
    @Autowired
    private InnCustomerDcDao innCustomerDcDao;
    @Override
    public List<InnCustomer> findInnCustomerByDate(String from, String to) {
        return innCustomerPmsDao.findInnCustomer(from,to);
    }

    @Override
    public void saveInnCustomer(List<InnCustomer> list) {
        if (!CollectionUtils.isEmpty(list)){
            for (InnCustomer customer:list){
                CustomerUtil.innCustomerCityAndProvince(customer);
            }
            innCustomerDcDao.saveInnCustomer(list);
        }

    }

    @Override
    public List<InnCustomer> findInnCustomerByPage(ParamDto paramDto, Pagination page) {
        Map<String,Object> map = innCustomerDcDao.queryInnCustomerByPage(paramDto,page);
        InnCustomerDto customerDto = innCustomerDcDao.findInnCustomerNumAndCityNum(paramDto);
        Pagination pagination = (Pagination)map.get("page");
        page.setRowsCount(pagination.getRowsCount());
        List<InnCustomer> list =  (List<InnCustomer>)map.get("list");
        int totalNum = customerDto.getTotalNum();
        for (InnCustomer innCustomer:list){
            if (StringUtils.isEmpty(innCustomer.getCity())){
                innCustomer.setCity(StringUtil.getString(Constants.OTHER_CITY));
            }
            innCustomer.setPercent(DcUtil.divide(innCustomer.getNum(),totalNum));
        }
        return  list;

    }

    @Override
    public InnCustomerDto findInnCustomerNumAndCityNum(ParamDto paramDto) {
        return innCustomerDcDao.findInnCustomerNumAndCityNum(paramDto);
    }
}
