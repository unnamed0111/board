<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시물 1</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/board.css'/>">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
<main>
  <h3><a href="<c:url value='/board/list'/>">게시판 목록</a></h3>
  <article class="board">
    <div class="title">
      <h4><c:out value=" ${board.boardTitle}"/></h4>
      <table>
        <tr>
          <th>작성자</th>
          <td><c:out value="${board.userId}"/></td>
          <th>작성일</th>
          <td><time datetime="2022-11-11"><fmt:formatDate value="${board.boardRegDate}" pattern="yyyy-MM-dd"/></time></td>
          <th>댓글</th>
          <td>${board.boardCommentCnt}</td>
          <th>조회</th>
          <td>${board.boardViewCnt}</td>
          <th>추천</th>
          <td>${board.boardLikeCnt}</td>
        </tr>
      </table>
    </div>
    <textarea id="contentBox" class="content" disabled>${board.boardContent}</textarea>
    <div class="like-box">
      <a id="likeBtn" href="" title="추천하기">
        <div>추천</div>
        <div id="likeCnt">500</div>
      </a>
    </div>
    <c:if test="${board.userId == globalUserInfo.userId}">
      <div class="tool">
        <a href="<c:url value='/board/modify'/>?id=${board.boardId}">수정하기</a>
        <a id="deleteBtn" href="<c:url value='/board/delete'/>?boardId=${board.boardId}">삭제하기</a>
      </div>
    </c:if>
    <div id="commentTable" class="list">
      <table>
        <caption>댓글 <span id="commentCnt"></span>개</caption>
        <thead class="hidden">
        <tr>
          <th>작성자</th>
          <th>내용</th>
          <th>작성일</th>
          <th></th>
        </tr>
        </thead>
        <tbody id="commentList">
        <tr id="commentBox" class="reply close">
          <td colspan="4">
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <form id="commentForm" class="form-comment">
      <label for="comment">댓글</label>
      <div>
        <textarea id="comment" cols="30" rows="10" placeholder="댓글을 입력해주세요."></textarea>
        <button id="sendBtn" data-method="write" type="button">등록</button>
      </div>
    </form>
  </article>
  <script>
    $(document).ready(function() {
      let totalHeight = $('#contentBox').prop('scrollHeight');
      $('#contentBox').height(totalHeight);
      showCommentList();
      showLike();
    });

    // BOARD
    $('#deleteBtn').on('click', function(event) {
      if(!confirm('정말로 삭제하시겠습니까?')) event.preventDefault();
    });

    // COMMENT
    let showCommentList = function() {
      // 기존 댓글 삭제
      writeForm();
      $('#commentList tr:not(#commentBox)').remove();

      $.ajax({
        type: 'GET',       // 요청 메서드
        url: '<c:url value="/comment/list"/>?id=${board.boardId}',  // 요청 URI
        headers: { "content-type": "application/json" }, // 요청 헤더
        dataType: 'text', // 전송받을 데이터의 타입
        success: function (result) {
          let list = JSON.parse(result);

          console.log(list);

          list.forEach(function(data) {

            let tempDOM = '';

            // let contentDOM = '';
            let rootDOMClass = '';

            if(data.commentParentId !== data.commentId) {
              rootDOMClass += ' reply-element';
              // contentDOM += '<span>' + data.commentContent + '</span>';
            }
            // else {
            //   contentDOM += '<a href="" title="답글" class="commentContent">' + data.commentContent + '</a>';
            // }

            tempDOM += '<tr class="comment' + rootDOMClass + '" data-id="' + data.commentId + '" data-parent="' + data.commentParentId + '">';
            tempDOM +=    '<td>' + data.userId + '</td>';
            tempDOM +=    '<td><a href="" title="답글" class="commentContent">' + data.commentContent + '</a></td>';
            tempDOM +=    '<td><time datetime="2022-11-11">' + dateToString(data.commentUpDate) + '</time></td>';
            tempDOM +=    '<td>';
            tempDOM +=      '<button class="modifyBtn">수정</button>';
            tempDOM +=      '<button class="removeBtn">삭제</button>';
            tempDOM +=    '</td>';
            tempDOM += '</tr>';

            $('#commentTable table').append(tempDOM);
          });

          $('#commentCnt').html(list.length);

        },
        error: function () { alert("error") } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    //write
    $("#sendBtn").click(function() {
      let method = $(this).attr('data-method');
      if(method === 'write') {
        write();
      } else if(method === 'modify') {
        let element = $(this).parent().parent().parent().parent().prev();
        console.log(element);
        modify(element);
      }
    });

    let write = function() {
      let content = $('#commentForm textarea').val()

      if(content.trim() === '') {
        alert('내용을 입력해야합니다.');
        return;
      }

      let data = {
        commentContent: content,
        boardId: ${board.boardId}
      };

      // 답글일 경우
      if($('#commentForm').attr('data-parent') != null)
        data.commentParentId = Number($('#commentForm').attr('data-parent'));

      $.ajax({
        type: 'POST',       // 요청 메서드
        url: '<c:url value="/comment/write"/>',  // 요청 URI
        headers: {"content-type": "application/json"}, // 요청 헤더
        dataType: 'text', // 전송받을 데이터의 타입
        data: JSON.stringify(data),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
        success: function (result) {
          confirm(result);
          // 새로고침
          showCommentList();
        },
        error: function (err) {
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    let modify = function (element) {
      let content = $('#commentForm textarea').val()

      if(content.trim() === '') {
        alert('내용을 입력해야합니다.');
        return;
      }

      let data = {
        commentContent: content,
        commentId: Number(element.attr('data-id'))
      };

      $.ajax({
        type: 'PATCH',       // 요청 메서드
        url: '<c:url value="/comment/modify"/>',  // 요청 URI
        headers: {"content-type": "application/json"}, // 요청 헤더
        dataType: 'text', // 전송받을 데이터의 타입
        data: JSON.stringify(data),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
        success: function (result) {
          confirm(result);
          // 새로고침
          showCommentList();
        },
        error: function (err) {
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    //remove
    $('#commentTable').on('click', '.removeBtn', function() {
      // 주인이 맞는지 확인

      // 재확인
      if(!confirm('정말 삭제하시겠습니까?')) return;

      // 해당 commentId 알아내기
      let id = Number($(this).parent().parent().attr('data-id'));
      let data = {
        commentId: id
      }

      // 해당 댓글 삭제하기
      $.ajax({
        type: 'DELETE',       // 요청 메서드
        url: '<c:url value="/comment/remove"/>',  // 요청 URI
        headers: {"content-type": "application/json"}, // 요청 헤더
        dataType: 'text', // 전송받을 데이터의 타입
        data: JSON.stringify(data),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
        success: function (result) {
          confirm(result);
          // 새로고침
          showCommentList();
        },
        error: function (err) {
          // console.log(err.responseText);
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    });

    // LIKE
    $('#likeBtn').on('click', function(event) {
      event.preventDefault();

      // 이미 추천을 누른 상황이면 like DELETE
      // 추천을 누르지 않은 상황이면 like POST
      if($(this).attr('data-checked') === 'true') {
        // DELETE
        unlike();
      } else {
        // POST
        like();
      }
    });

    //    LIKE POST
    let like = function(target) {
      $.ajax({
        type: 'POST',       // 요청 메서드
        url: '<c:url value="/like"/>?id=${board.boardId}',  // 요청 URI
        success: function (result) {
          alert(result);
          showLike();
        },
        error: function (err) {
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    //    LIKE DELETE
    let unlike = function(target) {
      $.ajax({
        type: 'DELETE',       // 요청 메서드
        url: '<c:url value="/like"/>?id=${board.boardId}',  // 요청 URI
        success: function (result) {
          alert(result);
          showLike();
        },
        error: function (err) {
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    //    LIKE SHOW
    let showLike = function() {
      $.ajax({
        type: 'GET',       // 요청 메서드
        url: '<c:url value="/like"/>?id=${board.boardId}',  // 요청 URI
        success: function (result) {
          console.log(result);
          $('#likeCnt').html(result.like);
          if(result.checked === 1) {
            $('#likeBtn').attr('data-checked', true).addClass('liked');
          } else {
            $('#likeBtn').attr('data-checked', false).removeClass('liked');
          }
        },
        error: function (err) {
          alert(err.responseText);
        } // 에러가 발생했을 때, 호출될 함수
      }); // $.ajax()
    }

    // UI controller
    //  reply transform
    $('#commentTable').on('click', '#commentList tr a', function(event) {
      event.preventDefault();

      let toggle = $(this).attr('data-toggle');

      // 만약 대댓글 작성 폼이면 댓글 작성 폼으로 변경
      if(toggle == 'on') {
        $('#commentForm').removeAttr('data-parent');
        $(this).removeAttr('data-toggle');
        writeForm();
        return;
      }

      $('#commentList tr a').removeAttr('data-toggle');
      $(this).attr('data-toggle', 'on');

      // 원댓글 id값 취하기
      let parentRow = $(this).parent().parent();

      let parentId = Number(parentRow.attr('data-parent'));

      parentRow.after($('#commentBox'));

      $('#commentBox td').append($('#commentForm'));
      $('#commentBox').removeClass('close');
      $('#commentForm label').html('답글').focus();
      $('#commentForm textarea').attr('placeholder', '답글을 입력해주세요.');
      $('#commentForm').attr('data-parent', parentId);
    });

    //  write transform
    let writeForm = function() {
      $('#commentTable').after($('#commentForm'));
      $('#commentBox').addClass('close');
      $('#commentForm').children('label').html('댓글').focus();
      $('#commentForm textarea').val('').attr('placeholder', '댓글을 입력해주세요.');
      $('#sendBtn').attr('data-method', 'write');
    }

    // modify
    $('#commentTable').on('click', '.modifyBtn', function() {
      // 주인이 맞는지 확인


      // 부모인 <tr>알아내기
      let tr = $(this).parent().parent();

      console.log(tr);

      // 만약 수정 상태라면 댓글 작성 폼으로 변경
      // 그리고 data-state를 지워주기
      if($(this).attr('data-state') === 'on') {
        $(this).removeAttr('data-state');
        $(this).html('수정')
        writeForm();
        return;
      }

      // 수정 초기화 작업
      $('.modifyBtn').removeAttr('data-state').html('수정');
      $(this).attr('data-state', 'on');

      // 수정 상태가 아니라면 수정 폼으로 변경
      modifyForm(tr);
      $(this).html('취소');
    });

    //  modify transform
    let modifyForm = function(tr) {
      tr.after($('#commentBox'));
      $('#commentBox').removeClass('close');
      $('#commentBox td').append($('#commentForm'))
      $('#commentForm label').html('수정').focus();
      $('#commentForm textarea').val(tr.find('.commentContent').html());
      $('#sendBtn').attr('data-method', 'modify');
    }

    //util
    let dateToString = function(full) {
      let date = new Date(full);
      return date.getFullYear() + "-" +
              ("0" + (date.getMonth() + 1)).slice(-2) + "-" +
              ("0" + date.getDate()).slice(-2) + " " +
              ("0" + date.getHours()).slice(-2) + ":" +
              ("0" + date.getMinutes()).slice(-2) + ":" +
              ("0" + date.getSeconds()).slice(-2);
    }


  </script>
</main>
</body>
</html>
