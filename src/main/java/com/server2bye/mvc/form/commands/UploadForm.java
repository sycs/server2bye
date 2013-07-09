package com.server2bye.mvc.form.commands;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@XmlRootElement
public class UploadForm {

	private List<CommonsMultipartFile> fileData;
	
	public List<CommonsMultipartFile> getFileData() {
		return fileData;
	}

	public void setFileData(List<CommonsMultipartFile> fileData) {
		this.fileData = fileData;
	}
}
