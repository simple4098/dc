package com.fanqie.dc.controller.pms;


import com.fanqie.dc.common.Param;
import com.fanqie.core.domain.InnActive;
import com.fanqie.core.domain.OperateTrend;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.dc.service.IOperateTrendService;
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
@RequestMapping("/operate")
public class OperateTrendController {
    private static Logger logger = LoggerFactory.getLogger(OperateTrendController.class);
    @Autowired
    private IOperateTrendService operateTrendService;

    @RequestMapping("/data")
    @ResponseBody
    public Object operate(String from,String to){
      final   Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        if (StringUtils.isEmpty(from)){
            from = DateUtil.fromDate(-1);
        }
        if (StringUtils.isEmpty(to)){
            to =  DateUtil.toDate(-1);
        }
        List<OperateTrend> trendService = operateTrendService.findOperateTrendService(from,to);
        operateTrendService.saveOperateTrend(trendService);

        return param;
    }

}
