package com.board.app.dao;


import com.board.app.domain.Board;
import com.board.app.domain.Comment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    private SqlSession session;
    private static final String namespace = "com.board.app.dao.CommentMapper.";

    @Autowired
    public CommentDaoImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public List<Comment> selectByBoardId(Integer boardId) throws Exception {
        return session.selectList(namespace + "selectByBoardId", boardId);
    }

    @Override
    public Integer insert(Comment comment) throws Exception {
        return session.insert(namespace + "insert", comment);
    }

    @Override
    public Integer update(Comment comment) throws Exception {
        return session.update(namespace + "update", comment);
    }

    @Override
    public Integer delete(Comment comment) throws Exception {
        return session.delete(namespace + "delete", comment);
    }

    @Override
    public Integer deleteByParentId(Comment comment) throws Exception {
        return session.delete(namespace + "deleteByParentId", comment);
    }

    @Override
    public Integer deleteByBoardId(Board board) throws Exception {
        return session.delete(namespace + "deleteByBoardId", board);
    }
}
