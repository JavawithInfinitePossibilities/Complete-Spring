<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Param Model</title>
</head>
<body>
	<h1>Hello ${name}</h1>
	<h1>Todays date :${today}</h1>
	<ul>
		<c:forEach var="tempRequest" items="${courses}">
			<li>${tempRequest}</li>
		</c:forEach>
	</ul>
</body>
</html>