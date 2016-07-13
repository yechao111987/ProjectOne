//package com.yechao.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.yechao.dao.UserDao;
//import com.yechao.dao.imp.UserDaoJdbcImp;
//
//public class Loginfilter implements Filter {
//	private UserDao userDao =new UserDaoJdbcImp();
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		System.out.println("destroy");
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1,
//			FilterChain arg2) throws IOException, ServletException {
//		System.out.println("dofilter");
////		String nameString=arg0.getParameter("username");
////		String passwdString=arg0.getParameter("passwd");
////		System.out.println(nameString);
////		if(userDao.login(nameString, passwdString)){
////			arg2.doFilter(arg0, arg1);
////			System.out.println("用户名和密码正确");
////		}else {
////			System.out.println("用户名或者密码不正确");
////			HttpServletRequest request=(HttpServletRequest) arg0;
////			request.setAttribute("info", "用户名或者密码不正确");
////			arg0.getRequestDispatcher("/Login.jsp").forward(arg0, arg1);
////		}	
//		arg2.doFilter(arg0, arg1);
//		}			
//		
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		System.out.println("filter初始化");	
//	}
//
//
//
//}
