package com.fanqie.dc.common;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/4/28
 * @version: v1.0.0
 */
public class JsonObject {
    private Object result;

    private String message;

    private boolean status;

    public JsonObject() {
    }

    public JsonObject(Object result, String message, boolean status) {
        this.result = result;
        this.message = message;
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
