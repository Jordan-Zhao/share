package com.share.locker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.OrderBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.dao.ItemDao;
import com.share.locker.dao.OrderDao;

@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	@Autowired
	private ItemDao itemDao;

	@Autowired
	private OrderDao orderDao;

	public Long rent(UserBO renter, Long itemId) {
		// 创建订单
		OrderBO orderBO = new OrderBO();
		orderBO.setItemId(itemId);
		orderBO.setRenterId(renter.getUserId());
		ItemBO itemBO = itemDao.selectItemById(itemId);
		orderBO.setOwnerId(itemBO.getUserId());
		orderBO.setDeposit(itemBO.getDeposit());
		orderBO.setTitle(itemBO.getTitle());
		orderBO.setTakeTime(null);
		orderBO.setFee(null);
		orderBO.setReturnLockerId(null);
		orderBO.setReturnTime(null);
		orderBO.setCheckTime(null);
		orderBO.setEditor(renter.getNick());
		orderBO.setStatus(LockerConstants.OrderStatus.CREATED.getCode());
		orderDao.saveOrder(orderBO);
		// TODO 生成存件二维码
		return orderBO.getOrderId();
	}
}
