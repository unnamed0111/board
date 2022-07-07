<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ldw
  Date: 2022-07-05
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<form action="<c:url value='/comment/write'/>" method="post">
    <input id="content" type="text">
    <input id="id" type="hidden" value="999">
    <button id="sendBtn" type="button">전송</button>
</form>
<script>
    $('#sendBtn').on('click', function() {
        let myData = { content: $('#content').val(), id: $('#id').val()};

        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/app/test/1',  // 요청 URI
            headers : { "content-type": "utf-8"}, // 요청 헤더
            dataType : 'text', // 전송받을 데이터의 타입
            // data : JSON.stringify(myData),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success : function(result){
                console.log(result);
            },
            error   : function(err){ $('body'.append(err)) } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    })


</script>
</body>
</html>
