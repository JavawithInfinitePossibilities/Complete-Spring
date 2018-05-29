<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h2>Hello World!</h2>

	<h1>Submit-> Front Controller(DispatcherServlet)-> Handler
		Mapping-> Controller-> Services-> Model and View(Controller)-> Front
		Controller(DispatcherServlet)-> View resolver-> View(Model)-> Response</h1>
	Hey User, May I know your name..
	<br />
	<form action="hello" method="post">
		<input type="text" name="name"
			placeholder="Enter your name (Simple call)"><br /> <input
			type="submit" value="Submit">
	</form>


	<form action="modelMapping" method="post">
		<input type="text" name="username"
			placeholder="Enter your user name (Mapping)"> <input
			type="submit" value="Submit">
	</form>

	<form action="complexModelMapping" method="post">
		<input type="text" name="userId"
			placeholder="Enter your user name (Complex Model Mapping)"> <input
			type="submit" value="Submit">
	</form>

	<form action="requestParamModel" method="post">
		<input type="text" name="user"
			placeholder="Enter your user name (Request param Mapping Model)">
		<input type="submit" value="Submit">
	</form>
	<h1>Please enter your details</h1>
	<form:form action="formElements" method="post" modelAttribute="info">
		First Name: <form:input path="firstName" />
		<form:errors path="firstName" />
		</br>
		Last Name: <form:input path="lastName" />
		</br>
		Gender: Male<form:radiobutton path="gender" value="Male" />
		        Female<form:radiobutton path="gender" value="Female" />
		</br>
		Citizen: <form:radiobuttons path="citizen" items="${citizen}" />
		</br>
		My likes in food: Veg<form:checkbox path="likes" value="Veg" />
		Non-Veg<form:checkbox path="likes" value="Non-Veg" />
		Egg<form:checkbox path="likes" value="Egg" />
		<br>
		Flower : <form:checkboxes items="${flower}" path="flower" />
		<br>
		State:<form:select path="state">
			<form:option value="Odish" />
			<form:option value="Karnatak" />
			<form:option value="AP" />
		</form:select>
		</br>
		Distract: <form:select path="district">
			<form:options items="${distract}" />
		</form:select>
		</br>
		Write about yourself: <form:textarea path="description" />
		</br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
