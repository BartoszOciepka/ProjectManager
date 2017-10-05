<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="example" class="table table-striped table-bordered"
	cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>Scale</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="scale" items="${scales}">
			<tr>
				<td>${scale.scale}</td>
				<td><a href="edit/${scale.getId()}">Edit</a></td>
				<td><a href="delete/${scale.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
</table>

<script>
	$(document).ready(function() {
		$('#example').DataTable( {
			"pagingType": "full_numbers",
			"columnDefs": [
				{"orderable":false, "targets": 1, "bSortable":false},
				{"orderable":false, "targets": 2, "bSortable":false}
				]});
		
	});
</script>