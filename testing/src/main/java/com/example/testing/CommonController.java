package com.example.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHome(HttpServletRequest request) {
        return "content/home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request) {
        return "content/index";
    }

}

