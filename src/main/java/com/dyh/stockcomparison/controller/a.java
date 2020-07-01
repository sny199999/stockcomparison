package com.dyh.stockcomparison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class a {
    @RequestMapping("/")
    @ResponseBody
    public String a(){
        return "123123213";
    }

}
