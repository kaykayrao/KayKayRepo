<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Blog View Page</h1> <br>
<form action="managedata">
<a href="http://localhost:2017/KKBlog/">Log Out</a> <br>
<a href="editor">Back to Editor Home</a><br><br>
<table border="1">
<tr>
<td>BlogId</td><td>BlogTitle</td><td>BlogContent</td><td>BlogStatus</td><td>Action Links</td>
</tr>
<c:forEach var="l" items="${listmsg}">
<tr>
<td><c:out value="${l[0]}"/></td>
<td><c:out value="${l[1]}"/></td>
<td><c:out value="${l[2]}"/></td>
<td><c:out value="${l[3]}"/></td>
<td>
<a href='editblog?blogid=<c:out value="${l[0]}"/>'>Edit Blog</a>  | 
<a href='settopublish?blogid=<c:out value="${l[0]}"/>'>Set Ready to Publish</a> |
<a href='deleteblog?blogid=<c:out value="${l[0]}"/>'>Delete Blog</a> | 
<a href='dlbanner?blogid=<c:out value="${l[0]}"/>'>Download Banner</a> |
<a href='preview?blogid=<c:out value="${l[0]}"/>'>Preview Blog</a>
</td>
</tr>
</c:forEach>
</table>
${bloglist}
</body>
</form>
</html>