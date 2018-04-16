<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<style>

body {
	text-size: 15px;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body>

<h2>COURSE LIST</h2>

<table>
  <tr>
    <th>ID</th>
    <th>Course Name</th>
  </tr>
  <c:forEach var="listCourse" items="${listCourse }">
  <tr>
    <td>${listCourse.courseid }</td>
    <td>${listCourse.coursename }</td>
    <td>
    	<a href="view_co/${listCourse.courseid }">View</a>
    	<a href ="delete_co/${listCourse.courseid }">Delete</a>
    	<a href ="edit_co/${listCourse.courseid }">Edit</a>
    </td>
  </tr>
  </c:forEach>
</table>
<form method="POST" action="/save_co">
	<br>
  <input type="hidden" name="courseid">
  <br>
  Course name:<br>
  <input type="text" name="coursename" >
  <br>
  <input type="submit" value="Save">
</form> 
<br>
</body>
</html>