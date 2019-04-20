<div id="mainPartFile">
<%@page import="com.dronado.daos.AdminDaos"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dronado.daos.UserDaos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Edit</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="fluid bg-info pl-5 pt-1" style="height:60px;font-style: oblique;width: 100%;">
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
<a class ="btn btn-success ml-3" href="/DronaDo/AdminHome">Admin Home</a>
<% String tableName = (String)request.getAttribute("tableName");
	ArrayList<String> column = (ArrayList<String>) request.getAttribute("column");
	HashMap<String, ArrayList<String>> arrayOfData = AdminDaos.getDataOfTable(tableName, column);
	int dataLength = arrayOfData.get(column.get(0)).size();
	int colLength = column.size();
%>
<div class="table-responsive ml-3 mt-2" style="width:90%">
<table id="Databasetable" class="table table-striped table-bordered" >
<thead>
	<tr><%for(String col:column){ %>
		<th><%=col.toUpperCase()%> </th><%} %>
		<th>OPERATION</th>
	</tr>
</thead>
<tbody>
<%for(int i=1;i<dataLength;i++){ %>
	<tr><%for(int j=0;j<colLength;j++){%>
			<td><%=arrayOfData.get(column.get(j)).get(i)%>
			</td><%} %>
		<td><a class="btn btn-danger" href="/DronaDo/AdminHome?operation=<%="remove"%>&tableName=<% out.print(tableName);%>&colname=<% out.print(column.get(0));%>&v=<% out.print(arrayOfData.get(column.get(0)).get(i));%>">DELETE</a></td>
	</tr><%} %>
	
</tbody>
</table>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('#Databasetable').DataTable();
} );

</script>
</body>
</html>
</div>