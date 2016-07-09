package com.cjzheng.wechat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cjzheng.wechat.model.CheckModel;
import com.cjzheng.wechat.model.messgae.response.Article;
import com.cjzheng.wechat.model.messgae.response.NewsMessage;
import com.cjzheng.wechat.model.messgae.response.TextMessage;
import com.cjzheng.wechat.util.EncoderHandler;
import com.cjzheng.wechat.util.MessageUtil;

/**
 * @date: 2016年6月26日下午12:17:18
 * @author: zhengchaojie
 * @version: v1.0
 */

@Service
public class CoreService {
	private static String wxToken = "cjwithsn";

	/**
	 * 微信开发者验证
	 * 
	 * @param wxAccount
	 *
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@Transactional
	public String validate(CheckModel tokenModel) {
		String signature = tokenModel.getSignature();
		String timestamp = tokenModel.getTimestamp();
		String nonce = tokenModel.getNonce();
		String echostr = tokenModel.getEchostr();
		if (signature != null && timestamp != null & nonce != null) {
			String[] str = { wxToken, timestamp + "", nonce + "" };
			Arrays.sort(str); // 字典序排序
			String bigStr = str[0] + str[1] + str[2];
			// SHA1加密
			String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
			// 确认请求来至微信
			if (digest.equals(signature)) {
				// 最好此处将echostr存起来，以后每次校验消息来源都需要用到
				return echostr;
			}
		}
		return "error";
	}

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义
			textMessage.setContent("欢迎访问<a href=\"http://blog.csdn.net/buptzhengchaojie\">北邮第五年-CJ</a>!");
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);
				List<Article> articleList = new ArrayList<Article>();
				Article article = new Article();
				article.setTitle("Nexus私服搭建、配置、上传snapshot");
				article.setDescription("这只是我的第一个图文消息，一条路走到黑那又怎样？");
				article.setPicUrl("http://cjwithsn.applinzi.com/images/home.jpg");
				article.setUrl("http://blog.csdn.net/buptzhengchaojie");
				articleList.add(article);
				// 设置图文消息个数
				newsMessage.setArticleCount(articleList.size());
				// 设置图文消息包含的图文集合
				newsMessage.setArticles(articleList);
				// 将图文消息对象转换成xml字符串
				respMessage = MessageUtil.newsMessageToXml(newsMessage);
				return respMessage;
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
