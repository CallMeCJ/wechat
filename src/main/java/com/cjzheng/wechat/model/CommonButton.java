package com.cjzheng.wechat.model;

/**
 * 
 * @Description: 普通按钮（子按钮）
 * @author: zhengchaojie
 * @date 2016年7月9日 上午9:44:25
 *
 */
public class CommonButton extends Button {
	private String type;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}