package com.share.locker.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.service.util.MockUtil;
import com.share.locker.web.dto.ValidLockerDTO;

@Controller
public class LockerController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(LockerController.class);

	/**
	 * 获取用户周边可用的locker
	 * 
	 * @param request
	 *            包括：lockerSize，经纬度
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/locker/getValidLocker.json", method = RequestMethod.POST)
	public Object closeLockerAfterPut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String lockerSize = request.getParameter("lockerSize");
		Long latitude = Long.parseLong(request.getParameter("latitude"));
		Long longitude = Long.parseLong(request.getParameter("longitude"));

		writeJsonMsg(response, true, mockGetValidLockerList());
		return null;
	}

	private List<ValidLockerDTO> mockGetValidLockerList() {
		List<ValidLockerDTO> list = new ArrayList<>();
		Long currentTime = System.currentTimeMillis();
		for (int i = 0; i < MockUtil.MACHINE_NAME_LIST.length; i++) {
			ValidLockerDTO dto = new ValidLockerDTO(); 
			Long lockerId = currentTime+i;
			dto.setLockerId(lockerId);
			dto.setMachineName(MockUtil.getMachineNameBylockerId(lockerId));
			list.add(dto);
		}
		return list;
	}
	
	

}
