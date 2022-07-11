package com.board.app.controller;

import com.board.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private BoardService boardService;

    @Autowired
    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/")
    public String getPage(Model m) {

        // 최근 게시물 10개

        // 오늘의 게시물 10개

        // 월간 인기 게시물 10개

        return "home";
    }
}
