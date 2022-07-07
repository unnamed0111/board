package com.board.app.dao;

import com.board.app.domain.User;

public interface UserDao {
    Integer insertUser(User user) throws Exception;

    Integer selectUserLogin(User user) throws Exception;

    User selectUser(String userId) throws Exception;
}
