<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Baby Parent</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<!-- body -->
<body class="w3-theme-l5">
<div class="main">
<!-- Header -->
	<jsp:include page="../layout/header.jsp"/>
<!-- END Header -->
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1600px;padding-top:120px;">    
  <!-- The Grid -->
  <div class="w3-row">
  	<!-- Left Column -->
    <jsp:include page="../layout/side-left.jsp"/>
    <!-- End Left Column -->
    <!-- Middle Column -->
    <div class="w3-col m7">
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center" style="padding: 30px;">
<h2>상세페이지</h2>
<c:set var="path" value="${pageContext.request.contextPath}" />
<table border="1" class="table">
<tr>
<td>등록일</td>
<td><fmt:formatDate value="${ data.DEAL_DATETIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>
<tr>
	<td>글번호</td>
	<td>${data.DEAL_NUM }</td>
</tr>
<tr>
	<td>글제목</td>
	<td>${data.DEAL_SUBJECT }</td>
</tr>
<tr>
	<td>글내용</td>
	<td>${data.DEAL_CONTENT }</td>
</tr>
<tr><td>글쓴이</td><td>${data.DEAL_ID }</td></tr>
<tr><td>조회수</td><td>${data.DEAL_READCOUNT }</td></tr>

</table>
<a href="${path}/${member.ID}/deal/updatepage?DEAL_NUM=${data.DEAL_NUM}">수정</a>
<a href="${path}/${member.ID}/deal/delete?DEAL_NUM=${data.DEAL_NUM}">삭제</a>
<input type="button" value="목록" onclick="location.href='${path}/${member.ID}/deal/list'">
<input type="button" value="글쓰기" onclick="location.href='${path}/${member.ID}/deal/write'">
		</div>
            </div>
          </div>
        </div>
      </div>
    <!-- End Middle Column -->
    </div>
     <!-- Right Column -->
    <jsp:include page="../layout/side-right.jsp"></jsp:include>      
    <!-- End Right Column -->
  <!-- End Grid -->
  </div>
  </div>
</div>
<!-- End Page Container -->
<!-- js 파일 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
</body>
</html>