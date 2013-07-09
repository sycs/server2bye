package com.server2bye.mvc.generator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;




public class RequestGenerator {

	public static RequestBuilder createLoginUserByJson(String username, String password){
		final String json = "{\"userName\":\"" + username + "\",\"password\":\""+ password + "\"}";
		System.out.println(json);
		return post("/user/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.getBytes());
	}
	
}
