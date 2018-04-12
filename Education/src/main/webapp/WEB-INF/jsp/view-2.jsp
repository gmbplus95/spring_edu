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
	
	<h2>COURSE DETAIL</h2>

<table>
<tr>
	<th>ID</th>
    <th>Course Name</th> 
  </tr>
  <tr>
     <td>${listCourse.courseid}</td>
     <td>${listCourse.coursename}</td> 
  </tr>
</table>
</body>
</html>