package com.share.locker.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.service.CheckCodeService;
import com.share.locker.service.ItemService;
import com.share.locker.service.LockerService;
import com.share.locker.service.OrderService;
import com.share.locker.service.util.BizUtil;

@Controller
public class PayController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(PayController.class);

	@Resource
	private OrderService orderService;
	@Resource
	private ItemService itemService;
	

	//生成取件二维码
			/*String code = checkCodeService.createCheckCode(LockerConstants.CheckCodeType.TAKE.getCode(), String.valueOf(orderId));
			
			Map<String, Object> map = new HashMap<>();
			map.put("orderId", String.valueOf(orderId));
			map.put("qrcode", code);
			ItemBO itemBO = itemService.getItemDetail(itemId);
			String machineName = lockerService.getLockerById(itemBO.getLockerId()).getMachineBO().getName();
			map.put("lockerId", String.valueOf(itemBO.getLockerId()));
			map.put("machineName", machineName);
			map.put("itemId", String.valueOf(itemBO.getItemId()));
			map.put("itemTitle", itemBO.getTitle());*/
}
