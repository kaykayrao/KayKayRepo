<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Editor Home Page</h1> <br>
<form action="editor">
<a href="http://localhost:2017/KKBlog/">Log Out</a> <br><br>
<a href="blog">Create New Blog</a>   <br><br>
<a href="managedata">View All Blogs</a>
<br> ${bloglist}
</form>
</body>
</html>