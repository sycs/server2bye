package com.server2bye.mvc.lbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/lbs")
public class LBSController {

	@RequestMapping(value = "/update_pos/{tokenid}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Map<String, String> updatePosition(
			@RequestParam(value="tokenid", required=true) String tokenid,
			@RequestParam(value="uid", required = true) String uid,
			@RequestParam(value="longitude", required = true) String longitude,
			@RequestParam(value="latitude", required = true) String latitude,
			HttpServletRequest request, HttpSession session){
		
		Map<String,String> response = new HashMap<String, String>();
		System.out.println("!!!!!!!!!!!!!!"+request.getParameter("uid"));
		
		response.put("ret", "1");
		response.put("errcode", "10001");
		return response;
	}
	
	@RequestMapping(value = "/delete_pos/{tokenid}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Map<String, String> deletePosition(
			@RequestParam(value="tokenid", required=true) String tokenid,
			@RequestParam(value="uid", required = true) String uid,
			HttpServletRequest request, HttpSession session){
		
		Map<String,String> response = new HashMap<String, String>();
		System.out.println("!!!!!!!!!!!!!!"+request.getParameter("uid"));
		
		response.put("ret", "1");
		response.put("errcode", "10001");
		return response;
	}
}
