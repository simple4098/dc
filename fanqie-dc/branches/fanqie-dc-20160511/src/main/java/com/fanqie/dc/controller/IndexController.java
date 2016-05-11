package com.fanqie.dc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/8/25
 * @version: v1.0.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/timer")
    public String timer(){
        return "old_data";
    }
}
