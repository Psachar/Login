<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type ="text/css">
.image{
width:1000px;
height:1000px;
background-image:Background-Image-6H6-2.jpg;
background-size:cover;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css" media="screen, projection">

</head>
<div class = "image">
<body style="vertical-align;">
<form class="form" method="post" action="Login">
<div class="account-info">
 <label>
User name:
<input type="text" name="uname"/><br>
</label>
<label>
Password:<input type="password" name="pass"/><br>
</label>
</div>
<div class="account-action">
<input class="btn" type="submit" value="Login"/><br><br>
<label>
New User?<a href="reg.jsp">Register Here</a>
</label>
</div>
</form>

</body>
</div>
</html>