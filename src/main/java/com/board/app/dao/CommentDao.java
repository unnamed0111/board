package com.board.app.dao;

import com.board.app.domain.Board;
import com.board.app.domain.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectByBoardId(Integer boardId) throws Exception;

    Integer insert(Comment comment) throws Exception;

    Integer update(Comment comment) throws Exception;

    Integer delete(Comment comment) throws Exception;

    Integer deleteByParentId(Comment comment) throws Exception;

    Integer deleteByBoardId(Board board) throws Exception;
}
