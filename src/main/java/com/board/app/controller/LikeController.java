package com.board.app.controller;

import com.board.app.domain.Board;
import com.board.app.service.BoardService;
import com.board.app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LikeController {
    private LikeService likeService;
    private BoardService boardService;

    @Autowired
    public LikeController(LikeService likeService, BoardService boardService) {
        this.likeService = likeService;
        this.boardService = boardService;
    }

    @PostMapping("/like") // /like?id=213   추천 올리기
    public ResponseEntity<String> like(@RequestParam(value = "id") Integer boardId, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return new ResponseEntity<String>("REQUIRED_LOGIN", HttpStatus.BAD_REQUEST);

        // 추천한 사람이랑 보드아이디로 좋아요 등록하기
        // 만약 이미 등록이 되어있으면 메세지 보내기 (에러는 아님)
        try {
            if(likeService.check(boardId, userId) == 1) return new ResponseEntity<String>("EXIST_LIKE", HttpStatus.OK);
            if(likeService.like(boardId, userId) == 0) throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("ERR_LIKE", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("LIKE_OK", HttpStatus.OK);
    }

    @DeleteMapping("/like") // /like?id=213   추천 내리기
    public ResponseEntity<String> unlike(@RequestParam(value = "id") Integer boardId, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return new ResponseEntity<String>("REQUIRED_LOGIN", HttpStatus.BAD_REQUEST);

        // 추천한 사람이랑 보드아이디로 좋아요 삭제하기
        // 만약 이미 없으면 메세지보내기
        try {
            if(likeService.check(boardId, userId) == 0) return new ResponseEntity<String>("NOT_EXIST_LIKE", HttpStatus.OK);
            if(likeService.unlike(boardId, userId) == 0) throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("ERR_UNLIKE", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("UNLIKE_OK", HttpStatus.OK);
    }

    @GetMapping("/like") // /like?id=123123
    public ResponseEntity<Map> show(@RequestParam(value = "id") Integer boardId, HttpServletRequest request) throws Exception {
        // 해당 보드아이디를 통해서 보드를 가져와서 보드내에 추천수 사용하기
        Map map = new HashMap();

        System.out.println("boardId = " + boardId);

        // 없는 보드를 참조할경우 에러 -> ERR_SHOW
        try {
            int likeCnt = boardService.get(boardId).getBoardLikeCnt();
            map.put("like", likeCnt);

            // 로그인 안했으면 추천수만 보여주기
            String userId = loginCheck(request);
            if(userId == null) return new ResponseEntity<Map>(map, HttpStatus.OK);

            // 로그인 했으면 추천수와 이미 추천했는지 여부를 보여줌
            map.put("checked", likeService.check(boardId, userId));
        } catch (Exception e) {
            e.printStackTrace();
            map.put("err", "ERR_SHOW");
            return new ResponseEntity<Map>(map, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    private String loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session == null) return null;

        return (String) session.getAttribute("id");
    }
}
