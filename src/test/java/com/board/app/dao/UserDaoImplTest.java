package com.board.app.dao;

import com.board.app.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;

    @Test
    public void selectUser() throws Exception {
        User user = userDao.selectUser("asdf");
        System.out.println("user = " + user);
    }

    @Test
    public void selectUserLogin() throws Exception {
        User user = new User();
        user.setUserId("beking");
        user.setUserPwd("0000");
        int rowCnt = userDao.selectUserLogin(user);
        System.out.println("rowCnt = " + rowCnt);
    }
}