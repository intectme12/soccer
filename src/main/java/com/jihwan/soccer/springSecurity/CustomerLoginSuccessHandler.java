package com.jihwan.soccer.springSecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerLoginSuccessHandler implements AuthenticationSuccessHandler {

    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 이전 페이지 URL 가져오기
        String refererUrl = request.getHeader("Referer");

        // 이전 페이지로 리다이렉트
        redirectStrategy.sendRedirect(request, response, refererUrl);
    }
}
