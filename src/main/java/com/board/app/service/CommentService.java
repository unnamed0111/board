package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.dao.CommentDao;
import com.board.app.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private BoardDao boardDao;
    private CommentDao commentDao;

    @Autowired
    public CommentService(BoardDao boardDao, CommentDao commentDao) {
        this.boardDao = boardDao;
        this.commentDao = commentDao;
    }

    public List<Comment> list(Integer boardId) throws Exception {
        return commentDao.selectByBoardId(boardId);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer write(Comment comment) throws Exception {
        int rowCnt = commentDao.insert(comment);
        boardDao.updateCommentCnt(comment.getBoardId(), 1);

        return rowCnt;
    }

    public Integer modify(Comment comment) throws Exception {
        return commentDao.update(comment);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer remove(Comment comment) throws Exception {
        int rowCnt = commentDao.delete(comment);
        boardDao.updateCommentCnt(comment.getBoardId(), -1);

        return rowCnt;
    }
}
