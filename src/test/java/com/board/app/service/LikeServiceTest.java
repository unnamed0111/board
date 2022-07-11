package com.board.app.service;

import com.board.app.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LikeServiceTest {
    @Autowired
    LikeService likeService;

    @Autowired
    BoardService boardService;

    @Test
    public void like() throws Exception {
        List<Board> list = boardService.getList();

        for(Board board : list) {
            likeService.like(board.getBoardId(), "kimpope");
        }
    }

    @Test
    public void unlike() throws Exception {
        List<Board> list = boardService.getList();

        for(Board board : list) {
            likeService.unlike(board.getBoardId(), "kimpope");
        }
    }

    @Test
    public void check() throws Exception {
        int check = likeService.check(145, "falconkick31");

        System.out.println("check = " + check);
    }

    @Test
    public void likeCntTest() throws Exception {
        int likeCnt = boardService.get(144).getBoardLikeCnt();

        System.out.println("likeCnt = " + likeCnt);
    }

    public void printBoardList(List<Board> list) {
        for(Board board : list) {
            System.out.println("[ board = " + board.getBoardTitle() + ", " + board.getBoardLikeCnt() + " ]");
        }
    }
}