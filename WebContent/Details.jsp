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
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/psa","root","root");
PrintWriter o=response.getWriter();
System.out.println(request.getParameter("uname"));
String s="select * from members where uname='"+request.getParameter("uname")+"'";
   Statement ps = con.createStatement();
   ResultSet rs1=ps.executeQuery(s);%>
   User : <%=rs1.getString(1)%><br>
   Password : <%=rs1.getString(2)%><br>
   Age:   <%=rs1.getString(3)%><br>
   Gender:<%=rs1.getString(4)%><br>
   Contact:<%=rs1.getString(5)%>
   

</body>
</html>