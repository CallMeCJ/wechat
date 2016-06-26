package com.cjzheng.wechat.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cjzheng.wechat.service.TokenService;

@Controller
@RequestMapping("/test")
public class Test {
	private Log log = LogFactory.getLog(Test.class);

	@Resource
	private TokenService tokenService;

	@RequestMapping(value = "/getAccessToken", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String getAccessToken(String appid, String secret) {
		try {
			return tokenService.getAccessToken(appid, secret);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("获取access_token异常", ex);
			}
			return "获取access_token异常";
		}
	}
}
