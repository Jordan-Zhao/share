package com.share.locker.service;

import java.util.List;

import com.share.locker.bo.OrderBO;
import com.share.locker.bo.UserBO;

public interface OrderService {
	Long rent(UserBO renter, Long itemId);
	
	OrderBO getOrderById(Long orderId,String status);
	
	OrderBO getOrderByItemId(Long itemId,String status);
	
	void updateOrderStatus(Long orderId, String status);
	
	List<OrderBO> getMyRentOrderList(Long userId);

}
