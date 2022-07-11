package com.board.app.dao;

import com.board.app.domain.Board;
import com.board.app.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    private SqlSession session;
    private static final String namespace = "com.board.app.dao.BoardMapper.";

    @Autowired
    public BoardDaoImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public Integer insertBoard(Board board) throws Exception {
        return session.insert(namespace + "insert", board);
    }

    @Override
    public Integer updateViewCnt(Integer boardId, Integer i) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("cnt", i);
        return session.update(namespace + "updateViewCnt", map);
    }

    @Override
    public Integer updateCommentCnt(Integer boardId, Integer i) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("cnt", i);
        return session.update(namespace + "updateCommentCnt", map);
    }

    @Override
    public Integer updateLikeCnt(Integer boardId, Integer i) throws Exception {
        Map map = new HashMap();
        map.put("boardId", boardId);
        map.put("cnt", i);
        return session.update(namespace + "updateLikeCnt", map);
    }

    @Override
    public Board selectById(Integer boardId) throws Exception {
        return session.selectOne(namespace + "selectById", boardId);
    }

    @Override
    public List<Board> selectByPage() throws Exception {
        return session.selectList(namespace + "selectByPageDefault");
    }

    @Override
    public Integer update(Board board) throws Exception {
        return session.update(namespace + "update", board);
    }

    @Override
    public Integer delete(Board board) throws Exception {
        return session.delete(namespace + "delete", board);
    }

    @Override
    public Integer selectCount() throws Exception {
        return session.selectOne(namespace + "selectCnt");
    }

    @Override
    public List<Board> selectBySearch(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "selectBySearch", sc);
    }

    @Override
    public Integer selectCountBySearch(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "selectCntBySearch", sc);
    }
}
