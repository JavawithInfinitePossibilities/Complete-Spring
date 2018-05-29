<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitness Tracker</title>
</head>
<body>
	<h1>Add Minutes Exercised</h1>
	<form:form commandName="exercise">
		<table>
			<tr>
				<td>Minutes Exercise for Day:</td>
				<td><form:input path="minutes" /></td>
			</tr>
			<tr colspan="2">
				<td><input type="submit" value="Enter Exercise" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>