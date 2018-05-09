package com.pub.exception.enums;

/**
 * Created by quyang on 2018/4/2.
 */
public enum ResultCode {

    DaoException(1000),
    InvalidParamException(1001),
    MissingParamException(1002),
    RedisException(1003),
    TargetExistedException(1004),
    TargetNotfoundException(1005),
    UnAutiorizedException(1006),
    SystemError(-1),
    CustomException(10000);

    private int code;

    ResultCode(int v){
        this.code = v;
    }

    public int getCode() {
        return code;
    }
}
