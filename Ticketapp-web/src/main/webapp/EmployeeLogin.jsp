<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
<h3>Login</h3><br><br>

<FORM action="/employee/Login" method="GET">
Email Id:&nbsp&nbsp&nbsp&nbsp<INPUT TYPE="text" placeholder="email id "NAME="emailId" required autofocus /><br><br><br>
Password:&nbsp&nbsp&nbsp&nbsp<input type="password" placeholder="password" name="password" required /><br><br><br>
<input type="submit" name="Login" value="Login">
</FORM>
</center>

</body>
</html>