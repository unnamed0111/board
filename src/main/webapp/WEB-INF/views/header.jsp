<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="top-menu">
    <h1><a href="<c:url value='/'/> ">게시판</a></h1>
    <nav>
        <h2>회원 메뉴</h2>
        <ul>
            <li><a href="<c:url value='/board/list'/>">게시판</a></li>
            <li><a href="<c:url value='/${globalUserInfo == null ? "login" : "logout"}'/>">${globalUserInfo == null ? "로그인" : "로그아웃"}</a></li>
            <c:if test="${globalUserInfo == null}">
                <li><a href="<c:url value='/register'/>">회원가입</a></li>
            </c:if>
        </ul>
    </nav>
</header>