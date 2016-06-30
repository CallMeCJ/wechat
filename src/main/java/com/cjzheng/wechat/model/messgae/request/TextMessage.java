package com.cjzheng.wechat.model.messgae.request;

/**
 * 
 * @Description: 请求消息之文本消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:19:57
 *
 */

public class TextMessage extends BaseMessage {
	// 消息内容
	private String content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
