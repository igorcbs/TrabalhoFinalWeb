	function openPage(pageUrl){
       window.location.href=pageUrl;
     }

function loadItens(){
	var counts = ['1','2','3','4'];
	document.setParameter("nome", Overwatch)
	var container = document.getElementById('divPrincipal');
	counts.forEach(function(count) {
	    container.append('<div class="col-md-6"><div class="review-item"><div class="review-cover set-bg" data-setbg="Bootstrap/img/review/5.jpg"></div><div class="review-text"><h4>Overwatch Halloween</h4><p>Multiplayer de 4 jogadores</p></div></div></div>');
	});
}