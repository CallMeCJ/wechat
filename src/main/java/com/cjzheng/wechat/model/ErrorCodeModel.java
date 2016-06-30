package com.cjzheng.wechat.model;

/**
 * 
 * @Description: 微信错误代码
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:18:01
 *
 */

public class ErrorCodeModel {
	private String errcode;// 全局返回码
	private String errmsg;// 说明

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
