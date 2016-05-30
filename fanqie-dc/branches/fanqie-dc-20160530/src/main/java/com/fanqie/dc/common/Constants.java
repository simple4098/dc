package com.fanqie.dc.common;

public class Constants {
	
	public final static int HTTP_SUCCESS = 200; //所有逻辑都正确
	public final static int HTTP_ERROR = 400; //访问正常但逻辑有误,app端要显示message信息
	public final static int HTTP_800 = 800;//订单重复 800
	public final static String DEFAULT_OTA="QUNAR";
	/** 返回key */
	public final static String STATUS = "status"; //状态
	public final static String MESSAGE = "message"; //状态说明
	public final static String TYPE = "type"; //状态类型
	public final static String DATA = "data";
	/** 返回结果 */
	public final static String SUCCESS = "success";
	public final static String spiderSUCCESS = "1000";
	public final static String FAILURE = "fail";
	public final static String OMS_MESPRICE_TYPE = "PRICE_AUDIT";
	public final static String COMPARE_PRICE_PRICE_AUDIT = "COMPARE_PRICE_PRICE_AUDIT";
	public final static String OMS_PROJECT= "oms";
	public final static Integer PERCENTAGE= 100;

}
