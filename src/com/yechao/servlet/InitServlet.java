package com.yechao.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.yecaho.daoStart.DaoStart;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		DaoStart.getInstance().setTypeString("jdbc");
		// TODO Auto-generated method stub
		InputStream inputStream=getServletContext().getResourceAsStream("/WEB-INF/classes/antx.properties");
		Properties properties=new Properties();
		try {
			properties.load(inputStream);
			String typeString=properties.getProperty("com.yechao.start.type");
			DaoStart.getInstance().setTypeString(typeString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log("ddddd");
			log("´íÎó", e);
		}
		
	}
       
}
