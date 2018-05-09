package com.homedo.as;

import com.pub.bean.ResultBean;
import com.pub.exception.enums.ResultCode;
import com.pub.springboot.AbstractExceptionControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * Created by quyang on 2018/4/2.
 */
@RestControllerAdvice("com.homedo.as.api")
public class ExceptionControllerAdvice extends AbstractExceptionControllerAdvice{

    private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResultBean errorHandler(Exception e) {
        ResultBean resultBean = super.handle(e);
        if(resultBean.getCode() == ResultCode.SystemError.getCode()){
            log.error("", e);
        }
        return resultBean;
    }
}
