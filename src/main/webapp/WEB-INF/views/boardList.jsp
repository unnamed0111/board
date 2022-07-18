<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/board_list.css'/>">
</head>
<body>
<%@ include file="header.jsp"%>
<main>
    <section class="list">
        <h3>게시판 목록</h3>
        <table>
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>댓글</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
                <th>추천</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td>${board.boardId}</td>
                    <td><a href="<c:url value='/board/read'/>?id=${board.boardId}">${board.boardTitle}</a></td>
                    <td>${board.boardCommentCnt}</td>
                    <td><c:out value="${board.userId}"/></td>
                    <td><time datetime="2022-11-11"><fmt:formatDate value="${board.boardRegDate}" pattern="yyyy-MM-dd"/></time></td>
                    <td>${board.boardViewCnt}</td>
                    <td>${board.boardLikeCnt}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="tool">
            <form class="search" action="<c:url value='/board/list'/>" method="get">
                <label class="hidden" for="searchOpt">검색</label>
                <select name="option" id="searchOpt">
                    <option value="T">제목</option>
                    <option value="C">내용</option>
                    <option value="W">제목+내용</option>
                </select>
                <input name="keyword" type="text" placeholder="검색">
                <button>검색</button>
            </form>
            <a class="btn-write" href="<c:url value='/board/write'/>">글쓰기</a>
        </div>
        <div class="page-handler">
            <ul>
                <c:if test="${ph.showPrev}">
                <li><a class="btn-pageHandler" href="<c:url value='/board/list'/>${ph.sc.getQueryString(ph.beginPage - 1)}">이전</a></li>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                <li <c:if test="${ph.sc.page == i}">class="selected"</c:if>><a href="<c:url value='/board/list'/>${ph.sc.getQueryString(i)}">${i}</a></li>
                </c:forEach>
                <c:if test="${ph.showNext}">
                <li><a class="btn-pageHandler" href="<c:url value='/board/list'/>${ph.sc.getQueryString(ph.endPage + 1)}">다음</a></li>
                </c:if>
            </ul>
        </div>
    </section>
</main>
</body>
</html>