<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>BabyParent</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- CSS -->
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./resources/css/main2.css"/>
	<style>
	html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
	</style>
<script type="text/javascript">
	function messageSendOpen() {
		window.open("messageSend", "messageSend", "width=500, height=600");
	}
</script>
<!-- body -->
<body class="w3-theme-l5">
<div class="main">
<!-- header -->
<tiles:insertAttribute name="header"/>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;padding-top:150px">    
  <!-- The Grid -->
  <div class="w3-row">
  	<!-- side-left -->
    <tiles:insertAttribute name="side-left"/>
    <!-- Middle Column -->
    <div class="w3-col m7">
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center">
		<h3>쪽지 리스트</h3>
		<table width="600" cellpadding="0" cellspacing="0" border="1">
			<colgroup bgcolor="#ddffaa">
				<col width="10%">
				<col width="50%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			<tr align="center">
				<td>번호</td>
				<td>발신자</td>
				<td>제목</td>
				<td>확인 날짜</td>
			</tr>
			<c:forEach var="bvo" items="${list}">
				<tr bgcolor="white">
					<td>${bvo.mNo}</td>
					<td>${bvo.mSender}</td>
					<td>${bvo.mSubject}</td>
					<td>${bvo.mReadTime}</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" class="btn" id="messageSend" onclick="messageSendOpen()">쪽지 보내기</button>
	</div>
            </div>
          </div>
        </div>
      </div>
    <!-- End Middle Column -->
    </div>
    <!-- side-right column -->
	<tiles:insertAttribute name="side-right"/>
  <!-- End Grid -->
  </div>
  </div>
</div>
<!-- End Page Container -->
</body>
</html>