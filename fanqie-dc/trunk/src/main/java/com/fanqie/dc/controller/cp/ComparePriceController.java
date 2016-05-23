package com.fanqie.dc.controller.cp;

import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.common.JsonModel;
import com.fanqie.dc.dto.CrmComparePriceDto;
import com.fanqie.dc.service.IComparePriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * DESC : 全量更新比价信息
 * @author : 番茄木-ZLin
 * @data : 2016/5/17
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/compare")
public class ComparePriceController {
    @Resource
    private IComparePriceService comparePriceService;

    /**
     * 定时任务执行比价
     * @return
     */
    @RequestMapping("/timer")
    @ResponseBody
    public Object index(){
        comparePriceService.updateTimerComparePrice();
        return null;
    }

    /**
     * crm 查询比价信息
     * @return
     */
    @RequestMapping("/price")
    @ResponseBody
        public Object crmPrice(ComparePriceData comparePriceData){
        JsonModel jsonModel = new JsonModel();
        try{
            CrmComparePriceDto crmComparePriceDto = comparePriceService.findComparePrice(comparePriceData);
            jsonModel.setObj(crmComparePriceDto);
            jsonModel.setStatus(Constants.HTTP_SUCCESS);
            return  jsonModel;
        }catch (Exception e){
            jsonModel.setStatus(Constants.HTTP_ERROR);
        }
        return jsonModel;
    }

}
