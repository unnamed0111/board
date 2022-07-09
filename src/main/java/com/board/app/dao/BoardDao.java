package com.board.app.dao;

import com.board.app.domain.Board;
import com.board.app.domain.Paging;

import java.util.List;

public interface BoardDao {
    Integer insertBoard(Board board) throws Exception;

    Integer updateViewCnt(Integer boardId, Integer i) throws Exception;

    Integer updateCommentCnt(Integer boardId, Integer i) throws Exception;

    Board selectById(Integer boardId) throws Exception;

    List<Board> selectByPage() throws Exception;

    List<Board> selectByPage(Paging paging) throws Exception;

    Integer update(Board board) throws Exception;

    Integer delete(Board board) throws Exception;

    Integer selectCount() throws Exception;
}
