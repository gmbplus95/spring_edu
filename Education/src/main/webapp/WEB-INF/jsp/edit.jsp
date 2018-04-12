<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>STUDENT EDIT</h2>
	<form method="POST" action="/save_st">
  Student ID:<br>
  <input type="text" name="studentid" value ="${listStudent.studentid }" readonly="readonly" >
  <br>
  Student name:<br>
  <input type="text" name="studentName" value ="${listStudent.studentName }" >
  <br>
  Student age:<br>
  <input type="text" name="studentAge" value ="${listStudent.studentAge }">
  <br>
  Student location:<br>
  <input type="text" name="studentLocation" value ="${listStudent.studentLocation }">
  <br><br>
  
  <input type="submit" value="Submit">
</form> 
</body>
</html>