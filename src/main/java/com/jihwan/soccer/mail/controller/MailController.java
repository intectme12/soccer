package com.jihwan.soccer.mail.controller;

import com.jihwan.soccer.mail.model.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendTempkey")
    @ResponseBody
    public String sendTempkey(@RequestParam String userEmail) throws MessagingException, UnsupportedEncodingException {

        logger.info("회원이메일 : " + userEmail);
        String sendTempkey = mailService.sendTempkey(userEmail);

        return sendTempkey;
    }

    @GetMapping("/ckEmailNo")
    @ResponseBody
    public String ckEmailNo(HttpServletRequest request){

        String emailNo = request.getParameter("emailNo");
        String userEmail = request.getParameter("userEmail");

        logger.info("유저이메일 : " + userEmail);
        logger.info("인증번호 : " + emailNo);

        String ckEmailNo = mailService. ckEmailNo(emailNo, userEmail);

        return ckEmailNo;
    }
}
