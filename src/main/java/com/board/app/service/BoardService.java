package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.dao.CommentDao;
import com.board.app.dao.LikeDao;
import com.board.app.domain.Board;
import com.board.app.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private BoardDao boardDao;
    private CommentDao commentDao;
    private LikeDao likeDao;

    @Autowired
    public BoardService(BoardDao boardDao, CommentDao commentDao, LikeDao likeDao) {
        this.boardDao = boardDao;
        this.commentDao = commentDao;
        this.likeDao = likeDao;
    }

    public Board read(Integer boardId) throws Exception {
        Board board = get(boardId);
        boardDao.updateViewCnt(boardId, 1);

        return board;
    }

    public Board get(Integer boardId) throws Exception {
        return boardDao.selectById(boardId);
    }

    public List<Board> getList(SearchCondition sc) throws Exception {
        return boardDao.selectBySearch(sc);
    }

    public List<Board> getList() throws Exception {
        return boardDao.selectByPage();
    }

    public List<Board> getDailyTop() throws Exception {
        return boardDao.selectDailyTop();
    }

    public List<Board> getMonthlyTop() throws Exception {
        return boardDao.selectMonthlyTop();
    }

    public Integer getSize(SearchCondition sc) throws Exception {
        return boardDao.selectCountBySearch(sc);
    }

    public Integer write(Board board) throws Exception {
        return boardDao.insertBoard(board);
    }

    public Integer modify(Board board) throws Exception {
        return boardDao.update(board);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer remove(Board board) throws Exception {
        commentDao.deleteByBoardId(board);
        likeDao.deleteByBoardId(board.getBoardId());
        return boardDao.delete(board);
    }
}
