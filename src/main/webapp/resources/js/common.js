/* 화면 상단으로 이동 */
function scrollToTop(){
	var topEle = $("#quick_menu");
	var currentPosition = parseInt($("#quick_menu").css("top"));
	var delay = 200;
	topEle.on('click', function() {
		$('html, body').stop().animate({scrollTop: 0}, delay);
	});
}

