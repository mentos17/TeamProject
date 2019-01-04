<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center" style="padding: 30px;">
				<h4 style="font-weight: 600; color: #1d2c52; margin-bottom: 20px;">받은 쪽지</h4>
				<table width="95%" cellpadding="0" cellspacing="0" border="0">
					<colgroup bgcolor="#4497fd">
						<col width="5%">
						<col width="15%">
						<col width="40%">
						<col width="30%">
						<col width="10%">
					</colgroup>
					<tr align="center" style="font-weight: 600; color: white; ">
						<td><input type="hidden" value="메세지넘버"></td>
						<td>보낸 사람</td>
						<td>제목</td>
						<td>받은 날짜</td>
						<td>삭제</td>
					</tr>
					<c:forEach items="${mlist}" var="message">
					 	<c:if test="${member.ID eq message.MESSAGE_RECEIVER}">  
							<tr bgcolor="white" align="center" height="40px" style="font-weight: 500; font-size: 16px;">
								<td><input type="hidden" value="${message.MESSAGE_NO}" id="MESSAGE_NO" name="MESSAGE_NO"></td>
								<td>${message.MESSAGE_SENDER}</td>
								<td>
									<c:if test="${message.MESSAGE_READVAL == false}">
										<span style="color: #78787c; font-size: 12px; font-weight: 600;">New</span>
									</c:if>
										<a href="#" id="messageView" onclick="window.open('${pageContext.request.contextPath}/${member.ID}/messageView?MESSAGE_NO=${message.MESSAGE_NO}', 'messageView', 'width=500, height=650')">${message.MESSAGE_SUBJECT}</a>
								</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${message.MESSAGE_SENDTIME}"/></td>
								<td>
									<a href="${pageContext.request.contextPath}/${member.ID}/messageDelete?MESSAGE_NO=${message.MESSAGE_NO}" onclick="return confirm('정말로 쪽지를 삭제하시겠습니까?')"><i class="fa fa-times" aria-hidden="true"></i></a>
								</td>
							</tr>
		 				</c:if>  
					</c:forEach>
				</table>
					<div class="btn_Message">
						<input id="messageSend" type="button" value="쪽지보내기" id="messageSend" onclick="window.open('${pageContext.request.contextPath}/${member.ID}/messageSend', 'messageSend', 'width=500, height=650')">
						<input class="sendMessageList" type="button" value="보낸 쪽지 확인" onclick="location.href='${pageContext.request.contextPath}/${member.ID}/messageSendList'">
					</div>
				</div>
            </div>
          </div>
        </div>
      </div>