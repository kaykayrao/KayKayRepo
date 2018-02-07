<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Preview Blog</h1> <br>
	<form method="post" enctype="multipart/form-data">
		<pre>
		<a href="http://localhost:2017/KKBlog/">Log Out</a><br>
		<a href="editor">Back to Editor Home</a><br><br>
		
Blog Id:	<input type="text" name="blogId" value=${x } readonly/> 	
Blog Title:	<input type="text" name="blogTitle" value=${y } readonly/> 
Blog Content:	<input type="text" name="blogContent" value=${z } readonly/>
	</pre>
	</form>
</body>
</html>