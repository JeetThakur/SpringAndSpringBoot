<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Customer Registeration Form</title>
	
	<style>
		.error{color:red}
	</style>
	
</head>
<body>
<i> Fill out the form, fields marked with (*) are compulsory </i>

	<br><br>
	<form:form action="processForm" modelAttribute="customer">
	
	First Name <form:input path="firstName" />
	<br><br>
	
	Second Name(*) <form:input path="secondName"/>
	<form:errors path="secondName" cssClass="error" />
	<br><br>
	
	<br><br>
	Free Passes <form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"/>
	
	<br><br>
	Postal Code (ZIP CODE) <form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error"/>
	
	<br><br>
	Course Code <form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error"/>
	
	<br><br>
	<input type="submit" value="submit" />
	</form:form>

</body>

</html>