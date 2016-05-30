package com.fanqie.dc.controller.pms;


import com.fanqie.core.domain.InnCustomer;
import com.fanqie.dc.common.Param;
import com.fanqie.dc.service.IInnCustomerService;
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
    public Object customer(final  String from,final  String to){
        logger.info("====客栈用户统计 start =====");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<InnCustomer> date = null;
                if (StringUtils.isEmpty(from) || StringUtils.isEmpty(to)){
                    String from = DateUtil.fromDate(-1);
                    String to   = DateUtil.toDate(-1);
                    date = innCustomerService.findInnCustomerByDate(from,to);
                    logger.debug("form:"+from+" to:"+from);
                }else {
                    date = innCustomerService.findInnCustomerByDate(from, to);
                    logger.debug("form:"+from+" to:"+to);
                }
                innCustomerService.saveInnCustomer(date);
            }
        };
        Thread t = new Thread(runnable);
        t.start();


        return param;
    }

}
