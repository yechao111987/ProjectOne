<%@page import="com.yechao.module.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content=$(this).parent().parent().find("td:eq(1)").text();
			var flag=confirm("Are you sure to delete "+content+ " info?");
			return flag;
		});
	})
</script>

</head>
<body>
	<%
	//若可以获取到请求参数username,则打出欢迎信息。把登陆信息存储在cookies中，并设置cookie时间
	//从cookies中获取用户信息，若存在，则显示欢迎信息
	//若既无参数，又无cookie，则重定向到login.jsp
	//String usernameString=request.getParameter("username");
	//if(usernameString != null && usernameString.trim().equals("yechao")){
	//}	
	%>
	
	
	
	<form action="query.do" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name ="name" /></td>
				<td>Address:</td>
				<td><input type="text" name ="address" /></td>
				<td>Phone:</td>
				<td><input type="text" name ="phone" /></td>
			</tr>
			<tr><td><hr></td></tr>		
			<tr>
				<td><input type="submit" value="query" /></td>
				<td><a href="add.jsp">ADD new customer</a>			
			</tr>		
		</table>
		<br>
	<h2>This is query result:</h2>
	<%
		List<Customer> customers =(List<Customer>)request.getAttribute("Customers");
		if(customers==null){
			System.out.println("null");
		}
		if(customers != null && customers.size() > 0){
	%>
	<hr>
	<br><br>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
				
			</tr>
			<%
				for(Customer customer:customers){
			%>
			<tr>
				<td><%=customer.getId() %></td>
				<td><%=customer.getName() %></td>
				<td><%=customer.getAddress() %></td>
				<td><%=customer.getPhone() %></td>
				<td>
					<a href="updateJsp.do?id=<%=customer.getId()%>">update</a>
					<a href="delete.do?id=<%=customer.getId()%>" class="delete">delete</a>					
				</td>
				
			</tr>
			<% 
				}
			%>
		</table>
	<%	
		}
	%>
	</form> 

</body>
</html>