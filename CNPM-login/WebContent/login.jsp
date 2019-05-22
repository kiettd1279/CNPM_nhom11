<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>	Login  </title>
</head>
<body>
<form action="servletLogin" method="post">
<h1>Sign in Complate</h1>
<h3 style="color: blue;"> Tài khoản : <%= request.getAttribute("userName") %></h3>
<h3 style="color: blue;"> Mật khẩu  : <%= request.getAttribute("pass") %></h3>

</form>
</body>
</html>