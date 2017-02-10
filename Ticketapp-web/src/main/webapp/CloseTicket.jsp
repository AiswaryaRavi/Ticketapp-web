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
		<h3>Update your Ticket</h3>
		<br> <br>

		<FORM action="/home/CloseTicket" method="get">
		<input type="hidden" name="emailId" value="${emailId}">
			 Ticket Id:<input type="text"
				placeholder="Id" name="tid" required autofocus /><br> <br>
			<br> 
				${ERROR}
				<br><br>
				<input type="submit" name="Closeticket" value="Close Ticket">
				</FORM>
				</center>

</body>
</html>