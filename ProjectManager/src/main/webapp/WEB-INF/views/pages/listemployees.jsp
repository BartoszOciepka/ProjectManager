<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="employee" items="${employees}">
	${employee} <a href="edit/${employee.id}">Edit</a> <a href="delete/${employee.id}">Delete</a> <br/>
</c:forEach>