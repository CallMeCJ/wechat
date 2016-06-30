package com.cjzheng.wechat.model.messgae.response;

/**
 * 
 * @Description: 响应消息之音乐消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:22:52
 *
 */

public class MusicMessage extends BaseMessage {
	// 音乐
	private Music music;

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}
}
