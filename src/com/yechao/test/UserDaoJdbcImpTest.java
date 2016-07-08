package com.yechao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yechao.dao.UserDao;
import com.yechao.dao.imp.UserDaoJdbcImp;

public class UserDaoJdbcImpTest {
	private UserDao userDao =new UserDaoJdbcImp();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		//fail("Not yet implemented");
		Boolean t;
		t=userDao.login("", "");
		System.out.println(t);
		
	}

}
