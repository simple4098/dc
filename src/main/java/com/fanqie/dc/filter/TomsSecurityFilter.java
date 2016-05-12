package com.fanqie.dc.filter;


import com.fanqie.util.DateUtil;
import com.fanqie.util.DcUtil;
import com.fanqie.util.JacksonUtil;
import com.fanqie.util.TomsConstants;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TomsSecurityFilter implements Filter  {
	protected transient final Logger log  =  Logger.getLogger(TomsSecurityFilter.class);


	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filter) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;  
        HttpServletRequest request = (HttpServletRequest)servletRequest;  
        request.setCharacterEncoding("UTF-8");
        //需要过滤的代码         
        String timestamp = request.getParameter("timestamp");
        String signature = request.getParameter("signature");
        String companyId = request.getParameter("companyId");
        String userId = request.getParameter("userId");
        log.info(request.getRequestURI()+"请求拦截开始,请求参数为 ,timestamp:"+timestamp+";signature:"+signature+" companyId:"+companyId+" userId:"+userId);
        RequestBean qBean =  new RequestBean();
        qBean.setCompanyId(companyId);
        qBean.setUserId(userId);
        qBean.setSignature(signature);
        qBean.setTimestamp(timestamp);
        Map<String,Object> requestMap  = new HashMap<String,Object>();
        if(checkApiRequest(qBean,requestMap)){
        	filter.doFilter(servletRequest, servletResponse); 
        }else{
        	response.setContentType("application/json;charset=UTF-8");
        	response.getWriter().print(JacksonUtil.obj2json(requestMap));
        }
	}
	
	public boolean checkApiRequest(RequestBean qBean,Map<String,Object> requestMap){
		boolean sign = true;
		if(!StringUtils.isEmpty(qBean.getSignature()) && !StringUtils.isEmpty(qBean.getTimestamp()) && !StringUtils.isEmpty(qBean.getTimestamp())){
			long time= Long.valueOf(qBean.getTimestamp());
			// 是否超时
			long start =System.currentTimeMillis()-(200000* DateUtil.MILLION_SECONDS_OF_MINUTE);
			long end = System.currentTimeMillis()+(20000000*DateUtil.MILLION_SECONDS_OF_MINUTE);
			if(time<=start || time>=end){ //请求超时
				requestMap.put(TomsConstants.MESSAGE, "请求超时");
				requestMap.put(TomsConstants.STATUS,TomsConstants.STATUS412);
		    	sign =false;
			}else{
				String key = DcUtil.obtMd5(qBean.getCompanyId()+time+qBean.getUserId());
				if(!key.equals(qBean.getSignature())){
					requestMap.put(TomsConstants.MESSAGE, "无权访问");
					requestMap.put(TomsConstants.STATUS, TomsConstants.STATUS403);
					sign =false;
				}
			}
			//秘钥是不对
	    }else{
			requestMap.put(TomsConstants.MESSAGE, "参数异常");
			requestMap.put(TomsConstants.STATUS, TomsConstants.STATUS403);
	    	sign = false;
	    }
		return sign;

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	 


}
