package com.share.locker.service;

import com.share.locker.bo.OrderBO;
import com.share.locker.bo.UserBO;

public interface OrderService {
	Long rent(UserBO renter, Long itemId);
	
	OrderBO getOrderById(Long orderId,String status);
	
	void updateOrderStatus(Long orderId, String status);

}
