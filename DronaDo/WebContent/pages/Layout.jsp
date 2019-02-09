<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="Head.jsp" flush="true"></jsp:include>
<script type="text/javascript">
document.getElementById("title").innerHTML =" Title of page";
</script>
<body>
<jsp:include page="TopAndSideMenu.jsp" flush="true"></jsp:include>
<div class ="MainPart">

		<script type="text/javascript">
		document.getElementById("user").setAttribute("src", "../img/default.png");
		//to change user image in side bar change second value
		</script>
<!-- 

		put code below this block


 -->
 <a href="/DronaDo/Profile">hhh</a>
</div>
<jsp:include page="Bottom.jsp" flush="true"></jsp:include>
</body>
</html>