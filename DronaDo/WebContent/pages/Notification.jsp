<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.dronado.daos.UserDaos" %>
<% String s = ""; 
	if(((String)request.getSession().getAttribute("userType")).equalsIgnoreCase("student")){
		s = new UserDaos().getAllStudentUsernameInString();
	}
	else{
		s = new UserDaos().getAllTutorUsernameInString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DronaDo - Notifications</title>

<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/prettyPhoto.css" rel="stylesheet">
<link href="../font/stylesheet.css" rel="stylesheet">
<link href="../css/animate.css" rel="stylesheet">
<link href="../css/flexslider.css" rel="stylesheet">
<link rel="stylesheet" media="screen" href="../css/sequencejs.css">
<link href="../css/style.css" rel="stylesheet">
<link href="../color/default.css" rel="stylesheet">
</head>
<body>
	<div class="span12" style="padding: 30px 30px 30px 30px">
	              <h3>Notifications</h3>
	              <div class="accordion" id="accordion2">
	                <%request.getAttribute("notifications"); %>
	              </div>
	</div>
	<div class="span12">
	<form method="post" action="../Notifications" onsubmit="validate()">
		<input type="hidden" id="isFormSubmitted" name="isFormSubmitted" value="false">
		<input type="text" name="all" id="all" placeholder="No Receivers added" disabled style="width: 1080px; "><br> 
							<label for="users"><i class="zmdi zmdi-account material-icons-name"></i></label> 
							<input id="users" style="width: 870px; "/>
							<input type="button" onclick="addReceivers()" value="Add">
		<input type="text" name="message" id="message"><input type="submit" value="Send">
	</form>
	</div>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/jquery.easing.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script src="../js/jquery.lettering.js"></script>
	<script src="../js/parallax/jquery.parallax-1.1.3.js"></script>
	<script src="../js/nagging-menu.js"></script>
	<script src="../js/sequence.jquery-min.js"></script>
	<script src="../js/sequencejs-options.sliding-horizontal-parallax.js"></script>
	<script src="../js/portfolio/jquery.quicksand.js"></script>
	<script src="../js/portfolio/setting.js"></script>
	<script src="../js/jquery.scrollTo.js"></script>
	<script src="../js/jquery.nav.js"></script>
	<script src="../js/modernizr.custom.js"></script>
	<script src="../js/prettyPhoto/jquery.prettyPhoto.js"></script>
	<script src="../js/prettyPhoto/setting.js"></script>
	<script src="../js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="../js/jquery-ui-1.8.5.custom.min.js"></script>
	<script>
		function validate(){
			document.getElementById("isFormSubmitted").value="true";
		}
		$(document).ready(function() {
			$("input#users").autocomplete({
				source : [<%=s%>]
			});
		});
		function addReceivers() {
			var s = document.getElementById("all").value;
			var v = document.getElementById("users").value;
			if (s == "")
				s = v;
			else {
				if (s.search(v) == -1)
					s = s + "," + v;
			}
			document.getElementById("all").value = s;
		}
	</script>
</body>
</html>