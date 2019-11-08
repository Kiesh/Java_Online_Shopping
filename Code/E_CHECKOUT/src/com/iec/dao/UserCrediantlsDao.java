package com.iec.dao;

import com.iec.entity.UserCrediantls;

public interface UserCrediantlsDao
{
	
	public  boolean loginStatus(UserCrediantls user);
	
	public String userType(UserCrediantls user);
	
	public String addUserCrediantls(UserCrediantls crediantls);
	

}
