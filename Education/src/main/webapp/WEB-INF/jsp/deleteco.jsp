<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%
    String studentid = request.getParameter("listStudent");
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>ADD COURSE FOR STUDENT</h2>
	<p> ID: ${listStudent.studentid }</p>
	<p> STUDENT NAME: ${listStudent.studentName }</p>
	<form method="GET" action="/view_st/deleteco">
	     <input type="hidden" name="studentid" value="${listStudent.studentid }" >
		<select name="courseid" id="courseid">
			<c:forEach var="listCourse" items="${listCourse }">
  			 	<option value="${listCourse.courseid}">${listCourse.coursename}</option>
  			</c:forEach>
		</select>
		<input type="submit" value="DELETE">
	</form>
</body>
</html>