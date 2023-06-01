package com.jihwan.soccer.config;

import com.jihwan.soccer.login.model.service.UserDetailsServiceImpl;
import com.jihwan.soccer.springSecurity.CustomerLoginSuccessHandler;
import com.jihwan.soccer.springSecurity.CustomerLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    // 인증, 인가가 필요없는 경로를 설정할떄 사용
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    // 인증, 인가에 대한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/","/sign/**", "/mail/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/**/**")
                    .usernameParameter("userId")
                    .passwordParameter("userPwd")
                    .loginProcessingUrl("/login/userLogin")
                    .successHandler(loginSuccessHandler())
                    .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/login/userLogout")
                    .logoutSuccessHandler(logoutSuccessHandler())
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

    // 로그인 성공 후 기존 페이지로 이동하기 위한 핸들러 설정
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new CustomerLoginSuccessHandler();
    }

    // 로그아웃 성공 후 기존 페이지로 이동하기 위한 핸들러 설정
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new CustomerLogoutSuccessHandler();
    }
}
