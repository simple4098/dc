package com.fanqie.dc.controller.oms;


import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;
import com.fanqie.dc.service.IOmsOrderService;
import com.fanqie.dc.support.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC : 订单统计
 * @author : lei
 * @data : 2015/9/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/stat")
public class OrderStatController {
    private static Logger logger = LoggerFactory.getLogger(OrderStatController.class);

    @Autowired
    private IOmsOrderService service;

    @RequestMapping("/orderStat")
    @ResponseBody
    public Object OrderStat(OrderStatBo bo){
        logger.info("====订单统计 OrderStat=====");
        Map<String,Object> result = new HashMap<>();
        List<OrderStat> orderStats;
        try{
            orderStats = service.getOrderStat(bo);
            result = service.updateToOms(orderStats, bo);
        }catch (Exception e){
            logger.debug("订单统计失败",e);
            CommonUtil.setErrorInfo(result,"订单统计失败，错误信息:"+e.getMessage());
            return result;
        }
        return result;
    }

}
