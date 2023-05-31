package com.jihwan.soccer.sign.model.dao;

import com.jihwan.soccer.sign.model.dto.SignDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignMapper {

    String checkUserId(String userId);

    String checkUserNik(String userNik);

    int insertUserSign(SignDTO signDTO);

    int insertUserSignRole(String userId);
}
