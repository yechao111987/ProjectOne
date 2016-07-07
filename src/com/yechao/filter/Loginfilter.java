package com.yechao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.yechao.dao.UserDao;
import com.yechao.dao.imp.CustomerDaoJdbcImp;
import com.yechao.dao.imp.UserDaoJdbcImp;

public class Loginfilter implements Filter {
	private UserDao userDao =new UserDaoJdbcImp();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("dofilter");
		String nameString=arg0.getParameter("username");
		String passwdStringS=arg0.getParameter("passwd");
		System.out.println(nameString);
		if(userDao.login(nameString, passwdStringS)){
			arg2.doFilter(arg0, arg1);
		}else {
			arg0.getRequestDispatcher("/Login.jsp").forward(arg0, arg1);
		}
			
//		if (!nameString.equals("yechao") || nameString.isEmpty()) {
//			arg0.getRequestDispatcher("/Login.jsp").forward(arg0, arg1);
//			}
//			else {
//				arg2.doFilter(arg0, arg1);
//			}
		}
		

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
		
	}



}
