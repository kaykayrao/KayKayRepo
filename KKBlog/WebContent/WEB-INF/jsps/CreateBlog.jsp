<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post" enctype="multipart/form-data">
		<pre>
		<a href="http://localhost:2017/KKBlog/">Log Out</a><br>
		<a href="editor">Back to Editor Home</a><br><br>
		
Blog Id:		<input type="text" name="blogId" required/> 	
Blog Title:		<input type="text" name="blogTitle" required/> 
Blog Image:		<input type="file" name="doc" accept=".jpg,.png,.gif" />
Blog Content:		<textarea rows="4" cols="50" name="blogContent" required>Enter text here...</textarea>				
Blog Status:		<input type="radio" name="blogStatus" value="draft" required>Draft <input type="radio" name="blogStatus" value="Readytopublish">Ready to publish<br>
		<input type="submit" value="Add Blog">
	</pre>
		<br>${msg}<br>
		<br> <a href="managedata">View All Blogs</a><br>
	</form>
</body>
</html>
