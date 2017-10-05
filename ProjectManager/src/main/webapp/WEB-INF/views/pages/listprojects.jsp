<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="example" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Project Name</th>
			<th>Start date</th>
			<th>Scale</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="project" items="${projects}">
			<tr>
				<td>${project.name}</td>
				<td>${project.date}</td>
				<td>${project.scale}</td>
				<td><a href="edit/${project.id}">Edit</a></td>
				<td><a href="delete/${project.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
</table>

<script>
	$(document).ready(function() {
		$('#example').DataTable( {
			"pagingType": "full_numbers",
			"columnDefs": [
				{"orderable":false, "targets": 3, "bSortable":false},
				{"orderable":false, "targets": 4, "bSortable":false}
				]});
		
	});
</script>