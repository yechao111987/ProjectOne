<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=IUTF-8">
<title>登陆页面</title>
</head>
<body>
<h1>Login Page</h1>
<form id="login" method="post" action="login.do">
	Name:<input type="text" name="username">
	<input type="submit" value="Login">
</form>

<%
//1.创建一个cookies对象
//	Cookie cookie=new Cookie("name","yechao");
//2.调用response的一个方法把cookies传给客户端
//	response.addCookie(cookie);
//	cookie.setMaxAge(30);

//1.获取cookies
//	Cookie [] cookies=request.getCookies();
//	if (cookies != null && cookies.length>0){
//		for(Cookie cookie2:cookies){
//			System.out.println(cookie2.getName()+":"+cookie2.getValue());
//		}
//	}


%>

</body>
</html>