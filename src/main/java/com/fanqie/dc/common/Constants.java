package com.fanqie.dc.common;

public class Constants {
	
	// http获取响应类型(all:所有，responseStr:网页字符串，cookies：网页cookies)
	public final static String HTTP_GET_TYPE_ALL = "all";
	public final static String HTTP_GET_TYPE_STRING = "responseStr";
	public final static String HTTP_GET_TYPE_COOKIES = "cookies";
	public final static int HTTP_SUCCESS = 200; //所有逻辑都正确
	public final static int HTTP_ERROR = 400; //访问正常但逻辑有误,app端要显示message信息
	public final static int HTTP_800 = 800;//订单重复 800
	public final static int HTTP_401 = 401;
	public final static int HTTP_404 = 404;
	public final static int HTTP_500 = 500;
	public final static int HTTP_411 = 411;//请求参数有误
	public final static int HTTP_412 = 412;//请求超时
	public final static int HTTP_413 = 413;//签名有误

	/** 返回key */
	public final static String STATUS = "status"; //状态
	public final static String MESSAGE = "message"; //状态说明
	public final static String TYPE = "type"; //状态类型
	public final static String CODE ="code";//返回状态码标志
	public final static String RESULT = "result";
	public final static String ERROR_CODE = "errorCode";
	public final static String DATA = "data";
	public final static String RESPONSE_FIELD_FLAG = "flag";
	/** 返回结果 */
	public final static String SUCCESS = "success";
	public final static String spiderSUCCESS = "1000";
	public final static String FAILURE = "fail";
	public final static String ORDER_REPEAT = "ORDER_REPEAT";
	public final static String ERROR_TIP_MSG = "请稍后再试";
	public final static String OMS_MESPRICE_TYPE = "PRICE_AUDIT";
	public final static String COMPARE_PRICE_PRICE_AUDIT = "COMPARE_PRICE_PRICE_AUDIT";
	public final static String OMS_PROJECT= "oms";
	//public final static int  spiderDay= 3;

}
