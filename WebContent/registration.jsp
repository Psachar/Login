<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.sql.*" %>
<%@ page import="com.praj.bean.EncryptDecrypt"%>
<% String uname=request.getParameter("uname");
String pass=request.getParameter("pass");
String age=request.getParameter("age");
String gender=request.getParameter("gender");
String contact=request.getParameter("contact");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/psa","root","root");
Statement s=con.createStatement();
EncryptDecrypt ed=EncryptDecrypt.getInstance();
String encr=ed.encrypt(pass);
int i=s.executeUpdate("insert into members values('"+uname+"','"+encr+"',"+age+",'"+gender+"',"+contact+")");
if(i>0)
{
	response.sendRedirect("welcome.jsp");
}
else
{
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>