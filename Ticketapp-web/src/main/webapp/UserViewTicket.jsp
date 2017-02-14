<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management</title>
</head>
<body><center>
<h1>TICKETS</h1>
	<br>
	<br>
	<br>

	<table border="1">
			<thead>
				<tr>
					<th>Ticket id</th>
					<th>subject</th>
					<th>description</th>
					<th>status</th>
					
				</tr>
			</thead>
	<c:forEach var="c" items="${TICKET_LIST}">
	
			<tbody>
				<tr>
					<td>${c.id}</td>
					<td>${c.subject}</td>

					<td>${c.description}</td>
					<td>${c.status}</td>

				
				</tr>
			</tbody>
			</c:forEach>
		</table>
	

	<br>
<br>
</center>
</body>
</html>