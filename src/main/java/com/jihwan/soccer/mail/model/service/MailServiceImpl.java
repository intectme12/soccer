package com.jihwan.soccer.mail.model.service;

import com.jihwan.soccer.mail.common.MailHandler;
import com.jihwan.soccer.mail.common.TempKey;
import com.jihwan.soccer.mail.model.dao.MailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class MailServiceImpl implements MailService{

    private final MailHandler mailHandler;
    private final JavaMailSender mailSender;
    private final MailMapper mailMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MailServiceImpl(MailHandler mailHandler, JavaMailSender mailSender, MailMapper mailMapper) {
        this.mailSender = mailSender;
        this.mailHandler = mailHandler;
        this.mailMapper = mailMapper;
    }

    @Override
    @Transactional
    public String sendTempkey(String userEmail) throws MessagingException, UnsupportedEncodingException {

        TempKey tk = new TempKey();
        String tempKey = tk.otp(8);

        logger.info("회원가입인증번호 : " + tempKey);

        String selectEmail = mailMapper.selectEmail(userEmail);

        logger.info("등록된이메일 : " + selectEmail);

        String result = "";
        if (selectEmail == null) {

            int sendTempkey = mailMapper.sendTempkey(userEmail, tempKey);

            if (sendTempkey > 0) {

                MailHandler sendMail = new MailHandler(mailSender);
                sendMail.setSubject("[K-league 인증 이메일입니다.]");
                sendMail.setText(
                        "<h1>K-league 이메일 인증</h1>" +
                                "<br>아래 인증번호를 입력해주세요." +
                                "<br>[" + tempKey + "]"
                );
                sendMail.setFrom("intectme@naver.com", "K-league");
                sendMail.setTo(userEmail);
                sendMail.send();

                result = "true";
            } else {

                result = "false";
            }
        } else if(selectEmail.equals(userEmail)){

            int tempKeyUpdate = mailMapper.tempKeyUpdate(userEmail, tempKey);

            if(tempKeyUpdate > 0){

                result = "true";
            } else {

                result = "false";
            }
        }

        logger.info("result : " + result);
        return result;
    }

    @Override
    @Transactional
    public String ckEmailNo(String emailNo, String userEmail) {

        String ckEmailNo = mailMapper.ckEmailNo(userEmail);

        String result = "";
        if(ckEmailNo.equals(emailNo)){

            result = "true";
        } else {

            result = "false";
        }

        return result;
    }
}
