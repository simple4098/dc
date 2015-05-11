package com.fanqie.dc.controller;


import com.fanqie.dc.common.Param;
import com.fanqie.dc.domain.IPEntity;
import com.fanqie.dc.domain.UserBean;
import com.fanqie.dc.service.IIPService;
import com.fanqie.dc.service.IUserService;
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
 * DESC : ip库Controller
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/test")
public class IPController {
    private static Logger logger = LoggerFactory.getLogger(IPController.class);
    @Autowired
    private IIPService ipService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public Object validateIp(){
      final   Map<String,Object> param = new HashMap<String, Object>();
        param.put("result", Param.SUCCESS);
        List<IPEntity> validIp = ipService.findValidIp(null, null);

        for (IPEntity ipEntity:validIp){
            UserBean userBean = new UserBean();
            userBean.setId(ipEntity.getId());
            userBean.setName(ipEntity.getIp());
            userService.save(userBean);
        }

        return param;
    }


    @RequestMapping("/obt")
    @ResponseBody
    public Object obtIp(){
        Map<String,Object> param = new HashMap<String, Object>();
        List<UserBean> list = userService.findAll();
        param.put("list",list);
        return    param;
    }
}
