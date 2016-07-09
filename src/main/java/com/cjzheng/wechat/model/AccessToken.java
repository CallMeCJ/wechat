package com.cjzheng.wechat.model;

/**
 * 
 * @Description: 微信token
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:17:19
 *
 */

public class AccessToken extends ErrorCodeModel {
	private String token; // 获取到的凭证
	private int expiresIn; // 凭证有效时间，单位：秒

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
