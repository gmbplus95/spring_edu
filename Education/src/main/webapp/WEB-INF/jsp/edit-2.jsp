<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>COURSE EDIT</h2>
	<form method="POST" action="/save_co">
  Course ID:<br>
  <input type="text" name="courseid" value ="${listCourse.courseid }" readonly="readonly" >
  <br>
  Course name:<br>
  <input type="text" name="coursename" value ="${listCourse.coursename }" >
  <br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>