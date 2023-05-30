package com.jihwan.soccer.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginPopup")
    public String loginPopup(){

        return "/login/loginPopup";
    }

    @PostMapping("/userLogin")
    public String userLogin(){

        return "";
    }
}
