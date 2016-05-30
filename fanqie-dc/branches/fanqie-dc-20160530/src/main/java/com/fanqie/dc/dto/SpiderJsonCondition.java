package com.fanqie.dc.dto;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class SpiderJsonCondition {


    //醒询关键字	string	hotel_id foreign_id room_type_id
    private String search_key;
    //查询的值
    private String search_value;

    public SpiderJsonCondition() {
    }

    public SpiderJsonCondition(String search_key, String search_value) {
        this.search_key = search_key;
        this.search_value = search_value;
    }

    public String getSearch_key() {
        return search_key;
    }

    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }

    public String getSearch_value() {
        return search_value;
    }

    public void setSearch_value(String search_value) {
        this.search_value = search_value;
    }
}
