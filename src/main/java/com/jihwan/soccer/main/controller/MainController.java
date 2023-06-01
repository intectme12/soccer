package com.jihwan.soccer.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public ModelAndView main(ModelAndView mv){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        if(username != null){

            logger.info("session Id : " + username );
            mv.addObject("userId", username);
        }

        mv.setViewName("/main/main");

        return mv;
    }
}
