<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TicketManagement</title>
</head>
<body>
	<center>
		<h3>Update your Ticket</h3>
		<br> <br>

		<FORM action="/" method="get">
			Email Id:&nbsp&nbsp&nbsp&nbsp<INPUT TYPE="text" placeholder="emailid"
				NAME="Emailid" required autofocus /><br>
			<br>
			<br> Password:&nbsp&nbsp&nbsp&nbsp<input type="password"
				placeholder="password" name="password" required /><br>
			<br>
			<br> Ticket Id:&nbsp&nbsp&nbsp<input type="text"
				placeholder="Id" name="Id" required autofocus /><br> <br>
			<br> Subject:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<INPUT TYPE="text"
				placeholder="Subject" NAME="Subject" required /><br> <br>
			<br> Description:&nbsp<input type="text"
				placeholder="Description" name="Description" required /><br> <br>
					<br> Priority:
			
			Low<input type="radio"
				 name="Priority" value="low" required /><br><br>
				 Medium<input type="radio"
				 name="Priority" value="medium" required /><br><br>
				  High<input type="radio"
				 name="Priority" value="high" required /><br><br>
				 <input type="submit" name="updateticket" value="Update">
		</FORM>
	</center>

</body>
</html>