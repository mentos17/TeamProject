<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
<!-- JS 파일 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resourses/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resourses/js/sockjs.js"></script>
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<div id="positionLayer">
	<!-- 레이어팝업 -->
	<table align="center" bgcolor="#FFFFFF">
		<tr>
			<td bgcolor="#4497fd" align="center" height="40px" width="100%" style="border: solid 1px #4497fd;">
				<font style="font-size: 18px; font-weight:bold" color="#FFFFFF">채팅</font>
			</td>
		</tr>
		<tr>
			<td>
				<div style="padding: 20px 0; overflow: auto; height: 400px;" align="left">
				<ul id="discussion"></ul>
				</div>
 			<ul id="discussion"></ul>
			<br/>
			<br/>		
	<c:choose>
		<%-- 로그인 되어 있을 경우 --%>
		<c:when test="${member.ID != null}">
			<p align="left" style="font-weight: 600; color: #1d2c52;">&nbsp;&nbsp;${member.ID}(${member.NAME})님이 입장하셨습니다.</p>
			<input type="hidden" id="memID" width="110" value="${member.ID}" readonly="readonly">
			<span style="display: none;" id="memName" width="110" value="${member.NAME}" readonly="readonly">${member.NAME}</span>
		</c:when>
		<%-- 로그인되어 있지 않을 경우 로그인 화면으로 이동 --%>
		<c:otherwise>
			<%
				response.sendRedirect("login");
			%>
		</c:otherwise>
	</c:choose>
		<input type="text" class="chatInput" id="message" size="50" align="middle" placeholder="메세지를 입력하세요">
			<br/>
			<br/>
			<input type="button" id="btnSend" value="전송"/>
			<input type="button" id="closeBtn" value="창닫기" onclick="window.close()">
			<%-- 대화창 --%>
			<ul id="discussion">
			</ul>
			</td>
		</tr>	
	</table>
	<br/>
<!-- 채팅 API -->
	<script src="http://demo.dongledongle.com/Scripts/jquery-1.10.2.min.js"></script>
	<script src="http://demo.dongledongle.com/Scripts/jquery.signalR-2.2.1.min.js"></script>

	<script type="text/javascript">
		var connection = $.hubConnection('http://demo.dongledongle.com/');
		var chat = connection.createHubProxy('chatHub');
		var meID = '<c:out value="${member.ID}"/>';
		
		$(document).ready(
				
				function() {
					chat.on('addNewMessageToPage', function(memID, message) {
						var memName = document.getElementById('memName');
						var list_ID = "<li class='listId'><strong>"+htmlEncode(memID)+"("+memName.innerHTML+")"+"</strong></li>"

						if (meID == $('#memID')) {
							var list_route = "<li class='balloon right'>"+htmlEncode(message)+"</li><br/>";
						}else {
							var list_route = "<li class='balloon left'>"+htmlEncode(message)+"</li><br/>";
						}
						
						$('#discussion').append(list_ID+list_route);
					});
					$('#message').focus();
					connection.start({jsonp : true}).done(
						function() {
							$('#btnSend').click(function() {
								chat.invoke('send', $('#memID').val(),
													$('#message').val());
													$('#message').val('').focus();
							});
						});
				});
		function htmlEncode(value) {
			var encodedValue = $('<div />').text(value).html();
			return encodedValue;
		}

	</script>
<!-- 채팅 API -->	
	</div>
</body>
</html>