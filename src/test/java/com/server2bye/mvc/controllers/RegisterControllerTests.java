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

@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterControllerTests extends AbstractContextControllerTests{
	
	@Before
	public void setup() throws Exception {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();

		objectMapper = new ObjectMapper();
		jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
				System.out, JsonEncoding.UTF8);
	}
	
	@Test
	public void testUserRegisterByRest() throws Exception {
		
		String mobile = "13842295199";
		String birthday = "1984-09-30";
		String password = "123456";
		String gender = "male";
		String userType = "buiness"; //{business | individual}
		
		
		String filePath = "D:\\free.jpg";
		File file = new File(filePath);
		String fileToUpload = file.getPath();
		
		System.out.println(fileToUpload);
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		map.add("mobile", mobile);
		map.add("birthday", birthday);
		map.add("password", password);
		map.add("gender", gender);
		map.add("userType", userType);
		map.add("head", new FileSystemResource(fileToUpload));
		String result = restTemplate.postForObject("http://localhost:8080/server2bye/register/add_user", map, String.class);
		System.out.println(result);
	}
}
