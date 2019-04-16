<%@page import="com.dronado.pojos.Subject"%>
<%@page import="com.dronado.pojos.Tutor"%>
<%@page import="com.dronado.daos.SubjectDaos"%>
<%@page import="com.dronado.daos.TutorDaos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script>
$(document).ready(function(){
	$("#tutorTable").dataTable();
	
});
</script>
</head>
<body>
<input type="hidden" name ="throughJspPAge" id ="throughJspPAge" value="true">
<div class ="table-responsive">
<table id ="tutorTable" class="table tb-dark">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Qualification</th>
			<th>Address</th>
			<th>Subject</th>
			<th>Standard</th>
			<th>Stream</th>
		</tr>
	</thead>
<tbody>
<%TutorDaos td = new TutorDaos();
SubjectDaos sd = new SubjectDaos();
for (Tutor t:td.findAllTutor()){
		for(int sid : t.getTuSubjects()){
			Subject s = sd.getSubjectById(sid);
%>
	<tr>
			<th><%= t.getTuFullName()%></th>
			<th><%= t.getTuEmail()%></th>
			<th><%= t.getQualification()%></th>
			<th><%= t.getTuAddress()%></th>
	<%if(s!=null){ %>
			<th><%= s.getSName()%></th>
			<th><%= s.getSStandard()%></th>
			<th><%= s.getSStream()%></th>
		
	<%}else{ %>
			<th></th>
			<th></th>
			<th></th>
	<%} %>
	</tr>
<%}} %>

</tbody>
</table>
</div>


</body>
</html>