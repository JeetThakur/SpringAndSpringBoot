<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>
<head>
<title>

</title>

</head>

<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/>
	<br><br>
	Last Name: <form:input path="secondName"/>
	<br><br>
	
	Country:
	<form:select path="country">
	<!-- <form:option value="Brazil" label="BRZ"/>
		<form:option value="France" label="FRA"/>
		<form:option value="India" label="IND"/>
		<form:option value="United States of America" label="USA"/>
		
		Are hardcoded options now we are using the java student code to do this	
	-->
		<form:options items="${student.getCountryOptions()}"/>
	</form:select>
	
	<br><br>
	
	Java<form:radiobutton path="favouriteLanguage" value="Java"/>
	PHP<form:radiobutton path="favouriteLanguage" value="PHP"/>
	JavaScript<form:radiobutton path="favouriteLanguage" value="JavaScript"/>
	
	<br><br>
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	MacOS <form:checkbox path="operatingSystems" value="MacOS"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	<input type="submit" value="submit"/>
	</form:form>
</body>

</html>