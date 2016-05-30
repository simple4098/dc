package com.fanqie.dc.controller.pms;


import com.fanqie.core.domain.OrderSource;
import com.fanqie.dc.common.Param;
import com.fanqie.dc.service.IOrderSourceService;
import com.fanqie.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
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
 * DESC : 活跃客栈
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/order")
public class OrderSourceController {
    private static Logger logger = LoggerFactory.getLogger(OrderSourceController.class);

    @Autowired
    private IOrderSourceService orderSourceService;

    @RequestMapping("/source")
    @ResponseBody
    public Object order(final String from,final String to){
        logger.info("====订单来源 start =====");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        orderSourceService.findOrderSource(from, to);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<OrderSource> orderSource = null;
                if (StringUtils.isEmpty(from) || StringUtils.isEmpty(to)){
                    String from = DateUtil.fromDate(-1);
                    String to   = DateUtil.toDate(-1);
                    logger.debug("form:"+from+" to:"+to);
                    orderSource = orderSourceService.findOrderSource(from, to);
                }else {
                    orderSource = orderSourceService.findOrderSource(from, to);
                    logger.debug("form:"+from+" to:"+to);
                }
                orderSourceService.saveOrderSource(orderSource);
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        return param;
    }

}
