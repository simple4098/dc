package com.fanqie.dc.controller.dc;

import com.fanqie.core.domain.InnCustomer;
import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.domain.OrderSource;
import com.fanqie.core.dto.InnActiveDto;
import com.fanqie.core.dto.OrderSourceDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.dc.service.IInnCustomerService;
import com.fanqie.dc.service.IOperateTrendService;
import com.fanqie.dc.service.IOrderSourceService;
import com.fanqie.util.JsonModel;
import com.fanqie.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * DESC :给第三方系统提供api接口(运营报表)
 * @author : 番茄木-ZLin
 * @data : 2015/5/17
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/api/toms")
public class TomsApiController {
    private static Logger logger = LoggerFactory.getLogger(TomsApiController.class);
    @Autowired
    private IInnCustomerService innCustomerService;
    @Autowired
    private IOperateTrendService operateTrendService;
    @Autowired
    private IInnActiveService innActiveService;
    @Autowired
    private IOrderSourceService orderSourceService;


    /**
     * toms 客户资料接口
     * @param paramDto 查询对象
     * @param pagination 分页对象
     */
    @RequestMapping(value = "/customer")
    @ResponseBody
    public JsonModel operate(ParamDto paramDto,Pagination pagination){
        logger.info("客户资料接口 start");
        JsonModel model = new JsonModel();
        List<InnCustomer> innCustomerByPage = innCustomerService.findInnCustomerByPage(paramDto, pagination);
        model.setRows(innCustomerByPage);
        model.setPagination(pagination);
        return model;
    }

    /**
     * 第三系统 查询一段时间接待多少客人，分布了多少个城市
     * @param paramDto
     * @return
     */
    @RequestMapping(value = "/obtCustomerNum")
    @ResponseBody
    public Object customerNum(ParamDto paramDto){
        logger.info("第三系统 查询一段时间接待多少客人 start");
        return innCustomerService.findInnCustomerNumAndCityNum(paramDto);
    }

    /**
     * 第三系统运营概况数据
     * @param paramDto 查询条件
     * @return
     */
    @RequestMapping(value = "/operate")
    @ResponseBody
    public Object operateTrend(ParamDto paramDto){
        logger.info("第三系统运营概况数据 start");
        OperateTrend operateTrend = operateTrendService.obtGeneralOperateTrend(paramDto);
        return operateTrend;
    }
    /**
     * 第三系统运营详情数据
     * @param paramDto 查询条件
     */
    @RequestMapping(value = "/opeDetail" )
    @ResponseBody
    public Object operateDetail(ParamDto paramDto){
        logger.info("第三系统运营概况数据-详情 start");
        JsonModel jsonModel = new JsonModel();
        Map<String,Object> operateTrendDto = operateTrendService.obtOpeDetail(paramDto);
        jsonModel.setResult(operateTrendDto);
        return jsonModel;
    }
    /**
     * 活跃报表接口
     * @param paramDto 查询条件
     */
    @RequestMapping(value = "/innActive" )
    @ResponseBody
    public Object innActive(ParamDto paramDto,Pagination pagination){
        logger.info("活跃报表接口 start");
        JsonModel jsonModel = new JsonModel();
       // paramDto.setStartDate("2015-04");
        List<InnActiveDto> list = innActiveService.findDcInnActive(paramDto,pagination);
        jsonModel.setRows(list);
        jsonModel.setPagination(pagination);
        return jsonModel;
    }
    /**
     * 订单来源接口
     * @param paramDto 查询条件
     */
    @RequestMapping(value = "/order" )
    @ResponseBody
    public Object order(ParamDto paramDto){
        logger.info("订单来源接口 start");
        JsonModel jsonModel = new JsonModel();
        List<OrderSource> list = orderSourceService.findDcOrderSource(paramDto);
        OrderSourceDto orderSource = orderSourceService.findDcOrderSourceNum(paramDto);
        jsonModel.setRows(list);
        jsonModel.setObj(orderSource);
        return jsonModel;
    }
}
