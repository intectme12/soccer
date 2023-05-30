package com.jihwan.soccer.sign.model.service;

import com.jihwan.soccer.sign.model.dao.SignMapper;
import com.jihwan.soccer.sign.model.dto.SignDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignServiceImpl implements SignService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SignMapper signMapper;

    @Autowired
    public SignServiceImpl(SignMapper signMapper) {
        this.signMapper = signMapper;
    }

    @Override
    public String checkUserId(String userId) {

        String checkUserId = signMapper.checkUserId(userId);

        String result = "";
        if(checkUserId == null){

            result = "true";
        } else if(checkUserId.equals(userId)){

            result = "false";
        }

        return result;
    }

    @Override
    public String checkUserNick(String userNick) {

        String checkUserNick = signMapper.checkUserNik(userNick);

        String result = "";

        if(checkUserNick == null){

            result = "true";
        } else if(checkUserNick.equals(userNick)){

            result = "false";
        }

        return result;
    }

    @Override
    @Transactional
    public String userSign(SignDTO signDTO) {

        int userSign = signMapper.insertUserSign(signDTO);

        String result = "";
        if(userSign > 0){

            result = "true";
        } else {

            result = "false";
        }

        return result;
    }
}
