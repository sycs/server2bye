package com.server2bye.mvc.register.controller;

/**
 * 
 **/
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.server2bye.mvc.register.commands.RegisterCommand;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@RequestMapping(value = "/verify_mobile", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> verifyMobile(@RequestParam("mobile") String mobile) {
		Map<String, String> response = new HashMap<String, String>();

		System.out.println(mobile);
		// 发送短信
		response.put("ret", "1");
		response.put("errcode", "10001");
		return response;
	}

	@RequestMapping(value = "/check_authcode", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> checkAuthCode(@RequestParam("authcode") String authcode) {
		Map<String, String> response = new HashMap<String, String>();

		System.out.println(authcode);
		// 发送短信
		response.put("ret", "1");
		response.put("errcode", "10001");
		return response;
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> addUser(
			@RequestParam(value="head", required = true) MultipartFile file,
			HttpServletRequest request, HttpSession session) {
		Map<String, String> response = new HashMap<String, String>();
		System.out.println(file.getOriginalFilename());
		System.out.println(request.getParameter("birthday"));
		// 发送短信
		response.put("ret", "1");
		response.put("errcode", "10001");
		response.put("tokenid", "dfc7ad3884e7");
		return response;
	}
}
