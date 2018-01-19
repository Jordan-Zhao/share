package com.share.locker.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

import com.share.locker.common.util.JsonUtil;

/**
 * Controller基类，提供公用的工具方法。
 * 
 * @author Jordan
 *
 */
public class BaseController {
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * http请求返回json数据。
	 * 
	 * @param response
	 * @param isSuccess
	 * @param returnData
	 */
	protected void writeJsonMsg(HttpServletResponse response, Boolean isSuccess, Object returnData) {
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			Map<String, Object> map = new HashMap<>();
			map.put("isSuccess", isSuccess);
			map.put("data", returnData);
			out.write(JsonUtil.toJson(map));
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("write json data to response occur exception", e);
		}
	}
}
