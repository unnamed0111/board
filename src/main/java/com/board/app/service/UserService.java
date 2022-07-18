package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.dao.CommentDao;
import com.board.app.dao.LikeDao;
import com.board.app.dao.UserDao;
import com.board.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getById(String userId) throws Exception {
        return userDao.selectUser(userId);
    }

    public Integer register(User user) throws Exception {
        return userDao.insertUser(user);
    }

    public boolean login(User user) throws Exception {
        return userDao.selectUserLogin(user) == 1;
    }
}
