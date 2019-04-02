
<!-- jQuery CDN - Slim version (=without AJAX) 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->

 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper.JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<!-- Bootstrap JS -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

<div class="wrapper">
	<!-- Sidebar  -->
	<nav id="sidebar">
		<div class="sidebar-header">
			<h3>DronaDo</h3>
			<strong>DD</strong>
		</div>
		<img id="user" alt="img/default.png" class="center img-fluid mt-2" src="/DronaDo/img/face.png">
		<ul class="list-unstyled components">
			<li>
				<ul>
					<li class="list-unstyled CTAs">
					</li>
				</ul>
			</li>
			<!-- 
			
			For Tutor
			
			 -->

			<%
				if (session.getAttribute("userType") != null
						&& ((String) session.getAttribute("userType")).equalsIgnoreCase("tutor")) {
			%>
			<li><a href="/DronaDo/TutorDashboard"> <i class="fa fa-bars"></i> Dashboard
			</a></li>
			<li><a href="/DronaDo/Profile"> <i class="fas fa-user-tie"></i>
					Edit Profile
			</a></li>
			<li><a href="/DronaDo/ManageSubjects"> <i class="fa fa-book"></i>
					Manage Subjects
			</a></li>
			<li><a href="#"> <i class="fa fa-bookmark"></i> Manage Class
			</a></li>
			<li><a href="#"> <i class="fa fa-comments"></i> Message
			</a></li>

			<%
				}
			%>
			<!-- 
			
			For Student
			
			 -->
			<%
				if (session.getAttribute("userType") != null
						&& ((String) session.getAttribute("userType")).equalsIgnoreCase("student")) {
			%>
			<li><a href="/DronaDo/StudentDashboard"> <i class="fa fa-bars"></i> Dashboard
			</a></li>
			<li><a href="/DronaDo/Profile"> <i class="fas fa-user-tie"></i>
					Edit Profile
			</a></li>
			<li><a href="/DronaDo/SearchTutor"> <i class="fas fa-search"></i> Search Tutor
			</a></li>
			<li><a href="/DronaDo/TutorNearYou"> <i class="fas fa-street-view"></i> Tutor Near You
			</a></li>
			<li><a href="#"> <i class="fas fa-bell"></i> Notifications
			</a></li>
			<li><a href="#"> <i class="fa fa-pie-chart"></i> Class
					Status
			</a></li>
			
			
			

			<%
				}
			%>

		</ul>


	</nav>

	<!-- Page Content  -->
	<div id="content">
		<div id="Logo" align="center">
			
		</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-#e1e6d5">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="btn btn-info">
					<i class="fas fa-align-left"></i> <span>Menu</span>
				</button>
				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-align-justify"></i>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item menu"><a class="nav-link" href="#">Home</a>
						</li>
						<li class="nav-item menu"><a class="nav-link" href="#">About
								Us</a></li>
						<li class="nav-item menu"><a class="nav-link" href="#">Log-out</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	<div class="MainPart"><jsp:include page="${requestScope.mainPartFile}" flush="true"></jsp:include></div>
	</div>
</div>
