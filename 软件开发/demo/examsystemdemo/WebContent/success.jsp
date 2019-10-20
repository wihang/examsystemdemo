
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>找回密码成功界面</title>
</head>
<body>
	恭喜你，查找密码成功
	<br>
	<%="学生证号:" + session.getAttribute("id")%><br />
	<%="你的密码为:" + session.getAttribute("pwd")%><br />
	<a href="login.jsp">返回登录</a>
</body>
</html>
