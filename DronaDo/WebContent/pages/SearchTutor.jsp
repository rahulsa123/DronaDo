
<%@page import="com.dronado.daos.UserDaos"%>
<%@page import="com.dronado.pojos.Subject"%>
<%@page import="com.dronado.daos.SubjectDaos"%>
<%@page import="com.dronado.daos.StudentDaos"%>
<%@page import="com.dronado.daos.TeachesDaos"%>
<%@page import="com.dronado.daos.NotificationDaos"%>
<%@page import="com.dronado.pojos.Tutor"%>
<%@page import="com.dronado.pojos.Student"%>
<%@page import="com.dronado.pojos.Teaches"%>
<%@page import="com.dronado.pojos.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dronado.daos.TutorDaos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<% 
try{
	int t = Integer.parseInt(request.getParameter("t"));
	int s = Integer.parseInt(request.getParameter("s"));
	System.out.println(t + " & "+ s + "received");
	Student stu = new StudentDaos().findByUId((int)session.getAttribute("uid"));
	Subject sub = new SubjectDaos().getSubjectById(s);
	new NotificationDaos().insert(new Notification(0,new java.util.Date(),(int)session.getAttribute("uid"),new TutorDaos().findByTuId(t).getUId(),stu.getStudFullName()+" has request to study " + sub.getSName() + "|" + sub.getSStandard() + "|" + sub.getSStream(),"request"+"&"+s));
%>
	 <div class="alert alert-success alert-dismissible">
 	<button type="button" class="close" data-dismiss="alert">&times;</button>
  	<strong>Success!</strong> Request sent
	</div>
<%
}catch(Exception e){
	System.out.println("Exception caught");
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script src="/DronaDo/js/jquery.min.js"></script>
<script>
$(document).ready(function(){

	$(document).ready( function () {
	    $('#tutorTable').DataTable();
	} );});
</script>
<script>
	function request(t,s) {
		alert(t+ " "+s);
		$("#mainPartFile").load("/DronaDo/pages/SearchTutor.jsp?t="+t+"&s="+s);
		alert("loading");
	}
</script>
</head>
<body>
<marquee class="container   text-info  font-italic" width="100%" direction="right"  behavior="alternate">
<h1  style="text-shadow: 3px 3px 5px red;">Search Tutor</h1>
</marquee>
<br><br>
<input type="hidden" name ="throughJspPAge" id ="throughJspPAge" value="true">
<div class ="table-responsive" style="max-width:80%;min-width:100%;">
<table id ="tutorTable" class="table table-hover" >
	<thead class="bg-info">
		<tr style="text-shadow: 2px 2px 2px blue;">
			<th><h5>Name</h5></th>
			<th><h5>Username</h5></th>
			<th><h5>Email</h5></th>
			<th><h5>Qualification</h5></th>
			<th><h5>Address</h5></th>
			<th><h5>Subject</h5></th>
			<th><h5>Standard</h5></th>
			<th><h5>Stream</h5></th>
			<th><h5>Request</h5></th>
		</tr>
	</thead>
<tbody >

<%
TutorDaos td = new TutorDaos();
ArrayList<Tutor> allTutor = td.findAllTutor();
SubjectDaos sd = new SubjectDaos(); 
UserDaos ud = new UserDaos();
for(Tutor t : allTutor){
	if(t.getTuSubjects().get(0)==0)
		continue;
	System.out.println(t.getTuSubjects());	
	String username = ud.getUsernameByUId(t.getUId());
	for(int sid : t.getTuSubjects()){
		Subject s = sd.getSubjectById(sid);
		
%>

	<tr class="table-success">
	<td><%=t.getTuFullName()%></td>
	<td><%=username%></td>
	<td><%=t.getTuEmail()%></td>
	<td><%=t.getQualification()%></td>
	<td><%=t.getTuAddress()%></td>
	<td><%=s.getSName()%></td>
	<td><%=s.getSStandard()%></td>
	<td><%=s.getSStream()%></td>
	<td><a onclick=request(<%=t.getTuId()%>,<%=s.getSId()%>) class="btn btn-primary">REQUEST</a></td>
	</tr>

<%}} %>



</tbody>
</table>
</div>

</body>
</html>