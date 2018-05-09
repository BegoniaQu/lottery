<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>

<%
String doadmin =(String)pageContext.getAttribute("doadmin");
response.sendRedirect(doadmin+"/sign/accessDenied.html");
%>