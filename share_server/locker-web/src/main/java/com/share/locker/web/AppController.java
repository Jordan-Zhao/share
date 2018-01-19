package com.share.locker.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.share.locker.common.AppConfig;

@Controller
public class AppController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(AppController.class);
	
	/**
	 * 获取系统配置信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAppConfig.json")
	public Object getAppConfig(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//TODO 获取AppConfig
		AppConfig appConfig = new AppConfig();
		appConfig.setPassworkMD5Key("SSHHAARREE_LLOOCCKKEERR");
		writeJsonMsg(response, true, appConfig);
		return null;
	}
}
