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
 </table>
 
</div>
<jsp:include page="Bottom.jsp" flush="true"></jsp:include>
</body>
</html>