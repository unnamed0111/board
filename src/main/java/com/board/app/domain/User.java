package com.board.app.domain;

import java.util.Date;

public class User {
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private Date userBirth;
    private Date userRegDate;

    public User() {}

    public User(String userId, String userPwd, String userName, String userEmail, Date userBirth) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirth = userBirth;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public Date getUserRegDate() {
        return userRegDate;
    }

    public void setUserRegDate(Date userRegDate) {
        this.userRegDate = userRegDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirth=" + userBirth +
                ", userRegDate=" + userRegDate +
                '}';
    }
}
