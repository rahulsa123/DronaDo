<script>
	function isValid(){
		alert("checking in signup");
		var username = document.getElementById("username").value;
		var password = document.getElementById("pass").value;
		var repass = document.getElementById("re_pass").value;
		alert(username + " " + password + " " + repass);
		if(username.length >0 && password == repass)
			return true;
		else if(username.length==0)
			document.getElementById("message").innerHTML= "Username can't be empty";
		else if(pass!=repass)
			document.getElementById("message").innerHTML = "Password didn't match";
		return false;
	}
</script>
<div id="authentication">
	<!-- Student Sign up form -->
	<section class="signup">
		<div class="container1">
			<a class="btn btn-color" onclick="document.getElementById('authenticationPopup').style.display = 'none'">&nbsp;X</a>
			<div class="signup-content row">
			
				<div class="span8">
							<h2 class="form-title">Sign Up</h2>
							<form method="post" action="/DronaDo/SignupServlet" onsubmit = "return isValid()">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username"
									placeholder="Username" required/>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group form-button">
								<div id="message">&nbsp;<%=request.getParameter("infoMessage") %></div>
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
							</form>
				</div>
				<div class="signup-image span4">
					<figure>
						<img src="/DronaDo/img/signup-image.jpg" alt="sign up image">
					</figure><u>
					<a class="signup-image-link" onclick="showSignIn()">I am already member</a></u>
				</div>
				</div>
		
		</div>
	</section>
</div>
