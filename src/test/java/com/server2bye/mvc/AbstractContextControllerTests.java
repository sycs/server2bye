package com.server2bye.mvc;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@WebAppConfiguration
@ContextConfiguration("classpath:spring/appServlet/test-context.xml")
public class AbstractContextControllerTests {

	@Autowired
	protected WebApplicationContext wac;
	@Autowired
	protected RequestMappingHandlerAdapter handlerAdapter;
	@Autowired
	protected RequestMappingHandlerMapping handlerMapping;
	@Autowired
	@Qualifier("restTemplate")
	protected RestTemplate restTemplate;
	
	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;
	protected JsonGenerator jsonGenerator;
	protected ObjectMapper objectMapper;
	protected URLConfig config;
	
	protected HttpClient httpClient;
	protected HttpPost httpPost;
	protected MultipartEntity multipartEntity;
	protected HttpResponse httpResponse;
	protected HttpEntity httpEntity;
}
