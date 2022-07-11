<%--@elvariable id="userInfo" type="com.board.app.domain.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BOARD SERVICE</title>
	<link rel="stylesheet" href='<c:url value="/resources/css/index.css"/>'>
</head>
<body>
<%--<header class="top-menu">--%>
<%--	<h1><a href="">게시판</a></h1>--%>
<%--	<nav>--%>
<%--		<h2>회원 메뉴</h2>--%>
<%--		<ul>--%>
<%--			<li><a href="<c:url value='/boards'/>">게시판</a></li>--%>
<%--			<li><a href="<c:url value='/${userInfo == null ? "login" : "logout"}'/>">${userInfo == null ? "로그인" : "로그아웃"}</a></li>--%>
<%--			<c:if test="${userInfo == null}">--%>
<%--				<li><a href="<c:url value='/register'/>">회원가입</a></li>--%>
<%--			</c:if>--%>
<%--		</ul>--%>
<%--	</nav>--%>
<%--</header>--%>
<%@ include file="header.jsp"%>
<main>
	<section class="list">
		<h3>최근 게시물</h3>
		<ul>
			<li><a href="">최근 글 dsad sa dsd sad sa dds adsssssssssssssssssssss</a></li>
			<li><a href="">최근 글</a></li>
			<li><a href="">최근 글</a></li>
		</ul>
	</section>
	<section class="list">
		<h3>오늘의 인기 게시물</h3>
		<ul>
			<li><a href="">최근 인기글</a></li>
			<li><a href="">최근 인기글</a></li>
			<li><a href="">최근 인기글</a></li>
		</ul>
	</section>
	<section class="list">
		<h3>월간 인기 게시물</h3>
		<ul>
			<li><a href="">월간 인기글</a></li>
			<li><a href="">월간 인기글</a></li>
			<li><a href="">월간 인기글</a></li>
		</ul>
	</section>
</main>
<footer>

</footer>
</body>
</html>