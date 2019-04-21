<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="com.dronado.daos.*"%>
<%@ page language="java" import="com.dronado.pojos.*"%>
<%@ page language="java" import="com.dronado.utilities.DateUtils"%>
<%
String s = "";	
int uid =-1;
	try{
	
			
	
		if (((String) request.getSession().getAttribute("userType")).equalsIgnoreCase("tutor")) {
			s = new UserDaos().getAllStudentUsernameInString();
		} else {
			s = new UserDaos().getAllTutorUsernameInString();
		}
		 uid = (int)request.getSession().getAttribute("uid");
		
		 if(request.getParameter("nid")!=null){
			 new NotificationDaos().remove(Integer.parseInt(request.getParameter("nid")));
		 }
		 if(request.getParameter("mode")!=null){
			 int nid = Integer.parseInt(request.getParameter("noid")); 
			 System.out.println(nid);
			 Notification n = new NotificationDaos().findByNotificationId(nid);
			 System.out.println(n);
			 if(request.getParameter("mode").equalsIgnoreCase("accept")){
				 int studid = Integer.parseInt(request.getParameter("studid"));
				 int teid = Integer.parseInt(request.getParameter("teid"));
				 System.out.println("studid="+studid + "teid = "+teid);
				 new AssignedDaos().insert(new Assigned(0,studid,teid,new java.util.Date()));
				 n.setType("accepted");
				 n.setMessage(n.getMessage() + "\n Request has been accepted. View class details in CLASS STATUS");
				 new NotificationDaos().edit(n);
			 }else if(request.getParameter("mode").equalsIgnoreCase("reject")){
				 n.setType("rejected");
				 n.setMessage(n.getMessage() + "\n Yor request has been rejected");
				 new NotificationDaos().edit(n);
			 }
		 }
	}catch(Exception e){
		System.out.println("Exception caught error here in notification.jsp first block of code");
		System.out.println(e);
		System.out.println(request.getAttribute("uid"));
	}
%>
<!DOCTYPE html>
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

		<h1 style="text-shadow: 3px 3px 5px red; float: left;">Notifications</h1>
		<a class="btn btn-primary" style="float: right;"
			onclick="newMessage()">New Message</a>

	</div>
	<div class="span12 table-responsive" id="messageBlock"
		style="display: none; width: 100%">

		<form method="post" action="/DronaDo/Notifications"
			onsubmit="return validate()">
			<table class="table bg-white"
				style="min-width: 100%; max-width: 100%">
				<tr>
					<td colspan="2"><input type="hidden" id="isFormSubmitted"
						name="isFormSubmitted" value="false"> <input type="hidden"
						name="all" id="all"> <input type="text"
						class="form-control" id="all1" placeholder="No Receivers added"
						style="height: 50px;" disabled="disabled"> <label
						for="users"><i
							class="zmdi zmdi-account material-icons-name"></i></label></td>
				</tr>
				<tr>
					<td><input class="form-control" id="users" /></td>
					<td><input type="button" class="btn btn-primary"
						onclick="addReceivers()" value="Add"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" name="message" id="message"
							placeholder="Write a message"></textarea></td>
					<td><input type="submit" class="btn btn-primary" value="Send">
					</td>
				</tr>



			</table>
		</form>

	</div>
	<div class="accordion fluid" id="accordion2" style="min-width: 80%;">

		<%
			NotificationDaos nd = new NotificationDaos();
			ArrayList<Notification> all = nd.findBySenderOrReceiverUId(uid);
			int z=0;
			for (Notification i: all) {
				if(i.getSender() == uid) {
					System.out.println("i.getSender() == uid");
						Student stu = new StudentDaos().findByUId(i.getReceiver());
						if(stu!=null) {
							
								System.out.println("i.getType().indexOf(\"request\")!=-1 else");

			%>
									<div class="accordion-group ">
										<div class="accordion-heading ">
											<input type="button"
												class="accordion-toggle  dropdown-toggle btn btn-primary"
												style="width: 100%; text-align: left;"
												value="<<<< <%=stu.getStudFullName() %> (<%= stu.getUsername()%>,Student) At : <%=DateUtils.DateToString(i.getDate()) %>"
												onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
										</div>
										<div id="<%=z %>" class="accordion-body collapse card ">
											<div class="accordion-inner  card-body  ml-5 ">
												<%=i.getMessage()%>
											</div>

										</div>
									</div>
								</div>
								<br>

			<%
						
					} else {
						Tutor t = new TutorDaos().findByUId(i.getReceiver());
						if(i.getType().indexOf("request")!=-1) {
							System.out.println(i.getType().indexOf("request")!=-1);
							int sid = Integer.parseInt(i.getType().split("&")[1]);
							Subject sub = new SubjectDaos().getSubjectById(sid);
		%>
							<div class="accordion-group ">
								<div class="accordion-heading ">
									<input type="button"
										class="accordion-toggle  dropdown-toggle btn btn-primary"
										style="width: 100%; text-align: left;"
										value="<<<< <%=t.getTuFullName() %> (<%= t.getUsername()%>,Tutor) At : <%=DateUtils.DateToString(i.getDate()) %>"
										onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
								</div>
								<div id="<%=z %>" class="accordion-body collapse card ">
									<div class="accordion-inner  card-body  ml-5 ">
										You requested to study
										<%= sub.getSName()%>
										|
										<%=sub.getSStandard().split("-")[0] %>
										to
										<%= sub.getSStandard().split("-")[1] %>
										|
										<%= sub.getSStream() %>
									<input type="button" class="btn btn-primary" value="Delete"
												onclick="deleteRequest(<%=i.getnId()%>)">
									</div>
								</div>
								<br>

		<%				}else{
		%>
								<div class="accordion-group ">
									<div class="accordion-heading ">
										<input type="button"
											class="accordion-toggle  dropdown-toggle btn btn-primary"
											style="width: 100%; text-align: left;"
											value="<<<< <%=t.getTuFullName() %> (<%= t.getUsername()%>,Tutor) At : <%=DateUtils.DateToString(i.getDate()) %>"
											onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
									</div>
									<div id="<%=z %>" class="card "
										style="display: none; margin: 0px 0px 0px 0px;">
										<div class=" card-body  ml-5 ">
											<%=i.getMessage()%>
										</div>
									</div>
								</div>
								<br>
						

		<%				}
					}
				} else {
					Student stu = new StudentDaos().findByUId(i.getSender());
					if (stu != null){
						if(i.getType().indexOf("request")!=-1){
		%>
							<div class="accordion-group ">
								<div class="accordion-heading ">
									<input type="button"
										class="accordion-toggle  dropdown-toggle btn btn-primary"
										style="width: 100%; text-align: left;"
										value=">>>> <%=stu.getStudFullName() %> (<%= stu.getUsername()%>,Student) At : <%=DateUtils.DateToString(i.getDate()) %>"
										onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
								</div>
								<div id="<%=z %>" class="accordion-body collapse card "
									style="display: none; margin: 0px 0px 0px 0px;">
									<div class="accordion-inner  card-body  ml-5 ">
										<%=i.getMessage()%>
									</div>
									<select id="classSelected<%=i.getnId()%>" class="form-control">
		<%							try{
										for(Teaches te:new TeachesDaos().findByTuIdAndSIdSimilar(uid, Integer.parseInt(i.getType().split("&")[1]))){
		%>
											<option value="<%=te.gettId()%>"><%=te.getDuration()%> | <%=te.getFees() %> | <%=te.gettAddress() %></option>
			
			<%
									}}catch(Exception e){
										System.out.println("Exception caught");
										System.out.println(e);
									}
		
		%>							</select>
									<input type="button" class="btn btn-success" value="Accept" onclick="acceptRequest(<%=i.getnId()%>,<%=stu.getStudId() %>);">
									<input type="button" class="btn btn-danger" value="Reject" onclick="rejectRequest(<%=i.getnId()%>,<%=stu.getStudId() %>);">
								</div>
							</div>
							<br>
							
		<%
							
						}else{
					
		%>
							<div class="accordion-group ">
								<div class="accordion-heading ">
									<input type="button"
										class="accordion-toggle  dropdown-toggle btn btn-primary"
										style="width: 100%; text-align: left;"
										value=">>>> <%=stu.getStudFullName() %> (<%= stu.getUsername()%>,Student) At : <%=DateUtils.DateToString(i.getDate()) %>"
										onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
								</div>
								<div id="<%=z %>" class="accordion-body collapse card "
									style="display: none; margin: 0px 0px 0px 0px;">
									<div class="accordion-inner  card-body  ml-5 ">
										<%=i.getMessage()%>
									</div>
								</div>
							</div>
							<br>

		<%			}}else {
						Tutor t = new TutorDaos().findByUId(i.getSender());
		%>
					
							<div class="accordion-group ">
								<div class="accordion-heading ">
									<input type="button"
										class="accordion-toggle  dropdown-toggle btn btn-primary"
										style="width: 100%; text-align: left;"
										value=">>>> <%=t.getTuFullName() %> (<%= t.getUsername()%>,Tutor) At : <%=DateUtils.DateToString(i.getDate()) %>"
										onclick="popupmessage(<%=z %>)"> <i class="icon-plus"></i>
								</div>
								<div id="<%=z %>" class="accordion-body collapse card "
									style="display: none; margin: 0px 0px 0px 0px;">
									<div class="accordion-inner  card-body  ml-5 ">
										<%=i.getMessage()%>
									</div>
								</div>
							</div>
							<br>
					
		<%			}
				}
				z += 1;
			}
		
		%>
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
		function popupmessage(n){
			var message = document.getElementById(String(n));
			if(message.style.display=="none")
				message.style.display="block";
			else
				message.style.display="none";
		}
		function acceptRequest(nid,studid){
			var teid = document.getElementById("classSelected"+nid).value;
			if(teid!=""){
				$("#mainPartFile").load("/DronaDo/pages/Notification.jsp?mode=accept&noid="+nid+"&studid="+studid+"&teid="+teid);
			}
		}
		function rejectRequest(nid,studid){
			var teid = document.getElementById("classSelected"+nid).value;
			if(teid!=""){
				$("#mainPartFile").load("/DronaDo/pages/Notification.jsp?mode=reject&noid="+nid+"&studid="+studid+"&teid="+teid);
			}
		}
		function deleteRequest(nid){
			alert(nid);
			$("#mainPartFile").load("/DronaDo/pages/Notification.jsp?nid="+nid);
		}
	</script>
</body>
</html>