package com.server2bye.mvc.user.commands;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {
	private String tobyeid;
	private String tokenid;
	private CommonsMultipartFile fileData;
	
	public String getTobyeid() {
		return tobyeid;
	}
	public void setTobyeid(String tobyeid) {
		this.tobyeid = tobyeid;
	}
	public String getTokenid() {
		return tokenid;
	}
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	
	
}
