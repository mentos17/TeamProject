<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<style type="text/css">
	.errMsg{
		font-size: 10pt; color: #2f29fc;
	}
	#checkBtn{
			  border-radius: 5px;
			  background-color: #4497fd;
			  border: none;
			  padding: 5px 10px;
			  color: white;
			  font-weight: 600;
	}
	#cancelBtn{
			  border-radius: 5px;
			  background-color: #cbcbcd;
			  border: none;
			  padding: 5px 10px;
			  color: white;
			  font-weight: 600;
	}
</style>
<script id="template" type="text/x-handlebars-template">
{{#each .}}
<span class="imageList">
	<a href="{{getView ID}}">
		<span id="{{ID}}">
			<img src="${pageContext.request.contextPath}/mypage/display?imageName={{PIC}}" alt="view" />
		</span>
	</a>
</span>
{{/each}}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.7/handlebars.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resources/js/imglogin.js"></script>
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <div align="center" class="mypage_area">
				<h4 style="font-weight: 600; color: #1d2c52;">회원정보 수정페이지</h4><br/>	
				<hr class="w3-clear" style="margin: 5px 0 20px;">	
					<table border="0" width="350" >
						<form:form commandName="member"
								   method="post" 
								   action="${pageContext.request.contextPath}/mypageOk"> 
							<tr>
								<th>아이디</th>
								<td>
									<!-- id부분은 수정금지 읽기만 가능하게 readonly="true"로  -->
									<form:input path="ID" maxlength="20" readonly="true" class="mypage_input"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<form:errors path="ID" cssClass="errMsg"/> <!-- 유효성 체크에 실패하면 error메시지 출력 구문 -->
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<form:password path="PWD" maxlength="20" class="mypage_input"/>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<form:errors path="PWD" cssClass="errMsg"/>
								</td>				
							</tr>
							<tr>
								<th>이름</th>
								<td>
									<form:input path="NAME" maxlength="13" class="mypage_input"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<form:errors path="NAME" cssClass="errMsg"/>
								</td>				
							</tr>
							<tr>
								<th>전화번호</th>
								<td>
									<form:input path="PHONE" maxlength="13" class="mypage_input"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<form:errors path="PHONE" cssClass="errMsg"/>
								</td>				
							</tr>
							<tr>
								<th>이메일</th>
								<td>
									<form:input path="EMAIL" maxlength="50" class="mypage_input"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<form:errors path="EMAIL" cssClass="errMsg"/>
								</td>				
							</tr>
							<tr>
								<td></td>
								<td class="imgfile" colspan="2">
									<input type="file" class = "file">
								</td>
							</tr>						
							<tr>
								<td>
									<ul class = "uploadedFileList"></ul>
									<form:hidden path="PIC" id="PIC"/>
								</td>
							</tr>				
							<tr>
								<td colspan="3" align="center" style="margin-top: 10px;">
									<input type="submit" id="checkBtn" value="수정"/>
									<input type="button" id="cancelBtn" value="취소" onclick="history.back();">
								</td>
							</tr>
						</form:form>
					</table>
				</div>
			</div>
          </div>
        </div>
      </div>