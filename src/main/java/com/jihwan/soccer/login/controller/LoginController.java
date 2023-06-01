package com.jihwan.soccer.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginPopup")
    public String loginPopup(){

        return "/login/loginPopup";
    }

    @PostMapping("/userLogin")
    public void userLogin(){}

    @GetMapping("/userLogout")
    public void userLogout(){}
}
