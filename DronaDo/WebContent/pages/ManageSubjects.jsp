<%@ page language="java" import="com.dronado.daos.SubjectDaos"%>
<%@ page language="java" import="com.dronado.daos.TutorDaos"%>
<%@ page language="java" import="com.dronado.pojos.Subject"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%
	SubjectDaos sd = new SubjectDaos();
	TutorDaos td = new TutorDaos();
	System.out.println(session.getAttribute("uid"));
	int a = (int)session.getAttribute("uid");
	ArrayList<Integer> arrSub = td.getTuSubjects(a);
%>
<style>
#"mainDiv" ul {
background-color: black;

}




</style>
<script type="text/javascript">
document.getElementById("title").innerHTML ="Manage Subjects";
</script>
<div id ="mainDiv" class="container text-center">
	<h1 style="text-shadow: 2px 2px 3px blue;"> Manage Subjects</h1>
	
	<form method="post" action="/DronaDo/ManageSubjects">
		<div id="all"></div>
							<br><br>
					<table>
					<tr>
						<td>
							<label for="subjects" ><i
								class="zmdi zmdi-account material-icons-name" ></i><h4  style="padding-right: 15px; font-style: italic;">Subject Name : </h4></label>
						</td>
						<td>
							 <input	type="text"		id="subjects" class="dropdown-toggle form-control" />
						</td>
					</tr> 
					<tr>
					<td>
						<label for="standardFrom" ><i class="zmdi zmdi-account material-icons-name"></i> <h4  style="padding-right: 15px;font-style: italic;">Standard From :</h4></label>
					</td>
					<td>
							<select id="standardFrom" name="standardFrom" class="form-control" >
								<option  class="dropdown-item" value="Pre-Nursery">Pre-Nursery</option>
								<option  class="dropdown-item" value="Nursery">Nursery</option>
								<option  class="dropdown-item" value="I">I</option>
								<option  class="dropdown-item" value="II">II</option>
								<option  class="dropdown-item"value="III">III</option>
								<option  class="dropdown-item" value="IV">IV</option>
								<option  class="dropdown-item" value="V">V</option>
								<option  class="dropdown-item" value="VI">VI</option>
								<option  class="dropdown-item" value="VII">VII</option>
								<option  class="dropdown-item" value="VIII">VIII</option>
								<option  class="dropdown-item" value="IX">IX</option>
								<option  class="dropdown-item" value="X">X</option>
								<option  class="dropdown-item" value="XI">XI</option>
								<option  class="dropdown-item" value="XII">XII</option>
								<option  class="dropdown-item" value="After School">After School</option>
								<option  class="dropdown-item" value="Graduation">Graduation</option>
								<option  class="dropdown-item" value="Post Graduation">Post Graduation</option>
							</select>
					</td>
					</tr>
					<tr>
					<td>
						 <label for="standardTo"><i
								class="zmdi zmdi-account material-icons-name"></i><h4  style="padding-right: 15px;font-style: italic;">Standard Upto : </h4></label>
					</td>
					<td>
							<select id="standardTo" name="standardTo" class="form-control">
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
							</select>
					</td>
					</tr>
					<tr>
						<td style="text-align: left;">
					 <label for="stream"><i class="zmdi zmdi-account material-icons-name pt-0"></i><h4 >Stream : </h4></label>
					</td>
					<td>		
					 <input class="form-control  dropdown-toggle"  id="addStream"> <input class="btn btn-color" type="button" onclick="addSubject()" value="Add">
					</td>
					</tr>
				</table>
	</form>
	<hr>
	<h3>My Subjects</h3>
	<br>
	<table class="table table-striped">
	<% if(arrSub!=null && arrSub.size()>0)  {%>
		<tr>
		<th>S.no</th>
		<th>Name</th>
		<th>Standard From</th>
		<th>Standard To</th>	
		<th>Stream</th>
		<th>Edit/Update</th>					
		<th>Delete/Cancel</th>					
		</tr>
		
		<% for (int i=0;i<arrSub.size();i++){ 
			int idx = arrSub.get(i);
			Subject sub = sd.getSubjectById(idx);
		%>
		
			<tr>
			<td id="sno<%=idx%>"><%=i+1 %></td>
			<td id="sname<%=idx%>"><%=sub.getSName() %></td>
			<td id="stdFrom<%=idx%>"><%=sub.getSStandard().split("-")[0] %></td>
			<td id="stdTo<%=idx%>"><%=sub.getSStandard().split("-")[1] %></td>
			<td id="stream<%=idx%>"><%=sub.getSStream() %></td>
			<td><input type="button" id=editUpdate<%=idx%> value="Edit" onclick="editUpdate(<%=idx%>)"></td>
			<td><input type="button" id=cancelDelete<%=idx%> value="Delete" onclick="cancelDelete(<%=idx%>)"></td>		
			</tr>
		<%} %>
	</table>
	<%} %>
	<form id="manageSubjectsForm" action="/DronaDo/ManageSubjects" method="post">
		<input type="hidden" id="operation" name="operation" value="">
		<input type="hidden" id="sno" name="sno" value="">
		<input type="hidden" id="sname" name="sname" value="">
		<input type="hidden" id="stdFrom" name="stdFrom" value="">
		<input type="hidden" id="stdTo" name="stdTo" value="">
		<input type="hidden" id="stream" name="stream" value="">
	</form>
</div>
	<script type="text/javascript" src="/DronaDo/js/jquery-1.4.2.js"></script>
	<script type="text/javascript"
		src="/DronaDo/js/jquery-ui-1.8.5.custom.min.js"></script>
		
<script>
var subjects = {};
function cancelDelete(i){
	if(document.getElementById("cancelDelete"+i).value=="Delete"){
		document.getElementById("operation").value = "Delete";
		document.getElementById("sno").value = i
		document.getElementById("sname").value = document.getElementById("sname"+i).innerHTML.trim();
		document.getElementById("stdFrom").value = document.getElementById("stdFrom"+i).innerHTML;
		document.getElementById("stdTo").value = document.getElementById("stdTo"+i).innerHTML; 
		document.getElementById("stream").value = document.getElementById("stream"+i).innerHTML.trim();
		document.getElementById("manageSubjectsForm").submit();
	} else if(document.getElementById("cancelDelete"+i).value=="Cancel"){
		document.getElementById("editUpdate"+i).value = "Edit";
		document.getElementById("cancelDelete"+i).value = "Delete";
		document.getElementById("sno"+i).innerHTML = subjects[i][0];
		document.getElementById("sname"+i).innerHTML = subjects[i][1];
		document.getElementById("stdFrom"+i).innerHTML = subjects[i][2];
		document.getElementById("stdTo"+i).innerHTML = subjects[i][3];
		document.getElementById("stream"+i).innerHTML = subjects[i][4];
	}
}
function addSubject(){
	if(document.getElementById("subjects").value.trim()=="" || document.getElementById("addStream").value.trim()==""){
		return;
	}
	document.getElementById("operation").value = "Add";
	document.getElementById("sname").value = document.getElementById("subjects").value.trim();
	document.getElementById("stdFrom").value = document.getElementById("standardFrom").value;
	document.getElementById("stdTo").value = document.getElementById("standardTo").value; 
	document.getElementById("stream").value = document.getElementById("addStream").value.trim();
	document.getElementById("manageSubjectsForm").submit();
}
function editUpdate(i){
	if(document.getElementById("editUpdate"+i).value == "Edit"){
		subjects[i] = [i,document.getElementById("sname"+i).innerHTML,document.getElementById("stdFrom"+i).innerHTML,document.getElementById("stdTo"+i).innerHTML,document.getElementById("stream"+i).innerHTML];
		document.getElementById("editUpdate"+i).value = "Update";
		document.getElementById("cancelDelete"+i).value = "Cancel";
		document.getElementById("sno"+i).innerHTML = "<input id=\"sno"+i+"i\" type=\"text\" value=\""+document.getElementById("sno"+i).innerHTML+"\">";
		document.getElementById("sname"+i).innerHTML = "<input id=\"sname"+i+"i\" type=\"text\" value=\""+document.getElementById("sname"+i).innerHTML+"\">";
		$("input#sname"+i+"i").autocomplete({
			source : [<%=sd.getSubjects()%>]
		});
		document.getElementById("stdFrom"+i).innerHTML = "<select id=\"stdFrom"+i+"i\">"+getStandardOptions+"</select>";
		document.getElementById("stdTo"+i).innerHTML = "<select id=\"stdTo"+i+"i\">"+getStandardOptions+"</select>";
		document.getElementById("stream"+i).innerHTML = "<input id=\"stream"+i+"i\" type=\"text\" value=\""+document.getElementById("stream"+i).innerHTML+"\">";
		$("input#stream"+i+"i").autocomplete({
			source : [<%=sd.getStreams()%>]
		});	
	}
	else if(document.getElementById("editUpdate"+i).value == "Update"){
		if(document.getElementById("sname"+i+"i").value.trim() == ""||document.getElementById("stream"+i+"i").value.trim()==""){
			cancelDelete(i);
			return;
		}
		document.getElementById("operation").value = "Update";
		document.getElementById("sno").value = document.getElementById("sno"+i+"i").value;
		document.getElementById("sname").value = document.getElementById("sname"+i+"i").value.trim();
		document.getElementById("stdFrom").value = document.getElementById("stdFrom"+i+"i").value;
		document.getElementById("stdTo").value = document.getElementById("stdTo"+i+"i").value; 
		document.getElementById("stream").value = document.getElementById("stream"+i+"i").value.trim();
		document.getElementById("manageSubjectsForm").submit();
	}
} 

function getStandardOptions(){
	var str = "<option value=\"Pre-Nursery\">Pre-Nursery</option>\r\n" + 
	"								<option value=\"Nursery\">Nursery</option>\r\n" + 
	"								<option value=\"I\">I</option>\r\n" + 
	"								<option value=\"II\">II</option>\r\n" + 
	"								<option value=\"III\">III</option>\r\n" + 
	"								<option value=\"IV\">IV</option>\r\n" + 
	"								<option value=\"V\">V</option>\r\n" + 
	"								<option value=\"VI\">VI</option>\r\n" + 
	"								<option value=\"VII\">VII</option>\r\n" + 
	"								<option value=\"VIII\">VIII</option>\r\n" + 
	"								<option value=\"IX\">IX</option>\r\n" + 
	"								<option value=\"X\">X</option>\r\n" + 
	"								<option value=\"XI\">XI</option>\r\n" + 
	"								<option value=\"XII\">XII</option>\r\n" + 
	"								<option value=\"After School\">After School</option>\r\n" + 
	"								<option value=\"Graduation\">Graduation</option>\r\n" + 
	"								<option value=\"Post Graduation\">Post Graduation</option>";
	return str;
}
</script>
<script>
$(document).ready(function() {
	alert("running");
	$("input#subjects").autocomplete({
		source : [<%=sd.getSubjects()%>]
	});
	$("input#addStream").autocomplete({
		source : [<%=sd.getStreams()%>]
	});
});
</script>