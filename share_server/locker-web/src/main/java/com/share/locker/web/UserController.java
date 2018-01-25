package com.share.locker.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.StringUtil;
import com.share.locker.service.ItemService;
import com.share.locker.service.UserService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.web.dto.ItemDTO;

@Controller
public class UserController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mine/login.json", method = RequestMethod.POST)
	public Object login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBO loginUser = null;
		if (StringUtil.isEmail(userName)) {
			// email 登录
			loginUser = userService.getUserByEmail(userName);
		} else {
			loginUser = userService.getUserByPhoneNumber(userName);
		}
		if (loginUser == null || !loginUser.getPassword().equals(password)) {
			writeJsonMsg(response, false, "Login failed");
			return null;
		} else {
			writeJsonMsg(response, true, loginUser.getUserId());
			return null;
		}
	}

	/**
	 * 获取“我的”信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mine/getMineData.json", method = RequestMethod.POST)
	public Object getMineData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBO loginUser = null;
		if (StringUtil.isEmail(userName)) {
			// email 登录
			loginUser = userService.getUserByEmail(userName);
		} else {
			loginUser = userService.getUserByPhoneNumber(userName);
		}
		if (loginUser == null || !loginUser.getPassword().equals(password)) {
			writeJsonMsg(response, false, "Login failed");
			return null;
		} else {
			Map<String, Object> userInfoMap = new HashMap<>();
			userInfoMap.put("user_icon_url", LockerConstants.MOCK_URL_BASE + "icon11.png");
			userInfoMap.put("nick", loginUser.getNick());
			userInfoMap.put("email", loginUser.getEmail());
			userInfoMap.put("phone_number", loginUser.getPhoneNumber());
			writeJsonMsg(response, true, userInfoMap);
			return null;
		}
	}

	/**
	 * 获取我发布的宝贝
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mine/getMyPublishItems.json", method = RequestMethod.POST)
	public Object publishItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBO loginUser = BizUtil.getLoginUser(request);
		List<ItemBO> itemList = itemService.getItemByUserId(loginUser.getUserId(), LockerConstants.MY_ITEM_STATUS_LIST);
		// 组装DTO
		if (!CollectionUtils.isEmpty(itemList)) {
			List<ItemDTO> itemDTOList = new ArrayList<>();
			for (ItemBO itemBO : itemList) {
				ItemDTO dto = new ItemDTO();
				dto.setItemId(itemBO.getItemId());
				if (CollectionUtils.isNotEmpty(itemBO.getSmallImgList())) {
					dto.setSmallImgUrl(itemBO.getSmallImgList().get(0).getUrl());
				}
				dto.setTitle(itemBO.getTitle());
				dto.setDeposit(BizUtil.convertDbPrice2Float(itemBO.getDeposit()));
				dto.setPriceStr(
						BizUtil.convertPrice2Str(itemBO.getPriceTime(), itemBO.getPriceTimeUnit(), itemBO.getPrice()));
				dto.setComment(99);// TODO
				itemDTOList.add(dto);
			}
			writeJsonMsg(response, true, itemDTOList);
			return null;
		}
		return null;
	}
}
