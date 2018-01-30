package com.share.locker.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.bo.CheckCodeBO;
import com.share.locker.bo.ItemBO;
import com.share.locker.bo.OrderBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.service.CheckCodeService;
import com.share.locker.service.ItemService;
import com.share.locker.service.LockerService;
import com.share.locker.service.OrderService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.web.dto.OrderDTO;

@Controller
public class OrderController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Resource
	private OrderService orderService;
	
	@Resource
	private CheckCodeService checkCodeService;
	
	@Resource
	private LockerService lockerService;
	
	@Resource
	private ItemService itemService;
	

	/**
	 * 下单租用
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/rent.json", method = RequestMethod.POST)
	public Object rent(HttpServletRequest request, HttpServletResponse response) {
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		UserBO loginUser = BizUtil.getLoginUser(request);

		//更新宝贝状态“锁定中”，用户30分钟内去支付。TODO 如果创建订单未成功、锁定时间过期，则自动解锁。（用任务实现）
		itemService.updateItemStatus(itemId, LockerConstants.ItemStatus.LOCKED.getCode());
		
		//创建订单
		Long orderId = orderService.rent(loginUser, itemId);
		
		//查询订单信息，支付页面显示
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.ItemStatus.LOCKED.getCode());
		
		OrderDTO orderDTO= new OrderDTO();
		orderDTO.setOrderId(orderBO.getOrderId());
		orderDTO.setItemId(orderBO.getItemId());
		orderDTO.setDeposit(orderDTO.getDeposit());
		orderDTO.setTitle(orderBO.getTitle());
		orderDTO.setCreateTime(orderBO.getCreateTime());
		orderDTO.setStatus(orderBO.getStatus());
		
		writeJsonMsg(response, true, orderDTO);
		return null;
	}
	
    /**
	 * 机柜发来请求，取件时，判断是否可以开柜
	 * @param request	机柜传过来：lockerId（保存在机柜中）、qrcode(用户手机扫码)
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "order/openLockerForTake.json", method = RequestMethod.POST)
	public Object openLockerForTake(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		String qrcode = request.getParameter("qrcode");
		
		//判断机柜和二维码是否匹配
		List<CheckCodeBO> codeBOList = checkCodeService.getValidCheckCodeByCode(LockerConstants.CheckCodeType.TAKE.getCode(), qrcode);
		if(CollectionUtils.isNotEmpty(codeBOList)) {
			for(CheckCodeBO codeBO : codeBOList) {
				Long orderId = Long.parseLong(codeBO.getCheckId());	//订单ID，生成code时作为checkId存入的
				OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.GENERATED_TAKE_QRCODE.getCode());
				Long itemId = orderBO.getItemId();
				ItemBO itemBO = itemService.getItemDetail(itemId);
				if(itemBO.getLockerId().equals(lockerId)) {	//lockerId匹配，则认为可以开门
					writeJsonMsg(response, true, true);
					return null;
				}
			}
		}
		
		writeJsonMsg(response, true, false);
		return null;
	}
	
	/**
	 * 机柜发来请求，告知柜门已放入宝贝
	 * @param request	机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/closeLockerAfterPut.json", method = RequestMethod.POST)
	public Object closeLockerAfterPut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		
		//查询lockerId对应的“CREATED"状态的宝贝
		ItemBO itemBO = itemService.getToPutItem(lockerId);
		
		//更新宝贝状态为“上架”
		itemService.onLineItem(itemBO.getItemId());
		
		writeJsonMsg(response, true, true);
		return null;
	}
}
