---
<<<<<<< HEAD
# <12/26>
=======
#변경 
com.team.login.DAO.MemberDAO -> com.team.login.DAO.LoginDAO

com.team.login.DAO.MemberDAOImpl  -> com.team.login.DAO.LoginDAOImpl

	/mybatis/mybatis-config.xml
	<typeAlias alias="MemberVO" type="com.team.login.DTO.MemberVO" /> 
	-> 

com.team.member.VO.MemberVO 
변수명 대문자로 변경

signUp.jsp 
form의 name값들 대문자로 변경

memberMapper.xml
파라미터값들 대문자로 변경


---

.gitignore 적용

프로젝트 불러온 후 

프로젝트 우클릭  - maven - update project 해야함.

---

>>>>>>> branch 'master' of https://github.com/juhoyoung/TeamProject.git
MemverController -> 회원가입 수정 ,로그아웃 추가

MemberDAO -> 회원가입 수정

MemberDAOImpl -> 회원가입 수정

MemberService -> 회원가입 수정

MemberServiceImpl -> 회원가입 수정

MemberMapper -> 회원가입 수정

view/logout 추가

layout -> side-left: 회원수정버튼 추가, 회원이름,생년월일,이메일 변경

layout ->header : 환영합니다 부분 <a></a> 추가, 회원 로그아웃 부분 변경

servlet-context.xml  

->D://upload->(D:\upload) 변경

<!-- 파일업로드 위한 디렉토리 설정 -->

	<beans:bean id="uploadPath" class="java.lang.String">
	
		<beans:constructor-arg value ="D://upload->(D:\upload)"/>
		
	</beans:bean> 
	

---

---
com.team.main.Controller -> mainController 추가(왜인지 모르겠지만 빠져있었음)
servlet-context.xml, pom.xml -> tiles 속성 제거(안써서)
layout -> header.jsp -> 로고 누르면 main으로 이동, member.NAME -> member.ID로 변경
회원정보 몇군데 -> 주소 컨트롤러로 가게 수정했습니다. 
저는 8080이 아니라서 접속을 거부당해서...

-------------------------------
쪽지 리스트, 상세보기, 삭제 구현 

보내기도 분명 됬었는데 팝업창이 갑자기 안떠서 보내지를 못함 수정해야됨

login, main 타이틀명 변경




