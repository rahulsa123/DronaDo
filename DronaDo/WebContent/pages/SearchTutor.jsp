<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script>
$(document).ready(function(){
	$("#tutorTable").dataTable({
		"bProcessing" : false,
		"bServerSide" : false,
		"sort":"position",
		"sAjaxSource":"/DronaDo/SearchTutorJson",
		"aoColumns":[
			{ data:"tuFullName" },
			{ data:"tuEmail" },
			{ data:"qualification" },
			{ data:"tuAddress" },
		]
	});
	
});
</script>
</head>
<body>
<input type="hidden" name ="throughJspPAge" id ="throughJspPAge" value="true">
<div class ="table-responsive">
<table id ="tutorTable" class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Qualification</th>
			<th>Address</th>
		</tr>
	</thead>
</table>
</div>


</body>
</html>