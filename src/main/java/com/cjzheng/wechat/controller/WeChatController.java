package com.cjzheng.wechat.controller;

import java.io.IOException;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cjzheng.wechat.model.CheckModel;
import com.cjzheng.wechat.service.CoreService;

/**
 * 
 * @Description: api请求入口
 * @author: zhengchaojie
 * @date 2016年6月30日 下午3:15:48
 *
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

	private static Logger logger = Logger.getLogger(WeChatController.class);

	@Resource
	private CoreService coreService;

	/**
	 * 
	 * @Title: TokenController
	 * @Description: 开发者模式token校验
	 * @param tokenModel
	 *            微信验证token
	 * @return String
	 * @throws ParseException
	 * @throws IOException
	 * 
	 * @Date: 2016年6月30日
	 * @author:zhengchaojie
	 */
	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String validate(CheckModel tokenModel) throws ParseException, IOException {
		logger.info("get");
		System.out.println("get");
		return coreService.validate(tokenModel);
	}

	/**
	 * 
	 * @Title: TokenController
	 * @Description: 微信其他接口的实现
	 * @param request
	 * @param response
	 * @return string
	 * @throws ServletException
	 * @throws IOException
	 * @Date: 2016年6月30日
	 * @author:zhengchaojie
	 */

	@RequestMapping(value = "/api", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String wechatPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("走到这咯");

		// 调用核心业务类接收消息、处理消息
		String respMessage = coreService.processRequest(request);
		System.out.println("得到的结果" + respMessage);
		return respMessage;
	}

}
