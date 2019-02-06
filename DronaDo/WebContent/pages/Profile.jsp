<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<jsp:include page="Head.jsp" flush="true"></jsp:include>
<script type="text/javascript">
document.getElementById("title").innerHTML ="Profile";
</script>
<body>
<jsp:include page="TopAndSideMenu.jsp" flush="true"></jsp:include>
<div class ="MainPart">
		
		<script type="text/javascript">
		document.getElementById("user").setAttribute("src", "/DronaDo/img/face.png");
		//to change user image in side bar change second value
		function sendData() {
			var b=confirm("New Data\n"+document.getElementById("fullName").value+"\n"+document.getElementById("email").value+"\n"+document.getElementById("phoneNo").value+"\n"+document.getElementById("address").value+"\n"+document.getElementById("qualification").value);
			if(b){
				alert("hell");
				document.forms["editForm"].submit();
			}
			
		}
		</script>
	
<!-- 

		put code below this block


 -->
 

 <h1>Hello <%= (String)request.getAttribute("userType") %> </h1>
 <table class="table">
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
 </table><br>
 
 <input type="button" id="edit" name="edit" value="Edit" >
 <form id="editForm" name ="editForm" action="/DronaDo/Profile" method="post" style="display:none;">
 <input type="hidden" id="operation" name="operation" value="None" >
 <table>
 <tr>
 <td>
 Enter New Name:
 </td>
 <td>
 <input type="text" id="fullName" name="fullName" value="<%=(String)request.getAttribute("fullName") %>">
 </td>
 </tr>
 <tr>
 <td>
 Enter New Email:
 </td>
 <td>
 <input type="text" name ="email" id ="email" value="<%=(String)request.getAttribute("email") %>">
 </td>
 </tr> 
  <tr>
 <td>
 Enter New PhoneNo:
 </td>
 <td>
 <input type="text" name="phoneNo" id="phoneNo" value="<%=(String)request.getAttribute("phoneNo") %>">
 </td>
 </tr>
  <tr>
 <td>
 Enter New Address:
 </td>
 <td>
 <input type="text" name ="address" id ="address" value="<%=(String)request.getAttribute("address") %>">
 </td>
 </tr>
 
 <% if(request.getAttribute("qualification")!=null &&!request.getAttribute("qualification").equals("")){ %>
  <tr>
 <td>
 Enter New Qualification:
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
 <input type="button" value="Submit" onclick="sendData();">
 
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
 
 
 
 
 
 
 
 
 
 
 
</div>
<jsp:include page="Bottom.jsp" flush="true"></jsp:include>
</body>
</html>