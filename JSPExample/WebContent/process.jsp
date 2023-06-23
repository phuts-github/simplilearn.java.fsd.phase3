<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
       %>
<%--     errorPage="error.jsp"  --%>
<%-- why remove? it is now defined in web.xml --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Process jsp</title>
</head>
<body>
	<% 
		String number1 = request.getParameter("n1");
		String number2 = request.getParameter("n2");
		
		int a = Integer.parseInt(number1);
		int b = Integer.parseInt(number2);
		int c = a / b;
		out.print("Division of " + a + " and " + b + " is " + c);
	%>
</body>
</html>