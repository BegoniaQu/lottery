package com.pub.springboot;

import com.pub.ResultUitls;
import com.pub.bean.ResultBean;
import com.pub.exception.*;
import com.pub.exception.enums.ResultCode;

import java.security.InvalidParameterException;

/**
 * Created by quyang on 2018/4/2.
 */
public abstract class AbstractExceptionControllerAdvice {

    public abstract ResultBean errorHandler(Exception e);


    protected ResultBean handle(Exception e){
        if(e instanceof SCCustomRuntimeException){
            return ResultUitls.fail(ResultCode.CustomException.getCode(), e.getMessage());
        }
        if(e instanceof SCDaoRuntimeException){
            return ResultUitls.fail(ResultCode.DaoException.getCode(), e.getMessage());
        }
        if(e instanceof SCInvalidParamException){
            return ResultUitls.fail(ResultCode.InvalidParamException.getCode(), e.getMessage());
        }
        if(e instanceof SCMissingParamException){
            return ResultUitls.fail(ResultCode.MissingParamException.getCode(), e.getMessage());
        }
        if(e instanceof SCRedisRuntimeException){
            return ResultUitls.fail(ResultCode.RedisException.getCode(), e.getMessage());
        }
        if(e instanceof SCTargetExistsRuntimeException){
            return ResultUitls.fail(ResultCode.TargetExistedException.getCode(), e.getMessage());
        }
        if(e instanceof SCTargetNotFoundRuntimeException){
            return ResultUitls.fail(ResultCode.TargetNotfoundException.getCode(), e.getMessage());
        }
        if(e instanceof SCUnAuthorizedRuntimeException){
            return ResultUitls.fail(ResultCode.UnAutiorizedException.getCode(), e.getMessage());
        }else{
            return ResultUitls.fail(ResultCode.SystemError.getCode(), e.getMessage());
        }

    }
}
