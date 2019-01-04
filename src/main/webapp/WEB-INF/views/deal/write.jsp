<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center" style="padding: 30px;">	
<h2>글쓰기 페이지</h2>
<c:set var="path" value="${pageContext.request.contextPath}" />
<form name="ddto" method="post" action="${path}/${member.ID}/deal/insert" class="table" >
	<div>제목<input name="DEAL_SUBJECT" id="deal_subject" size="80" required></div>
	<div>내용<textarea name="DEAL_CONTENT" id="deal_content" rows="8" cols="80" required></textarea> </div>
	<div>작성자<input name="DEAL_ID" id="deal_id" size="80" required></div>
		<div style="width:650px; text-align:center;">
            <input type="submit" value="확인">
            <input type="reset" value="리셋">
            <input type="button" value="목록" onclick="location.href='${path}/${member.ID}/deal/list'">
        </div>
		<!--섬머노트  -->
 	<div id="summernote"></div>
</form>
			</div>
            </div>
          </div>
        </div>
      </div>