package com.share.locker.service;

import com.share.locker.bo.UserBO;

public interface OrderService {
	Long rent(UserBO renter, Long itemId);
}
