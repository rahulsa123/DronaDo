<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html> 
<body>
<script type="text/javascript">
		
		//to change user image in side bar change second value
		function sendData() {
			var ref ="Name :"+document.getElementById("fullName").value+"\nEmail:"+document.getElementById("email").value+"\nPhone NO :"+document.getElementById("phoneNo").value+"\nAddress :"+document.getElementById("address").value;
			if(document.getElementById("qualification").value!=""){
				ref+="\nQualification"+document.getElementById("qualification").value;
			}
			var b=confirm(ref);
			if(b){
				
				document.forms["editForm"].submit();
			}
			
		}
</script>

 
 <div class ="table-responsive">
 <table class="table">
 <tr>
 	<th colspan="2">
 	<h1>Hello <%= (String)request.getAttribute("userType") %> </h1>
 	</th>
 </tr>
 <tr>
 	<td>Full Name : </td>
 	<td> <%=(String)request.getAttribute("fullName") %></td>
 </tr>
 <tr>
 	<td>Email : </td>
 	<td> <%= (String)request.getAttribute("email") %></td>
 </tr>	 
  <tr>
 	<td>Phone number : </td>
 	<td> <%= (String)request.getAttribute("phoneNo") %></td>
 </tr>
 <tr>
 	<td>Address : </td>
 	<td> <%= (String)request.getAttribute("address") %></td>
 </tr>
 <% if(request.getAttribute("qualification")!=null &&!request.getAttribute("qualification").equals("")){ %>
 <tr>
 	<td>Qualification : </td>
 	<td> <%= (String)request.getAttribute("qualification") %></td>
 </tr>
 <% } %>
 </table >
 </div>
 <br>
 
 <input type="button" class="btn btn-primary" id="edit" name="edit" value="Edit" >
 <form id="editForm" name ="editForm" action="/DronaDo/Profile" method="post" style="display:none;">
 <input type="hidden" id="operation" name="operation" value="None" >
 <table class="table">
 <tr>
 <th colspan="2">
 <h1>Edit Profile</h1>
 </th>
 </tr>
 <tr>
 <td>
	New Name:
 </td>
 <td>
 <input type="text" id="fullName" name="fullName" value="<%=(String)request.getAttribute("fullName") %>">
 </td>
 </tr>
 <tr>
 <td>
 New Email:
 </td>
 <td>
 <input type="text" name ="email" id ="email" value="<%=(String)request.getAttribute("email") %>">
 </td>
 </tr> 
  <tr>
 <td>
  New PhoneNo:
 </td>
 <td>
 <input type="text" name="phoneNo" id="phoneNo" value="<%=(String)request.getAttribute("phoneNo") %>">
 </td>
 </tr>
  <tr>
 <td>
New Address:
 </td>
 <td>
 <input type="text" name ="address" id ="address" value="<%=(String)request.getAttribute("address") %>">
 </td>
 </tr>
 
 <% if(request.getAttribute("qualification")!=null &&!request.getAttribute("qualification").equals("")){ %>
  <tr>
 <td>
 New Qualification:
 </td>
 <td>
 <input type="text" name="qualification" id="qualification" value="<%=(String)request.getAttribute("qualification") %>">
 </td>
 </tr>
 <%} else{%>
  <tr>
 <td>
 <input type="hidden" name="qualification" id="qualification" value="<%=(String)request.getAttribute("qualification") %>">
 </td>
 </tr>
 
 
 <% } %>
 </table>
 <input type="button" class="btn btn-primary" value="Submit" onclick="sendData();">
 
 </form>
 
 <script type="text/javascript">
 $(document).ready(function(){
	
	 $("#edit").on("click",function(){
		 if(document.getElementById("operation").value=="edit"){
		 	document.getElementById("operation").value="None";
		 }else{
			 document.getElementById("operation").value="edit";
		 }
		 $("#editForm").toggle();
	 });
	 
 });
 
 
 </script>
 </body>
</html>