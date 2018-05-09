package com.homedo.as.bean;

/**
 * Created by quyang on 2018/4/8.
 */
public class LoginUser {

    private String userName;
    private Long userId;
    private boolean admin;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
