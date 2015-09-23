package com.fanqie.dc.support.util;

import com.fanqie.dc.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CommonUtil {
	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	public static void setSuccessInfo(Map<String, Object> result) {
		setInfo(result, null, Constants.HTTP_SUCCESS, Constants.SUCCESS);
	}

    public static void setSuccessInfo(Map<String, Object> result,String message,String type) {
        setInfo(result, message, Constants.HTTP_SUCCESS, type);
    }

    public static void setErrorInfo(Map<String, Object> result, String message,String type) {
        setInfo(result, message, Constants.HTTP_ERROR, type);
    }

	public static void setErrorInfo(Map<String, Object> result, String message) {
		setInfo(result, message, Constants.HTTP_ERROR, Constants.FAILURE);
	}

	public static void setError800(Map<String, Object> result, String message) {
		setInfo(result, message, Constants.HTTP_800, Constants.FAILURE);
	}

	/**
	 * 设置返回信息
	 * 
	 * @param result
	 * @param message
	 *            错误信息说明
	 * @param status
	 *            错误代码
	 * @param type
	 *            错误代码类型
	 */
	public static void setInfo(Map<String, Object> result, String message,
			int status, String type) {
		setMessage(result, message, status, type);
	}

	private static void setMessage(Map<String, Object> result, String message,
			int status, String type) {
		if (message != null)
			result.put(Constants.MESSAGE, message);
		result.put(Constants.STATUS, status);
		if (type != null)
			result.put(Constants.TYPE, type);
	}

	/**
	 * 获取配置文件的值
	 * 
	 * @param key
	 *            properties 文件中的key值
	 */
	public static String obtProperties(String key) {
		if (StringUtils.isNotEmpty(key)) {
			Properties p = new Properties();
			InputStream in = CommonUtil.class
					.getResourceAsStream("/sso-info.properties");
			try {
				p.load(in);
			} catch (IOException e) {
				logger.error("读取配置文件异常:" + e);
			}
			return p.getProperty(key);
		}
		return null;
	}
	/**
	 * 获取配置文件的值
	 *
	 * @param key
	 * properties 文件中的key值
	 */
	public static String obtProperties(String key,String propertiesUrl) {
		if (StringUtils.isNotEmpty(key)) {
			Properties p = new Properties();
			InputStream in = CommonUtil.class.getResourceAsStream(propertiesUrl);
			try {
				p.load(in);
			} catch (IOException e) {
				logger.error("读取配置文件异常:" + e);
			}
			return p.getProperty(key);
		}
		return null;
	}

	/**
	 * 如果集合不为空 返回true
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isListNotEmpty(List list) {
		return list != null && list.size() > 0;
	}

	/**
	 * 根据name[] value[] 封装List<NameValuePair>
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static List<NameValuePair> initNameValuePairList(String[] name,
			String[] value) throws Exception {
		if (name.length != value.length)
			throw new RuntimeException("NameValuePair中name长度和value长度不一致");
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (int i = 0; i < name.length; i++) {
			BasicNameValuePair nvp = new BasicNameValuePair(name[i], value[i]);
			list.add(nvp);
		}
		return list;
	}

	/**
	 * ? 基本数据类型 List<?>转为已逗号分隔的字符串
	 */
	public static String ArrayToStrbyComma(
			@SuppressWarnings("rawtypes") List list) {
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				st.append(list.get(i));
			} else {
				st.append(list.get(i) + ",");
			}
		}
		return st.toString();
	}

	/**
	 * 以逗号分隔的字符串转换为指定类型的集合
	 * 
	 * @param <T>
	 * @param str
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> StrByCommaToArray(String str, Class<T> clazz) {
		String[] strArray = str.split(",");
		T[] obj = (T[]) Array.newInstance(clazz, strArray.length);
		Method method = null;
		try {
			if (clazz.getName().equals(String.class.getName())) {
				obj = (T[]) strArray;
			} else {
				method = clazz.getMethod("valueOf", String.class);
				for (int i = 0; i < strArray.length; i++) {
					obj[i] = (T) method.invoke(null, strArray[i]);
				}
			}
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		}
		List accList = Arrays.asList(obj);
		return accList;
	}

	//list 时间集合 转化成 String
	public static  String  listDateToStr(List<String> date){
		StringBuilder buffer = new StringBuilder();
		if (!org.springframework.util.CollectionUtils.isEmpty(date)){
			for (String da:date){
				buffer.append(da).append(",");
			}
			if (buffer.length()!=0){
				buffer.deleteCharAt(buffer.length()-1);
			}
		}
		return buffer.toString();
	}
}
