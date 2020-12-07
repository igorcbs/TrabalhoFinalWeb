<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zxx">
<head>
	<title>Game Collection</title>
	<meta charset="UTF-8">
	<meta name="description" content="Game Warrior Template">
	<meta name="keywords" content="warrior, game, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->   
	<link href="Bootstrap/img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="Bootstrap/css/font-awesome.min.css"/>
	<link rel="stylesheet" href="Bootstrap/css/owl.carousel.css"/>
	<link rel="stylesheet" href="Bootstrap/css/style.css"/>
	<link rel="stylesheet" href="Bootstrap/css/animate.css"/>
	
	<script type="text/javascript" src="Bootstrap/js/loadPage.js"></script>


	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<div class="container">
			<!-- logo -->
			<a class="site-logo" href="index.jsp">
				<img src="Bootstrap/img/logo.png" alt="">
			</a>

			<div class="user-panel">
				<form action="ControllerIndex" method="get">
					<a > <%= request.getAttribute("userNome")%> </a>  /  <a href="index.htm">Exit</a>
				</form>
			</div> 
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- site menu -->
			<nav class="main-menu">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="review.jsp">Games</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- Header section end -->


	<!-- Page info section -->
	<section class="page-info-section set-bg" data-setbg="Bootstrap/img/page-top-bg/3.jpg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>Game Collection</h2>
						<p>Manage your games here, tell which one you want to play, or even that one you lend to someone</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->

	<section class="page-section review-page spad">

		<div class="container" id="div">
			<div class="row" id="divPrincipal">
				
				<% 
				
				int qttJogos = (int) request.getAttribute("qttJogos");
				%>
				<%for(int i = 0; i < qttJogos; i++) {%>

					<div class="col-md-6">

					<div class="review-item">
						
					
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/5.jpg"></div>
						<div class="review-text">
						<%
							String nome = (String) request.getAttribute("nomeJogo" + i);
							int multiplayer = (int) request.getAttribute("multiplayerJogo" + i);
							int id = (int) request.getAttribute("idGame"+i);
						 
						
						%>
			
							<h4> <%= nome%> </h4>
							
							<p>Multiplayer de <%= multiplayer %> jogadores</p>
							<form action="ControllerReview" method="post"> 
								<input type="hidden" id="nomeJogo" name="nomeJogo" value="<%= nome%> " >
								<input type="hidden" id="multiplayerJogo" value="<%= multiplayer%>" >
								<input type="hidden" id="idGame" value=" <%= id %>">
								<input type="submit" id="submit" value= "GO">
							</form>
							
						</div>
					</div>
				</div>
				
				
				<%} %>
				
			</div>
			<div class="user-panel">
				<a href="contact.jsp">+</a>
			</div>
		</div>
	</section>
	<!-- Page section end -->
	
	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<ul class="footer-menu">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="review.jsp">Games</a></li>
			</ul>
			<p class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
		</div>
	</footer>
	<!-- Footer section end -->


	<!--====== Javascripts & Jquery ======-->
	<script src="Bootstrap/js/jquery-3.2.1.min.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>
	<script src="Bootstrap/js/owl.carousel.min.js"></script>
	<script src="Bootstrap/js/jquery.marquee.min.js"></script>
	<script src="Bootstrap/js/main.js"></script>
    </body>
</html>