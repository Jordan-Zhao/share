package com.share.locker.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.share.locker.bo.RegisterCodeBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.StringUtil;
import com.share.locker.service.ItemService;
import com.share.locker.service.RegisterCodeService;
import com.share.locker.service.UserService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.service.util.MockUtil;
import com.share.locker.web.dto.ItemDTO;
import com.share.locker.web.dto.UserDTO;

@Controller
public class UserController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private RegisterCodeService registerCodeService;

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
		if(StringUtil.isPhoneNumber(userName)) {
			loginUser = userService.getUserByPhoneNumber(userName);
		}else {
			loginUser = userService.getUserByEmail(userName);
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
		UserBO loginUser = BizUtil.getLoginUser(request);
		if (loginUser == null) {
			writeJsonMsg(response, false, "请先登录");
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(loginUser.getUserId());
		userDTO.setIconUrl(loginUser.getMinIconUrl());
		userDTO.setNick(loginUser.getNick());
		userDTO.setPhoneStr(StringUtil.getMaskString(loginUser.getPhoneNumber()));
		writeJsonMsg(response, true, userDTO);
		return null;
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
		List<ItemDTO> itemDTOList = new ArrayList<>();
		UserBO loginUser = BizUtil.getLoginUser(request);
		List<ItemBO> itemList = itemService.getItemByUserId(loginUser.getUserId(), LockerConstants.MY_ITEM_STATUS_LIST);
		// 组装DTO
		if (!CollectionUtils.isEmpty(itemList)) {
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
				dto.setComment(MockUtil.MOCK_COMMENT_NUMBER);
				itemDTOList.add(dto);
			}
		}
		writeJsonMsg(response, true, itemDTOList);
		return null;
	}
	
	/**
	 * 获取注册验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mine/getRegisterVerifyCode.json", method = RequestMethod.POST)
	public Object getRegisterVerifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phoneNumber = request.getParameter("phoneNumber");
		UserBO userBO = userService.getUserByPhoneNumber(phoneNumber.trim());
		if(userBO != null) {
			writeJsonMsg(response, false, "手机号"+phoneNumber+"已经注册");
			return null;
		}
		
		RegisterCodeBO codeBO = new RegisterCodeBO();
		codeBO.setRegisterCode(String.valueOf(new Random().nextInt(999999)));
		codeBO.setCreateTime(new Date());
		codeBO.setEditor(LockerConstants.EDITOR_SYSTEM);
		codeBO.setEditTime(new Date());
		codeBO.setExpireTime(LockerConstants.VERIFY_CODE_EXPIRE_TIME); // 10分钟
		codeBO.setStatus(LockerConstants.BaseDataStatus.VALID.toString());
		codeBO.setRegisterId(phoneNumber.trim());
		registerCodeService.createRegisterCode(codeBO);
		
		writeJsonMsg(response, true, codeBO.getRegisterCode());
		return null;
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mine/register.json", method = RequestMethod.POST)
	public Object register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phoneNumber = request.getParameter("phoneNumber").trim();
		String password = request.getParameter("password").trim();
		String verifyCode = request.getParameter("verifyCode").trim();
		
		//校验验证码
		RegisterCodeBO codeBO = registerCodeService.getRegisterCode(phoneNumber, verifyCode);
		if(System.currentTimeMillis() > (codeBO.getCreateTime().getTime()+codeBO.getExpireTime()) ) {
			writeJsonMsg(response, false, "验证码已过期");
		}
		
		UserBO userBO = new UserBO();
		userBO.setPhoneCountry(86);
		userBO.setPhoneNumber(phoneNumber);
		userBO.setPassword(password);
		userBO.setStatus(LockerConstants.UserStatus.VALID.getCode());
		userBO.setNick(MockUtil.getRandomNick());
		userBO.setMinIconUrl(MockUtil.MOCK_ICON_URL);
		UserBO registUser = userService.register(userBO);
		
		writeJsonMsg(response, true, registUser.getUserId());
		return null;
	}
	
	
	 public static void main(String[] arg) {
		 long time = System.currentTimeMillis();
		 System.out.println(time);
		 time = time+1000*60*10;
		 Date date = new Date(time);
		 System.out.println(date);
	 }
  
}
