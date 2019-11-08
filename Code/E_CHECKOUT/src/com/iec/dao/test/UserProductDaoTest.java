package com.iec.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iec.dao.UserProductDao;
import com.iec.dao.impl.UserProductDaoImpl;
import com.iec.entity.UserProduct;

public class UserProductDaoTest {

	@Test
	public void testAdd() 
	{
		
		UserProductDao userProductDao=new UserProductDaoImpl();
		
		
		//UserProduct userProduct=new UserProduct();
		//assertEquals(1, userProductDao.add(userProduct));
		
		
	}

}
