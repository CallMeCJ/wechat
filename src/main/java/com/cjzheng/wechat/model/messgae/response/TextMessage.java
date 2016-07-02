package com.cjzheng.wechat.model.messgae.response;

/**
 * 
 * @Description: 响应消息之文本消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:22:40
 *
 */

public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}
}
