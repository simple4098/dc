package com.fanqie.dc.enumeration;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/17
 * @version: v1.0.0
 */
public enum ComparePriceEnum {
    EVERY("任意"),PROBLEM("有问题"),RESOLVED("已解决");
    private String value;

    ComparePriceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
