package com.cjzheng.wechat.model;

/**
 * 
 * @Description: 微信token
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:17:19
 *
 */

public class AccessTokenModel extends ErrorCodeModel {
	private String access_token; // 获取到的凭证
	private String expires_in; // 凭证有效时间，单位：秒

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
}
