package com.yechao.dao.imp;

import com.yechao.dao.Dao;
import com.yechao.dao.UserDao;
import com.yechao.module.User;

public class UserDaoJdbcImp extends Dao<User> implements UserDao{

	@Override
	public boolean login(String username, String passwd) {
		// TODO Auto-generated method stub
		String mysql="select count(id) from users where name=? and password=?";
		long num=getForvale(mysql, username,passwd);
		if (num==1) {
			return true;
		}else {
			return false;
		}
	}
	

}
