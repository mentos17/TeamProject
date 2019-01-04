/*
 * 검색창 출력을 위한 JS
 */

pageNum = 0;
isDetach = true;

Handlebars.registerHelper('SetBtnState', function(isfollowed,type,options) {
	//console.log(isfollowed);
	if(isfollowed == ""){
		return 'fbhide';
	}
	if (type == "follow") {
		if(isfollowed == 'true'){
		
			return 'fbhide';
		}else{
			return;
		}
	  
	} else if(type =="following"){
		if(isfollowed == 'true'){
			return;
		}else{
			return 'fbhide';
		}
	}
	
});

function getSearchList(keyword){
	
	url = "/TeamPro/getSearchList";
	$.ajax({
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify({
			keyword : keyword,
			pageNum : pageNum
		}),
		url : url,
		success : function(result) {
			//console.log(result);
			if(isDetach == true)
				$("#search_list").children().detach();
			
			if(result.length == 0){
				if(isDetach == true)
					$("#search_list").append(
					"<div class='w3-col m12 w3-card w3-round w3-white' style='padding: 50px 30px;'>" +
						"<div class='w3-container'  align='center'>" +
					"<h4 style='font-weight: 500; color: #1d2c52;'>" + keyword + "로 검색한 결과가 없습니다.</h4> </div> </div>"
					);
			}else{
				var source = $("#search-template").html();
				var template = Handlebars.compile(source);
				var data = {
					search : result,
				}	
				//console.log(data);
				var html = template(data);
				$("#search_list").append(html);
				
				pageNum++;
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
	
}

$('body').scroll(function(){
	if ($('body').scrollTop() == $(document).height() - $(window).height()) {
		isDetach = false;
		
		var keyword = $("#keyword").val();
		getSearchList(keyword);
	
	}
});

$(document).ready(function(){
	
	var keyword = $("#keyword").val();
	
	getSearchList(keyword);
	
});
