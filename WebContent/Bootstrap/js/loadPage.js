	function openPage(pageUrl){
       window.location.href=pageUrl;
     }

function adada(){
	var counts = ['1','2','3','4'];
	var container = document.getElementById('jogos');
	counts.forEach(function(count) {
	    container.append('<div>' + count + '</div>');
	});
}