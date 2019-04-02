<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html> 
<body>
<script type="text/javascript">
		
		//to change user image in side bar change second value
		 // To send data
		 
  function sendData() {
		var ref ="Name :"+document.getElementById("fullName").value+"\nEmail:"+document.getElementById("email").value+"\nPhone NO :"+document.getElementById("phoneNo").value+"\nAddress :"+document.getElementById("address").value;
		if(document.getElementById("qualification").value!=""){
			ref+="\nQualification :"+document.getElementById("qualification").value;
		}
		
		var b=confirm(ref);
		//alert("Your current location is saved");
		if(b){
			
			document.forms["editing_form"].submit();
		}
		
	}
		
</script>
 <% if((Boolean)request.getAttribute("edit")){%>
 	<div class="alert alert-success alert-dismissible">
 	<button type="button" class="close" data-dismiss="alert">&times;</button>
  	<strong>Success!</strong> Profile is updated!!!
	</div>
 <%} %>
 <div class ="table-responsive ">
 <table class="table table-hover ">
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
 
 <tr>
 <td colspan="2">
 	<input type="hidden" id= "latitude" value="<%= request.getAttribute("latitude") %>">
 	<input type="hidden" id= "longitude"  value="<%= request.getAttribute("longitude") %>">
 	<div id="map" style="width:100%;">
 	</div>
 
 </td>
 </tr>
 </table >
 </div>
 <br>
 
 <input type="button" class="btn btn-primary" id="edit" name="edit" value="Edit" >
 <form id="editing_form"  name ="editing_form"  action="/DronaDo/Profile" method="post" style="display:none">
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
 <input type="text" class="form-control" id="fullName" name="fullName" value="<%=(String)request.getAttribute("fullName") %>">
 </td>
 </tr>
 <tr>
 <td>
 New Email:
 </td>
 <td>
 <input type="email" class="form-control" name ="email" id ="email" value="<%=(String)request.getAttribute("email") %>">
 </td>
 </tr> 
  <tr>
 <td>
  New PhoneNo:
 </td>
 <td>
 <input type="text" class="form-control" name="phoneNo" id="phoneNo" value="<%=(String)request.getAttribute("phoneNo") %>">
 </td>
 </tr>
  <tr>
 <td>
New Address:
 </td>
 <td>
 <input type="text" class="form-control" name ="address" id ="address" value="<%=(String)request.getAttribute("address") %>">
 </td>
 </tr>
 <tr>
 <td> Add new Location </td>
 <td> <input type="button" class="btn btn-primary" value="Get Current Location" onclick="getLocation();">
 <input type="hidden" id="new_latitude" name="new_latitude" >
 <input type="hidden" id="new_longitude" name="new_longitude">
 	</td>
 </tr>
 <% if(request.getAttribute("qualification")!=null &&!request.getAttribute("qualification").equals("")){ %>
  <tr>
 <td>
 New Qualification:
 </td>
 <td>
 <input type="text" class="form-control" name="qualification" id="qualification" value="<%=(String)request.getAttribute("qualification") %>">
 </td>
 </tr>
 <%} else{%>
  <tr style="display:none;">
 <td>
 <input type="hidden" name="qualification" id="qualification" value="<%=(String)request.getAttribute("qualification") %>">
 </td>
 </tr>
 <% } %>
 
 
 <tr>
 <td> New Profile Picture </td>
 <td> 
  <input type="file" id="profile_pic" name="profile_pic" class="input-default-js btn " data-multiple-target="{target} files selected"
    multiple>
   
 </td>
 </tr>
 
 
 <tr>
 	<th colspan="2"><input type="button" class="btn btn-primary" value="Submit" onclick="sendData();"></th>
 </tr>
 
 
 
 </table>
 </form>
 <br> 

 <script type="text/javascript">
 
 $(document).ready(function(){
	
	 $("#edit").on("click",function(){
		 if(document.getElementById("operation").value=="edit"){
		 	document.getElementById("operation").value="None";
		 }else{
			 document.getElementById("operation").value="edit";
		 }
		 $("#editing_form").toggle();
	 });
	 
 });
 </script>
 <script type="text/javascript" src="/DronaDo/pages/location.js"></script>
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyGiXClmvyhTyROW-N9yKodcoxUk_3bgI&libraries=places&callback=initMap"
    async defer></script>
 </body>
</html>