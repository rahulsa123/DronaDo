<%@page import="com.dronado.pojos.Subject"%>
<%@page import="com.dronado.daos.SubjectDaos"%>
<%@page import="com.dronado.pojos.Tutor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dronado.daos.TutorDaos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script>
$(document).ready(function(){
	$(document).ready( function () {
	    $('#tutorTable').DataTable();
	} );
	
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
			<th>Subject</th>
			<th>Standard</th>
			<th>Stream</th>
		</tr>
	</thead>
<tbody>
<%
TutorDaos td = new TutorDaos();
ArrayList<Tutor> allTutor = td.findAllTutor();
SubjectDaos sd = new SubjectDaos(); 
 
for(Tutor t : allTutor){
	System.out.println(t.getTuSubjects());	
	for(int sid : t.getTuSubjects()){
		Subject s = sd.getSubjectById(sid);
		
%>

	<tr>
	<td><%=t.getTuFullName()%></td>
	<td><%=t.getTuEmail()%></td>
	<td><%=t.getQualification()%></td>
	<td><%=t.getTuAddress()%></td>
	<td><%=s.getSName()%></td>
	<td><%=s.getSStandard()%></td>
	<td><%=s.getSStream()%></td>
	</tr>

<%}} %>
</tbody>
</table>
</div>


</body>
</html>