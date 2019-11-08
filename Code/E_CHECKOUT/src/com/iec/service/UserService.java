package com.iec.service;

import com.iec.entity.UserCrediantls;

import com.iec.entity.UserProfile;

public interface UserService 
{
	public  boolean loginStatus (UserCrediantls user);
	
	public String userType(UserCrediantls user);
	
	public String registration(UserCrediantls user ,UserProfile profile );
}
