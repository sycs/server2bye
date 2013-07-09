package com.server2bye.mvc.controllers;

import java.io.File;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.server2bye.mvc.AbstractContextControllerTests;
import com.server2bye.mvc.URLConfig;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTests extends AbstractContextControllerTests {

	@Before
	public void setup() throws Exception {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();

		objectMapper = new ObjectMapper();
		jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
				System.out, JsonEncoding.UTF8);

		config = new URLConfig();
	}

	@Test
	public void testUserLoginByRest() throws Exception {

		// API request URL
		String requestURL = config.url2bye + "/user/login";
		// API request parameters
		String mobile = "13842295199";
		String password = "desfxef2334";

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userName", mobile);
		map.add("password", password);
		String result = restTemplate.postForObject(requestURL, map,
				String.class);
		System.out.println(result);
	}

	@Test
	public void testUserLoginByMock() throws Exception {
		// API request URL
		String requestURL = "/user/login";

		request.setRequestURI(requestURL);
		request.setMethod("POST");
		request.addParameter("userName", "Õı÷–¡¡");
		request.addParameter("password", "1234");
		Object handler = handlerMapping.getHandler(request).getHandler();
		handlerAdapter.handle(request, response, handler);
		System.out.println(response.getContentAsString());
	}

	@Test
	public void testGetUserInfo() throws Exception {

		// API request URL
		String requestURL = config.url2bye + "/user/info/{tokenid}";
		// API request parameters
		String tobyeId = "525252228";
		String tokenId = "dfc7ad3884e7";

		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("tobyeid", tobyeId);
		parts.add("tokenid", tokenId);
		String response = restTemplate.postForObject(requestURL, parts,
				String.class, tokenId);
		System.out.println(response);
	}

	@Test
	public void testUpdateHead() throws Exception {

		// API request URL
		String requestURL = config.url2bye + "/user/update_head/{tokenid}";
		// API request parameters
		String tobyeId = "525252228";
		String tokenId = "dfc7ad3884e7";
		String filePath = "D:\\free.jpg";

		File file = new File(filePath);
		String fileToUpload = file.getPath();
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("tobyeid", tobyeId);
		parts.add("tokenid", tokenId);
		parts.add("head", new FileSystemResource(fileToUpload));
		String response = restTemplate.postForObject(requestURL, parts,
				String.class, tokenId);
		System.out.println(response);
	}
}
