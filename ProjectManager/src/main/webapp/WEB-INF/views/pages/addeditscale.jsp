<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="scale" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Scale: </label>
				<form:input class="form-control" path="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save" class="btn btn-primary" />
	</div>
</form:form>