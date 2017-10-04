<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form modelAttribute="project" method="post">

 Name: 
 <form:input path="name" id="name"></form:input>
	<form:errors path="name" cssclass="error" />
	<br />

 Date: 
 <form:input type="date" path="date" id="date"></form:input>
	<form:errors path="date" cssclass="error" />
	<br />
 
  Scale: 
 	<form:select path="scale" id="scale" data-selected="${project.getScale()}">
	<c:forEach var="option" items="${scaleOptions}">
		<option ${option == project.getScale() ?'selected="selected"' : '' }>${option}</option>
	</c:forEach>
	</form:select>
	<form:errors path="scale" cssclass="error" />
	<br />

	<input type="submit" value="Zapisz " />
</form:form>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#date").datepicker();
	});
</script>