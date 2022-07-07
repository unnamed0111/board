package com.board.app.controller;

import com.board.app.dao.UserDao;
import com.board.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GloabalController {
    private UserDao userDao;

    @Autowired
    public GloabalController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        m.addAttribute("error", ex);

        return "error";
    }

    @ModelAttribute("globalUserInfo")
    public User LoginInfo(HttpServletRequest request) throws Exception {
        System.out.println("전역 모델 처리기 진입");
        HttpSession session = request.getSession(false);

        if(session == null) {
            return null;
        }

        String userID = (String) session.getAttribute("id");

        if(userID == null) {
            return null;
        }

        return userDao.selectUser(userID);
    }
}
