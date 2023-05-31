package com.jihwan.soccer.login.controller;

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
    public String userLogin(@RequestParam(value = "error", required = false) String error, Model model){
        if(error != null){
            model.addAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return "";
    }

    @GetMapping("/userLogout")
    public String userLogout(HttpServletRequest request){

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getRequestURL().toString());

        return "redirect:request.getRequestURL().toString()";
    }
}
