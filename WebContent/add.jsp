<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add customers</title>
</head>
<body>

<h1>Add a Customer</h1>
<h2><%=request.getAttribute("Message") %></h2>
<form action="addCustomer.do">
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address"></td>
<tr>
<td>Phone:</td>
<td><input type="text" name="phone"></td>
</tr>
<tr></tr>
<tr><td><hr></td></tr>
<tr></tr>
<tr>
<td><input type="submit" value="add"></td>
</tr>
</table>
</form>

</body>
</html>