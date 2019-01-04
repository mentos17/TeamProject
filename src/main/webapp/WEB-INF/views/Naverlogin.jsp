<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BabyParent | NaverLogin</title>
<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<!-- js 파일 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body class="main">
	<!-- Header -->
	<jsp:include page="layout/header.jsp"/>
	<!-- END Header -->
	<div class="w3-col m3" id="loginArea" style="max-width: 400px;" align="center">
      	<div class="w3-card w3-round w3-white padding_area">
        	<div class="w3-container">
				<!-- 네이버 로그인 화면으로 이동 시키는 URL -->
				<h4>네이버 로그인 확인</h4>
				<div id="naver_id_login" style="text-align:center">
					<a href="${url}">
						네이버 로그인 하겠습니다.
					</a>
				</div>
				<div id="naver_id_login" style="text-align:center">
					<a href="${pageContext.request.contextPath}/${member.ID}/login">
						네이버 로그인 취소하겠습니다.
					</a>
				</div>
	  		</div>
		</div>
   	</div>		
</body>
</html> 