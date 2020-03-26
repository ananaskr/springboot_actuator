package com.ananskr.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/admin/index")
    public String admin(){
        return "welcome administrator!";
    }

    @RequestMapping(value = "/username_error")
    public String username_error(){
        return "user doesn't exists!";
    }

    @RequestMapping(value = "/passwd_error")
    public String passwd_error(){
        return "password error!";
    }

    @RequestMapping(value = "/unauthorize")
    public String unauthorize(){
        return "you are not an administrator! Please login first!";
    }
}
