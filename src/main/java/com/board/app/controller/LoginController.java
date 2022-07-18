package com.board.app.controller;

import com.board.app.dao.UserDao;
import com.board.app.domain.User;
import com.board.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) throws Exception {

        if(!userService.login(user)) {
            return "redirect:/login";
        }
        
        // 로그인 성공시 세션에 아이디 저장
        request.getSession().setAttribute("id", user.getUserId());

        return "redirect:/";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
