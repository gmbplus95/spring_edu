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
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
body {
	text-size: 15px;
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

<h2>STUDENT LIST</h2>

<table>
  <tr>
    <th>ID</th>
    <th>Student Name</th>
    <th>Student Age</th>  
    <th>Student Location</th> 
    <th>Action</th>
  </tr>
  <c:forEach var="listStudent" items="${listStudent }">
  <tr>
    <td>${listStudent.studentid }</td>
    <td>${listStudent.studentName }</td>
    <td>${listStudent.studentAge }</td>
    <td>${listStudent.studentLocation }</td>
    <td>
    	<a href="view_st/${listStudent.studentid }">View</a>
    	<a href ="delete_st/${listStudent.studentid }">Delete</a>
    	<a href ="edit_st/${listStudent.studentid }">Edit</a>
    </td>
  </tr>
  </c:forEach>
</table>
<form method="POST" action="/save_st">
	<br>
  <input type="hidden" name="studentid">
  <br>
  Student name:<br>
  <input type="text" name="studentName" >
  <br>
  Student age:<br>
  <input type="text" name="studentAge">
  <br>
  Student location:<br>
  <input type="text" name="studentLocation">
	</br>
  <input type="submit" value="Submit">
</form> 
</br>
<p><a href ="/course">View Course!!</a></p>
</body>
</html>