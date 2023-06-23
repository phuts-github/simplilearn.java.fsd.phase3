<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Example</title>
</head>
<body>
<!-- JSP Scripting element - Scriptlet, Expressions, Declaration tags -->
<!-- 	JSP Scriptlet Tag <br> -->
	<% 
		String username = request.getParameter("uname");
		out.print("Welcome : " + username + " to our JSP page."); 
	%>
	
	<br>
	
	<%
		String driver = config.getInitParameter("mysql-driver-class");
		out.print("Mysql Driver " + driver);
	%>

	<br>
	<%
		session.setAttribute("myusername",username);
		session.setAttribute("mysqldriver",driver);
	 %>	
	<br>
	<a href = "session.jsp">Session JSP</a>
	<br>
	
<!-- 	JSP Expression Tag <br> (mainly for printing -->
	Current Time: <%= java.util.Calendar.getInstance().getTime() %>
	
<!-- 	JSP Declaration Tag <br> -->
	<%! int cube(int n) {
			return n* n *n;
		}
	%>
	
	<%= "Cube of 5 is " + cube(5) %>
	
	<br>
	<br>
	
	<%@
		include file="include.html"
	 %>
	 
	<br>
	
	
</body>
</html>