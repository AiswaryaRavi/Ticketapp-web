<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management</title>
</head>
<body>
	<%
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://139.59.29.57:3306/aishwarya_db?user=dev_user&password=dev_pwd");
		
			Statement statement = connection.createStatement();

			resultset = statement.executeQuery("SELECT NAME FROM DEPARTMENTS");
	%>

	<center>
		<h3>Create your Ticket</h3>
		<br> <br>

		<FORM action="/home/CreateTicket" method="get">
			Email Id:&nbsp&nbsp&nbsp&nbsp<INPUT TYPE="text" placeholder="emailid"
				NAME="Emailid" required autofocus /><br> <br> <br>
			Password:&nbsp&nbsp&nbsp&nbsp<input type="password"
				placeholder="password" name="password" required /><br> <br>
			Subject:<input type="text"
				placeholder="Subject" name="Subject" required autofocus /><br>
			<br> <br> Description:<INPUT TYPE="text"
				placeholder="Description" NAME="Description" required /><br> <br>
			<br> Department:
		<select>
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select> 
			<br>
			<br> Priority:<br> <br> low<input type="radio"
				name="priority" value="low"> 
				  medium<input
				type="radio" name="priority" value="medium"><br> <br>
			high<input type="radio" name="priority" value="high"><br>
			<br> <br> <input type="submit" name="createticket"
				value="OK">
		</FORM>
	</center>
	<%
		} catch (Exception e) {
			out.println("wrong entry" + e);
		}
	%>
</body>
</html>