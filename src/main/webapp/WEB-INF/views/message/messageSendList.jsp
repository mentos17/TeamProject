<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center" style="padding: 30px;">
				<h4 style="font-weight: 600; color: #1d2c52; margin-bottom: 20px;">보낸 쪽지</h4>
				<table width="95%" cellpadding="0" cellspacing="0" border="0">
					<colgroup bgcolor="#4497fd">
						<col width="5%">
						<col width="15%">
						<col width="30%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tr align="center" style="font-weight: 600; color: white;">
						<td><input type="hidden" value="메세지넘버"></td>
						<td>받는 사람</td>
						<td>제목</td>
						<td>보낸 날짜</td>
						<td>확인 여부</td>
					</tr>
					<c:forEach items="${mslist}" var="message">
					 	<c:if test="${member.ID eq message.MESSAGE_SENDER}">  
							<tr bgcolor="white" align="center" height="40px" style="font-weight: 500; font-size: 16px;">
								<td><input type="hidden" value="${message.MESSAGE_NO}"></td>
								<td>${message.MESSAGE_RECEIVER}</td>
								<td>
									<a href="#" id="messageSendView" 
										onclick="window.open('${pageContext.request.contextPath}/${member.ID}/messageSendView?MESSAGE_NO=${message.MESSAGE_NO}', 'messageSendView', 'width=500, height=600')">${message.MESSAGE_SUBJECT}</a>
								</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${message.MESSAGE_SENDTIME}"/></td>
								<td>
								<c:choose>
									<c:when test="${message.MESSAGE_READVAL == false}">
										읽지 않음
									</c:when>
									<c:otherwise>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${message.MESSAGE_READTIME}"/>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
		 				</c:if>  
					</c:forEach>
				</table>
					<div class="btn_Message">
						<input class="sendMessageList" type="button" value="받은 쪽지 확인" onclick="location.href='${pageContext.request.contextPath}/${member.ID}/messageList'">
					</div>
				</div>
            </div>
          </div>
        </div>
      </div>