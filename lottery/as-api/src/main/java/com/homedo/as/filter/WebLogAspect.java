package com.homedo.as.filter;

/**
 * Created by quyang on 2018/4/3.
 */

import com.alibaba.druid.support.json.JSONUtils;
import com.pub.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by quyang on 2018/4/3.
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.homedo.as.api.*.*(..))")//要处理的方法，包名+类名+方法名
    public void cut(){}

    @Before("cut()")//在调用上面 @Pointcut标注的方法前执行以下方法
    public void doBefore(JoinPoint joinPoint){//用于获取类方法
        StringBuilder sb = new StringBuilder();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String reqMethod = request.getMethod();
        String uri = request.getRequestURI();
        sb.append("#APIEND ").append(reqMethod);
        sb.append(",url:").append(uri).append(",content-type:").append(request.getHeader("Content-Type"));
        if(reqMethod.equals(HttpMethod.GET.name())){ //Get 日志在logFilter中处理
            sb.append(",params=[");
            Enumeration<String> enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()){
                String k = enumeration.nextElement();
                String v = request.getParameter(k);
                sb.append(k).append("=").append(v).append("&");
            }
            int index =  sb.lastIndexOf("&");
            if(index >= 0){
                sb.deleteCharAt(index);
            }
            sb.append("]");
        }else if(reqMethod.equals(HttpMethod.POST.name())){
            sb.append(",body:").append(JsonUtil.getJsonFromObject(joinPoint.getArgs()[0]));
        }
        //ip
        //类方法
        //log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+'.'+ joinPoint.getSignature().getName());//获取类名及类方法
        log.info(sb.toString());
    }
}
