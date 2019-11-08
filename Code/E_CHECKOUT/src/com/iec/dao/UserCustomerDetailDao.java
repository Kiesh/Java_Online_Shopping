package com.iec.dao;

import java.util.ArrayList;

import com.iec.entity.UserCustomerDetail;
import com.iec.entity.UserProfile;
import com.iec.service.test.UserServiceCustomerDetail;

public interface UserCustomerDetailDao 
{
	
	
	ArrayList<UserProfile>getAll();
	
	public String delete(UserCustomerDetail customerDetail );
	
	//public String update (UserCustomerDetail detail);

}
