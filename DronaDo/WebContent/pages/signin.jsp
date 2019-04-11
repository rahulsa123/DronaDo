<script>
	function isValid(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username.length > 0 && password.length>0)
			return true;
		document.getElementById("message").innerHTML = "Username or Password is invalid";
		return false;
	}
</script>
<div id="authentication">
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container1">
            	<a class="btn btn-color" onclick="document.getElementById('authenticationPopup').style.display = 'none'">&nbsp;X</a>
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="/DronaDo/img/signin-image.jpg" alt="sign in image"></figure>
                        <u><a class="signup-image-link" onclick="showSignUp()">Create an account</a></u>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign In
                        </h2>
                        <form method="POST" class="register-form" id="login-form" action="/DronaDo/LoginServlet" onsubmit="return isValid();">
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" placeholder="Username" required/>
                                
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" placeholder="Password" required/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                            	<div id="message">&nbsp;<%= request.getParameter("infoMessage") %></div>
                                <input type="submit" name="signin" id="signin" class="form-submit"  value="Log in"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
</div>		

