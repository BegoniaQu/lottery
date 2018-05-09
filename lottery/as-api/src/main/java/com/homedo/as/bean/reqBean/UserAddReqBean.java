package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by quyang on 2018/4/24.
 */
public class UserAddReqBean {
    @NotBlank(message = "请填写手机号码")
    @Length(min = 11, max = 11, message="手机号码11位哦!")
    private String phoneNum;
    @NotBlank(message = "请填写姓名")
    private String userName;
    private int type = 0;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
