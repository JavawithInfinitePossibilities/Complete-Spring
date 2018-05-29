<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Elements</title>
</head>
<body>
	<h1>Hi ${firstName} ${lastName} and I am ${gender}</h1>
	</br>
	<h1>I am a ${citizen} and my state is ${state} , distract name is
		${district}</h1>
	<h1>Todays date :${today}</h1>
	<ul>
		<c:forEach var="tempRequest" items="${courses}">
			<li>${tempRequest}</li>
		</c:forEach>
	</ul>
	<ul>
		<h1>There is something about myself : ${description} and i like</h1>
		<c:forEach var="temp" items="${likes}">
			<li>${temp}</li>
		</c:forEach>
		<h1>and I like</h1>
		<c:forEach var="temp" items="${flower}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>