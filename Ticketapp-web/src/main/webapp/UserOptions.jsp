<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management</title>
</head>
<body>
	<center>
		<h3>Choose your Option</h3>
		<br> <br>

		<FORM action="../home/Creation" method="Get">
		 <input type="submit" name="create ticket" value="Create Ticket">
		</form>
		<br> <br> <br>
		<form action="../home/Updation" method="Get">
	<input type="submit" name="update ticket" value="Update Ticket">
		</form>
		<br> <br> <br>
		<form action="/ViewTicket" method="Get">
			<input type="hidden" name="emailId" value="${emailId}"> <input
				type="button" name="view ticket" value="View Ticket">
		</form>
		<br> <br> <br>
		<form action="../home/Close" method="Get">
			<input type="hidden" name="emailId" value="${emailId}"> <input
				type="submit" name="close ticket" value="Close Ticket">

		</form>
	</center>

</body>
</html>