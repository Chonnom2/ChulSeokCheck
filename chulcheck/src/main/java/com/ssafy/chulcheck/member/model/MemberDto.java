package com.ssafy.chulcheck.member.model;

public class MemberDto {
    private String userName;
    private String userId;
    private String userPwd;
    private String token;
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", token='" + token + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
