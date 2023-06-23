<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="addEntry">
		<div>Add New Journal Entry :</div>
		<br>
		<div>Id:</div>
		<input type="text" name="id"><br>
		<div>Title:</div>
		<input type="text" name="title"><br>
		<div>Category</div>
		<input type="text" name="category"><br><br> 
		<input type="submit"><br>
	</form>
	<br>
	<br>
	<form action="getEntry">
		<div>Enter The Id To Get Specific Entry:</div><br>
		<input type="text" name="id"><br><br>
		<input type="submit"><br>
	</form>
	<br>
	<br>
	<form action="getAllEntries">
	<div>Get All Journal Entries:</div><br><br>
		<input type="submit"><br>
	</form>
	<br>
	<br>
	<form action="delEntry">
		<div>Enter The Id To Delete Specific Entry:</div><br>
		<input type="text" name="id"><br><br>
		<input type="submit"><br>
	</form>
</body>
</html>