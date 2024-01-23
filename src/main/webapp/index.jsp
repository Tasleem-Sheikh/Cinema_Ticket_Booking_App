<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
</head>
<body>
	<H1>Log In Page</H1>


	<form action="login" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" />
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<input type="submit" value="login" />
		</table>
	</form>
	
	
	<h3 style="color:Chocolate">
	<%
	if (request.getAttribute("error_msg") != null) {

		out.println(request.getAttribute("error_msg"));

	}
	%>
	</h3>
	
</body>
</html>