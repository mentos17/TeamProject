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
<h2>수정</h2>
<c:set var="path" value="${pageContext.request.contextPath}" />

<form name="updateForm" method="POST" action="${path}/${member.ID}/deal/update" class="table">
	<div>글번호</div>
	<div><input name="DEAL_NUM" value="${data.DEAL_NUM }" type="text" readonly="readonly"></div>
	<div>작성자</div>
	<div><input name="DEAL_ID" value="${data.DEAL_ID }" type="text" readonly="readonly"></div>
	<div>제목</div>
	<div><input name="DEAL_SUBJECT" value="${data.DEAL_SUBJECT }" type="text" required></div>
	<div>내용</div>
	<div><textarea name="DEAL_CONTENT" rows="5" cols="50" required>${data.DEAL_CONTENT }</textarea></div>
	<div>조회수</div>
	<div><input name="DEAL_READCOUNT" value="${data.DEAL_READCOUNT }" type="text" readonly="readonly"></div>
	<div>작성일자</div>
	<div><fmt:formatDate value="${data.DEAL_DATETIME }" pattern="yyyy-MM-dd HH:mm:ss"/></div>
	<div>
		<input type="submit" value="글수정">
		<input type="reset" value="리셋">
		<input type="button" value="목록" onclick="location.href='${path}/${member.ID}/deal/list'">
	</div>
	</form>
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