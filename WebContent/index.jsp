<!DOCTYPE html>
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
				<form class="comment-form" action="ControllerIndex" method="get">
					<a > <%= request.getAttribute("userNome")%> </a>  /  <a href="index.htm">Exit</a>
				</form>
				
			</div>
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			
		</div>
	</header>
	<!-- Header section end -->
	

	<!-- Hero section -->
	<section class="hero-section">
		<div class="hero-slider owl-carousel">
			<div class="hs-item set-bg" data-setbg="Bootstrap/img/slider-1.jpg">
				<div class="hs-text">
					<div class="container">
						<h2>The Best <span>Games</span> Collection</h2>
						<p>Best collection of games which you can store. <br> take the control of all yours games and list <br>Don't lose a game any more</p>
						<form class="comment-form" action="ControllerIndex" method="post">
							<button class="site-btn">Game Collection</button>
						</form>
					</div>
				</div>
			</div>
			<div class="hs-item set-bg" data-setbg="Bootstrap/img/slider-2.jpg">
				<div class="hs-text">
					<div class="container">
						<h2>Start Your <span>Collection</span> Right Now!</h2>
						<p>You just need to register in our site <br> and add all games that you have <br>Don't waste more time!</p>
						<form class="comment-form" action="ControllerIndex" method="post">
							<button class="site-btn" >Game Collection</button>
						</form>
					</div>	
				</div>
			</div>
			
		</div>
	</section>
	
	<!-- Hero section end -->
	
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