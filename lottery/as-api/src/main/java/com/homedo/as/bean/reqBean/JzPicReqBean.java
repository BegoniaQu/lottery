package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

public class JzPicReqBean {

    @NotBlank(message = "请填写地址")
    private String jzPic;

    public String getJzPic() {
        return jzPic;
    }

    public void setJzPic(String jzPic) {
        this.jzPic = jzPic;
    }
}
