package com.jihwan.soccer.login.model.service;

import com.jihwan.soccer.login.model.dao.UserMapper;
import com.jihwan.soccer.login.model.dto.UserDTO;
import com.jihwan.soccer.login.model.dto.UserDetailsDTO;
import com.jihwan.soccer.login.model.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // UserDTO의 형태로 ID와 PWD를 조회해온다.
        UserDTO userDTO = userMapper.getUserInfo(userId);

        // 조회결과가 없으면 ID 재확인 요청을한다.
        if(userDTO == null) throw new UsernameNotFoundException("ID를 찾을 수 없습니다. 다시 확인해주세요.");

        // UserDetails를 implements한 구현체인 UserDetailsDTO를 객체화 하여 UserDTO에서 조회해 온 아이디와 비밀번호를 세팅한다.
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setUsername(userDTO.getUserId());
        userDetailsDTO.setPassword(userDTO.getUserPwd());

        // 해당 유저가 가진 권한을 List 형태로 받아온다. 이유는 여러가지 권한을 가지고 있을 수 있기 때문
        List<UserRoleDTO> userRoleDTOList = userMapper.getUserRole(userId);

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(userRoleDTOList != null){
            for(UserRoleDTO userRoles : userRoleDTOList){
                // SimpleGratedAuthority는 GrantedAuthority의 구현 클래스며 단순한 문자열 형태의 권한,
                // 예를들어 "ROLE_" 의 접두사를 통해 권한을 식별한다.
                authorities.add(new SimpleGrantedAuthority(userRoles.getRoleName()));
            }
        }

        userDetailsDTO.setAuthorities(authorities);
        userDetailsDTO.setEnabled(true);
        userDetailsDTO.setAccountNonExpired(true);
        userDetailsDTO.setAccountNonLocked(true);
        userDetailsDTO.setCredentialsNonExpired(true);

        return userDetailsDTO;
    }
}
