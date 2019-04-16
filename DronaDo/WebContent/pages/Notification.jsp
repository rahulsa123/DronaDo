<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.dronado.daos.UserDaos"%>
<%
	String s = "";
	if (((String) request.getSession().getAttribute("userType")).equalsIgnoreCase("student")) {
		s = new UserDaos().getAllStudentUsernameInString();
	} else {
		s = new UserDaos().getAllTutorUsernameInString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DronaDo - Notifications</title>
<!--  
<link href="/DronaDo/css/bootstrap.css" rel="stylesheet">
<link href="/DronaDo/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/DronaDo/css/prettyPhoto.css" rel="stylesheet">
<link href="/DronaDo/font/stylesheet.css" rel="stylesheet">
<link href="/DronaDo/css/animate.css" rel="stylesheet">
<link href="/DronaDo/css/flexslider.css" rel="stylesheet">
<link rel="stylesheet" media="screen" href="/DronaDo/css/sequencejs.css">
<link href="/DronaDo/css/style.css" rel="stylesheet">
<link href="/DronaDo/color/default.css" rel="stylesheet">
-->


</head>
<body>
	<div class="span12" style="padding: 30px 30px 30px 30px">
		
<h1 style="text-shadow: 3px 3px 5px red; float:left;">Notifications</h1>
<a class="btn btn-primary" style="float:right;" onclick="newMessage()">New Message</a>
		
	</div>
	<div class="span12 table-responsive" id="messageBlock" style="display:none; width: 100%">
	
		<form method="post" action="/DronaDo/Notifications"
			onsubmit="return validate()">
		<table class="table bg-white" style="min-width:100%;max-width:100%">
		<tr>  <td colspan="2">
						<input type="hidden" id="isFormSubmitted" name="isFormSubmitted"
					value="false"> 
					<input type="hidden" name ="all" id="all">
					<input type="text" class="form-control"  id="all1"
					placeholder="No Receivers added" style="height:50px;" disabled="disabled">
					
					<label for="users"><i
					class="zmdi zmdi-account material-icons-name"></i></label>				
					     
				</td>     
		</tr>
		<tr>
			<td>
				<input class="form-control" id="users"  />	
			</td>
			<td>
				<input type="button" class="btn btn-primary"
				onclick="addReceivers()" value="Add">
			</td>
		</tr>
		<tr>
			<td>
				<textarea  class="form-control" name="message" id="message" placeholder="Write a message"></textarea>
			</td>
			<td>
				<input
				type="submit" class="btn btn-primary" value="Send">
			</td>
		</tr>
			  
			
			
		</table>
		</form>
	
	</div>
	<div class="accordion" id="accordion2">
			${requestScope.notifications}
		</div>
	<script src="/DronaDo/js/jquery.min.js"></script>
	<script src="/DronaDo/js/jquery.easing.js"></script>
	<script src="/DronaDo/js/bootstrap.js"></script>
	<script src="/DronaDo/js/jquery.lettering.js"></script>
	<script src="/DronaDo/js/parallax/jquery.parallax-1.1.3.js"></script>
	<script src="/DronaDo/js/nagging-menu.js"></script>
	<script src="/DronaDo/js/sequence.jquery-min.js"></script>
	<script
		src="/DronaDo/js/sequencejs-options.sliding-horizontal-parallax.js"></script>
	<script src="/DronaDo/js/portfolio/jquery.quicksand.js"></script>
	<script src="/DronaDo/js/portfolio/setting.js"></script>
	<script src="/DronaDo/js/jquery.scrollTo.js"></script>
	<script src="/DronaDo/js/jquery.nav.js"></script>
	<script src="/DronaDo/js/modernizr.custom.js"></script>
	<script src="/DronaDo/js/prettyPhoto/jquery.prettyPhoto.js"></script>
	<script src="/DronaDo/js/prettyPhoto/setting.js"></script>
	<script src="/DronaDo/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="/DronaDo/js/jquery-1.4.2.js"></script>
	<script type="text/javascript"
		src="/DronaDo/js/jquery-ui-1.8.5.custom.min.js"></script>
	<script>
		function validate() {
			alert("mess"+document.getElementById("all").value+" "+document.getElementById("message").innerHTML);
			document.getElementById("isFormSubmitted").value = "true";
			return true;
		}
		$(document).ready(function() {
			alert("running");
			$("input#users").autocomplete({
				source : [<%=s%>]
			});
		});
		function addReceivers() {
			var s = document.getElementById("all").value;
			var v = document.getElementById("users").value;
			document.getElementById("users").value="";
			if (s == "")
				s = v;
			else {
				if (s.search(v) == -1)
					s = s + "," + v;
			}
			document.getElementById("all").value = s;
			document.getElementById("all1").value = s;
		}
		function newMessage(){
			if(document.getElementById("messageBlock").style.display =='none')
				document.getElementById("messageBlock").style.display = "block";
			else
				document.getElementById("messageBlock").style.display = "none";
		}
	</script>
</body>
</html>