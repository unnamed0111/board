package com.board.app.controller;

import com.board.app.domain.Comment;
import com.board.app.domain.Test;
import com.board.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Comment>> list(@RequestParam("id") Integer boardId) throws Exception {

        List<Comment> list = commentService.list(boardId);

        return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
    }

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody Comment comment, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return new ResponseEntity<String>("REQUIRED_LOGIN", HttpStatus.BAD_REQUEST);

        comment.setUserId(userId);
        System.out.println("comment = " + comment);

        commentService.write(comment);

        return new ResponseEntity<String>("WRT_OK", HttpStatus.CREATED);
    }

    @PatchMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody Comment comment, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return new ResponseEntity<String>("REQUIRED_LOGIN", HttpStatus.BAD_REQUEST);

        comment.setUserId(userId);

        commentService.modify(comment);

        return new ResponseEntity<String>("MOD_OK", HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> remove(@RequestBody Comment comment, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return new ResponseEntity<String>("REQUIRED_LOGIN", HttpStatus.BAD_REQUEST);

        comment.setUserId(userId);

        commentService.remove(comment);

        return new ResponseEntity<String>("DEL_OK", HttpStatus.OK);
    }

    private String loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session == null) return null;

        return (String) session.getAttribute("id");
    }
}
