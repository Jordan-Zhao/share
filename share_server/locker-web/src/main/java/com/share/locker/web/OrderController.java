package com.share.locker.web;

import java.util.Date;
import java.util.List;

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
import com.share.locker.web.dto.OrderReturnLockerDTO;
import com.share.locker.web.dto.PayFeeDTO;

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
	
	@Resource
	private TradeService tradeService;

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

		// 更新宝贝状态“锁定中”，用户30分钟内去支付。TODO 如果创建订单未成功、锁定时间过期，则自动解锁。（用任务实现）
		itemService.updateItemStatus(itemId, LockerConstants.ItemStatus.LOCKED.getCode());

		// 创建订单
		Long orderId = orderService.rent(loginUser, itemId);

		// 查询订单信息，支付页面显示
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.CREATED.getCode());

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(orderBO.getOrderId());
		orderDTO.setItemId(orderBO.getItemId());
		orderDTO.setDeposit(orderDTO.getDeposit());
		orderDTO.setTitle(orderBO.getTitle());
		orderDTO.setCreateTime(orderBO.getCreateTime());
		orderDTO.setStatus(orderBO.getStatus());
		orderDTO.setDeposit(BizUtil.convertDbPrice2Float(orderBO.getDeposit()));

		writeJsonMsg(response, true, orderDTO);
		return null;
	}

	/**
	 * 用户取件，扫描二维码时，机柜发来请求，判断是否可以开柜
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）、qrcode(用户手机扫码)
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "order/openLockerForTake.json", method = RequestMethod.POST)
	public Object openLockerForTake(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		String qrcode = request.getParameter("qrcode");

		// 判断机柜和二维码是否匹配
		List<CheckCodeBO> codeBOList = checkCodeService.getValidCheckCodeByCode(LockerConstants.CheckCodeType.TAKE.getCode(), qrcode);
		if (CollectionUtils.isNotEmpty(codeBOList)) {
			for (CheckCodeBO codeBO : codeBOList) {
				Long orderId = Long.parseLong(codeBO.getCheckId()); // 订单ID，生成code时作为checkId存入的
				OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.GENERATED_TAKE_QRCODE.getCode());
				Long itemId = orderBO.getItemId();
				ItemBO itemBO = itemService.getItemDetail(itemId);
				if (itemBO.getLockerId().equals(lockerId)) { // lockerId匹配，则认为可以开门
					writeJsonMsg(response, true, true);
					return null;
				}
			}
		}

		writeJsonMsg(response, true, false);
		return null;
	}

	/**
	 * 用户取件后，关闭柜门。机柜发来请求，告知柜门已关闭，用户已取走宝贝
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/closeLockerAfterTake.json", method = RequestMethod.POST)
	public Object closeLockerAfterTake(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));

		// 查询lockerId对应的“LOCKERD"状态的宝贝
		ItemBO itemBO = itemService.getLockedItem(lockerId);

		// 更新宝贝状态为“租用中”
		itemService.updateItemStatus(itemBO.getItemId(), LockerConstants.ItemStatus.USING.getCode());

		// 根据itemId找到order，更新订单状态
		OrderBO orderBO = orderService.getOrderByItemId(itemBO.getItemId(), LockerConstants.OrderStatus.GENERATED_TAKE_QRCODE.getCode());
		orderService.updateOrderStatus(orderBO.getOrderId(), LockerConstants.OrderStatus.USING.getCode());

		writeJsonMsg(response, true, true);
		return null;
	}

	/**
	 * 还件前，支付租金页面
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/getPayFeeData.json", method = RequestMethod.POST)
	public Object getPayFeeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long orderId = Long.parseLong(request.getParameter("orderId"));

		PayFeeDTO payFeeDTO = new PayFeeDTO();

		payFeeDTO.setOrderId(orderId);
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.USING.getCode());
		payFeeDTO.setTitle(orderBO.getTitle());
		ItemBO itemBO = itemService.getItemDetail(orderBO.getItemId());
		payFeeDTO.setPriceStr(BizUtil.convertPrice2Str(itemBO.getPriceTime(), itemBO.getPriceTimeUnit(), itemBO.getPrice()));
		payFeeDTO.setRentTime(BizUtil.getRentTimeStr(orderBO.getCreateTime(), itemBO.getPriceTimeUnit())); // TODO 应该从取件时间开始算起
		payFeeDTO.setFee(BizUtil.getRentFee(orderBO.getCreateTime(), itemBO.getPriceTime(), itemBO.getPriceTimeUnit(), BizUtil.convertDbPrice2Float(itemBO.getPrice()))); // TODO 应该从取件时间算起

		writeJsonMsg(response, true, payFeeDTO);
		return null;
	}
	
	/**
	 * 换件，获取换件二维码等信息
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/getReturnLockerData.json", method = RequestMethod.POST)
	public Object getReturnLockerData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long orderId = Long.parseLong(request.getParameter("orderId"));

		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.GENERATED_RETURN_QRCODE.getCode());
		ItemBO itemBO = itemService.getItemDetail(orderBO.getItemId());
		OrderReturnLockerDTO returnLockerDTO = new OrderReturnLockerDTO();
		returnLockerDTO.setItemTitle(orderBO.getTitle());
		returnLockerDTO.setLockerId(itemBO.getLockerId());
		returnLockerDTO.setMachineName(MockUtil.getMachineNameBylockerId(returnLockerDTO.getLockerId()));
		returnLockerDTO.setOrderId(orderId);
		
		CheckCodeBO checkCodeBO = checkCodeService.getValidCheckCode(LockerConstants.CheckCodeType.RETURN.getCode(), 
				String.valueOf(orderId));
		returnLockerDTO.setQrcode(checkCodeBO.getCheckCode());
		
		returnLockerDTO.setRemainTime(BizUtil.getCheckCodeRemainTime(checkCodeBO.getCreateTime(), checkCodeBO.getExpireTime()));

		writeJsonMsg(response, true, returnLockerDTO);
		return null;
	}

	/**
	 * 用户还件，扫描二维码时，机柜发来请求，获取柜门id，然后打开柜门
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）、qrcode(用户手机扫码)
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "order/openLockerForReturn.json", method = RequestMethod.POST)
	public Object openLockerForReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long machineId = Long.parseLong(request.getParameter("machineId"));
		String qrcode = request.getParameter("qrcode");

		// 根据qrcode获取订单id，qrcode应该唯一
		List<CheckCodeBO> codeBOList = checkCodeService.getValidCheckCodeByCode(LockerConstants.CheckCodeType.RETURN.getCode(), qrcode);
		CheckCodeBO checkCodeBO = codeBOList.get(0);
		Long orderId = Long.parseLong(checkCodeBO.getCheckId()); // 订单ID，生成code时作为checkId存入的
		OrderBO orderBO = orderService.getOrderById(orderId, LockerConstants.OrderStatus.GENERATED_RETURN_QRCODE.getCode());
		Long itemId = orderBO.getItemId();
		ItemBO itemBO = itemService.getItemDetail(itemId);
		
		//使用宝贝上架时的locker。TODO 是否有更好的策略？
		Long returnLockerId = itemBO.getLockerId();
		//TODO 判断lockerId与machineId 是否匹配。用户应该归还到owner存放的那个机柜，否则owner无法取回自己的宝贝
		
		writeJsonMsg(response, true, String.valueOf(returnLockerId));
		return null;
	}

	/**
	 * 用户还件后，关闭柜门。机柜发来请求，告知用户已还件
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/closeLockerAfterReturn.json", method = RequestMethod.POST)
	public Object closeLockerAfterReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		
		// 查询lockerId对应的“USING"状态的宝贝
		List<ItemBO> itemBOList = itemService.getItemByLockerId(lockerId,LockerConstants.ItemStatus.USING.getCode());
		ItemBO itemBO = itemBOList.get(0);

		// 宝贝状态仍然保持为“租用中”，等checked之后，更新为“上架”

		// 根据itemId找到order，更新订单状态
		OrderBO orderBO = orderService.getOrderByItemId(itemBO.getItemId(), LockerConstants.OrderStatus.GENERATED_RETURN_QRCODE.getCode());
		orderService.updateOrderStatus(orderBO.getOrderId(), LockerConstants.OrderStatus.RETURNED.getCode());

		writeJsonMsg(response, true, true);
		return null;
	}
	
	/**
	 * 用户还件后，管理员完成检查，宝贝没有损坏，通知服务端退还押金，上架宝贝
	 * 
	 * @param request
	 *            机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/checkQuality.json", method = RequestMethod.POST)
	public Object checkQuality(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		
		// 查询lockerId对应的“USING"状态的宝贝
		List<ItemBO> itemBOList = itemService.getItemByLockerId(lockerId,LockerConstants.ItemStatus.USING.getCode());
		ItemBO itemBO = itemBOList.get(0);

		// 根据itemId找到order
		OrderBO orderBO = orderService.getOrderByItemId(itemBO.getItemId(), LockerConstants.OrderStatus.RETURNED.getCode());
		
		// 退还押金
		MockUtil.refundDeposit(orderBO.getOrderId());
		
		//退还押金 的交易记录
		UserBO loginUser = BizUtil.getLoginUser(request);
		TradeBO tradeBO = new TradeBO();
		tradeBO.setOrderId(orderBO.getOrderId());
		tradeBO.setEditor(loginUser.getNick());
		tradeBO.setEditTime(new Date());
		tradeBO.setFee(orderBO.getDeposit());
		tradeBO.setFinishTime(new Date());
		tradeBO.setItemId(orderBO.getItemId());
		tradeBO.setOwnerId(itemBO.getUserId());
		//查询原支付方式，原路退还
		TradeBO payTradeBo = tradeService.getTradeByOrder(orderBO.getOrderId(), LockerConstants.TradeType.PAY_DEPOSIT.getCode());
		tradeBO.setPaymentType(payTradeBo.getPaymentType());
		tradeBO.setRemark("退还押金");
		tradeBO.setRenterId(loginUser.getUserId());
		tradeBO.setStatus(LockerConstants.TradeStatus.SUCCESS.getCode());
		tradeBO.setTradeType(LockerConstants.TradeType.REFUND_DEPOSIT.getCode());
		Long tradeId = tradeService.createTrade(tradeBO);
		
		//更新订单状态“已退押金”
		orderService.updateOrderStatus(orderBO.getOrderId(), LockerConstants.OrderStatus.REFUNDED_DEPOSIT.getCode());
		
		//更新宝贝状态“上架“
		itemService.updateItemStatus(itemBO.getItemId(), LockerConstants.ItemStatus.ONLINE.getCode());
		
		writeJsonMsg(response, true, true);
		return null;
	}
}
