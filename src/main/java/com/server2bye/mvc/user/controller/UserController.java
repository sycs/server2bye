package com.server2bye.mvc.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.server2bye.mvc.user.commands.UploadItem;
import com.server2bye.mvc.user.domains.User;

/**
 * Including method: "/user" : home "/user/login" : userLogin "/user/logout" :
 * userLogout "/user/info" : getUserInfo "/user/update_head" : updateHead
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Map<String, String> userLogin(
			@RequestParam(value = "userName", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request) {
		Map<String, String> response = new HashMap<String, String>();
		System.out.println("!!!!!!!!!!!!!!" + request.getParameter("userName"));
		User user = new User();
		user.setMobile(username);
		System.out.println(user.getMobile());
		response.put("code", "1");
		response.put("tokenid", "dfc7ad3884e7");
		response.put("errcode", "10001");
		return response;
	}

	@RequestMapping(value = "/logout/{tokenid}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Map<String, String> userLogout(@PathVariable("tokenid") String tokenid) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("code", "2");
		return response;
	}

	@RequestMapping(value = "/info/{tokenid}", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> getUserInfo(@RequestParam("tobyeid") String tobyeid,
			@PathVariable("tokenid") String tokenid) {
		System.out.println(tokenid + ":" + tobyeid);
		Map<String, String> response = new HashMap<String, String>();
		response.put("ret", "1");
		response.put("errcode", "10001");
		response.put("tobyeid", "525252228");
		response.put("nickname", "Peterظ");
		response.put("sex", "1");
		response.put("mobile", "13842277555");
		response.put("birthday", "1984/08/08");
		response.put("usertype", "1");
		response.put("head_img_url", "/user/getheadimg?tobyeid=525252228");
		return response;
	}

	@RequestMapping(value = "/update_head/{tokenid}", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> updateHead(
			@RequestParam(value = "head", required = true) MultipartFile file,
			@RequestParam(value = "tobyeid", required = true) String tobyeid,
			@RequestParam(value = "tokenid", required = true) String tokenid,
			HttpSession session) {
		System.out.println(file.getOriginalFilename());
		Map<String, String> resp = new HashMap<String, String>();
		
		/*
		 * if (result.hasErrors()) { for (ObjectError error :
		 * result.getAllErrors()) { System.err.println("Error: " +
		 * error.getCode() + " - " + error.getDefaultMessage()); }
		 * resp.put("ret", "1"); return resp; }
		 * System.err.println("-------------------------------------------");
		 * try { MultipartFile file = uploadItem.getFileData(); String fileName
		 * = null; InputStream inputStream = null; OutputStream outputStream =
		 * null; if (file.getSize() > 0) { inputStream = file.getInputStream();
		 * if (file.getSize() > 10000) { System.out.println("File Size:::" +
		 * file.getSize()); resp.put("ret", "1"); return resp; }
		 * System.out.println("size::" + file.getSize()); fileName =
		 * request.getRealPath("") + "/images/" + file.getOriginalFilename();
		 * outputStream = new FileOutputStream(fileName);
		 * System.out.println("fileName:" + file.getOriginalFilename());
		 * 
		 * int readBytes = 0; byte[] buffer = new byte[10000]; while ((readBytes
		 * = inputStream.read(buffer, 0, 10000)) != -1) {
		 * outputStream.write(buffer, 0, readBytes); } outputStream.close();
		 * inputStream.close(); }
		 * 
		 * // ..........................................
		 * session.setAttribute("uploadFile", file.getOriginalFilename()); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
		resp.put("ret", "0");
		return resp;
	}
}
