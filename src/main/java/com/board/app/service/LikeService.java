package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.dao.LikeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
    private LikeDao likeDao;
    private BoardDao boardDao;

    @Autowired
    public LikeService(LikeDao likeDao, BoardDao boardDao) {
        this.likeDao = likeDao;
        this.boardDao = boardDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer like(Integer boardId, String userId) throws Exception {
        int rowCnt = likeDao.insert(boardId, userId);
        // boardId가 없는걸 주면 에러가나서 다음 구문을 실행안시키고 바로 빠져나옴
        boardDao.updateLikeCnt(boardId, 1);
        return rowCnt;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer unlike(Integer boardId, String userId) throws Exception {
        int rowCnt = likeDao.delete(boardId, userId);
        // boardId가 없는걸 주면 에러가나서 다음 구문을 실행안시키고 바로 빠져나옴
        boardDao.updateLikeCnt(boardId, -1);
        return rowCnt;
    }

    public Integer check(Integer boardId, String userId) throws Exception {
        return likeDao.select(boardId, userId);
    }
}
