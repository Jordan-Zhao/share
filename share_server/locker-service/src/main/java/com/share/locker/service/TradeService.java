package com.share.locker.service;

import com.share.locker.bo.TradeBO;

public interface TradeService {
	
	Long createTrade(TradeBO tradeBO);
	
	TradeBO getTradeByOrder(Long orderId,String tradeType);
}
