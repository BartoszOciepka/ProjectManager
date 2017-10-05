

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form modelAttribute="project" method="post">

	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="name" id="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
			<div class="col">
				<label for="date">Date: </label>
				<form:input class="form-control" type="date" path="date" id="date"></form:input>
				<form:errors path="date" cssclass="error" />
			</div>
			<div class="col">
				<label for="scale">Scale: </label>
				<form:select class="form-control" path="scale" id="scale"
					data-selected="${project.getScale()}">
					<c:forEach var="option" items="${scaleOptions}">
						<option class="form-control"
							${option.scale == project.getScale() ?'selected="selected"' : '' }>${option.scale}</option>
					</c:forEach>
				</form:select>
				<form:errors path="scale" cssclass="error" />
			</div>

		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Zapisz " class="btn btn-primary" />
	</div>


</form:form>