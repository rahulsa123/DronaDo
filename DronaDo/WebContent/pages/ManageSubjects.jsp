<%@ page language="java" import="com.dronado.daos.SubjectDaos"%>
<%
	SubjectDaos sd = new SubjectDaos();
%>
<script type="text/javascript">
document.getElementById("title").innerHTML ="Manage Subjects";
</script>
<div class="container text-center">
	Manage Subjects
	
	<form method="post" action="/DronaDo/ManageSubjects">
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
	</form>
	<hr>
	<h3>My Subjects</h3>
	<br>
	<table class="table table-striped">
		<tr>
		<th>Sno</th>
		<th>Name</th>
		<th>Standard</th>
		<th>Stream</th>	
		<th></th>
		<th></th>					
		</tr>
		
		<tr>
		<td>1</td>
		<td>Physics</td>
		<td>5th to 12th</td>
		<td>1</td>
		<td><input type="submit" value="Edit"></td>
		<td><input type="submit" value="Delete"></td>		
		</tr>
		
		<tr>
		<td>1</td>
		<td>Physics</td>
		<td>5th to 12th</td>
		<td>1</td>
		<td><input type="submit" value="Edit"></td>
		<td><input type="submit" value="Delete"></td>		
		</tr>
		
		<tr>
		<td>1</td>
		<td>Physics</td>
		<td>5th to 12th</td>
		<td>1</td>
		<td><input type="submit" value="Edit"></td>
		<td><input type="submit" value="Delete"></td>		
		</tr>
	</table>
</div>
	<script type="text/javascript" src="/DronaDo/js/jquery-1.4.2.js"></script>
	<script type="text/javascript"
		src="/DronaDo/js/jquery-ui-1.8.5.custom.min.js"></script>
<script>
$(document).ready(function() {
	alert("running");
	$("input#subjects").autocomplete({
		source : [<%=sd.getSubjects()%>]
	});
	$("input#stream").autocomplete({
		source : [<%=sd.getStreams()%>]
	});
});
</script>