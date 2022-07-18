package com.board.app.dao;

public interface LikeDao {
    Integer select(Integer boardId, String user_id) throws Exception;

    Integer insert(Integer boardId, String user_id) throws Exception;

    Integer delete(Integer boardId, String user_id) throws Exception;

    Integer deleteByBoardId(Integer boardId) throws Exception;
}
