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
				<form action="ControllerReview" method="get">
					<script>
					
					/* $(".myBox").click(function() {
						  window.location = $(this).find("a").attr("href"); 
						  return false;
						}); */
					
					window.onload = function () {
						var gameQtt = '<%= request.getAttribute("qttJogos") %>';
						var i = 1;
						/* window.alert("adlkdwada" + gameQtt); */
						var arrayNomes = '<%= request.getParameterValues("nomeJogos") %>' ;
						for(i=1; i<=gameQtt; i++){
							var f = i;
							
							
							var iDiv = document.createElement('div');
							
			                iDiv.id = 'review-text';
			                iDiv.className = 'review-text';
			                iDiv.onclick = 'window.location.href='+'ControllerReview';
			                
		
			                var h4 = document.createElement('h4');
			                //h4.textContent = '<%= request.getAttribute("nomeJogo" + request.getAttribute("qttJogos")) %>' ;
			                h4.textContent = arrayNomes[i] ;
							h4.onclick = 'window.location.href='+'ControllerReview';
			                
			                var p = document.createElement('p');
			                p.textContent = '<%= request.getAttribute("multiplayerJogo" + request.getAttribute("qttJogos")) %>' + " Jogadores";
			                p.onclick = 'window.location.href='+'ControllerReview';
			                
			                iDiv.appendChild(h4);
			                iDiv.appendChild(p);
			              	
			                var divItem = document.createElement('div');
			                divItem.id = 'review-item';
			                divItem.className = 'review-item';
			                divItem.onclick = 'window.location.href='+'ControllerReview';
			                
			                divItem.appendChild(iDiv);
			                
			                
			                var divCol = document.createElement('div');
			                divCol.id = 'col-md-6';
			                divCol.className = 'col-md-6';
			                
			                divCol.appendChild(divItem);
							
			                document.getElementById("divPrincipal").appendChild(divCol);
			                
			                
						}

						/* $('#iDiv').append('<a id="div" href="ControllerReview">link text</a>').on('click', 'a', function()
		                		{
		                		   
		                		}); */
						
	
					}
					
						//Pick the values
						/* var daString = "<div class=" + "col-md-6" + "><div class=" + "review-item" + "onclick=" + "openPage('contactShow.jsp')" + "><div class=" + "review-cover set-bg" + "data-setbg=" + "Bootstrap/img/review/5.jpg" + "></div><div class=" + "review-text" + "><h4>Overwatch</h4><p>Multiplayer de 4 jogadores</p></div></div></div>";
						document.getElementById('divPrincipal').innerHTML += daString; */

					
					
				</script>
				
				</form>
				
				
				
				
				
				
				<!-- <script >
					window.addEventListener ? window.addEventListener("load",resize,false) : window.attachEvent && window.attachEvent("onload",resize);

				</script> -->
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/5.jpg"></div>
						<div class="review-text">
							<h4>
								<%= request.getAttribute("nomeJogo1") %>
							</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/6.jpg"></div>
						<div class="review-text">
							<h4>Grand Theft Auto</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/7.jpg"></div>
						<div class="review-text">
							<h4>Avatar</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/8.jpg"></div>
						<div class="review-text">
							<h4>Anthem</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/9.jpg"></div>
						<div class="review-text">
							<h4>Cyberpunk 2077</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-item" onclick="window.location.href='ControllerEditGame';">
						<div class="review-cover set-bg" data-setbg="Bootstrap/img/review/10.jpg"></div>
						<div class="review-text">
							<h4>Spiderman</h4>
							<p>Multiplayer de 4 jogadores</p>
						</div>
					</div>
				</div>
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