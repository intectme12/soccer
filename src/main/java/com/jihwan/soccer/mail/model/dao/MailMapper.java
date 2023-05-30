package com.jihwan.soccer.mail.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailMapper {
    String selectEmail(String certEmail);
    int sendTempkey(String certEmail, String certKey);

    int tempKeyUpdate(String certEmail, String certKey);

    String ckEmailNo(String certEmail);
}
