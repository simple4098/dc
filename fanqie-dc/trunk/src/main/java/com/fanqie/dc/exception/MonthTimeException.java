package com.fanqie.dc.exception;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
public class MonthTimeException extends Exception {

    public MonthTimeException() {
        super("起止时间跨月，无法执行订单统计");
    }
}
