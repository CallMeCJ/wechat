package com.cjzheng.wechat.model.messgae.response;

import java.util.List;

/**
 * 
 * @Description: 响应消息之图文消息
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:23:43
 *
 */

public class NewsMessage extends BaseMessage {
	// 图文消息个数，限制为10条以内
	private int articleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> articles;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
