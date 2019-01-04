<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<!-- font -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean"
	rel="stylesheet">
<script type="text/javascript">
	//회원수정 버튼 클릭시 첫화면으로 이동
	function goMypage() {
		location.href = "${pageContext.request.contextPath}/${member.ID}/mypage";
	}
</script>
<div class="header" data-spy="affix" data-offset-top="60"
	data-offset-bottom="200">
	<div class="top-bar" style="height: 70px;">
		<div class="container-fluid">
			<div class="row">
				<%-- 각 페이지 연결할 아이콘 --%>
				<div class="col-md-5" id="bar_left" align="left">
					<%-- 로그인 되어있을 경우 아이콘이 보이도록 한다. --%>
					<c:if test="${member.ID != null}">
						<div id="bar_icon">
							<a
								class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
								href="javascript:void(0);"><i class="fa fa-bars"></i></a> <a
								href="${pageContext.request.contextPath}/${member.ID}/deal/list"
								class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
								title="Board"><i class="fa fa-list" id="board_i"
								aria-hidden="true"></i></a> <a
								href="${pageContext.request.contextPath}/${member.ID}/messageList"
								class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
								title="Send Message"><i class="fa fa-envelope"
								id="message_i"></i></a> <a href="#"
								class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
								onclick="window.open('${pageContext.request.contextPath}/${member.ID}/multiChat', 'multiChat', 'width=400, height=650')"
								title="Chat"><i class="fa fa-weixin" id="chat_i"
								aria-hidden="true"></i></a>
							<%-- 새 글 알림 --%>
							<div class="w3-dropdown-hover w3-hide-small w3-hover-white">
								<button class="w3-button w3-padding-large" title="Notifications">
									<i class="fa fa-bell" id="alarm_i"></i> <span
										class="w3-badge w3-right w3-small"
										style="background-color: #cbcbcd;">${messageCount}</span>
								</button>
								<%-- 새 글 알림 드롭다운 --%>
								<div class="w3-dropdown-content w3-card-4 w3-bar-block"
									style="width: 300px; font-size: 14px; color: #1d2c52; font-weight: 600;">
									<a href="#" class="w3-bar-item w3-button">새로 업로드된 게시물이 개
										있습니다.</a> <a
										href="${pageContext.request.contextPath}/${member.ID}/messageList"
										class="w3-bar-item w3-button"> 읽지 않은 쪽지가 ${messageCount}개
										있습니다. </a> <a href="chat" class="w3-bar-item w3-button">채팅이 개
										있습니다.</a>
								</div>
							</div>
							<%-- 새 글 알림 끝 --%>
						</div>
					</c:if>
				</div>

				<%-- 각 페이지 연결할 아이콘 끝--%>
				<%-- 중앙 로고 --%>
				<div class="col-md-2 col-xs-2">
					<div class="babylogo">
						<a href="${pageContext.request.contextPath}/main"> <img
							src="${pageContext.request.contextPath}/resources/img/logo2.png"
							height="50px">
						</a>
					</div>
				</div>


				<%-- 중앙 로고끝 --%>


				<%-- 로그인 확인, 로그아웃 및 회원 정보 관리 --%>

				<div class="col-md-5" align="right">
					<%-- 검색창 --%>
					<input type="text" id="search_keyword" value="${keyword}"
						placeholder="검색할 아이디를 입력" style="margin-top: 10px;"> <a
						href="" onclick="return false;" id="search_confirm"><i
						class="fa fa-search fa-fw w3-margin-right w3-text-theme"></i></a>
					<%-- 검색창 끝 --%>

					<%-- 로그인이 되어 있을 경우 회원 정보 아이콘이 뜬다. --%>
					<c:if test="${member.ID != null}">
						<div class="w3-dropdown-hover">
							<%-- 		<c:if test="${!empty member.ID}"> --%>
							<button
								class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white w3-white"
								style="text-decoration: none; font-weight: 500; font-size: 18px;">
								<font color="#1d2c52">${member.ID}(${member.NAME})</font> &nbsp;
								<i class="fa fa-user-circle" aria-hidden="true" id="user_i"></i>
							</button>
							<div class="w3-dropdown-content w3-card-4 w3-bar-block"
								id="dropdown_menu" align="center">
								<a href="#" class="w3-bar-item w3-button" onclick="goMypage()">회원정보
									수정</a> <a
									href="${pageContext.request.contextPath}/${member.ID}/gallery"
									class="w3-bar-item w3-button">내 게시물 확인</a> <a
									href="${pageContext.request.contextPath}/${member.ID}/follower"
									class="w3-bar-item w3-button">팔로우</a> <a
									href="${pageContext.request.contextPath}/logout"
									onclick="return confirm('로그아웃하시겠습니까?')"
									class="w3-bar-item w3-button">Logout</a>
							</div>

						</div>
					</c:if>
					<c:if test="${empty member.ID}">
						<a href="${pageContext.request.contextPath}/login"
							style="padding: 20px 0px; font-size: 17px; font-weight: 900;">
							<font color="#1d2c52">로그인</font> &nbsp; <i
							class="fa fa-user fa-fw w3-margin-right w3-text-theme"></i>
						</a>
					</c:if>
				</div>

			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
</div>
