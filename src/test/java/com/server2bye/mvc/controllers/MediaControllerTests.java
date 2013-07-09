package com.server2bye.mvc.controllers;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server2bye.mvc.AbstractContextControllerTests;
import com.server2bye.mvc.URLConfig;


import org.apache.http.util.EntityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class MediaControllerTests extends AbstractContextControllerTests {

	@Before
	public void setup() throws Exception {
		httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        multipartEntity = new MultipartEntity();
        config = new URLConfig();
	}
	@Test
	public void testSaveFiles() throws Exception {

		// API request URL
		String requestURL = config.url2bye+"/media/upload";
		// API request parameters
		String tobyeId = "525252228";
		String tokenId = "dfc7ad3884e7";
		String imgPath1 = "D:\\psb1.jpg";
		String imgPath2 = "D:\\psb2.jpg";
		
		File fileS1 = new File(imgPath1);
		File fileS2 = new File(imgPath2);
        httpClient.getParams().setParameter("tokenid", tokenId);
        httpClient.getParams().setParameter("tobyeId", tobyeId);
        httpPost = new HttpPost(requestURL);
  
        ContentBody cb1 = new StringBody(tobyeId);
        ContentBody cb2 = new StringBody(tokenId);
        ContentBody file1 = new ByteArrayBody(FileUtils.readFileToByteArray(fileS1), "image/jpg", "a");
        ContentBody file2 = new ByteArrayBody(FileUtils.readFileToByteArray(fileS2), "image/jpg", "b");
  
        multipartEntity.addPart("tokenid", cb2);
        multipartEntity.addPart("tobyeid", cb1);
        multipartEntity.addPart("a", file1);
        multipartEntity.addPart("b", file2);
        httpPost.setEntity(multipartEntity);
  
        System.out.println("executing request " + httpPost.getRequestLine());
        httpResponse = httpClient.execute(httpPost);
        httpEntity = httpResponse.getEntity();
  
        System.out.println(httpResponse.getStatusLine());
        if (httpEntity != null) {
            System.out.println(EntityUtils.toString(httpEntity));
        }
  
        httpClient.getConnectionManager().shutdown();
	}
}
