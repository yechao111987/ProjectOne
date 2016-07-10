package com.yechao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
public class CustomerServletContextListener implements ServletContextListener,ServletRequestListener,HttpSessionIdListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServletContext contextDestroyed"+arg0.getServletContext());
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServletContext contextInitialized"+arg0.getServletContext());
		
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
