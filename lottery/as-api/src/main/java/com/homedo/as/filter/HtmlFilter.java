package com.homedo.as.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by quyang on 2018/4/22.
 */
public class HtmlFilter implements  Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String currentURL = request.getRequestURI();
        //System.out.println("---" + currentURL);
        /*if(!currentURL.contains("api") &&
                !currentURL.contains("mgr") &&
                !currentURL.contains("login.html") &&
                !currentURL.contains("static") &&
                !currentURL.contains("swagger")){
            if(request.getSession().getAttribute("loginUser") == null){
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        }*/
        if(currentURL.equals("/")){
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
        //加入filter链继续向下执行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
