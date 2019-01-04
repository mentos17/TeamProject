/**
 * 
 */


function ShowGallery(id, isMyGall){
	var GotoUrl = "";
	// 내가 쓴 글만 출력할때 = main 으로 접근
	if(isMyGall == 'true'){
		GotoUrl = "/TeamPro/" + id + "/getMyGallery";
	}
	// 대상 id가 쓴 글을 출력할때 = {id}/gallery 로 접근
	else{
		GotoUrl = "/TeamPro/" + id + "/getSpecGallery"
	}
	
	$("#gallery_list").children().detach();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		DataType : "json",
		url : GotoUrl,
		success : function(result) {
			//console.log(result.length);
			if(result.length != 0){		
				var source = $("#gallery-template").html();
				var template = Handlebars.compile(source);
				var data = {
					gall : result
				}
				var html = template(data);
				$("#gallery_list").append(html);
				TimeFormat();
			} else{
				$("#gallery_list").append("<h4 style='color: #1d2c52;'>글좀 써주세요... 싫음 말고</h4>");
			}
		}
		
	});
	
}

// 시간 처리 ex)1분전 , 10초전 작성 등등
function TimeFormat(){
	
	var length = $(".writeTime").length;
	var now = new Date();
	var old;
	for(var i=0; i<length; i++){
		var timetxt = $(".writeTime").eq(i).text();
		//console.log(now.getTime() + " : " + timetxt);
		
		old = new Date(parseInt(timetxt));
		var gap = now.getTime() - old.getTime();
		var sgap = Math.round(gap/1000);
		var mgap = Math.round(gap/1000/60);
		var hgap = Math.round(gap/1000/3600);
		if(hgap > 24){
			$(".writeTime").eq(i).text(old.getMonth()+1 + "월 " + old.getDate() + "일");
		}		
		else if(hgap >= 1){
			$(".writeTime").eq(i).text(hgap + "시간 전");
		}else if(mgap >= 1){
			$(".writeTime").eq(i).text(mgap + "분 전");
		}else if(sgap >= 1){
			$(".writeTime").eq(i).text(sgap + "초 전");
		}else{
			$(".writeTime").eq(i).text("방금 전");
		}
		
		//console.log(sgap + "초 차이 ," + mgap + "분 차이 " + hgap + "시간 차이");

	}
	
	
}

$(document).ready(function(){
	var isMyGall = $("#isMyGall").val()
	var pageid = $("#pageid").val();

	ShowGallery(pageid, isMyGall);
});