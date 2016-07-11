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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);//what means???
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String servletPath=req.getServletPath();
		log(servletPath);
		String methodname=servletPath.substring(1, servletPath.length()-3);
		log(methodname);
		log("通过java反射机制获取运行时方法和对象。");
		try {
			Method method=getClass().getDeclaredMethod(methodname, 
							HttpServletRequest.class,HttpServletResponse.class);
			System.out.println("获取method方法："+method);
			method.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/ProjectOne/error.jsp");
		}		
	}
	
	
	private void login(HttpServletRequest request,HttpServletResponse response) {
		log("调用login方法");
		log("写入cookie");
		String nameString=request.getParameter("username");
		String passwdString=request.getParameter("passwd");
		String loginString=passwdString+nameString;
		Cookie cookie=new Cookie("login", loginString);
		cookie.setMaxAge(100);
		//cookie.setPath("/");//设置cookie作用域
		response.addCookie(cookie);
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			log("找不到index.jsp",e);
		}		
	}

	
	private void query(HttpServletRequest request, HttpServletResponse response) {
		log("query");
		Cookie [] cookies=request.getCookies();
		if(cookies !=null &&cookies.length>0){
			for(Cookie cookie:cookies){
				String cookienameString=cookie.getName();
				if("login".equals(cookienameString)){
					String cookievalueString=cookie.getValue();
					log("cookie的值:"+cookievalueString);
					if (cookievalueString=="yechaoyechao") {
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
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						}	
					}
				}}else {
					try {
						response.sendRedirect("Login.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
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

