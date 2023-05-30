package com.jihwan.soccer.mail.model.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailService {
    String sendTempkey(String userEmail) throws MessagingException, UnsupportedEncodingException;

    String ckEmailNo(String emailNo, String userEmail);
}
