<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ldw
  Date: 2022-07-01
  Time: 오후 6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/register.css'/>">
</head>
<body>
<div class="reg-form">
    <h1><a href="<c:url value='/'/>">게시판</a></h1>
    <form action="<c:url value='/register'/>" method="post">
        <fieldset>
            <legend>회원가입</legend>
            <label for="id">아이디</label><input name="userId" id="id" type="text">
            <label for="pwd">비밀번호</label><input name="userPwd" id="pwd" type="password">
            <label for="name">이름</label><input name="userName" id="name" type="text">
            <label for="email">이메일</label><input name="userEmail" id="email" type="email">
            <label for="birth">생년월일</label><input name="userBirth" id="birth" type="date">
            <button type="submit">회원가입</button>
        </fieldset>
    </form>
</div>
</body>
</html>