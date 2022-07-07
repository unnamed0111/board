<%--@elvariable id="globalUserInfo" type="com.board.app.domain.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="button" value="${mode == 'MOD' ? '수정' : '등록'}"/>
<c:set var="link" value="${mode == 'MOD' ? 'modify' : 'write'}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/board_form.css'/>">
</head>
<body>
<%@ include file="header.jsp"%>
<main>
    <h3><a href="<c:url value='/board/list'/>">게시물 목록</a></h3>
    <form action="<c:url value="/board/${link}"/>" method="post">
        <h4>게시글 작성</h4>
        <table class="form-board">
            <tr>
                <th><label for="title">제목</label></th>
                <td>
                    <input
                           id="title"
                           name="boardTitle"
                           type="text"
                           placeholder="제목을 입력해주세요"
                           required
                           <c:if test='${mode == "MOD"}'>value="${board.boardTitle}"</c:if>
                    />
                </td>
            </tr>
            <tr>
                <th><label for="user">작성자</label></th>
                <td><input id="user" type="text" value="${globalUserInfo.userId}" readonly /></td>
            </tr>
            <tr>
                <th><label for="content">내용</label></th>
                <td><textarea id="content" name="boardContent" required>${board.boardContent}</textarea></td>
            </tr>
        </table>
        <input type="hidden" name="boardId" value="${board.boardId}"/>
        <div class="btn-write"><button type="submit">${button}</button></div>
    </form>
</main>
</body>
</html>
