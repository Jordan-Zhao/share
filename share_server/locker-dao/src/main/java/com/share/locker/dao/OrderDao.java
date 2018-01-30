package com.share.locker.dao;

import java.util.HashMap;
import java.util.Map;

import com.share.locker.bo.OrderBO;

public interface OrderDao {
	Long saveOrder(OrderBO orderBO);
	
	OrderBO getOrderById(Map<String, Object> params);
	
	void updateOrderStatus(Map<String, Object> params);
}
