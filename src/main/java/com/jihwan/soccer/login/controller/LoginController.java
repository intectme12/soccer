package com.jihwan.soccer.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String userLogin(){

        return "";
    }

    @GetMapping("/userLogout")
    public String userLogout(HttpServletRequest request){

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getRequestURL().toString());

        return "redirect:request.getRequestURL().toString()";
    }
}
