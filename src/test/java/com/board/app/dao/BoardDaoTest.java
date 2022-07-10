package com.board.app.dao;

import com.board.app.domain.Board;
import com.board.app.domain.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void insertBoardTest() throws Exception {
        Board board = new Board();

        board.setUserId("kimpope");
        board.setBoardTitle("세 번째 게시물");
        board.setBoardContent("세 번째 게시물입니다. 많이들 봐주시고 추천해주세요.");

        int rowCnt = boardDao.insertBoard(board);

        assertTrue(rowCnt == 1);
    }

    @Test
    public void selectByIdTest() throws Exception {
        Integer boardId = 3;

        Board board = boardDao.selectById(boardId);

        System.out.println("board = " + board);
    }

    @Test
    public void selectByPageTest() throws Exception {
        List<Board> boardList = boardDao.selectByPage();

        System.out.println("boardList = " + boardList);
    }

    @Test
    public void selectByPage2Test() throws Exception {

    }

    @Test
    public void updateTest() throws Exception {
        Board board = new Board();
        board.setBoardId(8);
        board.setUserId("kimpope");
        board.setBoardTitle("수정된 게시글");
        board.setBoardContent("원글 : 긴글 테스트");

        boardDao.update(board);

        Board newBoard = boardDao.selectById(8);

        System.out.println("newBoard = " + newBoard);
    }

    @Test
    public void selectBySearchTest() throws Exception {
        SearchCondition sc = new SearchCondition(1, 10, "-", "W");
        List<Board> list = boardDao.selectBySearch(sc);
        
        printBoardTitleList(list);
    }

    @Test
    public void selectCountBySearchTest() throws Exception {
        SearchCondition sc = new SearchCondition(1, 10, "1", "T");
        int rowCnt = boardDao.selectCountBySearch(sc);

        System.out.println("rowCnt = " + rowCnt);
    }

    public void printBoardTitleList(List<Board> list) {
        for(Board board : list) {
            System.out.println("board.getBoardTitle() = " + board.getBoardTitle());
        }
    }
}