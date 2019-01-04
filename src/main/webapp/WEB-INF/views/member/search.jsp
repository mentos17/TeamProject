<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.searchTemplateStyle{
width: 30%; 
margin: 0px 10px 10px 10px;

}

</style>

</head>
<body>
<input type="hidden" id="keyword" value="${keyword}">

<!-- Profile -->
	<div class=" w3-row-padding" id="search_list" style="text-align: left; min-height : 1px">

	
	</div>

<script id="search-template" type="text/x-handlebars-template">
{{#search}}
			<div class="w3-col w3-card w3-round w3-white searchTemplateStyle">
				<div class="w3-container">
					<br />
					<div class="w3-center image_wrapper">
						<%-- 만약 회원 프로필 이미지가 없을 경우에는 기본 이미지를 띄운다. --%>
						<img src="${pageContext.request.contextPath}/{{sMem_pic}}">
					</div>
					<hr>
					<%-- 회원 정보 --%>
					<div class="member_icon" style="font-weight: 500; font-size: 15px;">
						<span class="w3-right smallSizeFont">
							<button type="button"
								class="w3-button w3-theme-d1 w3-margin-bottom followBtn fbBtn {{#SetBtnState isfollowed 'follow'}}{{/SetBtnState}} fbtn_{{sMem_id}}"
								value='{{sMem_id}}'>팔로우</button>
							<button type="button"
								class="w3-button w3-theme-d1 w3-margin-bottom followingBtn fbBtn {{#SetBtnState isfollowed 'following'}}{{/SetBtnState}} fbtn_{{sMem_id}}"
								value='{{sMem_id}}'>
								<span>팔로잉</span> <span>언팔로우</span>
							</button>
						</span>
						<p style="padding-top: 5px; margin-bottom: 7px;">
							<a href="${pageContext.request.contextPath}/{{sMem_id}}/gallery"> {{sMem_id}} </a>
						</p>
						<br>
						
						<p>
							<i class="fa fa-envelope fa-fw w3-margin-right w3-text-theme"></i>
							{{sMem_email}}
						</p>
					</div>
				</div>
			</div>
{{/search}}
</script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.12/handlebars.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>
</html>
