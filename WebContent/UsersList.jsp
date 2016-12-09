<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.*"%>
Welcome <%=request.getParameter("uname") %><br/><br/>
<% Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/psa","root","root");
Statement ps = con.createStatement();
//String age=request.getParameter("age");
String sql = "select uname from members";
ResultSet rs=ps.executeQuery(sql);
int i=0;
while(rs.next())
{
	i++; %>
	User <%=i%> : <a href="Details.jsp"><%=rs.getString(1)%></a><br/>
<%}%>
<form method="post" action="Welcome"></form>


</body>
</html>