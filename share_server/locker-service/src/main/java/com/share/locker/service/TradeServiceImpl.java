package com.share.locker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.TradeBO;
import com.share.locker.dao.TradeDao;

@Service
public class TradeServiceImpl extends BaseServiceImpl implements TradeService {
	@Autowired
	private TradeDao tradeDao;
	
	public Long createTrade(TradeBO tradeBO) {
		tradeDao.insertTrade(tradeBO);
		return tradeBO.getTradeId();
	}
	
	public TradeBO getTradeByOrder(Long orderId,String tradeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", orderId);
		params.put("tradeType", tradeType);
		return tradeDao.getTradeByOrder(params);
	}
}
