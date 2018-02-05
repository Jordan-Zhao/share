package com.share.locker.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.reflect.TypeToken;
import com.share.locker.bo.ItemBO;
import com.share.locker.bo.OperationConfigBO;
import com.share.locker.bo.SettingBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.JsonUtil;
import com.share.locker.service.ItemService;
import com.share.locker.service.OperationService;
import com.share.locker.service.SettingService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.service.util.MockUtil;
import com.share.locker.web.dto.BannerDTO;
import com.share.locker.web.dto.HotItemDTO;
import com.share.locker.web.dto.OperationSettingDTO;

@Controller
public class AdminController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Resource
	private OperationService operationService;
	@Resource
	private ItemService itemService;
	@Resource
	private SettingService settingService;

	/**
	 * 生成运营数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/generateOptData.json", method = RequestMethod.POST)
	public Object generateOptData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBO loginUser = BizUtil.getLoginUser(request);
		
		writeJsonMsg(response, true, "操作成功");
		return null; 
	}
	
}
