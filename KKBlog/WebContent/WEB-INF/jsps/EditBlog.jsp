<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
		<pre>
		<a href="editorout">Log Out</a><br>
		<a href="editor">Back to Editor Home</a><br><br>
		
Blog Id:	<input type="text" name="blogId" value=${x } readonly/> 	
Blog Title:	<input type="text" name="blogTitle" value=${y } required/> 
Blog Content:	<input type="text" name="blogContent" value=${z } required/>
		<input type="submit" value="Update Blog">
	</pre>
		<br>${msg1}<br>
	</form>
</body>
</html>