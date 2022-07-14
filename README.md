# BOARD SERVICE

기존 게시판 서비스에서 부가적인 기능을 추가해서 만든 프로젝트입니다.<br>
추천기능과 추천수에 따른 메인화면 표시 기능 등을 추가하였습니다.<br>
그리고 이 프로젝트는 계속 업데이트 됩니다.
> 현재 작동하는 프로젝트가 궁금하신가요?<br>
>
> -BOARD SERVICE 바로가기-http://54.180.152.86:8080/board/

## 추가할 기능들
- 사진 첨부 및 표시
- 브라우저용 위지윅 추가 
- 유저 프로필 수정/탈퇴 기능 추가
- 관리자 기능 추가
## 사용기술
- Java 11
- Spring Framework
- MyBatis
- MySQL
- Tomcat 9.0
- AWS
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
## 현재 구현 완료된 기능들
- 회원가입시 유효 검사
- Request Parameter 및 Json XSS방지 구현
- 페이징 기능 구현
- 게시물 CRUD구현
- 댓글/답글 구현
