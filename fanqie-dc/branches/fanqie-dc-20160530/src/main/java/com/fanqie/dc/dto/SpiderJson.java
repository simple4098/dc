package com.fanqie.dc.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class SpiderJson {


    private String begin_date;

    private String end_date;

    private List<SpiderJsonCondition> search_condition;



    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<SpiderJsonCondition> getSearch_condition() {
        return search_condition;
    }

    public void setSearch_condition(List<SpiderJsonCondition> search_condition) {
        this.search_condition = search_condition;
    }
}
