package com.cjzheng.wechat.model;

/**
 * 
 * @Description: 微信验证字段
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:17:36
 *
 */

public class CheckModel extends ErrorCodeModel {
	String signature;
	String timestamp;
	String nonce;
	String echostr;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
