package com.iec.serviceDao.impl;

import com.iec.dao.UserCrediantlsDao;

import com.iec.dao.UserProfileDao;
import com.iec.dao.impl.UserCrediantlsDaoImpl;
import com.iec.dao.impl.UserProfileDaoImpl;
import com.iec.entity.UserCrediantls;
import com.iec.entity.UserProfile;
import com.iec.service.UserService;

public class UserServiceImpl implements UserService 
{
	private UserCrediantlsDao crediantlsDao = new UserCrediantlsDaoImpl();
		
	   // object of interface of dao layer in service layer
	
	private UserProfileDao userProfileDao = new UserProfileDaoImpl();

	// object of interface of dao layer in service layer

	public boolean loginStatus(UserCrediantls user) {
		// validation
		if (user.getUserId() == null) {
			return false;

		}
		if (user.getUserId().isEmpty()) {
			return false;
		}
		if (user.getPassword() == null) {
			return false;
		}
		if (user.getPassword().isEmpty()) {
			return false;
		}
		boolean response = crediantlsDao.loginStatus(user);
		return response;
	}

	public String userType(UserCrediantls user) {
		// validation
		if (user.getUserId() == null) {
			return "FAIL";

		}
		if (user.getUserId().isEmpty()) {
			return "FAIL";
		}

		String response = crediantlsDao.userType(user);
		return response;

	}

    
	public String registration(UserCrediantls crediantls, UserProfile profile)
    {
		String result="Fail";
		
		String Ouputusercrediantle=crediantlsDao.addUserCrediantls(crediantls);
		
		if(Ouputusercrediantle.equals("SUCCESS"))
		{
			System.out.println(2);
			
			String Outputuserprofile=userProfileDao.addUserProfile(profile);
			
			if(Outputuserprofile.equals("SUCCESS"))
			{
				System.out.println(3);
				result="SUCCESS";
				
			}
		}
            return result;


	}

}
