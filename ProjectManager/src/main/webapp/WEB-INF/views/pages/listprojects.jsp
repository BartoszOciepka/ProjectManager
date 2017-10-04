<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="project" items="${projects}">
	${project} <a href="edit/${project.id}">Edit</a> <a href="delete/${project.id}">Delete</a> <br/>
</c:forEach>