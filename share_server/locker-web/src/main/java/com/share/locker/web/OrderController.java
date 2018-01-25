package com.share.locker.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.bo.UserBO;
import com.share.locker.service.OrderService;
import com.share.locker.service.util.BizUtil;

@Controller
public class OrderController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Resource
	private OrderService orderService;

	/**
	 * 下单租用
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/rent.json", method = RequestMethod.POST)
	public Object onLineItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		UserBO loginUser = BizUtil.getLoginUser(request);
		Long orderId = orderService.rent(loginUser, itemId);
		writeJsonMsg(response, true, orderId);
		return null;
	}
}