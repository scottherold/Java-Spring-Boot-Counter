<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!-- JSTL library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Current Visit Count</title>
	</head>
	<body>
		<p>You have visited <a href="/">localhost:8080</a> <c:out value="${count}" /> times!<p>
		<br>
		<p><a href="/">Test another visit?</a></p>
		<form action="reset" method="GET">
			<input type="submit" value="Reset Counter">
		</form>
	</body>
</html>