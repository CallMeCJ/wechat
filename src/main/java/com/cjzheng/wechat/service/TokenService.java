package com.cjzheng.wechat.service;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cjzheng.wechat.model.AccessTokenModel;
import com.cjzheng.wechat.model.CheckModel;
import com.cjzheng.wechat.util.EncoderHandler;
import com.cjzheng.wechat.util.HttpClientUtil;
import com.cjzheng.wechat.util.JsonMapper;

/**
 * @date: 2016年6月26日下午12:17:18
 * @author: zhengchaojie
 * @version: v1.0
 */

@Service
public class TokenService {

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
	public String validate(String wxToken, CheckModel tokenModel) {
		String signature = tokenModel.getSignature();
		Long timestamp = tokenModel.getTimestamp();
		Long nonce = tokenModel.getNonce();
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
	 * 获取全局返回码
	 *
	 * @param appid
	 *            微信appid
	 * @param secret
	 *            微信secret
	 * @return
	 * @throws Exception
	 */
	public String getAccessToken(String appid, String secret) {
		if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(secret))
			return "请输入appid或appsecret";
		String accessToken = "";
		String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		AccessTokenModel accessTokenModel = JsonMapper.buildNormalMapper()
				.fromJson(HttpClientUtil.sendGetSSLRequest(
						accessTokenUrl + "?grant_type=client_credential&appid=" + appid + "&secret=" + secret, null),
				AccessTokenModel.class);
		if (StringUtils.isEmpty(accessTokenModel.getAccess_token())) {
			return null;
		} else {
			accessToken = accessTokenModel.getAccess_token();
		}
		return accessToken;
	}
}
