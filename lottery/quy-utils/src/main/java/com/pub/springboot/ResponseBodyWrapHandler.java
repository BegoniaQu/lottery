package com.pub.springboot;

import com.pub.ResultUitls;
import com.pub.bean.ResultBean;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by quyang on 2018/4/2.
 * 数据返回统一格式：ResultBean
 */
public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate){
        this.delegate = delegate;
    }


    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return delegate.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        if(!(o instanceof ModelAndView)){
            ResultBean resultBean = ResultUitls.ok(o);
            delegate.handleReturnValue(resultBean, methodParameter, modelAndViewContainer, nativeWebRequest);
        }
    }
}
