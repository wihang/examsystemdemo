<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>找回密码界面</title>
</head>
<body>
	<form action="ReturnPwdSvt" method="post">
		输入学生证号：<input type="text" name="id"> <br> <br> 选择提问：<select
			name="question">
			<option>你加入平安公司的原因是什么</option>
			<option>你最喜欢的一本书是什么</option>
		</select> <br> <br>输入答案：<input type="text" name="answer"><br>
		<br> <input type="submit" name="submit" value="提交"> <input
			type="reset" name="reset">
	</form>
</body>
</html>