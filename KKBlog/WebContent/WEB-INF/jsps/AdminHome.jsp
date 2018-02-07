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
<h1>Admin Home Page</h1> <br>
<form action="admin">
<a href="http://localhost:2017/KKBlog/">Log Out</a> <br><br>
<a href="usr">Create New User</a><br><br>
<a href="managedata">View All Blogs</a><br><br>
<a href="manageuser">View All Users</a><br>
<table border="1">
<tr>
<td>UserId</td><td>UserName</td><td>UserPwd</td><td>Action Links</td>
</tr>
<c:forEach var="l" items="${msg}">
<tr>
<td><c:out value="${l[0]}"/></td>
<td><c:out value="${l[1]}"/></td>
<td><c:out value="${l[2]}"/></td>
<td>
<a href='deleteuser?userid=<c:out value="${l[0]}"/>'>Delete User</a> | 
</td>
</tr>
</c:forEach>
</table>
<br>
<a href="pendingapproval">Pending Approvals</a><br>
<table border="1">
<tr>
<td>BlogId</td><td>BlogTitle</td><td>BlogStatus</td><td>Action Links</td>
</tr>
<c:forEach var="lst" items="${list}">
<tr>
<td><c:out value="${lst[0]}"/></td>
<td><c:out value="${lst[1]}"/></td>
<td><c:out value="${lst[2]}"/></td>
<td>
<a href='approveblog?blogid=<c:out value="${lst[0]}"/>'>Mark Publish</a> | 
<a href='rejectblog?blogid=<c:out value="${lst[0]}"/>'>Mark Reject</a> |
<a href='setblogdate?blogid=<c:out value="${lst[0]}"/>'>Mark publish to date</a>
</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>