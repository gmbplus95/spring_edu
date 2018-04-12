<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	text-size: 15px;
}
</style>
<body>
	
	<h2>STUDENT DETAIL</h2>

<table>
<tr>
	<th>ID</th>
    <th>Student Name</th>
    <th>Student Age</th>  
    <th>Student Location</th>  
    <th>Course</th>
  </tr>
  <tr>
     <td>${listStudent.studentid}</td>
     <td>${listStudent.studentName}</td> 
    <td>${listStudent.studentAge }</td>
    <td>${listStudent.studentLocation }</td>
     <td>${listCourse.coursename }</td>
  </tr>
 
  
</table>
 <p> <a href="/view_st/add_co/${listStudent.studentid}">Add Course!</a> </p>
</body>
</html>