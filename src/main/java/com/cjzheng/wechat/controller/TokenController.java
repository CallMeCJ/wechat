package com.cjzheng.wechat.controller;

import java.io.IOException;
import java.text.ParseException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cjzheng.wechat.model.CheckModel;
import com.cjzheng.wechat.service.TokenService;

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

}
