<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.dronado.daos.SubjectDaos"%>
<%
	SubjectDaos sd = new SubjectDaos();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DronaDo - Registration</title>
<link href="/DronaDo/css/bootstrap.css" rel="stylesheet">
<link href="/DronaDo/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/DronaDo/css/prettyPhoto.css" rel="stylesheet">
<link href="/DronaDo/font/stylesheet.css" rel="stylesheet">
<link href="/DronaDo/css/animate.css" rel="stylesheet">
<link rel="stylesheet" media="screen" href="/DronaDo/css/sequencejs.css">
<link href="/DronaDo/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="/DronaDo/css/style.css" rel="stylesheet">
<link href="/DronaDo/color/default.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="/DronaDo/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="/DronaDo/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="/DronaDo/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="/DronaDo/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="/DronaDo/ico/favicon.ico">



</head>
<body>
	<div class="row" style="padding: 40px 40px 40px 40px;">
		<div class="span12">
			<h1 style="text-shadow: 2px 2px 2px red;">Complete Registration</h1>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#student" data-toggle="tab"><i
						class="icon-shopping-cart"></i> Student</a></li>
				<li><a href="#tutor" data-toggle="tab"><i
						class="icon-wrench"></i> Tutor</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="student">
					<form id="studentForm" method="post"
						action="/DronaDo/SignupServlet" class>
						<input type="hidden" name="userType" value="student">
						<div class="form-group">
							<label for="fullname"><i
								class="zmdi zmdi-account material-icons-name"></i></label> <input
								type="text" name="fullname" id="fullname" class="form-control" 
								placeholder="Your Fullname" required style="width: 1073px;" />

						</div>
						<div class="form-group">
							<label for="email"><i class="zmdi zmdi-lock"></i></label> <input
								type="email" class="form-control" name="email" id="email" placeholder="Email"
								required style="width: 1073px;" />
						</div>
						<div class="form-group">
							<label for="phone"><i class="zmdi zmdi-lock"></i></label> <input
								type="text" class="form-control" name="phone" id="phone" pattern="[6-9]{1}[0-9]{9}"
								placeholder="Phone no." required style="width: 1074px;" />
						</div>
						<div class="form-group" style="height: 61px;">
							<label for="address"><i class="zmdi zmdi-lock"></i></label> <input
								type="text" class="form-control" name="address" id="address" placeholder="Address"
								required style="width: 615px;" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-color"
								value="Get Current Location" onclick="getLocation()">
						</div>
						<div class="form-group">
							<input type="hidden" id="new_latitude" name="new_latitude"
								value=0> <input type="hidden"  class="form-control" id="new_longitude"
								name="new_longitude" value=0>
						</div>

						<div class="form-group form-button">
							<div id="message">
								&nbsp;<input type="submit" name="register" id="register" class="btn btn-color"
									class="form-submit" value="Register">
							</div>
							<br>
						</div>
					</form>
				</div>

				<div class="tab-pane" id="tutor">
					<form id="tutorForm" method="post" action="/DronaDo/SignupServlet">
						<input type="hidden" name="userType" value="tutor">
						<div class="form-group">
							<label for="fullname"><i
								class="zmdi zmdi-account material-icons-name"></i></label> <input
								type="text" name="fullname" id="fullname"
								placeholder="Your Fullname" required style="width: 1077px;" />

						</div>
						<div class="form-group">
							<label for="email"><i class="zmdi zmdi-lock"></i></label> <input
								type="email" name="email" id="email" placeholder="Email"
								required style="width: 1076px;" />
						</div>
						<div class="form-group">
							<label for="phone"><i class="zmdi zmdi-lock"></i></label> <input
								type="text" name="phone" id="phone" pattern="[6-9]{1}[0-9]{9}"
								placeholder="Phone no." required style="width: 1079px;" />
						</div>
						<div class="form-group">
							<label for="qualification"><i
								class="zmdi zmdi-account material-icons-name"></i></label> <input
								type="text" name="qualification" id="qualification"
								placeholder="qualification" required style="width: 1080px;" />

						</div>
						<div class="form-group">
							<div id="all"></div>
							<label for="subjects"><i
								class="zmdi zmdi-account material-icons-name"></i>Subject Name</label> <input
								id="subjects" /> <label for="standardFrom"><i
								class="zmdi zmdi-account material-icons-name"></i>Standard From</label>
							<select id="standardFrom" name="standardFrom">
								<option value="Pre-Nursery">Pre-Nursery</option>
								<option value="Nursery">Nursery</option>
								<option value="I">I</option>
								<option value="II">II</option>
								<option value="III">III</option>
								<option value="IV">IV</option>
								<option value="V">V</option>
								<option value="VI">VI</option>
								<option value="VII">VII</option>
								<option value="VIII">VIII</option>
								<option value="IX">IX</option>
								<option value="X">X</option>
								<option value="XI">XI</option>
								<option value="XII">XII</option>
								<option value="After School">After School</option>
								<option value="Graduation">Graduation</option>
								<option value="Post Graduation">Post Graduation</option>
							</select> <label for="standardTo"><i
								class="zmdi zmdi-account material-icons-name"></i>Standard Upto</label>
							<select id="standardTo" name="standardTo">
								<option value="Pre-Nursery">Pre-Nursery</option>
								<option value="Nursery">Nursery</option>
								<option value="I">I</option>
								<option value="II">II</option>
								<option value="III">III</option>
								<option value="IV">IV</option>
								<option value="V">V</option>
								<option value="VI">VI</option>
								<option value="VII">VII</option>
								<option value="VIII">VIII</option>
								<option value="IX">IX</option>
								<option value="X">X</option>
								<option value="XI">XI</option>
								<option value="XII">XII</option>
								<option value="After School">After School</option>
								<option value="Graduation">Graduation</option>
								<option value="Post Graduation">Post Graduation</option>
							</select> <label for="stream"><i
								class="zmdi zmdi-account material-icons-name"></i>Stream</label> <input
								id="stream"> <input class="btn btn-color" type="button"
								onclick="addSubject()" value="Add">
						</div>
						<div class="form-group">
							<label for="address"><i class="zmdi zmdi-lock"></i></label> <input
								type="text" name="address" id="address" placeholder="Address"
								required style="width: 574px;" /> &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-color"
								value="Get Current Location" onclick="getLocation()">
						</div>
						<div class="form-group">
							<input type="hidden" id="new_latitude" name="new_latitude"
								value=0> <input type="hidden" id="new_longitude"
								name="new_longitude" value=0>
						</div>
						<div class="form-group form-button">
							<div id="message">
								<input type="submit" name="register" id="register"
									class="form-submit btn btn-color" value="Register">
							</div>
							<br>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="/DronaDo/js/jquery.min.js"></script>
	<script src="/DronaDo/js/jquery.easing.js"></script>
	<script src="/DronaDo/js/bootstrap.js"></script>
	<script src="/DronaDo/js/jquery.lettering.js"></script>
	<script src="/DronaDo/js/nagging-menu.js"></script>
	<script src="/DronaDo/js/sequence.jquery-min.js"></script>
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
		var subjects = [];
		$(document).ready(function() {
			alert("running");
			$("input#subjects").autocomplete({
				source : [<%=sd.getSubjects()%>]
			});
			$("input#stream").autocomplete({
				source : [<%=sd.getStreams()%>]
			});
		});
		function remove(idx){
			subjects.splice(idx,1);
			console.log(subjects);
			if (subjects.length == 0)
				document.getElementById("all").innerHTML = "";
			else{
				var display = "";
				display = "<table><thead><tr><th>Subject Name</th><th>Standard From</th><th>Standard Upto</th><th>Stream</th></tr></thead>";		
				for(var i=0;i<subjects.length;i++){
					display += "<tr>";
					display += "<td>" + subjects[i]["name"] +"<input type='hidden' name='sname' value = '"+subjects[i]["name"]+"'></td>";
					display += "<td>" + subjects[i]["standardFrom"] +"<input type='hidden' name='stdFrom' value='"+subjects[i]["standardFrom"]+"'></td>";
					display += "<td>" + subjects[i]["standardTo"] +"<input type='hidden' name='stdTo' value='"+subjects[i]["standardTo"]+"'></td>";
					display += "<td>" + subjects[i]["stream"] +"<input type='hidden' name='stream' value='"+subjects[i]["stream"]+"'></td>";				
					display += "<td>" + "<a class='btn btn-color' onclick='remove("+i+")'>Delete</a>"+"</td>";
					display += "</tr>";
				}
				display += "</table>";
				document.getElementById("all").innerHTML = display; 
			}
		}
		function addSubject() {
			var display = "";
			var sname = document.getElementById("subjects").value.trim();
			var standardFrom = document.getElementById("standardFrom").value;
			var standardTo = document.getElementById("standardTo").value;
			var stream = document.getElementById("stream").value.trim();
			if(sname == "" || stream == "")
				return;
			
			display = "<table><thead><tr><th>Subject Name</th><th>Standard From</th><th>Standard Upto</th><th>Stream</th></tr></thead>";		
			subjects.push({"name" : sname, "standardFrom" : standardFrom,  "standardTo" : standardTo, "stream" : stream});
			
			for(var i=0;i<subjects.length;i++){
				display += "<tr>";
				display += "<td>" + subjects[i]["name"] +"<input type='hidden' name='sname' value = '"+subjects[i]["name"]+"'></td>";
				display += "<td>" + subjects[i]["standardFrom"] +"<input type='hidden' name='stdFrom' value='"+subjects[i]["standardFrom"]+"'></td>";
				display += "<td>" + subjects[i]["standardTo"] +"<input type='hidden' name='stdTo' value='"+subjects[i]["standardTo"]+"'></td>";
				display += "<td>" + subjects[i]["stream"] +"<input type='hidden' name='stream' value='"+subjects[i]["stream"]+"'></td>";				
				display += "<td>" + "<a class='btn btn-color' onclick='remove("+i+")'>Delete</a>"+"</td>";
				display += "</tr>";
			}
			display += "</table>";
			document.getElementById("all").innerHTML = display; 
		}
	</script>
	<script type="text/javascript" src="location.js"></script>

</body>
</html>