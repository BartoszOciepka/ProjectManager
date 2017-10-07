<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form modelAttribute="project" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
			<div class="col">
				<label for="date">Date: </label>
				<form:input class="form-control" path="date" type="date"></form:input>
				<form:errors path="date" cssclass="error" />
			</div>
			<div class="col">
				<label for="scale">Scale: </label>
				<form:select class="form-control" path="scale">
					<c:forEach var="scale" items="${scaleOptions}">
						<option
							<c:if test="${scale.getName() eq project.getScale().getName()}">selected="selected"</c:if> value="${scale.getId()}">
								${scale.getName()}
						</option>
					</c:forEach>
				</form:select>
				<form:errors path="scale" cssclass="error" />
			</div>
			<div class="col">
				<label for="employees">Employees: </label>
				<form:select path="employees" items="${employees}" multiple="true" itemValue="id" itemLabel="lastName"/>
				<form:errors path="employees" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save" class="btn btn-primary" />
	</div>
</form:form>