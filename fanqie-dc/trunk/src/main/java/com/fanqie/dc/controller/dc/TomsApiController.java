package com.fanqie.dc.controller.dc;

import com.fanqie.dc.domain.InnCustomer;
import com.fanqie.dc.dto.InnCustomerDto;
import com.fanqie.dc.dto.ParamDto;
import com.fanqie.dc.service.IInnCustomerService;
import com.fanqie.util.JsonModel;
import com.fanqie.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/17
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/api/toms")
public class TomsApiController {
    @Autowired
    private IInnCustomerService innCustomerService;


    /**
     * toms 客户资料接口
     * @param paramDto 查询对象
     * @param pagination 分页对象
     */
    @RequestMapping("/customer")
    @ResponseBody
    public JsonModel operate(ParamDto paramDto,Pagination pagination){
        paramDto.setStartDate("2015-04-03 00:00:00");
        paramDto.setEndDate("2015-04-03 23:59:00");
        paramDto.setTagId("1");
        paramDto.setUserId("2df7667a-6cf4-4320-8449-6483c643ea62");
        paramDto.setInnId(12087);
        paramDto.setDataPermission(false);
        paramDto.setCompanyId("d0392bc8-131c-48a4-846e-c81c66097781");
        paramDto.setTagId("d51c1bad-56a4-420b-aea2-fcace22af546");
        JsonModel model = new JsonModel();
        List<InnCustomer> innCustomerByPage = innCustomerService.findInnCustomerByPage(paramDto, pagination);
        model.setTotal(pagination.getRowsCount());
        model.setRows(innCustomerByPage);
        model.setPage(pagination.getPage());
        return model;
    }

    @RequestMapping("/obtCustomerNum")
    @ResponseBody
    public Object customerNum(ParamDto paramDto){
        paramDto.setUserId("2df7667a-6cf4-4320-8449-6483c643ea62");
        InnCustomerDto customerDto = innCustomerService.findInnCustomerNumAndCityNum(paramDto);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("num",customerDto.getTotalNum());
        map.put("cityName",customerDto.getTotalCityNun());
        JsonModel jsonModel = new JsonModel();
        jsonModel.setResult(map);
        return customerDto;
    }
}
