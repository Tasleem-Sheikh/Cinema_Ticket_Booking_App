<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post" >
<table>
<tr>
<td>Email</td>
<td><input type="email" name="email" value="<%out.println(request.getAttribute("email"));;%>" readonly /></td>
</tr>
<tr>
<td>Movie</td>
<td><input type="text" name="movie" value="<%out.println(request.getAttribute("movie"));%>" /></td>
</tr>
<tr>
<td>Language</td>
<td><input type="text" name="language" value="<%out.println(request.getAttribute("language"));%>" /></td>
</tr>
<tr>
<td>Seat Row</td>
<td><input type="text" name="seat_row" value="<%out.println(request.getAttribute("seat_row"));%>" /></td>
</tr>
<td>Seat Number</td>
<td><input type="text" name="seat_number" value="<%out.println(request.getAttribute("seat_number"));%>" /></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="u_email" value="<%out.println(request.getAttribute("u_email"));%>" /></td>
</tr>
</table>
<input type="submit" value="CONFIRM">
</form>
</body>
</html>