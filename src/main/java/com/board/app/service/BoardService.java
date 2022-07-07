package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.dao.CommentDao;
import com.board.app.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardDao boardDao;
    private CommentDao commentDao;

    @Autowired
    public BoardService(BoardDao boardDao, CommentDao commentDao) {
        this.boardDao = boardDao;
        this.commentDao = commentDao;
    }

    public Board read(Integer boardId) throws Exception {
        Board board = get(boardId);
        boardDao.updateViewCnt(boardId, 1);

        return board;
    }

    public Board get(Integer boardId) throws Exception {
        return boardDao.selectById(boardId);
    }

    public List<Board> getList() throws Exception {
        return boardDao.selectByPage();
    }

    public Integer write(Board board) throws Exception {
        return boardDao.insertBoard(board);
    }

    public Integer modify(Board board) throws Exception {
        return boardDao.update(board);
    }

    public Integer remove(Board board) throws Exception {
        commentDao.deleteByBoardId(board);
        return boardDao.delete(board);
    }
}
