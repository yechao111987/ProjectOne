<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Demo Page</h1>
<h2>demo1</h2>
<a href="customerServlet?method=add">add</a>
<br>
<a href="customerServlet?method=query">query</a>
<br>
<a href="customerServlet?method=delete">delete</a>

<h2>demo2</h2>
<a href="addCustomer.do">add.do</a>
<br>
<a href="query.do">query.do</a>
<br>
<a href="deleteCustomer.do">delete.do</a>
<br>
<a href="error.do">error.do</a>



</body>
</html>