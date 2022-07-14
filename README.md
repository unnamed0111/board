# BOARD SERVICE

기존 게시판 서비스에서 부가적인 기능을 추가해서 만든 프로젝트입니다.<br>
추천기능과 추천수에 따른 메인화면 표시 기능 등을 추가하였습니다.<br>
그리고 이 프로젝트는 계속 업데이트 됩니다.
> 현재 작동하는 프로젝트가 궁금하신가요?<br>
>
> -BOARD SERVICE 바로가기-http://54.180.152.86:8080/board/
## 사용기술
#### `Back-end`
- Java 11
- Spring Framework
- MyBatis
- MySQL
- Tomcat 9.0
- AWS
#### `Front-end`
- HTML/CSS/JavaScript
- jQuery
## 구성
- HOME
  - 최근 게시물 
  - 오늘의 인기 게시물
  - 월간 인기 게시물
- BOARD
  - 게시물 목록
  - 게시물 검색
  - 페이징 기능
  - 게시물 CRUD
  - 게시물 추천
- USER
  - 회원가입
  - 유효성 검사
  - 로그인
- COMMENT
  - 댓글/답글 CRUD
  - REST 처리
- LIKE
  - 추천 기능
  - REST 처리
## 핵심 기능들

이 서비스의 핵심기능은 게시물 작성입니다.
사용자가 게시물을 작성하고 등록을 하면
게시물이 목록에 갱신됩니다.

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">
  
### 전체 흐름
![flow](https://user-images.githubusercontent.com/4982309/179008967-cb1f4427-f2e7-4525-8062-b57aeda49795.png)

### Controller
![슬라이드2](https://user-images.githubusercontent.com/4982309/179017587-e23bee4a-e01b-4dee-994b-3988fafde5b8.PNG)
- 로그인 여부 체크
  + 세션을 받아서 ID확인
  + 없으면 홈으로 redirect
- 유저 정보를 Board객체에 주입
- Board 객체를 Service계층으로 전달

### Service
![슬라이드3](https://user-images.githubusercontent.com/4982309/179018327-133d69bf-fe14-48e0-aec2-f85432f4dc49.PNG)
- Board객체를 그대로 DAO로 전달

### DAO
![슬라이드4](https://user-images.githubusercontent.com/4982309/179018454-51d15b5d-32ac-4ed5-89df-0d867dfabbd9.PNG)
- 전달 받은 Board객체를 myBatis로 해당 Mapper로 전달
- myBatis로 Mapper에 등록된 SQL문 실행
</div>
</details>

## 현재 구현 완료된 기능들
- 회원가입시 유효 검사
- Request Parameter 및 Json XSS방지 구현
- 페이징 기능 구현
- 게시물 CRUD구현
- 댓글/답글 구현
### 추가할 기능들
- 사진 첨부 및 표시
- 브라우저용 위지윅 추가 
- 유저 프로필 수정/탈퇴 기능 추가
- 관리자 기능 추가
