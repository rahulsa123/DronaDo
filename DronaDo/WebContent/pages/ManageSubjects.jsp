<script type="text/javascript">
document.getElementById("title").innerHTML ="Manage Subjects";
</script>
<div class="container text-center">
	Manage Subjects
	
	<form method="post" action="ManageSubjects">
		<label for="subjectName">Subject Name</label>
		<input type="text" id="subjectName"><br>
		<label for="subjectStandard">Subject Standard</label>
		<input type="text" id="subjectStandard"><br>
		<label for="subjectStream">Subject Stream</label>		
		<input type="text" id="subjectStream"><br>
		<input type="submit" value="Add Subject"><br>
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