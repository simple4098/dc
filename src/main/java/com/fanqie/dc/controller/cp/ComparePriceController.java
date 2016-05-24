package com.fanqie.dc.controller.cp;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.common.JsonModel;
import com.fanqie.dc.dto.CrmComparePriceDto;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.service.IComparePriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private IComparePriceConfService comparePriceConfService;

    /**
     * 定时任务执行比价
     * @return
     */
    @RequestMapping("/timer")
    @ResponseBody
    public Object index(){
        JsonModel jsonModel = new JsonModel();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                comparePriceService.updateTimerComparePrice();
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        return  jsonModel;
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


    @RequestMapping("/config")
    public String config(Model model){
        ComparePriceConf comparePriceConf = comparePriceConfService.selectComparePriceConf();
        model.addAttribute("config",comparePriceConf);
        return "config";
    }
    @RequestMapping("/configView")
    public String configView(Model model,String id){
        ComparePriceConf comparePriceConf = comparePriceConfService.selectComparePriceConfById(id);
        model.addAttribute("data",comparePriceConf);
        return "configView";
    }

    @RequestMapping("/configUpdate")
    @ResponseBody
    public Object configUpdate(ComparePriceConf comparePriceConf){

        try {
            comparePriceConfService.configUpdate(comparePriceConf);
            return new JsonModel(200,"更新成功");
        } catch (Exception e) {
            return new JsonModel(400,e.getMessage());
        }

    }
}
