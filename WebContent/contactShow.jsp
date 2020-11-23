<!DOCTYPE html>
<html lang="en">
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

			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- site menu -->
			<!-- <nav class="main-menu">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="review.jsp">Games</a></li>
				</ul>
			</nav> -->
		</div>
	</header>
	<!-- Header section end -->

	<!-- Page info section -->
	<section class="page-info-section set-bg" data-setbg="Bootstrap/img/page-top-bg/5.jpg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>Edit a game</h2>
						<p>In that field you will be capable of add games into your list,change his state and other informations.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->
	<section class="page-section spad contact-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="contact-form-warp">
						<h4 class="comment-title">Edit your game</h4>
						<form class="comment-form" action="ControllerEditGame" method="post">
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="Name" id="nome" name="nome" value="<%= request.getParameter("nomeGame")%>">
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="Platform" id="plataforma" name="plataforma" value="<%= request.getParameter("plataformaGame")%>">
								</div>
								<div class="col-md-6">
									Number of players: <input type="number" min="1" max="8" placeholder="1" id="multiplayer" name="num" value="<%= request.getParameter("numPlayers")%>"> <BR>
								</div>
								<div class="col-md-6">
									<input type="checkbox" id="online" name="online" value="online" value="<%= request.getParameter("nomeGame")%>"> Online <BR>
								</div>
								
								<div class="col-md-6">
									<BR> What is the state of the game? <BR>
									<input type="radio" id="estado" name="emprestado" value="estado" /> Lent <BR>
									<input type="radio" id="estado" name="nafila" value="estado" /> In queue <BR>
									<input type="radio" id="estado" name="desejado" value="estado" /> Wanted <BR>
									<input type="radio" id="estado" name="jogando" value="estado" /> Playing <BR>
									<input type="radio" id="estado" name="zerado" value="estado" /> Zeroed <BR>
								</div>
								<div class="col-lg-12">
									<!-- <input type="text" placeholder="Subject"> 
									<textarea placeholder="Message"></textarea>  -->
									<BR> <button class="site-btn btn-sm" name="edit">Edit</button>    
									<button class="site-btn btn-sm" name="delete">Remove</button>
								</div>
							
								
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page section end -->

	
	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<!-- <ul class="footer-menu">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="review.jsp">Games</a></li>
			</ul> -->
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


	<!-- load for map -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCWTIlluowDL-X4HbYQt3aDw_oi2JP0Krc&sensor=false"></script>
	<script src="Bootstrap/js/map.js"></script>

    </body>
</html>