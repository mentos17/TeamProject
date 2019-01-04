<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/message.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
<div id="sendTitle" align="center" style="background-color: #4497fd; width: 100%; height: 50px;">
	<font color="white" id="send_text" style="font-weight: 600; font-size: 18px;">보낸 쪽지 확인</font>
</div>
<c:if test="${member.ID!= null}">
	<div title="메세지 확인">
		<form method="post" name="messageView" id="messageView">
			<table align="center" width="90%" cellpadding="0" cellspacing="0" border="0">
				<tr bgcolor="white">
					<td>받는 사람</td>
					<td>${msdto.MESSAGE_RECEIVER}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${msdto.MESSAGE_SUBJECT}</td>
				</tr>
				<tr>
					<td>보낸 날짜</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${msdto.MESSAGE_SENDTIME}"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${msdto.MESSAGE_CONTENT}</td>
				</tr>
				<tr align="center">
					<td><input type="button" value="창닫기" id="closeBtn" onclick="window.close()"></td>
				</tr>
			</table>
		</form>
	</div>
</c:if>
<!-- js 파일 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
</body>
</html>