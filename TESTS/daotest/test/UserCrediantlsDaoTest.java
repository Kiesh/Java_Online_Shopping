package com.iec.dao.test;

import static org.junit.Assert.*;


import org.junit.Ignore;
import org.junit.Test;

import com.iec.dao.UserCrediantlsDao;
import com.iec.dao.impl.UserCrediantlsDaoImpl;
import com.iec.entity.UserCrediantls;

public class UserCrediantlsDaoTest {

	@Test
	public void testLoginStatus() {
		UserCrediantlsDao dao = new UserCrediantlsDaoImpl();
		UserCrediantls crediantls = new UserCrediantls("admin", "admin");
		assertTrue(dao.loginStatus(crediantls));

	}

	@Test
	public void testUserType() {
		UserCrediantlsDao dao = new UserCrediantlsDaoImpl();
		UserCrediantls crediantls = new UserCrediantls("staff", "staff");
		assertEquals("S", dao.userType(crediantls));

	}

	@Test
	public void testAddUserCrediantls() {
		UserCrediantlsDao dao = new UserCrediantlsDaoImpl();
		UserCrediantls crediantls = new UserCrediantls("staff", "staff", "S");
		equals(0);

	}

}
