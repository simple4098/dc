package com.fanqie.dc.controller.pms;


import com.fanqie.dc.common.Param;
import com.fanqie.dc.domain.OrderSource;
import com.fanqie.dc.service.IOrderSourceService;
import com.fanqie.util.DateUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
    public Object validateIp(){
      final   Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        String from = "2014-04-05 00:00:00";
        String to = "2014-04-05 23:59:59";
       /* from = DateUtil.fromDate(-1);
        to = DateUtil.toDate(-1);*/

        List<OrderSource> orderSource = orderSourceService.findOrderSource(from, to);
        DateTime dateTime = DateUtil.addDate(-1);
        Date date = DateUtil.dateTimeToDate(dateTime);
        orderSourceService.saveOrderSource(orderSource,date);

        return param;
    }

}
