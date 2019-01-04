<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>BabyParent | Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/gallery.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/message.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/follow.css"/>
<!-- 썸머노트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<%-- 로그인된 아이디 --%>
<input type="hidden" id="mem_id" value="${member.ID}">

<c:set var="center" value="${param.center}"/>
	<c:if test="${empty center}"> 
 		<c:set var="center" value="gallery/list.jsp"/>
 	</c:if>
<body class="w3-theme-l5 main" style="overflow-x: hidden; overflow-y:auto;">

<!-- Header -->
	<jsp:include page="layout/header.jsp"/>
<!-- END Header -->

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1600px;padding-top:120px;">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <jsp:include page="layout/side-left.jsp"/>
    <!-- End Left Column -->

	<!-- Center -->
	<div class="w3-col m7">
		<jsp:include page="${center}"></jsp:include>
	</div>
	<!-- END Center -->
    
    <!-- Right Column -->
    <jsp:include page="layout/side-right.jsp"></jsp:include>      
    <!-- End Right Column -->
    <jsp:include page="layout/top-slide.jsp"></jsp:include>  
    
  <!-- End Grid -->
  </div>
  </div>
<!-- End Page Container -->

<br>
<script type="text/javascript">
// Accordion
function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme-d1";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme-d1", "");
    }
}
// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

$(document).ready(function(){
	$("#search_confirm").on("click", function(){
		var keyword = $("#search_keyword").val();
		
		location.href="${pageContext.request.contextPath}/search?keyword="+keyword;
	});
});
//게시판
$(document).ready(
	function() {
		$("#image").hide();
			$("#choice").change(function() {
				if ($("#choice").val() == 'image') {
					$("#small").hide();
					$("#image").show();
				} else {
					$("#image").hide()
					$("#small").show();
				}
			});
		$("#myInput").on(
			"keyup",
				function() {
					var value = $(this).val().toLowerCase();
					$("#small tr").filter(
						function() {
							$(this).toggle(
								$(this).text().toLowerCase().indexOf(value) > -1)
						});
					$("#image tr").filter(
						function() {
							$(this).toggle(
								$(this).text().toLowerCase().indexOf(value) > -1)
						});
				});	
})
//썸머노트
$('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 100
});
</script>
<!-- js 파일 -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.12/handlebars.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/followblock.js"></script>
</body>
</html> 
