package com.board.app.controller;

import com.board.app.domain.Board;
import com.board.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private BoardService boardService;

    @Autowired
    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/")
    public String getPage(Model m) throws Exception {

        // 최근 게시물 10개
        List<Board> list = boardService.getList();
        m.addAttribute("recentList", list);
        // 오늘의 인기 게시물 10개
        list = boardService.getDailyTop();
        m.addAttribute("dailyTopList", list);
        // 월간 인기 게시물 10개
        list = boardService.getMonthlyTop();
        m.addAttribute("monthlyTopList", list);

        return "home";
    }
}
