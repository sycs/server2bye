package com.server2bye.mvc.register.commands;

import org.codehaus.jackson.annotate.JsonProperty;


public class RegisterCommand {
	
	@JsonProperty("mobile")
	private String mobile;
	@JsonProperty("password")
	private String password;
	@JsonProperty("sex")
	private String sex;
	@JsonProperty("birthday")
	private String birthday;
	@JsonProperty("userType")
	private String userType;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
