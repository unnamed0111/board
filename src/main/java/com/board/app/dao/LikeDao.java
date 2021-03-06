package com.board.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LikeDao {
    private SqlSession session;
    private static final String namespace = "com.board.app.dao.LikeMapper.";

    @Autowired
    public LikeDao(SqlSession session) {
        this.session = session;
    }

    public Integer select(Integer boardId, String user_id) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("userId", user_id);

        return session.selectOne(namespace + "select", map);
    }

    public Integer insert(Integer boardId, String user_id) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("userId", user_id);

        return session.insert(namespace + "insert", map);
    }

    public Integer delete(Integer boardId, String user_id) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("userId", user_id);

        return session.delete(namespace + "delete", map);
    }

    public Integer deleteByBoardId(Integer boardId) throws Exception {
        return session.delete(namespace + "deleteByBoardId", boardId);
    }
}
