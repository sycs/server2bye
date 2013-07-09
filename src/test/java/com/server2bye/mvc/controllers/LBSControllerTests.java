package com.server2bye.mvc.controllers;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.server2bye.mvc.AbstractContextControllerTests;
import com.server2bye.mvc.URLConfig;

@RunWith(SpringJUnit4ClassRunner.class)
public class LBSControllerTests extends AbstractContextControllerTests {

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
	public void testUpdatePos() throws Exception {
		String requestURL = config.url2bye+"/lbs/update_pos/{tokenid}";
		String tokenid = "uiklsdhinosk";
		String uid = "10010";
		String longitude = "15855.02512";
		String latitude = "1652.502";

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("tokenid", tokenid);
		map.add("uid", uid);
		map.add("longitude", longitude);
		map.add("latitude", latitude);

		String result = restTemplate.postForObject(requestURL, map,String.class, tokenid);

		System.out.println(result);
	}
	
	@Test
	public void testDeletePos() throws Exception {
		String requestURL = config.url2bye+"/lbs/delete_pos/{tokenid}";
		String tokenId = "uiklsdhinosk";
		String uId = "10010";
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("tokenid", tokenId);
		map.add("uid", uId);
		
		String result = restTemplate.postForObject(requestURL, map,String.class, tokenId);

		System.out.println(result);
	}
}
