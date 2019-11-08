package com.iec.entity;

public class UserCrediantls {
	private String userId;
	private String password;
	private String userType;
	private int loginStatus;

	public UserCrediantls() {

	}

	public UserCrediantls(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;

	}



	public UserCrediantls(String userId, String password, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
