package com.share.locker.web;

import java.util.Date;
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
import com.share.locker.bo.TradeBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.service.CheckCodeService;
import com.share.locker.service.ItemService;
import com.share.locker.service.LockerService;
import com.share.locker.service.OrderService;
import com.share.locker.service.TradeService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.service.util.MockUtil;
import com.share.locker.web.dto.OrderDTO;

@Controller
public class TradeController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(TradeController.class);

	@Resource
	private OrderService orderService;
	@Resource
	private ItemService itemService;
	@Resource
	private TradeService tradeService;
	@Resource
	private CheckCodeService checkCodeService;

	/**
	 * 押金支付成功
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/trade/depositPayFinished.json", method = RequestMethod.POST)
	public Object depositPayFinished(HttpServletRequest request, HttpServletResponse response) {
		Long orderId = Long.parseLong(request.getParameter("orderId"));
		String payWay = request.getParameter("payWay");
		UserBO loginUser = BizUtil.getLoginUser(request);
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.CREATED.getCode());
		ItemBO itemBO = itemService.getItemDetail(orderBO.getItemId());

		// 保存交易记录
		TradeBO tradeBO = new TradeBO();
		tradeBO.setOrderId(orderId);
		tradeBO.setEditor(loginUser.getNick());
		tradeBO.setEditTime(new Date());
		tradeBO.setFee(orderBO.getDeposit());
		tradeBO.setFinishTime(new Date());
		tradeBO.setItemId(orderBO.getItemId());
		tradeBO.setOwnerId(itemBO.getUserId());
		tradeBO.setPaymentType(payWay);
		tradeBO.setRemark(null);
		tradeBO.setRenterId(loginUser.getUserId());
		tradeBO.setStatus(LockerConstants.TradeStatus.SUCCESS.getCode());
		tradeBO.setTradeType(LockerConstants.TradeType.PAY_DEPOSIT.getCode());
		Long tradeId = tradeService.createTrade(tradeBO);

		// 更新订单状态“已支付押金”
		orderService.updateOrderStatus(orderId, LockerConstants.OrderStatus.PAID_DEPOSIT.getCode());

		// 生成取件二维码
		String takeQrcode = checkCodeService.createCheckCode(LockerConstants.CheckCodeType.TAKE.getCode(), 
				String.valueOf(orderId),LockerConstants.QR_CODE_EXPIRE_TIME_TAKE);
		
		// 更新订单状态“已生成取件二维码”
		orderService.updateOrderStatus(orderId, LockerConstants.OrderStatus.GENERATED_TAKE_QRCODE.getCode());

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(orderBO.getOrderId());
		orderDTO.setItemId(orderBO.getItemId());
		orderDTO.setDeposit(orderDTO.getDeposit());
		orderDTO.setTitle(orderBO.getTitle());
		orderDTO.setCreateTime(orderBO.getCreateTime());
		orderDTO.setStatus(orderBO.getStatus());
		orderDTO.setLockerId(String.valueOf(itemBO.getLockerId()));
		orderDTO.setMachineName(MockUtil.getMachineNameBylockerId(itemBO.getLockerId()));
		orderDTO.setTakeQrcode(takeQrcode);
		writeJsonMsg(response, true, orderDTO);
		return null;
	}

	/**
	 * 租金支付成功,保存交易记录，更新状态等
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/trade/feePayFinished.json", method = RequestMethod.POST)
	public Object feePayFinished(HttpServletRequest request, HttpServletResponse response) {
		Long orderId = Long.parseLong(request.getParameter("orderId"));
		Float fee = Float.parseFloat(request.getParameter("fee"));
		String payWay = request.getParameter("payWay");
		UserBO loginUser = BizUtil.getLoginUser(request);
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.USING.getCode());
		ItemBO itemBO = itemService.getItemDetail(orderBO.getItemId());

		// 保存交易记录
		TradeBO tradeBO = new TradeBO();
		tradeBO.setOrderId(orderId);
		tradeBO.setEditor(loginUser.getNick());
		tradeBO.setEditTime(new Date());
		tradeBO.setFee(BizUtil.convertInputPrice2Int(String.valueOf(fee)));
		tradeBO.setFinishTime(new Date());
		tradeBO.setItemId(orderBO.getItemId());
		tradeBO.setOwnerId(itemBO.getUserId());
		tradeBO.setPaymentType(payWay);
		tradeBO.setRemark(null);
		tradeBO.setRenterId(loginUser.getUserId());
		tradeBO.setStatus(LockerConstants.TradeStatus.SUCCESS.getCode());
		tradeBO.setTradeType(LockerConstants.TradeType.PAY_RENT_FEE.getCode());
		Long tradeId = tradeService.createTrade(tradeBO);

		// 更新订单状态“已支付租金”
		orderService.updateOrderStatus(orderId, LockerConstants.OrderStatus.PAID_FEE.getCode());

		// 生成还件二维码
		String returnQrcode = checkCodeService.createCheckCode(LockerConstants.CheckCodeType.RETURN.getCode(), 
				String.valueOf(orderId),LockerConstants.QR_CODE_EXPIRE_TIME_TAKE);
		
		// 更新订单状态“已生成还件二维码”
		orderService.updateOrderStatus(orderId, LockerConstants.OrderStatus.GENERATED_RETURN_QRCODE.getCode());
		
		writeJsonMsg(response, true, orderId);
		return null;
	}
}
