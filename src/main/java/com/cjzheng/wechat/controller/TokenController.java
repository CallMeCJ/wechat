package com.cjzheng.wechat.controller;

import java.io.IOException;
import java.text.ParseException;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjzheng.wechat.model.AccessTokenModel;
import com.cjzheng.wechat.model.CheckModel;
import com.cjzheng.wechat.service.TokenService;
import com.cjzheng.wechat.util.HttpClientUtil;
import com.cjzheng.wechat.util.JsonMapper;

/**
 * @date: 2016年6月26日下午12:13:57
 * @author: zhengchaojie
 * @version: v1.0
 */
@Controller
@RequestMapping("/wechat")
public class TokenController {

	@Resource
	private TokenService tokenService;

	/**
	 * 开发者模式token校验
	 *
	 * @param wxAccount
	 *            开发者url后缀
	 * @param response
	 * @param tokenModel
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/check/{wxToken}", method = RequestMethod.GET, produces = "text/plain")
	public @ResponseBody String validate(@PathVariable("wxToken") String wxToken, CheckModel tokenModel)
			throws ParseException, IOException {
		return tokenService.validate(wxToken, tokenModel);
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
	@RequestMapping(value = "testAccessToken")
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
