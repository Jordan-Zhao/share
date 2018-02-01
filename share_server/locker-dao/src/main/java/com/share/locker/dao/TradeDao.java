package com.share.locker.dao;

import java.util.Map;

import com.share.locker.bo.TradeBO;

public interface TradeDao {
	Long insertTrade(TradeBO tradeBO);

	TradeBO getTradeByOrder(Map<String, Object> params);
}
