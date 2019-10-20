<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册用户</title>
</head>
<body>
<body>
	<form action="RegisterServlet" method="post" οnsubmit="return validate()">
		学生证号：<input type="text" name="id"> <br> <br>姓名：<input
			type="text" name="name"><br> <br> 密码：<input
			type="password" name="pwd"><br> <br> 密码确定：<input
			type="password" name="cpwd"><br> <br> 密码提问：<select
			name="question">
			<option>你加入平安公司的原因是</option>
			<option>你最喜欢的一本书</option>
		</select>(用于找回密码) <br> <br>问题答案：<input type="text" name="answer"><br>
		<br> <input type="submit" name="submit" value="提交"> <input
			type="reset" name="reset">
	</form>
</body>
</body>
 
</html>