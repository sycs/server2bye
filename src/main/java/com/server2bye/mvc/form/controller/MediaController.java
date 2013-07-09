package com.server2bye.mvc.form.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.helpers.MessageFormatter;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/media")
public class MediaController {

	@RequestMapping(value = "/upload", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody Map<String,String> upload(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
        if (req instanceof MultipartHttpServletRequest) {
            final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
            String tokenId = multiRequest.getParameter("tokenid").toString();
            System.out.println(tokenId);
            final Map<String, MultipartFile> files = multiRequest.getFileMap();
            Collection<MultipartFile> values = files.values();
            for (Iterator<MultipartFile> iterator = values.iterator(); iterator.hasNext(); ) {
                Object next = iterator.next();
                MultipartFile file = (MultipartFile) next;
                System.out.println(MessageFormatter.arrayFormat("Name [{}] Content Type [{}] Original Filename [{}] Size [{}]", new String[]{
                    file.getName(), file.getContentType(), file.getOriginalFilename(), "" + file.getSize()
                }));
            }
        } else {
            throw new RuntimeException("Invalid Request Type");
        }
        Map<String,String> response = new HashMap<String, String>(); 
		response.put("ret", "1");
		response.put("errcode", "1");
		return response;
    }

}
