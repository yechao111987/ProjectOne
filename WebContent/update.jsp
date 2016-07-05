<%@page import="com.yechao.dao.CustomerDao"%>
<%@page import="com.yechao.module.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<h1>Update a Customer</h1>
<%
Customer customer=(Customer)request.getAttribute("Customer");
%>
<h2><%=request.getAttribute("Message") %></h2>
<form action="updateCustomer.do?id=<%=customer.getId()%>">
<table>
<%
request.setAttribute("id", customer.getId());
System.out.println(request.getSession());
System.out.println(customer.getId());
Object aa=request.getAttribute("id");
System.out.println(aa);
%>
<tr>
<td>
<input type="hidden" name="id" value=<%=customer.getId() %> >
<input type="hidden" name="oldName" value=<%=customer.getName() %> >
</td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" value=<%=customer.getName() %>><%=customer.getName() %></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" value=<%=customer.getAddress() %>><%=customer.getAddress() %></td>
<tr>
<td>Phone:</td>
<td><input type="text" name="phone" value=<%=customer.getPhone() %>><%=customer.getPhone() %></td>
</tr>
<tr></tr>
<tr><td><hr></td></tr>
<tr></tr>
<tr>
<td><input type="submit" value="update"></td>
</tr>
</table>
</form>
</body>
</html>