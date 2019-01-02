function getContextPath() { // ContextPath 얻어오는 함수

	var hostIndex = location.href.indexOf(location.host) + location.host.length;

	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));

}
// 
Handlebars.registerHelper('getType', function(type,follower,following,options) {
	  if (type == "follower") {
	    return follower;
	  } else {
	    return following;
	  }
});


// 팔로워 목록을 출력
function getFollowerList(my_id, page_id) {
	$.ajax({
		type : "POST",
		contentType : "application/json",
		DataType : "json",
		url : "/TeamPro/" + page_id + "/getFollowerList",
		success : function(result) {
			$("#follow_list").children().detach();
			if(result.length == 0){
				$("#follow_list").append("<h1>저런! 친구가 없으시네요!</h1>");
			}else{
				var source = $("#follow-template").html();
				var template = Handlebars.compile(source);
				var data = {
					follow : result,
					type : "follower"
				}	
				//console.log(data);
				var html = template(data);
				$("#follow_list").append(html);
				
				$.each(result, function(i){
					//console.log(result[i].follower_id);
					isFollowed(my_id , result[i].follower_id);
				})
			}
			

		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
}


//팔로잉 목록을 출력
function getFollowingList(my_id, page_id) {
	$.ajax({
		type : "POST",
		contentType : "application/json",
		DataType : "json",
		url : "/TeamPro/" + page_id + "/getFollowingList",
		success : function(result) {
			
			
			$("#follow_list").children().detach();
			if(result.length == 0){
				$("#follow_list").append("<h1>저런! 친구를 만드세요!</h1>");
			}else{
				var source = $("#follow-template").html();
				var template = Handlebars.compile(source);
				var data = {
					follow : result,
					my_id,
					type : "following"
				}
				
				var html = template(data);
				$("#follow_list").append(html);
				
				$.each(result, function(i){
					isFollowed(my_id , result[i].following_id);
				})
			};
			

		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
}

// 팔로우 되어있는지 여부 체크
function isFollowed(follower_id, following_id) {
	var isfollowed;
	if(follower_id != "")
	$.ajax({
		
		type : "POST",
		//async: false,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			follower_id : follower_id,
			following_id : following_id
		}),
		url : "/TeamPro/isFollowed",
		success : function(result) {
			isfollowed = result;
			// 팔로우 되어있는 사람이 아닐때
			if (isfollowed == 0) { 
				
				$('.fbtn_'+ following_id).filter('.followBtn').removeClass(
				'fbhide');
				$('.fbtn_'+ following_id).filter('.followingBtn').addClass(
				'fbhide');

			// 팔로우 되어있는 사람일때
			} else { 
				
				$('.fbtn_'+ following_id).filter('.followBtn').addClass(
				'fbhide');
				$('.fbtn_'+ following_id).filter('.followingBtn').removeClass(
				'fbhide');
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}

	});
	

}


// 팔로우 눌렀을때 처리
function follow(following_id) {
	var follower_id = $("#mem_id").val();
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify({
			follower_id : follower_id,
			following_id : following_id
		}),
		url : "/TeamPro/follow",
		success : function(result) {
			if (result == 1) { // 팔로우 되었을때
				// alert("성공!");
				console.log("팔로우 성공 - ajax")
				$('.fbtn_'+ following_id).filter('.followBtn').addClass(
				'fbhide');
				$('.fbtn_'+ following_id).filter('.followingBtn').removeClass(
				'fbhide');
			} else { // 언팔로우 안되었을때
				console.log("팔로우 실패! 이미 팔로우 되어있음.")
			}

		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}

	});
}

// 언파로우 버튼 눌렀을때.
function unfollow(following_id) {
	
	var follower_id = $("#mem_id").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		// dataType: "json",
		data : JSON.stringify({
			follower_id : follower_id,
			following_id : following_id
		}),
		url : "/TeamPro/unfollow",
		success : function(result) {
			if (result == 1) { // 언팔로우 되었을때
				// alert("성공!");
				console.log("언팔로우 성공 - ajax")
				$('.fbtn_'+ following_id).filter('.followBtn').removeClass(
				'fbhide');
				$('.fbtn_'+ following_id).filter('.followingBtn').addClass(
				'fbhide');
			} else { // 언팔로우 안되었을때
				console.log("언팔로우 실패! 팔로우 되어있는 사람이 아님!")
			}

		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}

	});

}

// 팔로우 추천 목록 얻어오기.
function getSuggestionFollowList(my_id){
	
	$("#small_recommend_list").children().detach();
	if(my_id != ""){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			// dataType: "json",
			data : my_id,
			url : "/TeamPro/SuggestionFollow",
			success : function(result) {
				
				//console.log(result);
				if(result.length > 0){
					var source = $("#s_recom_follow-template").html();
					var template = Handlebars.compile(source);
					var data = {
						s_r_list : result,
						my_id,
					}
					
					var html = template(data);
					$("#small_recommend_list").append(html);
					
					$.each(result, function(i){
						isFollowed(my_id , result[i].following_id);
					})
				}else{
					$("#small_recommend_list").append("더 이상 추천 할 회원이 없습니다.");
				}
			}
		})
	}	
}

// 버튼 클릭 이벤트 ~~
function BtnClickEvent(){
	// 팔로워 버튼 메뉴 클릭 이벤트
	$(document).on("click", "#getfollower_Btn" , function(){
		
		var id = $("#page_id").val()
		url = getContextPath() + "/" + id + "/follower/";
		location.href = url;
		
	});
	
	// 팔로잉 버튼 메뉴 클릭이벤트.
	$(document).on("click", "#getfollowing_Btn" , function(){
		
		var id = $("#page_id").val()
		url = getContextPath() + "/" + id + "/following/";
		location.href = url;
		
	});
	
	
	$(document).on("click", ".followBtn" , function(){
		var following_id = $(this).val();
		follow(following_id);
		
	});
	
	$(document).on("click", ".followingBtn" , function(){
		var following_id = $(this).val();
		unfollow(following_id)
		
	});

}

$(document).ready(function(){
	BtnClickEvent();
	
	// 로그인된 아이디 (main.jsp에 hidden값)
	var my_id = $("#mem_id").val();
	
	// 현재 봐야하는 페이지의 아이디
	var page_id = $("#page_id").val();
	//console.log(my_id + " " + page_id);

	// follow 페이지에서 호출했을때.
	if(page_id != null){
		if($("#page_type").val() == 'follower'){	
			getFollowerList(my_id, page_id);
		}
		else{
			getFollowingList(my_id, page_id);
		} 
	}
	// 로그인 되어있지않으면 팔로우 추천목록을 호출하지 않음.
	if(my_id != null)
		$("#small_recommend_list").children().detach();
		getSuggestionFollowList(my_id);

	
	
})
