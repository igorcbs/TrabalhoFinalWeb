<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
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


</head>
<body>

<div id="preloder">
		<div class="loader"></div>
	</div>
	<!-- Header section -->
	<header class="header-section">
		<div class="container">
			<!-- logo -->
			 <a class="site-logo" href="index.html">
			 <img src="Bootstrap/img/logo.png" alt="">
			</a> 
			
			<div class="user-panel">
				<a href="#">Login</a>  /  <a href="#">Register</a>
			</div>
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- site menu -->
			<nav class="main-menu">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="review.jsp">Games</a></li>
				</ul>
			</nav>
		</div>
	</header>
	
	<section class="page-section spad contact-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="contact-form-warp">
						<h4 class="comment-title">Faça seu Login</h4>
						<form class="comment-form" action="ControllerLogin" method="get">
							<div class="row">
								<div class="col-md-6">
									<input type="email" placeholder="Email" id="email">
								</div>
								<div class="col-md-6">
									<input type="password" placeholder="Senha" id="senha">
								</div>
								<div class="col-lg-12">
									<button class="site-btn btn-sm">Entrar</button>
								</div>
							</div>
							<hr>
							<h5 class="comment-title">Ou</h5>
							<p>
						</form>
						
						<form class="comment-form" action="ControllerLogin" method="post">
							<h4 class="comment-title">Realize seu Cadastro</h4>
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="Nome" id="nome" name="nome">
								</div> 
								<div class="col-md-6">
									<input type="email" placeholder="Email" id="email" name="email">
								</div>
								<div class="col-md-6">
									<input type="password" placeholder="Senha" id="senha" name="senha">
								</div>
								<div class="col-lg-12">
									<input class="site-btn btn-sm" type="submit" value="Registre-se"/>
								</div>
							</div>	
						
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	
		<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<ul class="footer-menu">
				<li><a href="index.html">Home</a></li>
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