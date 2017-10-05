<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="employee" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="firstName" id="firstName"></form:input>
				<form:errors path="firstName" cssclass="error" />
			</div>
			<div class="col">
				<label for="surname">Surname: </label>
				<form:input class="form-control" path="lastName" id="lastName"></form:input>
				<form:errors path="lastName" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
			<input type="submit" value="Zapisz " class="btn btn-primary" />
	</div>
</form:form>