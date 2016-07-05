<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateCustomer.do?id=<%=request.getAttribute("Id") %>">
<table>
<tr>
<td>
</td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" value=<%=request.getAttribute("Name") %>></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" value=<%=request.getAttribute("Address") %>></td>
<tr>
<td>Phone:</td>
<td><input type="text" name="phone" value=<%=request.getAttribute("Phone") %>></td>
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