<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
</head>
<body>
<main class="center">
    <h1><a href="">게시판</a></h1>
    <form class="form-login" action="<c:url value='/login'/>" method="post">
        <fieldset>
            <legend class="hidden">로그인</legend>
            <table class="tbl-login">
                <tr>
                    <th><label for="id">아이디</label></th>
                    <td><input name="userId" id="id" type="text" placeholder="아이디를 입력해주세요" required></td>
                </tr>
                <tr>
                    <th><label for="pwd">비밀번호</label></th>
                    <td><input name="userPwd" id="pwd" type="password" placeholder="비밀번호를 입력해주세요" required></td>
                </tr>
            </table>
            <ul class="list">
                <li><input name="idRemember" id="check" type="checkbox"><label for="check">아이디 저장</label></li>
                <li><a href="<c:url value='/register'/>">회원가입</a></li>
            </ul>
            <div class="btn-login"><button type="submit">로그인</button></div>
        </fieldset>
    </form>
</main>
</body>
</html>