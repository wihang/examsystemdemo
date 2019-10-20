<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆界面</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		学生证号:<input type="text" name="id" /><br />
		密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password"
			name="pwd" /><br /> <input type="checkbox" name="autoLogin"
			value="y" />自动登录<br /> <input type="submit" value="登录" /> <a
			href="register.jsp"><input type="button" value="注册" /></a> <a
			href="returnPwd.jsp"><input type="button" value="忘记密码" /></a>
	</form>
 
</body>
</html>