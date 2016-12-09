<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="registration.jsp">
User name:<input type="text" name="uname"/><br>
Password:<input type="password" name="pass"/><br>
Age:<input type="text" name="age"/><br>
Gender:<input type="radio" name="gender" value="M">Male
<input type="radio" name="gender" value="F">Female
<input type="radio" name="gender" value="O">Others<br>
Contact number:<input type="text" name="contact"><br>
<input type="submit" value="Submit"><br>
Already Registered?<a href="index.jsp">Login Here</a>
</form>
</body>
</html>