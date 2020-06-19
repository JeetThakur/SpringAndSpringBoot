<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>

<body>
The student's name is:

${student.firstName} ${student.secondName }

<br>
Also the country selected: ${student.country}

<br>
The favourite Lang: ${student.favouriteLanguage }

<br>
The various Operating Systems possible are: 
<ul>
	<c:forEach var="temp" items="${student.operatingSystems }">
	<li> ${temp} </li>
	</c:forEach>
</ul>
</body>
</html>