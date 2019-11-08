package com.iec.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.iec.dao.UserCustomerDetailDao;
import com.iec.dao.impl.UserCustomerDetailDaoImpl;
import com.iec.entity.UserProfile;

public class UserCustomerDetailDaoTest {

	@Test
	public void testGetAll() {

		UserProfile profile = new UserProfile();
		
		UserCustomerDetailDao customerDetailDao = new UserCustomerDetailDaoImpl();
		
		ArrayList<UserProfile> list = customerDetailDao.getAll();
		
		for (UserProfile userProfile : list) 
		{
			System.out.println(userProfile.getFirstName());
			
		}
		assertNotNull(list);

	}

}
