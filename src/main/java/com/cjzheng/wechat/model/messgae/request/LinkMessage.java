package com.cjzheng.wechat.model.messgae.request;

/**
 * 
 * @Description: 请求消息之链接消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:20:32
 *
 */

public class LinkMessage extends BaseMessage {
	// 消息标题
	private String title;
	// 消息描述
	private String description;
	// 消息链接
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
