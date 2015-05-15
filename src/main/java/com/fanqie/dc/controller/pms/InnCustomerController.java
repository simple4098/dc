package com.fanqie.dc.controller.pms;


import com.fanqie.dc.common.Param;
import com.fanqie.dc.domain.InnCustomer;
import com.fanqie.dc.domain.OperateTrend;
import com.fanqie.dc.service.IInnCustomerService;
import com.fanqie.dc.service.IOperateTrendService;
import com.fanqie.util.DateUtil;
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
 * DESC : 客栈用户统计
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/inn")
public class InnCustomerController {
    private static Logger logger = LoggerFactory.getLogger(InnCustomerController.class);
    @Autowired
    private IInnCustomerService  innCustomerService;

    @RequestMapping("/customer")
    @ResponseBody
    public Object validateIp(String start){
      final   Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        String from ="2015-04-03 00:00:00";// DateUtil.fromDate(-1);
        String to ="2015-04-03 23:59:59";// DateUtil.toDate(-1);
        List<InnCustomer> date = innCustomerService.findInnCustomerByDate(from, to);

        innCustomerService.saveInnCustomer(date);

        return param;
    }

}
