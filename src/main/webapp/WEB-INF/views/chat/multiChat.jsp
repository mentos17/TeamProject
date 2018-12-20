<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>채팅</title>
<script type="text/javascript" src="../resourses/js/jquery.min.js"></script>
<script type="text/javascript" src="../resourses/js/sockjs.js"></script>
</head>
<body>
	<div id="positionLayer" style="overflow-y: auto; width: 370px; height: 450px; position: fixed; right: 0; bottom: 0; z-index: 10000; border: 2px solid #000000; text-align: center;">
	<!-- 레이어팝업 -->
	<table align="center" bgcolor="#FFFFFF">
		<tr>
			<td bgcolor="#D75E00" align="center" height="30"><font style="font-size: 18px; font-weight:bold" color="#FFFFFF">자유채팅</font></td>
		</tr>
		<tr>
			<td>
				<div style="overflow: auto; height: 200px;" align="left">
				<ul id="discussion"></ul>
				</div>
			
 			<ul id="discussion"></ul>
			<br/>
			<br/>		
<!-- 
	<!-- 채팅 대화명 if문 -->
	<%
		String mem_id = (String) session.getAttribute("sessionID");
		int customer_number = (int) (Math.random() * 99) + 1;
	%>
	<!-- 로그인 하지 않은 경우 -->
	<%
		if (mem_id == null) {
	%>
	<p align="left">&nbsp;1. 귀하의 ID는 : 고객번호 <<%=customer_number%>번></a></p>
	<p align="left">&nbsp;2. 미 로그인 시 고객번호  + 랜덤 숫자 부여됨</p>
	<p align="left">&nbsp;3. 로그인 시 기본 대화명 "본인 ID" 부여됨</p>
	<input type="hidden" id="userid" width="110" style="" value="고객번호 <<%=customer_number%>번>" readonly="readonly">
	<br />
	<!-- 관리자 로그인 한 경우 -->
	<%
		} else if (session.getAttribute("sessionID").equals("info@naver.com")) {
	%>
	<p align="left">&nbsp;1. 귀하의 ID는 : 고객센터 관리자입니다.</a></p>
	<p align="left">&nbsp;2. 미 로그인 시 고객번호  + 랜덤 숫자 부여됨</p>
	<p align="left">&nbsp;3. 로그인 시 기본 대화명 "본인 ID" 부여됨</p>
	<input type="hidden" id="userid" width="110" style="" value="고객센터 관리자" readonly="readonly">
	<br />
	<!-- 일반 로그인 한 경우 -->
	<%
		} else if (mem_id != null) {
	%>
	<p align="left">&nbsp;1. 귀하의 ID는 : <%=mem_id%> </a></p>
	<p align="left">&nbsp;2. 미 로그인 시 고객번호  + 랜덤 숫자 부여됨</p>
	<p align="left">&nbsp;3. 로그인 시 기본 대화명 "본인 ID" 부여됨</p>
	<input type="hidden" id="userid" width="110" style="" value="<%=mem_id%>" readonly="readonly">
	<br />
	<%
		}
	%>
	<!-- 채팅 대화명 if문 -->
			<input type="text" id="message" size="50" align="middle" placeholder="메세지를 입력하세요">
			<br/>
			<br/>
			<input type="button"style="font-size:18px; font-weight:bold; background-color: #D75E00; color:#ffffff; width: 100%;"  id="btnSend" value="전송"/>
			<ul id="discussion"></ul>
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

		$(document).ready(
				function() {

					chat.on('addNewMessageToPage', function(name, message) {
						$('#discussion').append(
								'<li><strong>' + htmlEncode(name)
										+ '</strong>: ' + htmlEncode(message)
										+ '</li>');
					});

					$('#message').focus();

					connection.start({
						jsonp : true
					}).done(
							function() {

								$('#btnSend')
										.click(
												function() {
													chat
															.invoke('send', $(
																	'#userid')
																	.val(), $(
																	'#message')
																	.val());
													$('#message').val('')
															.focus();
												});
							});
				});

		function htmlEncode(value) {
			var encodedValue = $('<div />').text(value).html();
			return encodedValue;
		}
	</script>
<!-- 채팅 API -->	
	<!-- 닫기 버튼 자바 -->
		<script>
			function close_window() {
				var popup = document.getElementById("positionLayer");
				popup.style.display = "none";
			}
		</script>
		<!-- 닫기 버튼 자바 -->

		<!-- 닫기 버튼 html -->
		<div id="popup">
			<div id="close" onclick="close_window()">닫기</div>
		</div>
		<!-- 닫기 버튼 html -->

	</div>
</body>
</html>