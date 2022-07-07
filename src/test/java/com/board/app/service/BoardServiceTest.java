package com.board.app.service;

import com.board.app.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void removeTest() throws Exception {
        Board board = new Board();
        board.setUserId("asdf");
        board.setBoardId(12);

        boardService.remove(board);
    }
}