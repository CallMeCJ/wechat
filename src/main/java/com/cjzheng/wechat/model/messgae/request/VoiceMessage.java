package com.cjzheng.wechat.model.messgae.request;

/**
 * 
 * @Description: 请求消息之语音消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:20:45
 *
 */

public class VoiceMessage extends BaseMessage {
	// 媒体ID
	private String mediaId;
	// 语音格式
	private String format;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
