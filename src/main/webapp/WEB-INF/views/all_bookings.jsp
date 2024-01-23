<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Tickets</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Customer_Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Movie</th>
			<th>Language</th>
			<th>Seat_Row</th>
			<th>Seat_Number</th>
			<th>Update</th>
			<th>Update</th>
		</tr>
		<%
		ResultSet rs = (ResultSet) request.getAttribute("results");
		while (rs.next()) {
		%>
		<tr>
			<td>
				<%
				out.println(rs.getString(1));
				%>
			</td>
			<td>
				<%
				out.println(rs.getString(2));
				%>
			</td>

			<td>
				<%
				out.println(rs.getString(3));
				%>
			</td>
			<td>
				<%
				out.println(rs.getString(4));
				%>
			</td>
			<td>
				<%
				out.println(rs.getString(5));
				%>
			</td>
			<td>
				<%
				out.println(rs.getString(6));
				%>
			</td>
			<td>
				<%
				out.println(rs.getString(7));
				%>
			</td>
			<td><a
				href="update?email=<%out.println(rs.getString(2));%>&movie=<%out.println(rs.getString(4));%>&language=<%out.println(rs.getString(5));%>&seat_row=<%out.println(rs.getString(6));%>&seat_number=<%out.println(rs.getString(7));%>&u_email=<%out.println(rs.getString(2));%>">UPDATE</a></td>
			<td><a href="delete?email=<%out.println(rs.getString(2));%>">Cancel
					Booking</a></td>
		</tr>



		<%
		}
		%>

		<div style="color: green">
			<%
			if (request.getAttribute("update_msg") != null) {
				out.println(request.getAttribute("update_msg"));

			}
			%>
			<%
			if (request.getAttribute("cancelled") != null) {
				out.println(request.getAttribute("cancelled"));

			}
			%>
		</div>


	</table>
</body>
</html>