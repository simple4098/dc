package com.fanqie.dc.common;

import com.fanqie.util.Pagination;

import java.util.List;
import java.util.Map;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/17
 * @version: v1.0.0
 */
public class JsonModel {
    //状态 默认返回200的状态
    private int status = 200;
    private Object obj;
    private String message;

    public JsonModel() {
    }

    public JsonModel(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
