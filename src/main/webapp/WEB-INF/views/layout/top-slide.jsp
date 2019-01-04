<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<style type="text/css">
	#quick_menu {
		text-align: center;
		position: fixed;
		top: 90%;
		right: 2%;
		width: 70px;
	  	height: 70px;
	  	border-radius: 5px;
	  	line-height: 70px;
	  	padding: 2px;
	}
	</style>
</head>
</html>
<body>
	<div class="w3-card w3-white" id="quick_menu">
		<a href="#" onclick="scrollToTop()">
			<i class="fa fa-arrow-up" aria-hidden="true"></i>
			<font style="font-weight: bold;">TOP</font>
		</a>
	</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
