package com.board.app.dao;

import com.board.app.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private SqlSession session;
    private static final String namespace = "com.board.app.dao.UserMapper.";

    @Autowired
    public UserDaoImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public Integer insertUser(User user) throws Exception {
        return session.insert(namespace + "insertUser", user);
    }

    @Override
    public Integer selectUserLogin(User user) throws Exception {
        return session.selectOne(namespace + "selectUserLogin", user);
    }

    // UserPwd 제외
    @Override
    public User selectUser(String userId) throws Exception {
        return session.selectOne(namespace + "selectUser", userId);
    }
}
