package com.fanqie.dc.controller.oms;

import com.fanqie.dc.bean.HouseTypeNumber;
import com.fanqie.dc.service.IOmsHouseTypeService;
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
 * DESC : oms客栈可卖房型数量统计
 * @author : xiong
 * @data : 2016/1/22
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/number")
public class HouseTypeNumberController {
	private static Logger logger = LoggerFactory.getLogger(HouseTypeNumberController.class);

	@Autowired
	private IOmsHouseTypeService service;
	
	@RequestMapping("/housetype")
    @ResponseBody
    public Object houseTypeNumber(){
        logger.info("====开始统计inn可卖房型数量=====");
        Map<String,Object> result = new HashMap<>();
        List<HouseTypeNumber> houseType;
        try{
        	houseType = service.getHouseTypeNumber();
            result = service.addToOms(houseType);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("统计inn可卖房型数量失败",e);
            CommonUtil.setErrorInfo(result,"统计inn可卖房型数量失败，错误信息:"+e.getMessage());
            return result;
        }
        return result;
    }

}
