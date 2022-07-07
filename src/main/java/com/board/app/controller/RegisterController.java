package com.board.app.controller;

import com.board.app.dao.UserDao;
import com.board.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {
    private UserDao userDao;

    @Autowired
    public RegisterController(UserDao userDao) {
        this.userDao = userDao;
    }

    @InitBinder
    public void toDate(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) throws Exception {
        System.out.println("user = " + user);
        userDao.insertUser(user);
        return "redirect:/";
    }
}
