package com.yechao.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.org.apache.xpath.internal.operations.And;
import com.yecaho.daoStart.DaoStart;
import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.dao.imp.CustomerDaoJdbcImp;
import com.yechao.dao.imp.CustomerDaoXMLImp;
import com.yechao.module.Customer;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//使用了多态
	//private CustomerDao customerDao= new CustomerDaoJdbcImp();
	//private CustomerDao customerDao=new CustomerDaoXMLImp();
	private CustomerDao customerDao=DaoStart.getInstance().getCustomerDao();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);//what means???
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String method=request.getParameter("method");
//		//System.out.print(method);
//
//		switch (method) {
//		case "add":add(request,response);break;
//		case "delete":delete(request,response);break;
//		case "query":query(request,response);break;
//		}
//		
//	}


	//@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String servletPath=req.getServletPath();
		//System.out.println(servletPath);
		//String methodname=servletPath.substring(1);
		String methodname=servletPath.substring(1, servletPath.length()-3);
		//System.out.println(methodname);
//		try {
//			//获取运行类的的类名称 1
//			//Class<?> classType=Class.forName("java.lang.String");
//			//获取允运行类的类名称   2
//			Class<?> classType=Customer.class;
//			
//			//新建类的对象
//			Object customer1=classType.newInstance();
//			System.out.println("customer1:"+customer1);
//			//获取方法
//			Method[] stringMethods=classType.getMethods();
//			Method stringMethods1=classType.getMethod("setAddress1",new Class[]{String.class});
//			System.out.println("stringMethods1:"+stringMethods1);
//			//使用方法
//			Object resultObject=stringMethods1.invoke(customer1, new Object[]{("我的地址")});
//			System.out.println("resultObject:"+resultObject);
//			System.out.println((String)resultObject);
//
//			
//			for (Method stringMethod : stringMethods) {
//				System.out.println(stringMethod);
//				//method.invoke(req, resp);
//			}
//			//System.out.println(stringMethod);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Method[] methods=getClass().getDeclaredMethods();
		try {
			//Method methods1=getClass().getMethod(methodname, new Class[]
			//		{HttpServletRequest.class,HttpServletResponse.class});
			Method method=getClass().getDeclaredMethod(methodname, 
							HttpServletRequest.class,HttpServletResponse.class);
			System.out.println("获取method方法："+method);
			method.invoke(this, req,resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No such Method");
			resp.sendRedirect("/ProjectOne/error.jsp");
		}

//		for (Method method : methods) {
//			System.out.println(method);
//			//method.invoke(req, resp);
//		}		
		//Method method=getClass().getDeclaredMethod(methodname, HttpServletRequest.class)
		//Method method= getClass().getDeclaredMethods(methodname,HttpServletRequest.class,
		//		HttpServletRequest.class);
		//method.invoke(this, req,resp);
		//method[0].invoke(this, HttpServlet);
		

		
	}
	
	
	private void login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("login");
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log("错误",e);
		}

//		String usernameString=request.getParameter("username");
//		//若可以获取到请求参数username,则打出欢迎信息。
//		if (usernameString != null && usernameString.trim().equals("yechao")){
//		
//			//把登陆信息存储在cookies中，并设置cookie时间
//			Cookie cookie=new Cookie("username",usernameString);
//			cookie.setMaxAge(3000);
//			//cookie.setPath("/");
//			response.addCookie(cookie);	
//			try {
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else {
//			//从cookies中获取用户信息，若存在，则显示欢迎信息
//			Cookie [] cookies=request.getCookies();
//			if(cookies !=null &&cookies.length>0){
//				for(Cookie cookie:cookies){
//					String cookienameString=cookie.getName();
//					if("username".equals(cookienameString)){
//						String cookievalueString=cookie.getValue();
//						request.setAttribute("username", cookievalueString);
//						try {
//							request.getRequestDispatcher("index.jsp").forward(request, response);
//						} catch (ServletException | IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						
//					}
//			}
//				try {
//					response.sendRedirect("Login.jsp");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			else {
//				try {
//					response.sendRedirect("Login.jsp");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
	}

	
	private void query(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("username".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					//request.setAttribute("username", cookievalueString);
					try {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}}else{
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		Critalfactor cc=new Critalfactor(name, address, phone);
		//1.使用customerDao的getAll（）方法获取Customer的集合
		List<Customer> customers=customerDao.getSearch(cc);
		//2.吧Customer的集合放入request中
		request.setAttribute("Customers", customers);
		//3.转发页面到indexs.jsp
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("username".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					request.setAttribute("username", cookievalueString);
					try {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}}else{
		String idsString=request.getParameter("id");
		int id=0;
		try {
			id=Integer.parseInt(idsString);
			customerDao.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			response.sendRedirect("query.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		

	}
	
	private void updateJsp(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("updateJsp");
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("username".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					request.setAttribute("username", cookievalueString);
					try {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}}else{
		String idString=request.getParameter("id");
		int id=0;
		id=Integer.parseInt(idString);
		Customer customer=customerDao.get(id);
		request.setAttribute("Customer", customer);
		try {
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

		
	}
	
	private void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateCustomer");
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("username".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					request.setAttribute("username", cookievalueString);
					try {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}}else{
		request.setCharacterEncoding("utf-8");
		String nameString=request.getParameter("name");
		String addressString=request.getParameter("address");
		String phoneString=request.getParameter("phone");
		String oldNameString=request.getParameter("oldName");
//		Integer id=(Integer)request.getAttribute("id");
		String idsString =request.getParameter("id");
		Integer id=Integer.parseInt(idsString);
//		System.out.println(request.getAttribute("id"));
//		System.out.println(request.getSession());
//		System.out.println(id);
		Critalfactor cc=new Critalfactor(nameString,addressString,phoneString);
		if (customerDao.getCountByName(nameString)>1) {
			String messageString="The Name is Used!";
			request.setAttribute("Message", messageString);
			request.getRequestDispatcher("updateJsp.do").forward(request, response);
			//request.getRequestDispatcher("updateFail.jsp").forward(request, response);
			//response.sendRedirect("updateFail.jsp");

		
			
		} else {
			if (oldNameString != nameString && customerDao.getCountByName(nameString)==1) {
				String messageString="The Name is Used!";
				request.setAttribute("Message", messageString);
				request.setAttribute("Address", addressString);
				request.setAttribute("Phone", phoneString);
				request.setAttribute("id", idsString);
				request.setAttribute("oldName", oldNameString);
				request.getRequestDispatcher("updateNew.jsp").forward(request, response);
				//此处可以新建一个页面，作为新的参数带出
			}
			else{
			customerDao.updateById(id, cc);
			try {
				response.sendRedirect("updateSuc.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}}
		
		
		
	}
	

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("add");
		//获取请求的参数
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("username".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					request.setAttribute("username", cookievalueString);
					try {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}}else{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String nameString=request.getParameter("name");
		//System.out.println(nameString);
		String addressString=request.getParameter("address");
		String phoneString=request.getParameter("phone");
		//构建一个Customer类，把参数传进去
		if (customerDao.getCountByName(nameString)>0) {
			String messageString="The name is used.";
			request.setAttribute("Message", messageString);
			try {
				request.getRequestDispatcher("add.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			Customer customer=new Customer();
			customer.setName(nameString);
			customer.setAddress(addressString);
			customer.setPhone(phoneString);
			customerDao.Save(customer);
			try {
				response.sendRedirect("query.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	}}

	}

