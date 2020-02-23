<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<h3>Hello! This is my page! Entry data for registration:</h3>
	<form action="registration" method ="post">
		<label for="firstName">First name:</label> <input name="firstName"><br><br>
		<label for="lastName">Last name:</label> <input name="lastName"><br><br>
		<label for="email">Email:</label> <input name="email"> <br><br>
		<label for="password">Password:</label> <input type="password" name="password"><br><br>
		<input type="submit" value="registration"><br>
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>