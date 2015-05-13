package com.fanqie.dc.controller.pms;


import com.fanqie.dc.common.Param;
import com.fanqie.dc.domain.InnActive;
import com.fanqie.dc.service.IInnActiveService;
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
 * DESC : 活跃客栈
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/inn")
public class InnActiveController {
    private static Logger logger = LoggerFactory.getLogger(InnActiveController.class);

    @Autowired
    private IInnActiveService innActiveService;

    @RequestMapping("/active")
    @ResponseBody
    public Object validateIp(){
      final   Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        String from = "2015-05-05 00:00:00";
        String to = "2015-05-05 23:59:59";
        from = DateUtil.fromDate(-1);
        to = DateUtil.toDate(-1);
        List<InnActive> innActive = innActiveService.findDayInnActive(from, to);
        innActiveService.saveInnActive(innActive);

        return param;
    }

}
