<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form modelAttribute="scale" method="post">

	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Scale: </label>
				<form:input class="form-control" path="scale" id="name"></form:input>
				<form:errors path="scale" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save " class="btn btn-primary" />
	</div>


</form:form>