package com.fanqie.dc.support.util;

import com.fanqie.core.dto.GetPmsOrderStatusParamDto;
import com.fanqie.dc.dto.SpiderJson;
import com.fanqie.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/20
 * @version: v1.0.0
 */
public class CpHttpClient {


    private final  static  int TIME_OUT = 90000;
    private final  static  int REQUEST_SOCKET_TIME = 60000;
    private static Logger logger = LoggerFactory.getLogger(CpHttpClient.class);
    private CpHttpClient(){}

    public static HttpClient CpHttpClient(String proxyIp,int proxyPort){
        HttpClientBuilder httpClientBuilder =HttpClientBuilder.create();
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CpHttpClient.TIME_OUT)
                .setSocketTimeout(CpHttpClient.REQUEST_SOCKET_TIME).build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
        //设置代理
        if(!StringUtils.isEmpty(proxyIp) && 0!=proxyPort){
            HttpHost proxy = new HttpHost(proxyIp, proxyPort);
            httpClientBuilder.setProxy(proxy);
        }
        CloseableHttpClient httpClient = httpClientBuilder.build();
        return httpClient;
    }

    public static HttpClient obtHttpClient(){
        HttpClientBuilder httpClientBuilder =HttpClientBuilder.create();
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CpHttpClient.TIME_OUT)
                .setSocketTimeout(CpHttpClient.REQUEST_SOCKET_TIME).build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
        return httpClientBuilder.build();
    }

    /**
     *
     * @param url 爬虫系统地址
     * @param data 查询参数
     * @throws Exception
     */
    public static String httpPost(String url,SpiderJson data) throws Exception {
        HttpClient httpClient = obtHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        String json = JacksonUtil.obj2json(data);
        httpPost.setEntity(new StringEntity(json,ContentType.APPLICATION_JSON));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String value = EntityUtils.toString(entity,"utf-8");
        return value;
    }

}
