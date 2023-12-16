<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./Store.jsp" method="post">
		<table>
			<tr>
				<td><h3>Id:</h3></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><h3>Name:</h3></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><h3>Email:</h3></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SEND"></td>
			</tr>
		</table>
	</form>
</body>
</html>