<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="example" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td><a href="edit/${employee.id}">Edit</a></td>
				<td><a href="delete/${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>


<script>
	$(document).ready(function() {
		$('#example').DataTable( {
			"columnDefs": [
				{"orderable":false, "targets": 2, "bSortable":false},
				{"orderable":false, "targets": 3, "bSortable":false}
				]
		});
	});
</script>