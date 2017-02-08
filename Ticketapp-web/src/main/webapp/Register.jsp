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
<h3>Register</h3><br><br>

<FORM action="/home/Register" method="Get">
 Name  	:&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Name" name="Name" required autofocus /><br><br><br>
EmailId :&nbsp&nbsp<INPUT TYPE="text" placeholder="emailid" name="Emailid"required /><br><br><br>
Password:&nbsp<input type="password" placeholder="password" name="password"required /><br><br><br>
${ERROR}<br><br>
<input type="submit" name="Sign up" value="REGISTER">
</FORM>
</center>
</body>
</html>