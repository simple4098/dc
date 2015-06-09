package com.fanqie.dc.controller.pms;


import com.fanqie.dc.common.Param;
import com.fanqie.core.domain.InnActive;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.util.DateUtil;
import com.fanqie.util.DcUtil;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/inn")
public class InnActiveController {
    private static Logger logger = LoggerFactory.getLogger(InnActiveController.class);

    @Autowired
    private IInnActiveService innActiveService;

    @RequestMapping("/active")
    @ResponseBody
    public Object innActive(String from,String to){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        if (StringUtils.isEmpty(from)){
            from = DateUtil.fromDate(-1);
        }
        if (StringUtils.isEmpty(to)){
            to =  DateUtil.toDate(-1);
        }
        int day = (int)DateUtil.subDay(from, to);
        if (day>0){
            for (int i=0;i<day;i++){
               String from1 = DateUtil.fromDate(i,from);
               String to1 = DateUtil.toDate(from1);
               List<InnActive> innActive = innActiveService.findDayInnActive(from1, to1);
               innActiveService.saveInnActive(innActive,from1);
            }
        }else {
            List<InnActive> innActive = innActiveService.findDayInnActive(from, to);
            innActiveService.saveInnActive(innActive,from);
        }

        return param;
    }

}
