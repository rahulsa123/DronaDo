<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<title>DronaDo - Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- styles -->
<link href="/DronaDo/css/bootstrap.css" rel="stylesheet">
<link href="/DronaDo/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/DronaDo/css/prettyPhoto.css" rel="stylesheet">
<link href="/DronaDo/font/stylesheet.css" rel="stylesheet">
<link href="/DronaDo/css/animate.css" rel="stylesheet">
<link href="/DronaDo/css/flexslider.css" rel="stylesheet">
<link rel="stylesheet" media="screen" href="/DronaDo/css/sequencejs.css">
<link href="/DronaDo/css/style.css" rel="stylesheet">
<link href="/DronaDo/color/default.css" rel="stylesheet">

<!-- Fav and touch icons -->
<link rel="shortcut icon" href="/DronaDo/img/favicon.ico">
<!-- Font Icon -->
<link rel="stylesheet"
	href="/DronaDo/font/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css-->
<link rel="stylesheet" href="/DronaDo/css/style1.css">
<style>
.authenticationPopup {
	display: none;
	position: fixed;
	top: 7%;
	left: 50%;
	margin: 0px -400px 0px -400px;
	z-index: 15;
}
</style>

</head>

<body style="font-family: cursive;">
	<form style="display:none;">
	</form>

	<header>

		<!-- start top -->
		<div id="topnav" class="navbar navbar-fixed-top default">
			<div class="navbar-inner">
				<div class="container">
					<div class="logo">
						<a class="brand" href="index.jsp"><img src="/DronaDo/img/logo2.png"
							alt="DronaDo"></a>
					</div>
					<div class="navigation">
						<nav>
							<ul class="nav pull-right">
								<li class="current"><a href="#featured">Home</a></li>
								<li><a href="#works">Services</a></li>
								<li><a href="#about">About</a></li>
								<li><a href="#team">Our Team</a></li>
								<li><a href="#contact">Contact</a></li>
								<li><a href="#" class="btn btn-color" onclick="showAuth();">Sign
										In</a></li>
							</ul>
						</nav>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		<!-- end top -->
	</header>
	<div id="authenticationPopup" class="authenticationPopup"></div>
	<!-- section featured -->
	<section id="featured">

		<!-- sequence slider -->
		<div id="sequence-theme">
			<img class="prev" src="/DronaDo/img/bt-prev.png" alt="Previous"> <img
				class="next" src="/DronaDo/img/bt-next.png" alt="Next">
			<div class="container">
				<div class="row">
					<div class="span12">
						<div id="sequence">
							<ul>
								<li class="animate-in">
									<div class="info letter-container">
										<h2 class="fade">WELCOME</h2>
									</div>
									<h4 class="subtitle">Learn from your nearby Drona</h4>
									<div class="bottomup">
										<img src="/DronaDo/img/slider/parallax/img-6.jpg" alt="">
									</div>
								</li>
								<li class="animate-in">
									<div class="info letter-container">
										<h2 class="fade">Be a part time Tutor</h2>
									</div>
									<h4 class="subtitle">Teach and Earn</h4>
									<div class="lefttop">
										<img src="/DronaDo/img/slider/parallax/img-8.png" alt="">
									</div>
								</li>
								<li class="animate-in">
									<div class="info letter-container">
										<h2 class="fade">Education at your door</h2>
									</div>
									<h4 class="subtitle">We provide you the best educational
										experience</h4>
									<div class="righttop">
										<img src="/DronaDo/img/slider/parallax/img-10.jpg" alt="">
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>


	<!-- section works -->
	<section id="works" class="section gray-bg">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div class="headline">
						<h3>
							<span>Find the best</span>
						</h3>
					</div>
				</div>
				<div class="span12">
					<div class="section-intro">
						<center>
							<form>
								<table>
									<tr>
										<td><input type="text"
											placeholder="Type the subject/tutor id/location"
											style="width: 400px; height: 20px; padding: 25px 10px 25px 10px;"></td>
										<td><input type="submit" class="btn btn-color btn-large"
											value="Filter"></td>
									</tr>
								</table>
							</form>
						</center>
					</div>
				</div>
				<div class="span12">
					<ul class="filter">
						<li class="all active"><a href="#" class="btn btn-color">All
								Tutors</a></li>
						<li class="web"><a href="#" class="btn btn-color">Physics</a></li>
						<li class="brand"><a href="#" class="btn btn-color">Chemistry</a></li>
						<li class="graphic"><a href="#" class="btn btn-color">Mathematics</a></li>
						<li class="photo"><a href="#" class="btn btn-color">Photography</a></li>
						<li class="ilustrator"><a href="#" class="btn btn-color">Ilustrator</a></li>
					</ul>
					<div class="row">
						<ul class="portfolio-area">
							<li class="portfolio-item2" data-id="id-0" data-type="web">
								<div class="thumb-wrapp"
									style="padding: 12px 15px 12px 15px; background-color: #bb5191;">
									<!--
                  <img src="img/portfolio/img1.jpg" class="folio-image" alt="">
                  -->
									<div class="folio-img">
										<table style="left: 0px">
											<tr>
												<td><b>Subject</b></td>
												<td>:&nbsp;Physics, Chemistry, Maths</td>
											</tr>
											<tr>
												<td><b>Experience</b></td>
												<td>:&nbsp;15 years</td>
											</tr>
											<tr>
												<td><b>Locality</b></td>
												<td>:&nbsp;Piplani, Bhopal</td>
											</tr>
										</table>
									</div>
									<div class="folio-caption">

										<h5>Sudhir Singh</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="brand">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img2.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="web">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img3.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="graphic">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img4.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="ilustrator">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img5.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="brand">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img6.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="photo">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img7.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="photo">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img8.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="brand">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img9.jpg" class="folio-image" alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="photo">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img10.jpg" class="folio-image"
										alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="graphic">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img11.jpg" class="folio-image"
										alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
							<li class="portfolio-item2" data-id="id-0" data-type="brand">
								<div class="thumb-wrapp">
									<img src="/DronaDo/img/portfolio/img12.jpg" class="folio-image"
										alt="">
									<div class="folio-caption">
										<h5>Tutor name</h5>
										<span class="folio-link"> <a
											href="/DronaDo/img/portfolio/big.jpg" data-pretty="prettyPhoto"
											title="zoom"> <i
												class="icon-rounded  icon-32 icon-zoom-in"></i></a> <a href="#"><i
												class="icon-rounded  icon-32 icon-link"></i></a>
										</span>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- section works -->

	<!-- end section about -->
	<section id="about">
		<div class="container-fluid" style="background-color: #fff;">
			<div class="row">
				<div class="container">

					<div class="container">
						<div class="row">
							<div class="span12">
								<div class="headline">
									<h3>
										<span>How it Works</span>
									</h3>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h3>Students/Parents</h3>
							<hr />
							
								<b> Tell Us Your Tuition Needs:</b> Just fill few details about
								your home tuition needs and we will show your requirements to
								all our tutors.</em>
							<br>
							<em><b> Get Free Demo:</b> Interested home tutors will
									apply for your home tuition and we will arrange a free demo
									class by our home tutor.</em>
							<br>
							
								<em><b>Confirm If You Like: </b> After the demo class,
									evaluate the teacher and if you are satisfied with tutors
									teaching abilities then confirm him.</em>
							<br>
								<em> <b>Go Premium:</b> Need help? Avail the best in class
									service from our customer service executives for just Rs 500.
								</em>
							<br>
						</div>
						<div class="col-md-6">
							<h3>Tutors</h3>
							<hr />
							<br>
								<em><b> Create Profile:</b> Advertise about yourself by
									creating your profile. Profiles with more details gets maximum
									attention from our students and parents.</em>
							<br>
								<em><b>Get Students: </b> You can find students by
									searching tuition needs posted on our website which matches
									your profile. Apply tuitions relevant to you.</em>
							<br>
								<em><b> Start Earning:</b> Students/Parents who posted the
									tuition needs you applied will request a demo class. Give your
									best in the demo class to get the tuition confirmed.</em>
							<br>
								<em><b>Go Premium: </b> Need help? Avail the best in class
									service from our customer service executives for just Rs 500.</em>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- section team -->
	<section id="team" class="section parallax">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div class="headline">
						<h3>
							<span>Our Team</span>
						</h3>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span4">
					<div class="well box aligncenter">
						<i class="icon-circled active icon-48 icon-group"></i>
						<h3>Rahul Sahu</h3>
							Back-end Developer<br>.<br>
						
						<a href="#" class="btn btn-color">Know more</a>
					</div>
				</div>
				<div class="span4">
					<div class="well box aligncenter">
						<i class="icon-circled icon-48 icon-thumbs-up"></i>
						<h3>Utkarsh Mishra</h3>
							Back-end Developer<br>.<br>
						<a href="#" class="btn btn-color">Know more</a>
					</div>
				</div>
				<div class="span4">
					<div class="well box aligncenter">
						<i class="icon-circled icon-48 icon-beaker"></i>
						<h3>Vijay Shahwal</h3>
							Front-end Developer<br>Management<br>
						<a href="#" class="btn btn-color">Know more</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end section team -->


	<!-- section contact -->
	<section id="contact" class="section">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div class="headline">
						<h3>
							<span>Get in touch with us</span>
						</h3>
					</div>
				</div>
				<div class="span12">
					<div class="section-intro">

					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<h4>
						<i class="icon-circled icon-32 icon-envelope"></i> Contact form
					</h4>

					<!-- start contact form -->
					<div id="sendmessage">Your message has been sent. Thank you!</div>
					<div id="errormessage"></div>

					<form action="" method="post" role="form" class="contactForm">
						<div id="sendmessage">Your message has been sent. Thank you!</div>
						<div id="errormessage"></div>

						<ul class="contact-list">
							<li class="form-group"><input type="text" name="name"
								class="form_input" id="name" placeholder="Your Name"
								data-rule="minlen:4" data-msg="Please enter at least 4 chars">
								<div class="validation"></div>
							<li class="form-group"><input type="email"
								class="form_input" name="email" id="email"
								placeholder="Your Email" data-rule="email"
								data-msg="Please enter a valid email">
								<div class="validation"></div></li>
							<li class="form-group"><input type="text" class="form_input"
								name="subject" id="subject" placeholder="Subject"
								data-rule="minlen:4"
								data-msg="Please enter at least 8 chars of subject">
								<div class="validation"></div></li>

							<li class="form-group"><textarea class="form_textarea"
									name="message" rows="12" data-rule="required"
									data-msg="Please write something for us" placeholder="Message"></textarea>
								<div class="validation"></div></li>
							<li class="last">
								<button class="btn btn-large btn-theme" type="submit" id="send">Send
									a message</button>
							</li>
						</ul>
					</form>
					<!-- end contact form -->

				</div>
				<div class="span6">
					<h4>
						<i class="icon-circled icon-32 icon-user"></i> Get in touch with
						us
					</h4>
					<p>Feel free to ask if you have any question regarding our
						services or if you just want to say Hello, we would love to hear
						from you.</p>
					<div class="dotted_line"></div>
					<p>
						<span><i class="icon-phone"></i> <strong>Phone:</strong>
							+9458087470 or +917906819098</span>
					</p>

					<p>
						<span><i class="icon-envelope-alt"></i> <strong>Email:</strong>
							info@dronado.com</span>
					</p>
					<div>
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22864.11283411948!2d-73.96468908098944!3d40.630720240038435!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew+York%2C+NY%2C+USA!5e0!3m2!1sen!2sbg!4v1540447494452"
							width="100%" height="350" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end section contact -->


	<footer>
		<div class="verybottom">
			<div class="container">
				<div class="row">
					<div class="span12">
						<div class="aligncenter">
							<div class="logo">
								<a class="brand" href="index.jsp"> <img
									src="/DronaDo/img/logo2.png" alt="DronaDo">
								</a>
							</div>
							<p>Sharing and Gaining knowledge is the real taste of life.</p>
							<div class="social-links">
								<ul class="social-links">
									<li><a href="#" title="Twitter"><i
											class="icon-circled icon-64 icon-twitter"></i></a></li>
									<li><a href="#" title="Facebook"><i
											class="icon-circled icon-64 icon-facebook"></i></a></li>
									<li><a href="#" title="Google plus"><i
											class="icon-circled icon-64 icon-google-plus"></i></a></li>
									<li><a href="#" title="Linkedin"><i
											class="icon-circled icon-64 icon-linkedin"></i></a></li>
									<li><a href="#" title="Pinterest"><i
											class="icon-circled icon-64 icon-pinterest"></i></a></li>
								</ul>

							</div>

							<p>&copy; SacredCoders - All right reserved</p>
							<div class="credits">
								Designed by <a>SacredCoders</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- Javascript Library Files -->

<script src="/DronaDo/js/jquery.min.js"></script>
<script src="/DronaDo/js/jquery.easing.js"></script>
<script src="/DronaDo/js/bootstrap.js"></script>
<script src="/DronaDo/js/jquery.lettering.js"></script>
<script src="/DronaDo/js/parallax/jquery.parallax-1.1.3.js"></script>
<script src="/DronaDo/js/nagging-menu.js"></script>
<script src="/DronaDo/js/sequence.jquery-min.js"></script>
<script src="/DronaDo/js/sequencejs-options.sliding-horizontal-parallax.js"></script>
<script src="/DronaDo/js/portfolio/jquery.quicksand.js"></script>
<script src="/DronaDo/js/portfolio/setting.js"></script>
<script src="/DronaDo/js/jquery.scrollTo.js"></script>
<script src="/DronaDo/js/jquery.nav.js"></script>
<script src="/DronaDo/js/modernizr.custom.js"></script>
<script src="/DronaDo/js/prettyPhoto/jquery.prettyPhoto.js"></script>
<script src="/DronaDo/js/prettyPhoto/setting.js"></script>
<script src="/DronaDo/js/jquery.flexslider.js"></script>
<!-- Contact Form JavaScript File -->
<script src="/DronaDo/contactform/contactform.js"></script>

<!-- Template Custom Javascript File -->
<script src="/DronaDo/js/custom.js"></script>
<script src="/DronaDo/js/main.js"></script>
<script>

	if ("${requestScope.showSignIn}" == "true") {
		$("#authenticationPopup").load("/DronaDo/pages/signin.jsp?infoMessage=${requestScope.infoMessage}");
		document.getElementById("authenticationPopup").style.display = "block";
	} else if ("${requestScope.showSignUp}" == "true") {
		$("#authenticationPopup").load("/DronaDo/pages/signup.jsp?infoMessage=${requestScope.infoMessage}");
		document.getElementById("authenticationPopup").style.display = "block";
	}
</script>
<script>
	function showAuth() {

		$("#authenticationPopup").load("/DronaDo/pages/signin.jsp?infoMessage=${requestScope.infoMessage}");
		document.getElementById("authenticationPopup").style.display = "block";
	}
	function showSignUp(){
		if ("${requestScope.showSignUp}" == "true") 
			$("#authenticationPopup").load("/DronaDo/pages/signup.jsp?infoMessage=${requestScope.infoMessage}");
		else
			$("#authenticationPopup").load("/DronaDo/pages/signup.jsp?infoMessage=");
		document.getElementById("authenticationPopup").style.display = "block";
	}
	function showSignIn(){
		if ("${requestScope.showSignIn}" == "true") 
			$("#authenticationPopup").load("/DronaDo/pages/signin.jsp?infoMessage=${requestScope.infoMessage}");
		else
			$("#authenticationPopup").load("/DronaDo/pages/signin.jsp?infoMessage=");
		document.getElementById("authenticationPopup").style.display = "block";
	}
</script>
</body>

</html>
