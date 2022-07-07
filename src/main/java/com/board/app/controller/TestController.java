package com.board.app.controller;

import com.board.app.domain.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/write")
    public String test(@RequestBody Test test) throws Exception {

        System.out.println("test = " + test);

        return "OK";
    }
}
