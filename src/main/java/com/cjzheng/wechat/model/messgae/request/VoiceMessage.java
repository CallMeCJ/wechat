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
	private String MediaId;
	// 语音格式
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
