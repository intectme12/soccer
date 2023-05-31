package com.jihwan.soccer.login.model.dao;

import com.jihwan.soccer.login.model.dto.UserDTO;
import com.jihwan.soccer.login.model.dto.UserRoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO getUserInfo(String userId);

    List<UserRoleDTO> getUserRole(String userId);
}
