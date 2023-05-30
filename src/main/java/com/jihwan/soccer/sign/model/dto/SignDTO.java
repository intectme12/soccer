package com.jihwan.soccer.sign.model.dto;

public class SignDTO {

    private String userId;
    private String userNick;
    private String userPwd;
    private String userBirth;
    private String userEmail;

    public SignDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "SignDTO{" +
                "userId='" + userId + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
