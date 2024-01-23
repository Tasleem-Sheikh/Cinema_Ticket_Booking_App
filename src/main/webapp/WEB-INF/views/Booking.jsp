<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1 style="color: blue">BOOK YOUR TICKET HERE</h1>

	<form action="book" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" pattern="[a-zA-Z0-9][a-zA-Z0-9_.]*@[0-9a-zA-Z]+([.][a-zA-Z]+)+" required /></td>
			</tr>
			<div style="color: Red" >
				<h2>
					<%
					if (request.getAttribute("Invalid_Email") != null) {
						out.println(request.getAttribute("Invalid_Email"));
					}
					%>
				</h2>
			</div>
			<tr>
				<td>Contact Number</td>
				<td><input type="text" name="contact" pattern="[6-9][0-9]{9}" required /></td>
			</tr>
			<tr>
				<td>Movie</td>
				<td><input type="text" name="movie" /></td>
			</tr>
			<tr>
				<td>Language</td>
				<td><input type="text" name="language" /></td>
			</tr>
			<tr>
				<td>Seat Row</td>
				<td><input type="text" name="seat_row"/>
				
				</td>
			</tr>
			<tr>
				<td>Seat Number</td>
				<td><input type="number" name="seat_number" min="1" max="25" value="15" /></td>
			</tr>

		</table>

		<td><input type="submit" value="book_ticket"
			onclick="callAlert();" /></td>



	</form>
	<div style="color: red">
		<h2>
			<%
			if (request.getAttribute("already_booked") != null) {
				out.println(request.getAttribute("already_booked"));
			
			}
			%>
		</h2>
	</div>
	<div style="color: green">
		<h2>
			<%
			if (request.getAttribute("booked") != null) {
				out.println(request.getAttribute("booked"));
				request.removeAttribute("boked");
			}
			%>
		</h2>
	</div>
</body>
</html>
