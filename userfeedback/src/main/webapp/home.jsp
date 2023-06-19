<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html lang="en">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<%@include file="header.html"%>
<body>
	<form action="addFeedback" method="post">
		<div>Add New User Feedback Entry :</div>
		<br> Id:<br> <input type="number" name="id" value="0" ><br>
		Category:<br> <input type="text" name="name"><br>
		Feedback:<br> <input type="text" name="feedback"><br>
		<br> <input type="submit"><br>
	</form>
	<br>
	<br>
	<form action="getFeedback" method="post" >
		Enter The Id To Get Specific User Feedback:<br> <input
			type="number" name="id" value="0" ><br> <br> <input
			type="submit"><br>
	</form>
	<br>
	<br>
	<form action="getAllFeedback" method="post">
		Get All User Feedback:<br> <br> <input type="submit"><br>
	</form>
	<br>
	<br> ${entries}
	<br> ${entry} 


	<script>
//		function getEntries() {
			var feedbackList = $
			{
				entries
			}
			document.write("feedbackList length " + feedbackList.length)
			for (var i = 0; i < feedbackList.length; i++) {

				out.print("ID: " + feedbackList[i].id);
				//alert("ID: " + feedbackList[i].id);
			}
//		}
	</script>




</body>

</html>