
<%@page import="com.dronado.daos.AdminDaos"%>
<%@page import="com.dronado.daos.UserDaos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
function getDisplayBlock(val) {
	
	var x = document.getElementById(val);
	if(x.style.display=="none")
		x.style.display ="block";
	else
		x.style.display ="none";
}

</script>
</head>
<body>
<div class="fluid bg-info pl-5 pt-1" style="width:100%;height:60px; font-style: oblique;">
<h1 style="float:left;" class="text-dark">Dronado <sub class="text-white" style="font-size: x-small;">Administration</sub></h1>
<div style="float: right;" >
	<ul style="display:flex;list-style:none; font-size: x-large;;" >
		<li ><a class="nav-link text-dark"  href="/DronaDo/pages/index.jsp" >Home</a>
		</li>
		<li ><a class="nav-link text-dark" href="/DronaDo/Logout" >Log-out</a>
		</li>
	</ul>
</div>
</div>
<h5 class="fluid text-white pl-4 pt-1 pb-1" style="background-color: #4d4dff;font-style: italic;">Hello <%  UserDaos ud = new UserDaos();
		String name = ud.getUsernameByUId((Integer)session.getAttribute("uid")); %>
		<%= name %>
		</h5>
<br>	
<h3 style="text-shadow: 2px 2px 2px blue;"> Database Information</h3><hr style="height: 3px">	
<div class="ml-3 pl-3" style="width: 50%;text-align: left;">
<%   HashMap<String, ArrayList<String>> tableAndColumn = null;
try{
tableAndColumn =(HashMap<String, ArrayList<String>>) request.getAttribute("tableAndColumn");
}catch(Exception e){
	out.print("error in catch" +e);
}
for(String table: tableAndColumn.keySet()){	
		%>
<input type="button" class="btn btn-primary" onclick="getDisplayBlock(<%out.println("\'"+table+"\'");%>);" value=<%out.println("\""+table+"\"");%> style="width: 100%; text-align: left;">  
 <div class="card-body" style="display: none;" id=<%out.println("\""+table+"\"");%>>
<ul class="list-group">
<% for(String column : tableAndColumn.get(table)){ %>
<li class="list-group-item"><%= column %> </li>
<%} %>
</ul><br>
<form action="/DronaDo/AdminHome" method="post">
<input type="hidden"  name="tableName" value=<%out.println("\""+table+"\"");%>>
<input class="btn btn-success" style="float: right;" type="submit" value="Edit">
</form> 
</div>	
<br><br>
<% } %>

</div>
</body>
</html>