# <12/30>

<최지원 해야할 것 메모>

어제까지 잘뜨던 배경 이미지가 갑자기 안떠서 수정해야 함. 이유를 모르겠음

알림 -> 구현 db, el태그 활용 쪽지랑 비슷하게. 

실시간은 웹소켓 써야되서 힘들것도 같음.

제가 참고할 사이트 적어놓은것

//http://highlighttt.tistory.com/12 

//https://www.youtube.com/watch?v=gQyRxPjssWg

---

### 로그인 관련

- main 으로 접속할시 LoginInterceptor를 통해서 로그인 안되어있을 경우 login 페이지로 이동하게 변경 

	- LoginInterceptor 사용 안되고 있길래 전체 주석처리하고 마음대로 바꿨습니다.
	필요할때 다시 살려서 쓰시면 될거같아요.

- *servlet-context*에 인터셉터 맵핑에 main 추가

- *loginController* 로그인 성공시 ```return "main" -> return "redirect:main"``` 으로 변경

- *memberController* 로그아웃 매핑을 loginController로 이동.

- *logout.jsp* 삭제

- *loginController* > loginSuccess 에서 ```return "redirect:login"; -> return "login";``` 로 변경

### gallery 관련

- *list* 추가

- *gallery.js* 추가 (ajax 처리용 / handlebar 사용해서 출력.)

- 글 목록 보는건  이미지 출력만 처리하면 끝

- **{id}/gallery** 로 접속하면 화면 출력


### 기타 등등
- header.jsp 로그인 안되어있으면 로그인 버튼 뜨게 바꿈


- main2.css 

```a{ text-decoration: none; }``` 추가

# <12/30 끝>

---

# <12/31>

### js파일 임포트 코드 위치 각 페이지 아래에 배치

### css
- 로그인, 메인 화면, 회원 정보 수정, 쪽지 리스트 변경
- 헤더, 사이드 쪽 변경

### 로그인 관련
- member 폴더안의 login.jsp 삭제(안쓰는 듯 해서)
- 로그아웃 : 헤더 우측 -> 드롭다운 메뉴로 위치 이동
		     로그아웃할지 여부 확인 후 로그아웃하도록 변경

### 회원 정보 관련
- 회원 정보 수정 : 왼쪽 회원정보 메뉴 -> 헤더 우측 부분 드롭다운 메뉴로 위치 이동

### 팔로우 관련
- 팔로워 수 확인(?) : 왼쪽 회원정보 메뉴 아래 -> 헤더 우측 부분 드롭다운 메뉴로 위치 이동 
- handlebar로 페이지 출력
### 갤러리 관련
- 게시물 업로드 : 왼쪽 회원정보 메뉴 아래 -> 회원정보 메뉴로 위치 변경

### 게시판 관련
- memberInterceptor 추가 (특정 주소(follower,following,gallery) 접근시 회원 정보 받아서 side-left.jsp에 뿌려주기 위한 역할)
- servletcontext에 인터셉터 매핑 추가 (오늘 추가된 몇개 페이지도 추가로 매핑할 예정)
- 게시물, 팔로우에서 아이디 누르면 해당 아이디 갤러리로 이동하는 링크 추가.

### 채팅 관련
-

### 기타 등등
- side-left.jsp 각 페이지에 맞게 프로필 출력되게 변경 
```member.~~~ -> profile.~~~```

# <12/31 끝>
---


# <01/01>

### 로그인 관련

### 회원 정보 관련
- 마이페이지 이동 경로  mypage/${member.ID} 에서 ${member.ID}/mypage 로 변경

### 팔로우 관련
- 팔로우 추천 추가 완료

### 갤러리 관련

### 게시판 관련

### 채팅 관련
-
### 기타 등등
- header에 상단 메인 로고 클릭 부분 변경 (main으로 접속시 loginInterceptor 에서 먼저 로그인 여부 체크하기때문에 활용 하시면 됩니다.)
- servlet-conetext -> logininterceptor -> Controller 순서.

-
# <01/01> 끝
---
