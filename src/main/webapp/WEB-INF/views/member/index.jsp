<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:catch>
    <c:choose>
        <c:when test="${empty authInfo }">
            <li>
                 <a href="/login"><i class="fa fa-sign-in"></i> 로그인</a>
             </li>
             <li>
                 <a href="/register/step1"><i class="fa fa-user"></i> 회원가입</a>
             </li>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${authInfo.grade eq '1' }">
                    <li>
                       <p>관리자 ${authInfo.name }님, 환영합니다.</p>
                   </li>
                   <li>
                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                </c:when>
                <c:otherwise>
                    <li>
                       <p>${authInfo.name }님, 반갑습니다!</p>
                   </li>
                   <li>
                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</c:catch>
</body>
</html>