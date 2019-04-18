<!DOCTYPE html>
<%@ page language="java" import="com.dronado.daos.TutorDaos"%>
<%@ page language="java" import="com.dronado.pojos.Tutor"%>
<%@ page language="java" import="com.dronado.daos.AssignedDaos"%>
<%@ page language="java" import="com.dronado.daos.StudentDaos"%>
<%@ page language="java" import="com.dronado.daos.TeachesDaos"%>
<%@ page language="java" import="com.dronado.daos.SubjectDaos"%>
<%@ page language="java" import="com.dronado.pojos.Teaches"%>
<%@ page language="java" import="com.dronado.pojos.Subject"%>
<%@ page language="java" import="com.dronado.pojos.Student"%>
<%@ page language="java" import="java.util.ArrayList"%>

<%
TutorDaos td = new TutorDaos();
TeachesDaos ted = new TeachesDaos();
SubjectDaos sd = new SubjectDaos();
AssignedDaos ad = new AssignedDaos();
StudentDaos std = new StudentDaos();
Tutor t=null;
Student st = null;
int uid = (int)session.getAttribute("uid");
String userType = (String)session.getAttribute("userType");
%>
<%
	
	if(userType.equalsIgnoreCase("tutor")){
		
		t = td.findByUId(uid);
		
		
		ArrayList<Teaches> teachList = ted.findAllByTuId(t.getTuId());
%>
<script type="text/javascript" src="/DronaDo/js/jquery-ui-1.8.5.custom.min.js"></script>
		<div class="fluid" style="max-width: 80%;">
			<h1 style="text-shadow: 2px 2px 2px blue; text-align: center;">Manage Class</h1><hr style="width: 3px;">
			<form style="font-size: large; font-style: italic; text-shadow: 1px 1px 1px red;">
				<label for="addSubject">Subject</label><input class="subjects form-control" name="addSubject" id="addSubject"><br>
				<label for="addFees">Fees/Hour:</label><input class="form-control" type="number" name="addFees" id="addFees"><br>
				<label for="addTimeFrom">Time From:</label><input class="form-control" type="text" name="addTimeFrom" id="addTimeFrom"><br>
				<label for="addTimeTo">Time To:</label><input type="text" class="form-control" name="addTimeTo" id="addTimeTo"><br>
				<label for="addDays">Days:</label>
				<select name="addDaysVisible" class="form-control" multiple id="addDaysVisible">
				    <option value="Sun">Sunday</option>
				    <option value="Mon">Monday</option>
				    <option value="Tue">Tuesday</option>
				    <option value="Wed">Wednesday</option>
				    <option value="Thurs">Thursday</option>
				    <option value="Fri">Friday</option>
				    <option value="Sat">Saturday</option>
				</select><br>
				<label for="addExperience">Experience</label><input type="number" class="form-control" placeholder="Add experience in Year" name="addExperience" id="addExperience"><br>
				<label for="addAddress">Address</label><input type="text" class="form-control" placeholder="Add Address" name="addAddress" id="addAddress"><br>
				<input type="button" class="btn btn-primary" onclick="addValidate()" value="Add Class">
			</form>
		</div>
		<hr>
<%		if(teachList.size()>0){	
%>
			<table>
				<thead>
				<tr>
					<th>S.no.</th>
					<th>Subject</th>
					<th>Fees/hour</th>
					<th>From</th>
					<th>To</th>
					<th>Days</th>
					<th>Experience(in years)</th>
					<th>Address</th>
					<th>Edit/Update</th>
					<th>Delete/Cancel</th>
					<th>Message</th>
				</tr>
				</thead>
			<%for (int i=0; i<teachList.size();i++){
					Teaches te = teachList.get(i);
					Subject s = sd.getSubjectById(te.getsId());
			%>
				<tr>
					<td id="sno<%=te.gettId()%>"><%=i+1 %></td>
					<td id="subject<%=te.gettId()%>"><%=s.getSName() + " & " + s.getSStandard() + " & " + s.getSStream() %></td>
					<td id="fees<%=te.gettId()%>"><%=te.getFees() %></td>
					<%try{ %>
						<td id="timeFrom<%=te.gettId()%>"><%=te.getDuration().split(" & ")[0] %></td>
						<td id="timeTo<%=te.gettId()%>"><%=te.getDuration().split(" & ")[1] %></td>
						<%
						String str = "";
						for(int z=2;z<te.getDuration().split(" & ").length;z++){
							str += "," + te.getDuration().split(" & ")[z] ;
						} 
						if(!str.equals(""))
							str = str.substring(1);
						%>
					<td id="days<%=te.gettId()%>"><%=str%></td>
					<%}catch(Exception e){e.printStackTrace();
					%>
					</td>
					<td  id="days<%=te.gettId()%>"></td>
					<% 
					} %>
					<td id="experience<%=te.gettId()%>"><%=te.getExperience()%></td>
					<td id="address<%=te.gettId()%>"><%=te.gettAddress()%></td>
					<td><input type="button" id="editUpdate<%=te.gettId()%>" value="Edit" onclick="editUpdate(<%=te.gettId()%>)"></td>
					<td><input type="button" id="cancelDelete<%=te.gettId()%>" value="Delete" onclick="cancelDelete(<%=te.gettId()%>)"></td>
					<td><input type=text placeholder="Write a message" id="message<%=te.gettId()%>"><input type="button" value="Send" onclick="messageSend(<%=te.gettId()%>)">
				</tr>
			<%}%>
			</table>

<%		}%>
 
<%	} else if(userType.equalsIgnoreCase("student")){
		st = std.findByUId(uid);
		ArrayList<Teaches> stte = ad.findAllClassByStudentId(st.getStudId());
		if(stte.size()>0){
%>
			<table>
				<thead>
				<tr>
					<th>S.no.</th>
					<th>Tutor Username</th>
					<th>Tutor name</th>
					<th>Subject</th>
					<th>Fees/hour</th>
					<th>From</th>
					<th>To</th>
					<th>Days</th>
					<th>Teacher's Experience(in years)</th>
					<th>Address</th>
					<th>Exit</th>
				</tr>
				</thead>
<%
			for(int z=0;z<stte.size();z++){
				Teaches te = stte.get(z);
				Tutor tu = td.findByTuId(te.getTuId());
				Subject s=sd.getSubjectById(te.getsId());
%>
				<tr>
					<td><%=z+1 %></td>
					<td><%=tu.getUsername()%></td>
					<td><%=tu.getTuFullName() %></td>
					<td><%=s.getSName() + " & " + s.getSStandard() + " & " + s.getSStream() %></td>
					<td><%=te.getFees() %></td>
					<td><%=te.getDuration().split(" & ")[0] %></td>
					<td><%=te.getDuration().split(" & ")[1] %></td>
					<td>
					<%	String ss = "";
						for(int k=2;k<te.getDuration().split(" & ").length;k++)
							ss+= ","+te.getDuration().split(" & ")[k];
						ss = ss.substring(1);
					%><%=s%>
					</td>
					<td><%=te.getExperience() %></td>
					<td><%=te.gettAddress() %></td>
					<td><input type="button" id="teid<%=ad.getAssigned(te.gettId(), st.getStudId())%>" value="Exit" onclick="exit(<%=te.gettId()%>)"></td>
				</tr>		
		
<%
			}
		}

	}
%>
<form id="manageClassForm" method="post" action="/DronaDo/ManageClass">
	<input type="hidden" id="formSno" name="formSno"  value="">
	<input type="hidden" id="formSubject" name="formSubject" value="">
	<input type="hidden" id="formFees" name="formFees" value="">
	<input type="hidden" id="formDuration" name="formDuration" value="">
	<input type="hidden" id="formExperience" name="formExperience" value="">
	<input type="hidden" id="formAddress" name="formAddress" value="">
	<input type="hidden" id="operation" name="operation" value="">
	<input type="hidden" id="teidx" value="">
	<input type="hidden" id="formMessage" value="">
</form>
<!-- 
<script type="text/javascript" src="/DronaDo/js/jquery-1.4.2.js"></script>

 -->
	
	<script>
	<%
		try{
		System.out.println("t="+t);
		System.out.println("t.getTuId() = " + t.getTuId());	
		System.out.println("sd.getAllInSubjectsFromTuid(t.getTuId()) = " + sd.getAllInSubjectsFromTuid(t.getTuId()));
	%>
	var subjects = [<%=sd.getAllInSubjectsFromTuid(t.getTuId())%>];
	$(document).ready(function(){
		alert("running");
		$(".subjects").autocomplete({
		source:[<%=sd.getAllInSubjectsFromTuid(t.getTuId())%>]
		});
	});
	<%		
		}catch(Exception e){
			System.out.println("Exception caught");
			System.out.println(e);
		}
	%>
	
	var tutorData = {};
	function editUpdate(idx){
		if(document.getElementById("editUpdate"+idx).value == "Edit"){
			tutorData[idx] = {
					"sno" : document.getElementById("sno"+idx).innerHTML,
					"subject":document.getElementById("subject"+idx).innerHTML,
					"fees":document.getElementById("fees"+idx).innerHTML,
					"timeFrom":document.getElementById("timeFrom"+idx).innerHTML,
					"timeTo":document.getElementById("timeTo"+idx).innerHTML,
					"days": document.getElementById("days"+idx).innerHTML,
					"experience": document.getElementById("experience"+idx).innerHTML,
					"address": document.getElementById("address"+idx).innerHTML
			};
			console.log(tutorData);
			document.getElementById("subject"+idx).innerHTML = "<input type='text' class='subjects' id=\"updateSubject"+idx+"\" value=\""+document.getElementById("subject"+idx).innerHTML+"\">"
			document.getElementById("fees"+idx).innerHTML = "<input type='number' id=\"updateFees"+idx+"\" value=\""+document.getElementById("fees"+idx).innerHTML+"\">"
			document.getElementById("timeFrom"+idx).innerHTML = "<input type='text' id=\"updateTimeFrom"+idx+"\" value=\""+tutorData[idx]["timeFrom"]+"\">"
			document.getElementById("timeTo"+idx).innerHTML = "<input type='text' id=\"updateTimeTo"+idx+"\" value=\""+tutorData[idx]["timeTo"]+"\">"
			var str =  "<select name=\"updateDays"+idx+"\" multiple id=\"updateDays"+idx+"\">" + 
			"				    <option value=\"Sun\""+((tutorData[idx]["days"].search("Sun")!=-1)?" selected ":"")+">Sunday</option>" + 
					"				    <option value=\"Mon\""+((tutorData[idx]["days"].search("Mon")!=-1)?" selected ":"")+">Monday</option>" + 
					"				    <option value=\"Tue\""+((tutorData[idx]["days"].search("Tue")!=-1)?" selected ":"")+">Tuesday</option>" + 
					"				    <option value=\"Wed\""+((tutorData[idx]["days"].search("Wed")!=-1)?" selected ":"")+">Wednesday</option>" + 
					"				    <option value=\"Thurs\""+((tutorData[idx]["days"].search("Thurs")!=-1)?" selected ":"")+">Thursday</option>" + 
					"				    <option value=\"Fri\""+((tutorData[idx]["days"].search("Fri")!=-1)?" selected ":"")+">Friday</option>" + 
					"				    <option value=\"Sat\""+((tutorData[idx]["days"].search("Sat")!=-1)?" selected ":"")+">Saturday</option>" + 
					"				</select>";
			alert(str);
			document.getElementById("days"+idx).innerHTML =str;
			document.getElementById("experience"+idx).innerHTML = "<input type='number' id=\"updateExperience"+idx+"\" value=\""+document.getElementById("experience"+idx).innerHTML+"\">"
			document.getElementById("address"+idx).innerHTML = "<input type='text' id=\"updateAddress"+idx+"\" value=\""+document.getElementById("address"+idx).innerHTML+"\">"
			document.getElementById("editUpdate"+idx).value = "Update";
			document.getElementById("cancelDelete"+idx).value = "Cancel";	
		}
		else if(document.getElementById("editUpdate"+idx).value == "Update"){
			if(subjects.includes(document.getElementById("updateSubject"+idx).value)==-1 || document.getElementById("updateTimeFrom").value.trim()=="" ||document.getElementById("updateTimeTo").value.trim()=="" || document.getElementById("updateDaysVisible").value==""||document.getElementById("updateExperience").value==""){
				cancelDelete(idx);
				return;
			}
			document.getElementById("formSno").value = idx;
			document.getElementById("formSubject").value = document.getElementById("updateSubject"+idx).value;
			document.getElementById("formFees").value = document.getElementById("updateFees"+idx).value;
			var v = document.getElementById("formDuration");
			v.value += document.getElementById("updateTimeFrom").value + " & ";
			v.value += document.getElementById("updateTimeTo").value;
			for(var i=0;i<7;i++){
				if(document.getElementsByName("updateDays"+idx)[0][i].selected){
					v.value += " & "+document.getElementsByName("updateDays"+idx)[0][i].value;
				} 
			}
			document.getElementById("formExperience").value = document.getElementById("updateExperience").value;
			document.getElementById("formAddress").value = document.getElementById("updateAddress").value;
			document.getElementById("operation").value = "Update";
			document.getElementById("manageClassForm").submit();
			
		}
	}
	function cancelDelete(idx){
		if(document.getElementById("cancelDelete"+idx).value == "Cancel"){
			document.getElementById("subject"+idx).innerHTML = tutorData[idx]["subject"];
			document.getElementById("fees"+idx).innerHTML = tutorData[idx]["fees"];
			document.getElementById("timeFrom"+idx).innerHTML = tutorData[idx]["timeFrom"];
			document.getElementById("timeTo"+idx).innerHTML = tutorData[idx]["timeTo"];
			document.getElementById("days"+idx).innerHTML = tutorData[idx]["days"];
			document.getElementById("experience"+idx).innerHTML = tutorData[idx]["experience"];
			document.getElementById("address"+idx).innerHTML = tutorData[idx]["address"];
			document.getElementById("editUpdate"+idx).value = "Edit";
			document.getElementById("cancelDelete"+idx).value = "Delete";
		} else if(document.getElementById("cancelDelete"+idx).value == "Delete"){
			document.getElementById("formSno").value = idx;
			document.getElementById("operation").value = "Delete";
			document.getElementById("manageClassForm").submit();
		}
	}
	function addValidate(){
		if(subjects.includes(document.getElementById("addSubject").value)==-1 || document.getElementById("addTimeFrom").value.trim()=="" ||document.getElementById("addTimeTo").value.trim()=="" || document.getElementById("addDaysVisible").value==""||document.getElementById("addExperience").value==""||document.getElementById("addAddress").value==""){
			return false;
		}
		document.getElementById("formSubject").value = document.getElementById("addSubject").value;
		document.getElementById("formFees").value = document.getElementById("addFees").value;
		var v = document.getElementById("formDuration");
		v.value += document.getElementById("addTimeFrom").value + " & ";
		v.value += document.getElementById("addTimeTo").value;
		for(var i=0;i<7;i++){
			if(document.getElementsByName("addDaysVisible")[0][i].selected){
				v.value += " & "+document.getElementsByName("addDaysVisible")[0][i].value;
			} 
		}
		document.getElementById("formAddress").value = document.getElementById("addAddress").value;
		document.getElementById("formExperience").value = document.getElementById("addExperience").value;
		document.getElementById("operation").value = "Add"
		alert("submitting");
		document.getElementById("manageClassForm").submit();
		return false;
	}
	function exit(idx){
		document.getElementById("teidx").value = idx;
		document.getElementById("operation").value = "Exit";
		document.getElementById("manageClassForm").submit();
	}
	function messageSend(idx){
		document.getElementById("operation").value = "MessageByTutor";
		document.getElementById("formMessage").value = document.getElementById("message"+idx).value;
		document.getElementById("manageClassForm").submit();		
	}
</script>
