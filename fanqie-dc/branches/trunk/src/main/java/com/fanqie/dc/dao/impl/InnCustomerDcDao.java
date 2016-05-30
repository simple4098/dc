package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.InnCustomer;
import com.fanqie.core.dto.InnCustomerDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.IInnCustomerDcDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import com.fanqie.util.Pagination;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
@Repository
public class InnCustomerDcDao extends BaseDaoImpl<InnCustomer> implements IInnCustomerDcDao {
    private static  final String NA = "com.fanqie.dc.dao.IInnCustomerDcDao.";

    @Override
    public void saveInnCustomer(List<InnCustomer> list) {
        Map<String,Object> param = new HashMap<>();
        param.put("list",list);
        this.template.insert(NA.concat("saveInnCustomerList"), param);
    }
    @Override
    public void saveInnCustomer(InnCustomer innCustomer) {
        this.template.insert(NA.concat("saveInnCustomer"),innCustomer);
    }

    public Map<String, Object> queryInnCustomerByPage(ParamDto paramDto, Pagination page) {
        return queryByPage(paramDto,page,NA.concat("queryInnCustomerByPage"));
    }

    public InnCustomerDto findInnCustomerNumAndCityNum(ParamDto paramDto) {
        return template.selectOne(NA.concat("findInnCustomerNumAndCityNum"),paramDto);
    }
}
