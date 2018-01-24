package com.share.locker.dao;

import com.share.locker.bo.OrderBO;

public interface OrderDao {
	Long saveOrder(OrderBO orderBO);
}
