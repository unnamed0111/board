package com.board.app.controller;

import com.board.app.dao.UserDao;
import com.board.app.domain.User;
import com.board.app.domain.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @InitBinder
    public void toDate(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result) throws Exception {
        System.out.println("user = " + user);

        // 아이디 중복 확인
        User userExisted = userDao.selectUser(user.getUserId());

        if(userExisted != null) {
            result.rejectValue("userId", "exist");
        }

        if(result.hasErrors()) return "register";

        userDao.insertUser(user);
        return "redirect:/";
    }
}
