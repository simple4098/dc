/**
 * 
 */
package com.fanqie.dc.filter;

/**
 * 接口请求头
 * 
 * @author xi
 *
 */
public class RequestBean {
	private String timestamp; //当前时间毫秒
	private String signature; //加密签名
	private String companyId; //渠道ID
	private String userId;

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
