package com.fanqie.dc.controller.pms;


import com.fanqie.core.domain.InnActive;
import com.fanqie.dc.common.Param;
import com.fanqie.dc.service.IInnActiveService;
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
@RequestMapping("/inn")
public class InnActiveController {
    private static Logger logger = LoggerFactory.getLogger(InnActiveController.class);

    @Autowired
    private IInnActiveService innActiveService;

    @RequestMapping("/active")
    @ResponseBody
    public Object innActive(final  String from,final  String to){
        logger.info("====活跃客栈 start =====");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int day = 0;
                if (StringUtils.isEmpty(from) || StringUtils.isEmpty(to)){
                    String from = DateUtil.fromDate(-1);
                    String to   = DateUtil.toDate(-1);
                    day = (int)DateUtil.subDay(from,to);
                    for (int i=0;i<day;i++){
                        String from1 = DateUtil.fromDate(i,from);
                        String to1 = DateUtil.toDate(from1);
                        List<InnActive> innActive = innActiveService.findDayInnActive(from1, to1);
                        innActiveService.saveInnActive(innActive,from1);
                    }
                    logger.info("form:" + from + " to:" + to);
                }else {
                    day = (int)DateUtil.subDay( from, to);
                    for (int i=0;i<day;i++){
                        String from1 = DateUtil.fromDate(i,from);
                        String to1 = DateUtil.toDate(from1);
                        List<InnActive> innActive = innActiveService.findDayInnActive(from1, to1);
                        innActiveService.saveInnActive(innActive,from1);
                    }
                    logger.info("form:" + from + " to:" + to);
                }

            }
        };
        Thread t = new Thread(runnable);
        t.start();
        return param;
    }

}
