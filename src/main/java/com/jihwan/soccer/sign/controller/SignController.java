package com.jihwan.soccer.sign.controller;

import com.jihwan.soccer.sign.model.dto.SignDTO;
import com.jihwan.soccer.sign.model.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sign")
public class SignController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/moveUserSignAgree")
    public String moveUserSignAgree(){

        return "/sign/user-sign-agree";
    }

    @PostMapping("/moveUserSign")
    public String moveUserSign(){

        return "/sign/user-sign";
    }

    @GetMapping("/checkUserId")
    @ResponseBody
    public String checkUserId(@RequestParam String userId){

        logger.info("아이디중복확인 : " + userId);

        String checkUserId = signService.checkUserId(userId);

        return checkUserId;
    }

    @GetMapping("/checkUserNick")
    @ResponseBody
    public String checkUserNick(@RequestParam String userNick){

        logger.info("닉네임중복확인 : " + userNick);

        String checkUserNick = signService.checkUserNick(userNick);

        return checkUserNick;
    }

    @PostMapping("/userSign")
    @ResponseBody
    public String userSign(@RequestBody SignDTO signDTO){

        logger.info("유저회원가입정보 : " + signDTO);

        String userSign = signService.userSign(signDTO);

        return userSign;
    }
}
