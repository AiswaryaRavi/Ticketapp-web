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

		<FORM action="/" method="Get">
			<input type="button" name="emailId" value={$emailId}> <input
				type="button" name="create ticket" value="Create Ticket"
				onclick="window.location.href='CreateTicket.jsp'">
		</form>
		<br> <br> <br>
		<form action="/" method="Get">
			<input type="button" name="emailId" value={$emailId}> <input
				type="button" name="update ticket" value="Update Ticket"
				onclick="window.location.href='UpdateTicket.jsp'">
		</form>
		<br> <br> <br>
		<form action="/" method="Get">
			<input type="button" name="emailId" value={$emailId}> <input
				type="button" name="view ticket" value="View Ticket"
				onclick="window.location.href='ViewTicket.jsp'">
		</form>
		<br> <br> <br>
		<form action="/" method="Get">
			<input type="button" name="emailId" value={$emailId}> <input
				type="button" name="close ticket" value="Close Ticket"
				onclick="window.location.href='CloseTicket.jsp'">

		</FORM>
	</center>

</body>
</html>