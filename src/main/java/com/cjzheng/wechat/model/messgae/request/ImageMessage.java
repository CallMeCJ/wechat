package com.cjzheng.wechat.model.messgae.request;

/**
 * 
 * @Description: 请求消息之图片消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:19:15
 *
 */

public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return PicUrl;
	}

	/**
	 * @param picUrl
	 *            the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

}
