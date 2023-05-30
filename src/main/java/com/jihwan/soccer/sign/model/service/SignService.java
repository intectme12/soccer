package com.jihwan.soccer.sign.model.service;

import com.jihwan.soccer.sign.model.dto.SignDTO;

public interface SignService {
    String checkUserId(String userId);

    String checkUserNick(String userNick);

    String userSign(SignDTO signDTO);
}
