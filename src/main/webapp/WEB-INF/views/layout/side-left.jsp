<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<body>
    <div class="w3-col m3" style="max-width: 320px;">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white" style="padding: 20px;">
        <div class="w3-container">
         <h4 class="w3-center" style="color: #1d2c52;">Profile</h4>
         <br/>
         <div class="w3-center image_wrapper">
         	<%-- 만약 회원 프로필 이미지가 없을 경우에는 기본 이미지를 띄운다. --%>
         	<c:choose>
				<c:when test="${empty profile.PIC}">
					<img src="${pageContext.request.contextPath}/resources/img/baby.jpg" alt="defaultImage">					
				</c:when>
				<c:otherwise>
					<img src="${pageContext.request.contextPath}/${profile.PIC}">
				</c:otherwise>
			</c:choose>
         </div>
         <hr>
        <%-- 회원 정보 --%>
        <div class="member_icon" style="font-weight: 500; font-size: 15px;" align="left">
	         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> ${profile.NAME}</p>
	         <p><i class="fa fa-envelope fa-fw w3-margin-right w3-text-theme"></i> ${profile.EMAIL}</p>
	         <p><i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i> ${profile.BIRTH}</p>
	         <%-- 로그인 했을때만 글쓰기 버튼 보인다 --%>
	         <c:if test="${!empty member.ID}"> 
	         	<p align="center"><input type="button" class="uploadBtn"
	         	onclick="location.href='${pageContext.request.contextPath}/imgupload'" value="게시물 올리기"></p>
	         </c:if>
        </div>
        </div>
      </div>
      <br>
      <!-- Accordion -->
      <div class="w3-card w3-round w3-white" style="padding: 10px; border-radius: 4px;">
        <div class="w3-white">
          <button onclick="myFunction('Demo2')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Events</button>
          <div id="Demo2" class="w3-hide w3-container">
            <p>Some other text..</p>
          </div>
        </div>      
      </div>
      <br>     
      <!-- 팔로우 추천 목록 -->
      <c:if test="${!empty member.ID}"> 
	      <div class="w3-card w3-round w3-white w3-hide-small" style="padding: 30px 10px;">
	      	<h4 style="text-align: center; color: #1d2c52; margin-bottom: 10px;">Recommend Follow</h4>
	        <hr class="w3-clear" style="margin: 5px 20px 20px;">
	        <div class="w3-container" id="small_recommend_list">	        	
	        </div>
	      </div>
      </c:if>
      <br>
    </div>
<script id="s_recom_follow-template" type="text/x-handlebars-template">
{{#s_r_list}}
	<img src="${pageContext.request.contextPath}/resources/img/baby.jpg" 
	        	alt="defaultImage" class="w3-left w3-circle" style="max-width: 100%; max-height: 50px;">
	        	<span class="w3-right smallSizeFont">
					<button type="button" class="w3-button w3-theme-d1 w3-margin-bottom followBtn fbBtn fbtn_{{following_id}}"
						value='{{following_id}}'>팔로우
					</button>
					<button type="button" class="w3-button w3-theme-d1 w3-margin-bottom followingBtn fbBtn fbhide fbtn_{{following_id}}"
						value='{{following_id}}'>
						<span>팔로잉</span> <span>언팔로우</span>
					</button>
				</span>
	        	<font style="font-size: 18px; font-weight: 600; margin: 0 10px;">
					<a href="${pageContext.request.contextPath}/{{following_id}}/gallery"><span class="writerId">{{following_id}}</span></a>
				</font>	        	
				<br><div class="w3-clear" style="margin: 5px 20px 10px;"></div>

{{/s_r_list}}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.12/handlebars.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/followblock.js"></script> --%>
</body>