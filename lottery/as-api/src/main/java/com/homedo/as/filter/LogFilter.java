package com.homedo.as.filter;

import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by quyang on 2018/4/3.
 */
public class LogFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        final StringBuilder sb = new StringBuilder();
        String uri = httpServletRequest.getRequestURI();
        String reqMethod = httpServletRequest.getMethod();
        sb.append("#APIEND ").append(reqMethod);
        sb.append(",url:").append(uri).append(",content-type:").append(httpServletRequest.getHeader("Content-Type"));

        //GET
        if(reqMethod.equals(HttpMethod.GET.name())){
            sb.append(",params=[");
            Enumeration<String> enumeration = httpServletRequest.getParameterNames();
            while (enumeration.hasMoreElements()){
                String k = enumeration.nextElement();
                String v = httpServletRequest.getParameter(k);
                sb.append(k).append("=").append(v).append("&");
            }
            int index =  sb.lastIndexOf("&");
            if(index >= 0){
                sb.deleteCharAt(index);
            }
            sb.append("]");
            logger.info(sb.toString());
        //POST
        }
        //doFilter
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
