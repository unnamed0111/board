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
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void writeTest() throws Exception {
        for (int i = 0; i < 120; i++) {
            Board board = new Board();
            board.setUserId("kimpope");
            board.setBoardTitle("TEST" + i);
            board.setBoardContent("TEST" + i);

            boardService.write(board);
        }
    }

    @Test
    public void removeTest() throws Exception {
        Board board = new Board();
        board.setUserId("kimpope");
        board.setBoardId(145);

        boardService.remove(board);
    }

    @Test
    public void getMonthlyTop() throws Exception {
        List<Board> list = boardService.getMonthlyTop();

        printSimpleBoard(list);
    }

    private void printSimpleBoard(List<Board> list) {
        for(Board board : list) {
            System.out.println("board = " + board);
        }
    }
}