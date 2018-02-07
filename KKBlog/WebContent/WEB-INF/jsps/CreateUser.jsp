<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="create" method="post">

		<pre>
		<a href="http://localhost:2017/KKBlog/">Log Out</a><br>
		<a href="admin">Back to Admin Home</a><br><br>
User Name:		<input type="text" name="userName" required /> 
User PassWord:		<input type="text" name="userPwd" required/>

		<input type="submit" value="Create User">
<br>${msg}<br>
	</pre>
	</form>
</body>
</html>