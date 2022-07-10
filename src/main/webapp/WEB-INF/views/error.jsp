<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ldw
  Date: 2022-07-02
  Time: 오전 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>에러페이지</title>
</head>
<body>
    <div>현재 페이지는 시험용으로 사용되고있습니다.</div>
    <a href="<c:url value='/'/>">돌아가기</a>
    <div>
        에러메세지 : ${error}
    </div>
</body>
</html>
